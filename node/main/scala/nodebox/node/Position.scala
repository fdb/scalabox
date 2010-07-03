package nodebox.node

class Position(val x: Int, val y: Int) {
  def +(o: Position) = new Position(x + o.x, y + o.y)
}

object Position {
  private val ZERO = new Position(0, 0)

  def apply() = ZERO

  def apply(x: Int, y: Int) = new Position(x, y)
}