package scala.demo.xiebian

import scala.demo.compare.{Animal, Person}

//用+表示具有协变性
case class XiebianDemo[+T](val head:T,val tail:XiebianDemo[T]) {
  //因为是协变的，入参必须是T的超类
  def append[U>:T](newHead:U) = new XiebianDemo[U](newHead,this)
}

object XiebianDemo extends App{

  var x1:XiebianDemo[AnyRef] = new XiebianDemo[Person](Person("h1","zhangsan",16),new XiebianDemo[Person](Person("h2","lisi",12),null)) //如果没有+，编译失败
  println(x1.head)
  println(x1.tail.head)
  x1 = x1.append(new Animal("h3"))
  println(x1.head)


}

//逆变
class Person2[-A]{def test[R<:A](x:R){}}

class Person3[+A]{
  def test[R>:A](x:R){}
}

//类型通配符  _<:O