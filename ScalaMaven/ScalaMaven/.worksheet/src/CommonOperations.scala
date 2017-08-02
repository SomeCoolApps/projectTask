object CommonOperations {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68);   println("Welcome to the Scala worksheet")
  
  
    import com.v2maestros.bda.scala.common._
  	import org.apache.log4j.Logger
	import org.apache.log4j.Level;$skip(167); ;
	
	Logger.getLogger("org").setLevel(Level.ERROR);$skip(49); ;
	Logger.getLogger("akka").setLevel(Level.ERROR);$skip(43); ;
  	
  	val sc = SparkCommonUtils.spContext;System.out.println("""sc  : org.apache.spark.SparkContext = """ + $show(sc ));$skip(113); 
  	
  	//Load the file. Lazy initialization
	val irisData = sc.textFile(SparkCommonUtils.datadir 	+ "/iris.csv");System.out.println("""irisData  : org.apache.spark.rdd.RDD[String] = """ + $show(irisData ));$skip(18); val res$0 = 
	irisData.cache();System.out.println("""res0: CommonOperations.irisData.type = """ + $show(res$0));$skip(37); val res$1 = 
	//Loads only now.
	irisData.count();System.out.println("""res1: Long = """ + $show(res$1));$skip(18); val res$2 = 
	irisData.first();System.out.println("""res2: String = """ + $show(res$2));$skip(18); val res$3 = 
	irisData.take(5);System.out.println("""res3: Array[String] = """ + $show(res$3));$skip(241); 

	// the above line can also be written as
	// irisData take 5
	
	
	
	//for(x <- irisData){println(x)}
  	
	//Storing Data to files
	//irisData.saveAsTextFile(SparkCommonUtils.datadir
		//	+ "iris_output.csv")
			
			def readFirstColumn(){};System.out.println("""readFirstColumn: ()Unit""");$skip(59); 
			
			
			val nextData = irisData.map(x => x.split(",") );System.out.println("""nextData  : org.apache.spark.rdd.RDD[Array[String]] = """ + $show(nextData ));$skip(202); 
			//import scala.util.Try
				//for(x <- nextData){println(Try(x.toFloat))}
                                                  
                                                  println(nextData.count);$skip(40); 
        val values = Array.fill( 3)(10);System.out.println("""values  : Array[Int] = """ + $show(values ));$skip(56); 
        
        val newValues = sc.parallelize(values);System.out.println("""newValues  : org.apache.spark.rdd.RDD[Int] = """ + $show(newValues ));$skip(46); val res$4 = 
        
        newValues.reduce((x,y)=>x+y);System.out.println("""res4: Int = """ + $show(res$4))}
                                                  
        //val d = irisData.reduce((x,y) => x.split(",") (0).toFloat + y.split(",")(0).toFloat)
                                                  
}
