package scala.demo.temp

import java.io.File

import scala.io.Source
//RichFile类中定义了Read方法
class RichFile(val file:File){
  def read=Source.fromFile(file).getLines().mkString
}

object ImplicitFunction extends App{
  implicit def double2Int(x:Double)=x.toInt
  var x:Int=3.5
  //隐式函数将java.io.File隐式转换为RichFile类
  implicit def file2RichFile(file:File)=new RichFile(file)
  //File类的对象并不存在read方法，此时便会发生隐式转换
  //将File类转换成RichFile
  val f=new File("file.log").read
  println(f)

  def testImplicitMethod(implicit s1:String)=s1+" :dd:"
  implicit val s1:String = "aaa"

  testImplicitMethod
  println( testImplicitMethod)

  def compare[T<:Ordered[T]](first:T,second:T)={
    if (first < second)
      first
    else
      second
  }

  def compare[T](first:T,second:T)(implicit order:T => Ordered[T])={
    if (first < second)
      first
    else
      second
  }

  println(compare("A","B"))
}

/**
  * 隐式转换的条件：1、方法的参数类型不匹配时 2、调用类中不存在的方法或成员时
  *
  * 不发生隐式转换的情况 ：1、在不发生隐式转换的条件下能通过编译 2、隐式转换不唯一，即ambiguous 3、隐式转换不会嵌套进行
  *
  * 隐式参数:如果定义了隐式参数,方法调用时可以不传参数
  */