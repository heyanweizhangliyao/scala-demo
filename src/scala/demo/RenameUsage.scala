package scala.demo.caseclass

import scala.collection.mutable
import java.util.{HashMap => JavaHashMap}

object RenameUsage {
  def main(args: Array[String]): Unit = {
    println("------------------")

    val mapJava = new JavaHashMap[String,String]();
    val map = new mutable.HashMap[String,String];
    mapJava.put("a","1");
    mapJava.put("b","2");

    map.put("spark","best");
    map.put("java","better");
    map.put("scala","good");

    for( key <- mapJava.keySet().toArray ){
      println(key+":"+mapJava.get(key));
    }

    map.foreach(e => {
      val (k,v) = e
      println(k+":"+v)
    })

  }

}
