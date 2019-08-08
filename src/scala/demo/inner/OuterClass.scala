package scala.demo.inner

class OuterClass {

  private[this] val width:Int = 0

  def test(i:OuterClass#InnerClass){println(i.height)} //类型投影，使得这个方法可以接收任意Innerclass对象

  class InnerClass{

    val height:Double = 0.0
    val width:Int = 1

    def outWidth=OuterClass.this.width

  }

}
object Test{
  def main(args: Array[String]): Unit = {
    val outerClass = new OuterClass()
    var innerClass = new outerClass.InnerClass()
    println(innerClass.outWidth)
  }
}
