package scala.demo.caseclass

import java.io.{File, FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

import scala.beans.BeanProperty

object SwitchTest {


  /**
    * case class   Case Class一般被翻译成样例类，它是一种特殊的类，能够被优化以用于模式匹配
    *
    * 当一个类被声名为case class的时候，scala会帮助我们做下面几件事情：
    * 1 构造器中的参数如果不被声明为var的话，它默认的话是val类型的，但一般不推荐将构造器中的参数声明为var
    * 2 自动创建伴生对象，同时在里面给我们实现子apply方法，使得我们在使用的时候可以不直接显示地new对象
    * 3 伴生对象中同样会帮我们实现unapply方法，从而可以将case class应用于模式匹配，关于unapply方法我们在后面的“提取器”那一节会重点讲解
    * 4 实现自己的toString、hashCode、copy、equals方法
    * 除此之此，case class与其它普通的scala类没有区别
    *
    *在进行模式匹配的时候，有些时候需要确保所有的可能情况都被列出，此时常常会将case class的超类定义为sealed（密封的) case class
    *
    *
    * @param args
    */


  def main(args: Array[String]): Unit = {

    val s = Student("zhangsan",26,32056)
    //深度copy
    val sCopy = s.copy()
    println(s==sCopy)//true
    println(s eq(sCopy)) //false
    println(s)//toString方法

    val sCopy_name = s.copy("武当张三丰")
    println(sCopy_name)
    println(sCopy_name eq(s))


    matchTest2

    matchTest3

    //可以在方法中定义方法

    def patternShow(x:Any)= {
      println( "patternShow is calling",x)
      x match {
        case 5 => "five"
        case "Mon" => "星期一"
        case "Sep" => "九月份"
        case null => "null"
        case Nil => "empty list"
        case _ => "other constant"
      }
    }
    println(patternShow(5))

   /* Map.apply("abc"->1,"546"->22).foreach(ele => println(ele._1,ele._2) )
    for( (k,v) <- Map.apply("abc"->1,"546"->22)){
      println(k,v)
    }*/

    val w = new Worker("abc",12)
    w.workNo=("023652136")


    val file = new File("person.log")
    val out = new ObjectOutputStream(new FileOutputStream(file))
    out.writeObject(w)
    out.close()

    val in = new ObjectInputStream(new FileInputStream(file))
    val worker = in.readObject()
    print(worker)
    in.close()

  }


  def matchTest1={
    for(i <- 1 to 81){

      i match{
        case 10 => println(10)
        case _ if(i%7 == 0) => println("7的倍数:"+i)
        case _ if(i%8 == 0) => println("8的倍数:"+i)
        case _ if(i%5 == 0) => println("5的倍数:"+i)
        case _ if(i%3==0) => println("3的倍数:"+i)
        case _ =>
      }

    }
  }


  def matchTest2={
    val schoolCase = SchoolCase("华润大厦OPPO",Teacher("zhang",26,"02321"),Student("lisi",18,36523),Nobody("无名氏"))
    schoolCase match {
      case SchoolCase(_,_,_,Nobody(name)) => println(name)
      case SchoolCase(_,Teacher(name,age,teacherNo),_,_) => println("Teacher",name,age,teacherNo)
      case _ => println("other case")

    }
  }

  def matchTest3={
   val p:Person = Teacher("陈景润",29,"025463")
    p match {
      case Teacher(name,age,teacherNo) => println("Teacher->"+p)
      case Student(name,age,teacherNo) => println("Student->"+p)
      case Nobody(name) => println("Nobody->"+p)
    }
  }

}


sealed abstract class Person

case class Teacher(name:String,age:Int,teacherNo:String) extends Person

case class Student(name:String,age:Int,studentNo:Int) extends Person

case class Nobody(name:String) extends Person


// 多个参数的case class
case class SchoolCase (desc:String,persons:Person*)


@SerialVersionUID(5441454524L)
class Worker(val name:String,val age:Int) extends Serializable{

  @volatile
  @BeanProperty
  @transient
  var workNo:String = null
}