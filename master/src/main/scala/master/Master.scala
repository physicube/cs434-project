package master

import org.apache.logging.log4j.scala.Logging
import org.apache.logging.log4j.Level
import message.greeter

object Master {
  def main(args: Array[String]): Unit = {
    if (args.length == 0) {
      println("no arg")
    }
  }
  
}