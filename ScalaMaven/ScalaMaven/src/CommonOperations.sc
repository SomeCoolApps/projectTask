object CommonOperations {  println("Welcome to the Scala worksheet")
                                                  //> Welcome to the Scala worksheet
  
  
    import com.v2maestros.bda.scala.common._
  	import org.apache.log4j.Logger
	import org.apache.log4j.Level;
	
	Logger.getLogger("org").setLevel(Level.ERROR);
	Logger.getLogger("akka").setLevel(Level.ERROR);
  	
  	val sc = SparkCommonUtils.spContext       //> Using Spark's default log4j profile: org/apache/spark/log4j-defaults.propert
                                                  //| ies
                                                  //| SLF4J: Class path contains multiple SLF4J bindings.
                                                  //| SLF4J: Found binding in [jar:file:/Users/home_comp/.m2/repository/org/slf4j/
                                                  //| slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar!/org/slf4j/impl/StaticLoggerBi
                                                  //| nder.class]
                                                  //| SLF4J: Found binding in [jar:file:/Users/home_comp/.m2/repository/org/slf4j/
                                                  //| slf4j-nop/1.5.3/slf4j-nop-1.5.3.jar!/org/slf4j/impl/StaticLoggerBinder.class
                                                  //| ]
                                                  //| SLF4J: Found binding in [jar:file:/Users/home_comp/.m2/repository/org/slf4j/
                                                  //| slf4j-jdk14/1.5.6/slf4j-jdk14-1.5.6.jar!/org/slf4j/impl/StaticLoggerBinder.c
                                                  //| lass]
                                                  //| SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanat
                                                  //| ion.
                                                  //| SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
                                                  //| 16/12/19 19:08:22 WARN AbstractHandler: No Server set for org.spark_project.
                                                  //| jetty.server.handler.ErrorHandler@531e1314
                                                  //| sc  : org.apache.spark.SparkContext = org.
                                                  //| Output exceeds cutoff limit.
  	
  	//Load the file. Lazy initialization
	val irisData = sc.textFile(SparkCommonUtils.datadir 	+ "/iris.csv")
                                                  //> irisData  : org.apache.spark.rdd.RDD[String] = /Users/home_comp/Desktop/dev/
                                                  //| workspace/ScalaMaven/data-files//iris.csv MapPartitionsRDD[1] at textFile at
                                                  //|  CommonOperations.scala:14
	irisData.cache()                          //> res0: CommonOperations.irisData.type = /Users/home_comp/Desktop/dev/workspac
                                                  //| e/ScalaMaven/data-files//iris.csv MapPartitionsRDD[1] at textFile at CommonO
                                                  //| perations.scala:14
	//Loads only now.
	irisData.count()                          //> [Stage 0:>                                                          (0 + 0)
                                                  //|  / 2]                                                                      
                                                  //|           res1: Long = 150
	irisData.first()                          //> res2: String = 5.1,3.5,1.4,0.2,setosa
	irisData.take(5)                          //> res3: Array[String] = Array(5.1,3.5,1.4,0.2,setosa, 4.9,3,1.4,0.2,setosa, 4.
                                                  //| 7,3.2,1.3,0.2,setosa, 4.6,3.1,1.5,0.2,setosa, 5,3.6,1.4,0.2,setosa)

	// the above line can also be written as
	// irisData take 5
	
	
	
	//for(x <- irisData){println(x)}
  	
	//Storing Data to files
	//irisData.saveAsTextFile(SparkCommonUtils.datadir
		//	+ "iris_output.csv")
			
			def readFirstColumn(){}   //> readFirstColumn: ()Unit
			
			
			val nextData = irisData.map(x => x.split(",") )
                                                  //> nextData  : org.apache.spark.rdd.RDD[Array[String]] = MapPartitionsRDD[2] at
                                                  //|  map at CommonOperations.scala:35
			//import scala.util.Try
				//for(x <- nextData){println(Try(x.toFloat))}
                                                  
                                                  println(nextData.count)
                                                  //> 150
        val values = Array.fill( 3)(10)           //> values  : Array[Int] = Array(10, 10, 10)
        
        val newValues = sc.parallelize(values)    //> newValues  : org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[3] at pa
                                                  //| rallelize at CommonOperations.scala:42
        
        newValues.reduce((x,y)=>x+y)              //> res4: Int = 30
                                                  
        //val d = irisData.reduce((x,y) => x.split(",") (0).toFloat + y.split(",")(0).toFloat)
                                                  
}