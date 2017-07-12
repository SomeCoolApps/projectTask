package com.coolapps;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coolapps.model.Task;

@Controller


public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository ;
	
	@Value("${welcome.message:User1}")
	private String message = "User1";

	@RequestMapping("/")
	//public String welcome(Map<String, Object> model) {
	public String welcome(Model model) {
		model.addAttribute("user", this.message);
		model.addAttribute("task", new Task());
		//return "createOrUpdateTaskForm";
		return "welcome";
	}
	////http://localhost:8080/createTask?summary=hello&description=description_is_this
	@GetMapping(path="/createTask") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String summary
			, @RequestParam String description) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Task t = new Task();
		t.setSummary(summary);
		t.setDescription(description);
		t.setDueDate(new Date());
		//t.setId(12);
		taskRepository.save(t);
		return "Saved";
	}
	
	@GetMapping("/task")
    public String greetingForm(Model model) {
		 model.addAttribute("task", new Task());
        return "task";
    }
	
	@PostMapping("/task")
    public String greetingSubmit(@ModelAttribute Task greeting) {
		

		Task t = new Task();
		t.setSummary(greeting.getSummary());
		t.setDescription(greeting.getDescription());
		t.setDueDate(new Date());
		//t.setId(12);
		taskRepository.save(t);
		
        return "redirect:/";
    }
	
	
	@ModelAttribute("allTasks")
	public Iterable<Task> populateTask() {
		
		return taskRepository.findAll();/*
	List<Task> listTask= new ArrayList<Task>();
	Task t =new Task();
	t.setSummary("Task 1");
	t.setDescription("call the tech");
	t.setDueDate(new Date());
	t.setId(1);
	
	listTask.add(t);
	
	Task t2 =new Task();
	t2.setDescription("complete coding");
	t2.setSummary("Task 2");
	t2.setDueDate(new Date());
	t2.setId(2);
	listTask.add(t2);
	return listTask;
	*/}

}
