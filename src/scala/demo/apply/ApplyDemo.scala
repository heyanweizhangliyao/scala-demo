package scala.demo.apply

class ApplyDemo {

}

object EMail{

  //apply用于无new构造对象
  def apply(user:String,domain:String)={println("apply method is calling");user+"@"+domain}

  //unapply用于匹配模式充当extrator
  def unapply(arg: String): Option[(String,String)] ={
    println("unapply method is calling")
    val parts = arg.split("@")
    if(parts.length == 2) return Some(parts(0),parts(1))
    None
  }
}

object Twice{
  def apply(s:String): String=s+s

  def unapply(arg: String): Option[String] ={
    val length = arg.length/2
    val half = arg.substring(0,length)
    if(half == arg.substring(length)) Some(half) else None
  }
}

object UpperCase{
  def unapply(s: String): Boolean = s == s.toUpperCase()
}

object ApplyAndUnapply{
  def main(args: Array[String]): Unit = {

   /* def testMatch(x:Any): Unit ={

      x match {
        case EMail(user,domain) => println("user:"+user+",domain:"+domain)
        case _ => println("不合法的匹配")
      }
    }

    testMatch(EMail("龙傲天","163.com"))
    testMatch("abcdewf")

    val s= "10.12.184.29:6400,10.12.184.15:6500,10.12.184.15:6400,10.12.184.11:6500,10.12.184.11:6400,10.12.184.29:6501,10.12.184.29:6401,10.12.184.15:6501,10.12.184.15:6401,10.12.184.11:6501,10.12.184.11:6401,10.12.184.29:6500"
    println(s.split(",").length)*/

   /* def userTwiceUpper(s:String) = {
      println(UpperCase.unapply(Twice.unapply(  EMail.unapply(s).get._1  ).get))
      s match{
      // 下面case后面的条件语句   <=>    UpperCase.unapply(Twice.unapply(  EMail.unapply(s).get._1  ).get)
        case EMail(Twice(x @ UpperCase()),domain) => "match:"+x+" indomain "+domain
        case _ => "no match"
      }
    }
    println(userTwiceUpper(EMail("ABCABC","qq.com")))*/



  /*  for (_ <- 1 to 10){
      println("a")
    }*/

    var newList = List(1,22,3,5).map(_+2)
    newList = newList sortWith (_<_)
    println(newList)

  }
}


