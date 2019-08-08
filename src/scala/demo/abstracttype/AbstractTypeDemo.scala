package scala.demo.abstracttype

object AbstractTypeDemo extends App {
  val any:ConcretePersonA = ConcretePersonA(null)
  any.dosomething("龙战国","泡面")
}

abstract class PersonA{

  def test()={println("aaa")}

  def dosomething(name:in,food:out)
  type in
  type out
  type fin


}

case class ConcretePersonA(val h:Any) extends PersonA{
  override def dosomething(name:String,food:String): Unit = println(name+" person eat "+food+" with chopsticks")

  override type in = String
  override type out = String
  override type fin = Boolean
}