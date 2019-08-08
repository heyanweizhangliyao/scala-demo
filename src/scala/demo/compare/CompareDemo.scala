package scala.demo.compare

import java.io.Serializable

object CompareDemo extends App {

  val s1 = Student("abc",25)
  val s2 = Student("def",25)
  println(s1.compare(s2))

  val p1 = new Pair1[Student](s1,s2)
  println(p1.smaller.name)


  implicit val pp = new PersonOrdering
  //不给函数指定参数，此时会查找一个隐式值，该隐式值类型为Ordering[Person],根据上下文界定的要求，该类型正好满足要求
  //因此它会作为smaller的隐式参数传入，从而调用ord.compare(first, second)方法进行比较
  val p = new Pair[Person](Person("h1","zhangsan",22),Person("h2","wangwu",55))
  println(p.smaller.name)

  // =:= 判断类型是否相等
// T<:<U 判断T是不是U的子类

  def test[T](s:T)(implicit e:T <:< java.io.Serializable)={s+"haha"}

  def test2[T](s:T)(implicit e:T =:= java.lang.String)={println("string 类型")}

  println(test("dddd"))
  println(test2("abc"))

}

case class Student(val name: String, val age: Int) extends Ordered[Student] {
  override def compare(that: Student): Int = {
    val r = this.age - that.age
    if (r != 0) return r
    this.name.compareTo(that.name)
  }
}


//将类型参数定义为T<:Ordered[T]   //比较的时候直接使用<符号进行对象间的比较
class Pair1[T<:Ordered[T]](val first:T,val second:T){

  def smaller()={
    if(first < second)
      first
    else
      second
  }

}


//一上下文界定的参数形式为T:M 的形式，其中M是一个泛型，要求存在一个M[T]类型的隐式值
class PersonOrdering extends Ordering[Person]{
  override def compare(x: Person, y: Person): Int = {
    if(x.age != y.age) return x.age-y.age
    x.name.compareTo(y.name)
  }
}

case class Person(override val h:String, val name:String, val age:Int) extends Animal(h){
  println("person is constrcucting")
}

//下面的代码定义了一个上下文界定
//它的意思是在对应的作用域中，必须存在一个类型为Ordering[T]的隐式值，该隐式值可以作用于内部的方法
class Pair[T:Ordering](val first:T,val second:T){

  def smaller(implicit ord:Ordering[T])={
    if(ord.compare(first,second) > 0) first
    second
  }

}

class Animal(val h:String){
  def getH = h
}