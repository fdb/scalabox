package nodebox.node

class Node(
        val prototype: Option[Node],
        val name: String,
        val position: Position,
        val ports: List[Port],
        val nodes: List[Node],
        val connections: List[Connection]) {

  def this(prototype: Node, name: String, position: Position, ports: List[Port], nodes: List[Node], connections: List[Connection]) = {
    this(Some(prototype), name, position, ports, nodes, connections)
  }

  def this(prototype: Node, name: String, position: Position, ports: List[Port]) = {
    this(Some(prototype), name, position, ports, List.empty, List.empty)
  }

  private def this() = {
    this(None, "root", Position(), List.empty, List.empty, List.empty)
  }

  override def toString() = name + " (" + prototype + ")"

  def findNode(name: String): Option[Node] = nodes.find(_.name == name)

  def findPort(name: String): Option[Port] = ports.find(_.name == name)
  def portIndex(name: String): Int = ports.indexWhere(_.name == name)
}

object Node {
  val ROOT: Node = new Node()
}