package GameAttributes

import java.util.ArrayList
import java.util.Scanner

object Driver extends App {
  Console.println("Welcome to Risk!")
  val keyboard = new Scanner(System.in)
  val random = scala.util.Random

  var cont = true
  var numPlayers = 0

  while (cont) {
    Console.println("How many players do you have? ")
    numPlayers = keyboard.nextInt()
    if (numPlayers < 3 || numPlayers > 6) {
      Console.println("Please choose between 3 and 6 players")
    } else {
      cont = false
    }
  }
  val armiesDefault = 35
  var turns = new ArrayList[Integer]();
  for (i <- 1 to numPlayers) {
    turns.add(i);
  }
  var players = new Array[Player](numPlayers)

  for (i <- 1 to numPlayers) {
    Console.println(s"Name for Player $i")
    val name = keyboard.next()
    var turn = turns.remove(random.nextInt(turns.size()))
    players(i - 1) = new Player(name, turn, armiesDefault - (5 * (numPlayers - 3)))
  }

  for (player <- players) Console.println(player.toString)



}
