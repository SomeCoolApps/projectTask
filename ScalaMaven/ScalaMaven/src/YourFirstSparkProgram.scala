object YourFirstSparkProgram extends App{
  import org.apache.log4j.Logger
	import org.apache.log4j.Level;
  Logger.getLogger("org").setLevel(Level.ERROR);
	Logger.getLogger("akka").setLevel(Level.ERROR);
  
	import org.apache.spark.SparkContext
	import org.apache.spark.SparkConf
	
	//A name for the spark instance. Can be any string
	val appName="V2Maestros"
	//Pointer / URL to the Spark instance - embedded
	//val sparkMasterURL = "local[2]"
	val sparkMasterURL = "spark://home-comps-MacBook-Pro.local:7077"
	
	
	//Create a configuration object
	val conf = new SparkConf()
			.setAppName(appName)
			.setMaster("local")
			//.set("spark.executor.memory","1g")
			
	//Start a Spark Session
	val spContext = SparkContext.getOrCreate(conf)
	
	//Check http://localhost:4040
	
	//Load a data file into an RDD
	val tweetsRDD = spContext.textFile("/Users/home_comp/Desktop/dev/workspace/scala-spark-bda/data-files/movietweets.csv")

	//print first five lines
	for( tweet <- tweetsRDD.take(5)) println(tweet)
	
	//Print number of lines in file
	//This is lazy evaluation
	println("Total tweets in file :" + tweetsRDD.count())
	
	//Convert tweets to upper case
	val tweetsUpper = tweetsRDD.map( s => s.toUpperCase())
	
	//Print the converted items.
	tweetsUpper.take(5)

}