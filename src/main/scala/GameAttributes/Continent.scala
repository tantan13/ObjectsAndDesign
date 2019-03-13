package GameAttributes

class Continent(val name: String, val bonus: Int, val territories: List[Territory]) {
  override def toString: String = s"Continent: $name \n" + getTerritories

  def getTerritories: String = {
    var territoriesString = ""
    territories.foreach(territoriesString += "    " + _.toString + " \n")
    territoriesString.substring(0, territoriesString.length - 2) + "\n"
  }
}