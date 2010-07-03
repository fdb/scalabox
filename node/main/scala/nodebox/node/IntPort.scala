package nodebox.node

class IntPort(override val name: String, override val direction: Direction.Value, val value: Int) extends Port(name, direction) {

}