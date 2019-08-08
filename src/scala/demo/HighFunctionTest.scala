package scala.demo

class HighFunctionTest {

}

object HighFunctionTest{

  def main(args: Array[String]): Unit = {

    //filter
    val filterArray = Array(25.0,23,22,90.9).filter(_>24)
    println(filterArray)

    val filterMap = Map("abc"->"123","abcd"->"1234","java"->"4").filter(_._2.length > 2)
    println(filterMap)

    //reduce
    val a:Int = List(1,2,12,-127,104).reduce((x,y)=>x+y)
    val b:Int = List(1,2,12,-127,104).reduce(_+_)
    println(a);println(b)

    val c:AnyVal = Array(1,2,12,-127,104).reduceLeft(_+_)
    println(c)

    //fold foldLeft foldRight
    val d = Array(1,2,12,-127,104).foldLeft(0)(_+_)
    println(d)

    //scan scanLeft scanRight 每一步执行的结果都保存起来，执行完后生成数组

    val e = List(12,54,98,63,55).scanLeft(23)( (x,y)=>{println(x,y);2*x+y})
    println(e)

//    val fun = multiply(3.5)
//    println(fun(5.9))

   //函数里柯化
    multiply(3.2)
    val m1 = multiply2(2)_
    println(m1(2.001))
    println(multiply2(2)(65.0325))

    /*
    *部分应用函数
    *
    定义一个求和函数
      scala> def sum(x:Int,y:Int,z:Int)=x+y+z
      sum: (x: Int, y: Int, z: Int)Int

      //不指定任何参数的部分应用函数
      scala> val s1=sum _
      s1: (Int, Int, Int) => Int = <function3>

      scala> s1(1,2,3)
      res91: Int = 6

       //指定两个参数的部分应用函数
      scala> val s2=sum(1,_:Int,3)
      s2: Int => Int = <function1>

      scala> s2(2)
      res92: Int = 6

      //指定一个参数的部分应用函数
      scala> val s3=sum(1,_:Int,_:Int)
      s3: (Int, Int) => Int = <function2>

      scala> s3(2,3)
      res93: Int = 6
    */





  }
  def multiply(factor:Double)=(x:Double)=>x*factor

  //函数里柯化，以上函数又可以写成,但是不能通过multiply2(3.2)调用，会报错,可以以 multiply2(3.2)_偏函数的方式
  def multiply2(factor:Double)(x:Double)=x*factor
}
