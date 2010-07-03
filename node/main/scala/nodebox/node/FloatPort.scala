package nodebox.node

class FloatPort(override val name: String, override val direction: Direction.Value, val value: Float) extends Port(name, direction) {
  
}