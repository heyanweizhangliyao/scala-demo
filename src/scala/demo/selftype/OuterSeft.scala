package scala.demo.selftype

/**
  * 1、别名，self可以是其它名称
  */


class OuterSeft {
// 相当于外部类别名 == OterSeft.this
  outself =>
  val v = "a"

  println(outself.v+"::"+this.v)
  class InnerSelf{
    val v = "b"
    println(outself.v)
    println(this.v)
  }
}
/**
  * 2、定义自身类型self type
  *
  */
trait X{
  def foo={println("X foo")}
}

class Xb extends X

class B{
  //要求B在实例化或者定义子类时，必须混入指定的X类型，这个类型也可以指定为当前类型
  self:X =>


//  override def foo: Unit = self.foo
}

class C extends B with X{

}

object selftypetest{

  def main(args: Array[String]): Unit = {

    (new B with X).foo
    (new C).foo

    (new OuterSeft).v
  }
}