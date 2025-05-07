//Copyright (C) Quentin BAERT and Maxime MORGE 2019
package hulk

import akka.actor.Actor
import akka.actor.FSM
import akka.actor.*

/**
  * The messages
  */
sealed trait HulkMessage
object Flick extends HulkMessage
object Warning extends HulkMessage
object HulkSmash extends HulkMessage
object Calm extends HulkMessage

/**
  * The state of Bruce
  */
sealed trait BruceState
case object Banner extends BruceState
case object Hulk extends BruceState

/**
  * The mind of Bruce
  * @param patience is an integer representation of his memory
  */
final case class Mind(patience: Int = 3)

/**
  * Bruce is an agent, i.e. an actor with a behaviour and a state of mind
  */
class Bruce extends Actor, FSM[BruceState, Int]:
  // Bruce starts as Banner with patience
  startWith(Banner, stateData = 3)

  // When Bruce is Banner, the flicks decrease his patience until he becomes Hulk
  when(Banner) {
    case Event(Flick, patience) if patience > 0 =>
      println("Bruce: -Hum...")
      stay() using patience - 1
    case Event(Flick, patience) if patience == 0 =>
      println("Bruce: -Grr...")
      goto(Hulk) using 0 replying Warning
  }

  // When Bruce is Hulk, flicks imply a smash and he calms down, i.e. become Banner
  when(Hulk) {
    case Event(Flick, _) =>
      stay() replying{
        sender() ! HulkSmash
        self ! Calm
      }
    case Event(Calm, _) =>
      goto(Banner) using 3
  }

  // Monitoring
  onTransition {
    case from -> to => println(s"Bruce was $from and he becomes $to")
  }

  // Bruce last message when he is terminated
  onTermination { _ =>
    println("Bruce: -I am sorry...")
  }

  // Initialize Bruce
  initialize()
