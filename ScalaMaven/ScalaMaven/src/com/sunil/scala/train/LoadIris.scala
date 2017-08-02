package com.sunil.scala.train

object  LoadIris  extends App{
  import com.v2maestros.bda.scala.common._
  	import org.apache.log4j.Logger
	import org.apache.log4j.Level;
	
	Logger.getLogger("org").setLevel(Level.ERROR);
	Logger.getLogger("akka").setLevel(Level.ERROR);
  	
  	val sc = SparkCommonUtils.spContext
  	
  	//Load the file. Lazy initialization
	val irisData = sc.textFile(SparkCommonUtils.datadir 	+ "/iris.csv")
	irisData.cache()
	//Loads only now.
	irisData.count()
	irisData.first()
	irisData.take(5)

	// the above line can also be written as 
	// irisData take 5
	
	
	
	for(x <- irisData){println(x)}
  	
	//Storing Data to files
	//irisData.saveAsTextFile(SparkCommonUtils.datadir 
		//	+ "iris_output.csv")
			
			
			val nextData = irisData.map(x => x.split(",") )
			
				for(x <- nextData){println(x.toString())}
			
			
			
}