package GameAttributes

class Player(val name: String, val turnNo: Int, var armies: Int) {
  override def toString: String = s"Player: $name, Armies: $armies, Turn No.: $turnNo"

}
