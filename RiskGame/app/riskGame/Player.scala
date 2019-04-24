package riskGame

import scala.collection.mutable.ListBuffer

class Player(val name: String, val turnNo: Int, var armies: Int) {
  def this(name: String) = this(name, 0, 0)
  var totalArmies: Int = armies
  var occupiedConts: List[Continent] = List()
  val occupiedTerr: ListBuffer[Territory] = ListBuffer()


  override def toString: String = s"Player: $name, Armies: $armies, Turn No.: $turnNo"

  def calcArmies: Unit = {
    var newArmies = occupiedTerr.size match {
      case num if num < 9 => 3
      case _ => occupiedTerr.size / 3
    }
    occupiedConts.foreach(newArmies += _.bonus)

    this + newArmies
  }

  def +(addArmies: Int): Unit = {
    armies += addArmies
    totalArmies += addArmies
  }

  def -(negArmies: Int): Unit = {
    totalArmies -= negArmies
  }

  override def equals(obj: Any): Boolean = obj match {
    case p: Player => p.name.equals(this.name)
    case _ => false
  }

  def getOccTerr: List[Territory] = occupiedTerr.toList

  def isOut: Boolean = totalArmies <= 0




}