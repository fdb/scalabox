package nodebox.node

object Direction extends Enumeration {
  val OUTPUT = Value("Output")
  val INPUT = Value("Input")
}
abstract class Port(val name: String, val direction: Direction.Value) {
  
}