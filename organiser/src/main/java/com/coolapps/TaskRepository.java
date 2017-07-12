package com.coolapps;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coolapps.model.Task;
@Repository
public interface TaskRepository  extends CrudRepository<Task, Long>{

}
