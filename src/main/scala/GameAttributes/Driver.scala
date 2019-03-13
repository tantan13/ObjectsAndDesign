package GameAttributes

import java.util.ArrayList
import java.util.Scanner

object Driver extends App {
  Console.println("Welcome to Risk!")
  val keyboard = new Scanner(System.in)
  val random = scala.util.Random

  var cont = true
  var numPlayers = 0

  Console.println()
  while (cont) {
    Console.println("How many players do you have? ")
    numPlayers = keyboard.nextInt()
    if (numPlayers < 3 || numPlayers > 6) {
      Console.println("Please choose between 3 and 6 players")
    } else {
      cont = false
    }
  }

  val armiesDefault = numPlayers match {
    case 3 => 35
    case 4 => 30
    case 5 => 25
    case 6 => 20
  }

  var turns = new ArrayList[Integer]()
  for (i <- 1 to numPlayers) {
    turns.add(i)
  }
  var players = new Array[Player](numPlayers)

  Console.println()
  for (i <- 1 to numPlayers) {
    Console.println(s"Name for Player $i")
    val name = keyboard.next()
    var turn = turns.remove(random.nextInt(turns.size()))
    players(i - 1) = new Player(name, turn, armiesDefault)
  }

  Console.println("\nAssigned number of armies and Player Order:")
  for (player <- players.sortBy(_.turnNo)) Console.println(player.toString)

  Console.println("\nAvailable Continents and their territories")
  Map.displayMap

  Console.println("\nPlayers will now be assigned initial territories randomly")
  Console.println("Press 'y' and enter to continue")
  var muda = keyboard.next()

  for (con <- Map.continents) {
    for (terr <- con.territories) {
      var rando = players(random.nextInt(numPlayers))
      terr.owner = rando
      terr.numArmies = 1
      terr.owner.armies -= terr.numArmies
    }
  }

  for (con <- Map.continents) {
    for (terr <- con.territories) {
      if (terr.owner.armies >= 10)
        terr.numArmies += random.nextInt(10)
      else if (terr.owner.armies < 10 && terr.owner.armies >= 1)
        terr.numArmies += random.nextInt(terr.owner.armies)
      else
        terr.numArmies = terr.numArmies
      terr.owner.armies -= terr.numArmies
    }
  }

  Console.println("\nAssigned territories:")
  Map.displayMap
}
