//Copyright (C) Maxime MORGE 2019
package hulk

import akka.actor.*
import scala.io.StdIn

/**
  * Test Bruce
  */
object Main extends App:

  // Create the actor system
  val system: ActorSystem = ActorSystem("PlayHulk")

  try
    // Create Bruce and the reckless agent
    val bruce: ActorRef = system.actorOf(Props(classOf[Bruce]))
    system.actorOf(Props(classOf[Reckless], bruce))
    println(">>> Press ENTER to exit <<<")
    StdIn.readLine()
    
  finally
    system.terminate()
    
  

// @main def hello(): Unit =
//   println("Hello world!")
//   println(msg)

// def msg = "I was compiled by Scala 3. :)"