package scala.demo.traittest

import java.io.{File, PrintWriter}

trait Logger {
  println("Logger")
  def log(msg:String):Unit
}

trait FileLogger extends Logger{

  println("FileLogger")

  val fileName:String
  lazy val fileOutput = new PrintWriter(fileName)

  def beforeLog():Unit={fileOutput.println("#")}

  override def log(msg: String): Unit = {fileOutput.println(msg);fileOutput.flush()}
}

class Person{
  println("construct a person")
}

class Teacher extends Person with FileLogger with Cloneable{
  println("construct a teacher")
  val fileName:String = "file.log"

}

object TraitDemo{


  def main(args: Array[String]): Unit = {

//      new FileLogger {}.log("hello scala-trait")
    /*val fileLogger:FileLogger = new Teacher
    fileLogger.beforeLog()
    fileLogger.log("hello scala-trait-3")

    System.getProperties.forEach((t: Object, u: Object) => println(t + " -> " + u))
*/

    // 函数本身作为参数
    println(accept(12,3,a1))
    println(accept(545,22,a1))

    //函数作为返回值
    println(mutiplyBy(2.0)(3.0))

    //Array.map
    val nameList = new File(".").list()
    val nameList2 = nameList.map(fileName => {
      fileName*2
    })
    println(nameList2)

    //List.map
    println(List.apply(56,32,23,65).map((element:Int) => {element*0.2}))

    //List.map2
    List(1->"Spark",2->"Java",3->"Hadoop").map((ele) => ele._2)

    //Map.map
    println(Map("spark"->1,"hive"->2,"hadoop"->3).map((ele)=>{ele._2} ))


  }

  // 函数本身作为参数
  def accept(x:Int,y:Int,fn:(Int,Int)=>String):Double={Integer.parseInt(fn(x,y))+2.0}

  def a1(x:Int,y:Int) = {x+y+""}

  //函数作为返回值
  def mutiplyBy(factor:Double) = (x:Double)=>factor*x

}
