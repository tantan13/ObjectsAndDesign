package riskGame

import scala.util.Random

import scala.collection.mutable
import scala.math.min

trait Attack {
  private val random = Random

  def attack(attackTerr: Territory, defendTerr: Territory, attackDice: Int, defendDice: Int): String = {
    val attackRolls = getDiceRolls(attackDice)
    val defendRolls = getDiceRolls(defendDice)
    val losses = compareDiceRolls(attackRolls.zipAll(defendRolls, 0, 0))
    attackTerr.removeArmies(losses._1)
    defendTerr.removeArmies(losses._2)
    getAttackMsg(attackTerr, defendTerr, losses, attackRolls, defendRolls)
  }

  def occupy(fromTerr: Territory, toTerr: Territory, armies: Int): Unit = {
    toTerr.setOwner(fromTerr.owner)
    toTerr.addArmies(armies)
    fromTerr.numArmies -= armies
  }

  def getMaxDice(attackTerr: Territory, defenseTerr: Territory): (Int, Int) = {
    (min(attackTerr.numArmies - 1, 3), min(defenseTerr.numArmies, 2))
  }

  private def getDiceRolls(numDice: Int): List[Int] = {
    val rolls = new mutable.MutableList[Int]()
    for (i <- 0 until numDice) {
      rolls += random.nextInt(6) + 1
    }
    rolls.sortWith(_ > _).toList
  }

  private def compareDiceRolls(rolls: List[(Int, Int)]): (Int, Int) = {
    def compDiceHelper(rolls: List[(Int, Int)], attackLoss: Int, defenseLoss: Int): (Int, Int) = rolls match {
      case Nil => (attackLoss, defenseLoss)
      case adRolls if adRolls.head._1 <= adRolls.head._2 => compDiceHelper(rolls.tail, attackLoss + 1, defenseLoss)
      case _ => compDiceHelper(rolls.tail, attackLoss, defenseLoss + 1)
    }
    compDiceHelper(rolls, 0, 0)
  }

  private def getAttackMsg(attackTerr: Territory, defenseTerr: Territory, losses: (Int, Int), attackRolls: List[Int], defenseRolls: List[Int]): String = {
    attackTerr.owner.name + " rolled " + attackRolls.toString.substring(5, attackRolls.toString.length - 1) +
    " and lost " + losses._1 + " army/armies since "+ defenseTerr.owner.name + " rolled " +
    defenseRolls.toString.substring(5, defenseRolls.toString.length - 1) + " and lost " + losses._2 + " army/armies. \n" +
    " " + attackTerr.name + " has " + attackTerr.numArmies + " army/armies left and " + defenseTerr.name +
    " has " + defenseTerr.numArmies + " army/armies left."
  }


}
