package ilio.algorithm

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class AppLoader {
}

object AppLoader extends App {

    override def main(args: Array[String]): Unit = SpringApplication.run(classOf[AppLoader])
}
