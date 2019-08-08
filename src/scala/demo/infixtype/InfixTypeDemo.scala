package scala.demo.infixtype

/**
  * 中置类型，最常用的场景是模式匹配
  */
case class InfixTypeDemo[S, T](val name: S, val hight: T) {

}

object InfixTypeDemo extends App {

  val infixTypeDemo: String InfixTypeDemo Long = InfixTypeDemo("龙战国", 56L)

  infixTypeDemo match {

    //    case name InfixTypeDemo hight => println("name:"+name+",hight:"+hight)
    case "龙战国" InfixTypeDemo 56L => println("matching is oking")
    case _ => println("matching nothing")

  }

  def test1(x: Array[_]) {} // 等价于 def test1(x:Array[T] forSome {type T}){}
  def test2[T](x: Array[T]) {}

  def test3[K, V](x: Map[K, V]) {}

  //  def test4(x:Map[_,_]){}
  def test4(x: Map[K, V] forSome {type K; type V}) {
    x.foreach(e => {
      val (k, v) = e
      println(k)

    })
  }


  test4(Map(124->"dafds"))

  val max = (x: Int, y: Int) => if (x < y) y else x

  //通过Funtion2定义一个输入参数为两个整型
  //返回类型为Int的函数,这里是通过new创建创建函数
  //而这个类正是Function2，它是函数类型类
  val anonfun2 = new Function2[Int, Int, Int] {
    def apply(x: Int, y: Int): Int = if (x < y) y else x
  }
  println(max(0, 1) == anonfun2(0, 1))

}