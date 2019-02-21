package GameAttributes

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
  val turns = 1 to numPlayers
  var players = new Array[Player](numPlayers)

  for (i <- 1 to numPlayers) {
    Console.println(s"Name for Player $i")
    val name = keyboard.next()
    players(i - 1) = new Player(name, turns(i - 1), armiesDefault - (5 * (numPlayers - 3)))
  }

  for (player <- players) Console.println(player.toString)



}
