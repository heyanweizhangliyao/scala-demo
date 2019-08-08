package scala.demo.jicheng

abstract class ParentClass(val name:String,val age:Int) {

  def sleep()

  def wc= println("go wc all the day")
}

class SonClass (name:String,age:Int,val score:Double) extends ParentClass(name,age){
  override def sleep= println("sleeping by side")

  override def wc: Unit = {
    super.wc
    println("are you bu fu? let's dan tian")
  }
}


object SonClassTest{
  def main(args: Array[String]): Unit = {
    val sc = new SonClass("heyanwei",24,98.5)
    sc.sleep
    sc.wc
    sc.name
    sc.age
  }
}
