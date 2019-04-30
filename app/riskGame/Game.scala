package riskGame

import java.util.ArrayList

import javax.inject.Singleton

@Singleton
object Game extends Attack {
  var players: Array[Player] = new Array[Player](0)
  private val random = scala.util.Random
  private var nextPlayerIndex: Int = 0

  def initGame(stringPlayer: Array[String]): Unit = {
    initPlayers(stringPlayer)
    initTerritories()
  }

  private def initPlayers(stringPlayer: Array[String]): Unit= {
    val numArmies = stringPlayer.length match {
      case 3 => 35
      case 4 => 30
      case 5 => 25
      case 6 => 20
    }

    val turns = new ArrayList[Integer]()
    for (turnNo <- 1 to stringPlayer.length)
      turns.add(turnNo)

    val playerArr = new Array[Player](stringPlayer.length)
    for (i <- stringPlayer.indices) {
      playerArr(i) = new Player(stringPlayer(i), turns.remove(random.nextInt(turns.size())), numArmies)
    }

    players = playerArr.sortBy(_.turnNo)
  }

  private def initTerritories(): Unit = {
    for (terr <- RiskMap.allTerritories) {
      val newOwner = players(random.nextInt(players.size))
      if (newOwner.armies > 0) {
        newOwner.occupiedTerr += terr
        terr.owner = newOwner
        val armies = newOwner.armies match {
          case a: Int if a >= 3 => random.nextInt(3) + 1
          case _ => 1
        }
        terr.numArmies += armies
        newOwner.armies -= armies
      }
    }
  }

  def getNextPlayer: Player = {
    val player = players(nextPlayerIndex % players.size)
    nextPlayerIndex += 1
    player.calcArmies
    player
  }

  def getCurrPlayer: Player = players((nextPlayerIndex - 1) % players.size)

  def playersToString: String = {
    var x = ""
    for (player <- players) {
      x += s"Player: ${player.name}   " + player.occupiedTerr.toString + "\n"
      x += s"Armies remaining: ${player.armies}\n"
    }
    x
  }

  def addArmies(terr: Territory, armies: Int): Unit = {
    terr.owner.armies -= armies
    terr.numArmies += armies
  }

  def removePlayer(player: Player): Unit = {
    players = players.filterNot(_.equals(player)).sortBy(_.turnNo)
  }

  def gameOver(): Boolean = players.size == 1

  def moveArmies(from: Territory, to: Territory, numArmies: Int): Unit = {
    from.numArmies -= numArmies
    to.numArmies += numArmies
  }

  def contOccupied(cont: Continent, player: Player): Boolean = {
    var isOcc = true
    for (territory <- cont.territories) {
      if (!(territory.owner.equals(player))) isOcc = false
    }
    isOcc
  }


}
