package GameAttributes

import scala.collection.immutable.Nil

class Territory(val name: String, var numArmies: Int, var owner: Player) {

  def this(name: String, numArmies: Int) = this(name, numArmies, null)
  def playName: String = owner.name

  override def toString: String = {
    if (owner == null)
      s"Territory: $name, Armies: $numArmies"
    else
      s"Territory: $name, Owner: $playName, Armies: $numArmies"
  }
}