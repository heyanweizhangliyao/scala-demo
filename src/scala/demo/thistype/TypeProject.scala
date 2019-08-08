package scala.demo.thistype

import scala.demo.inner.OuterClass
import scala.reflect.runtime.universe._

/**
  * 类型投影
  * 同一个类的不同对象，各自的内部类对象类型不一样
  *
  * type是比类更细的概念
  */
object TypeProject extends App {

  val o1:OuterClass = new OuterClass
  val o2:OuterClass = new OuterClass
//  println(typeOf[o1.type]) //scala.demo.thistype.TypeProject.o1.type
//  println(typeOf[o2.type])  // scala.demo.thistype.TypeProject.o2.type
  println("o1与o2类型一样 " + (typeOf[o1.type] == typeOf[o2.type]))
  println("o1与o2类一样 " + (o1.getClass == o2.getClass))
  val o1In = new o1.InnerClass
  val o2In = new o2.InnerClass
  println(typeOf[o1.InnerClass]) //scala.demo.thistype.TypeProject.o1.InnerClass
  println(typeOf[o2.InnerClass]) // scala.demo.thistype.TypeProject.o2.InnerClass
  println("o1的innerclass与o2的innerclass类型一样 "+(typeOf[o1In.type ]==typeOf[o2In.type]))
  println("o1的innerclass与o2的innerclass类一样 "+(o1In.getClass==o2In.getClass))

  o1.test(o2In)
  o1.test(o1In)


  type X = A with Cloneable
  def test(x:X)={
    println("OK")
  }
  test(new B)
}

//利用type声明复合类型 A with Cloneable是复合类型

class B extends A with Cloneable

class A

