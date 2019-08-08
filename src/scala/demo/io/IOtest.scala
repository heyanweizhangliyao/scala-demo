package scala.demo.io

import java.io.FileWriter
import java.net.URL

import scala.io.Source

object IOtest {
  def main(args: Array[String]): Unit = {

    //读文件
   /* val file = Source.fromFile("C:\\Users\\80263843\\Desktop\\abc.txt");
    val lines = file.getLines()
    for (i <- lines) println(i)
    file.close();*/
    //写文件
   /* val outwriter = new FileWriter("file.log",true);
    outwriter.write("586xxx");
    outwriter.write(System.getProperty("line.separator"))
    outwriter.flush()
    outwriter.close()*/

    val url = Source.fromURL(new URL("http://www.baidu.com/"));
    print(url.mkString)

  }
}
