package riskGame

class Territory(val name: String, var numArmies: Int, val continent: Continent) {
  def this(name: String, continent: Continent) = this(name, 0, continent)
  var owner: Player = new Player("player")

  override def toString: String = s"Territory: $name, Armies: $numArmies, Owner: ${owner.name}"

  def addArmies(armies: Int): Unit = numArmies += armies

  def removeArmies(armies: Int): Unit = {
    val takeAway = armies match {
      case num if armies > numArmies => numArmies
      case _ => armies
    }
    numArmies -= takeAway
    owner - takeAway
  }

  def setOwner(player: Player): Unit = owner = player

  def isConquered: Boolean = numArmies == 0
}