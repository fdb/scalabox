package nodebox.app

import javax.swing.JPanel
import nodebox.node._
import java.awt.{Dimension, Graphics2D, Graphics}

class SceneView(val controller: SceneController) extends JPanel {
  val NODE_WIDTH = 50
  val NODE_HEIGHT = 50
  val PORT_HEIGHT = 10

  setPreferredSize(new Dimension(800, 600))

  override def paintComponent(g: Graphics) {
    val g2 = g.asInstanceOf[Graphics2D]
    val activeParent = controller.activeParent
    activeParent.connections.foreach(paintConnection(g2, activeParent, _))
    activeParent.nodes.foreach(paintNode(g2, _))
  }

  def paintConnection(g: Graphics2D, parent: Node, connection: Connection) {
    val outputNode = parent.findNode(connection.outputNodeName)
    val inputNode = parent.findNode(connection.inputNodeName)
    if (outputNode.isEmpty || inputNode.isEmpty) return
    val outputPortIndex = outputNode.get.portIndex(connection.outputPortName)
    val inputPortIndex = inputNode.get.portIndex(connection.inputPortName)
    if (outputPortIndex < 0 || inputPortIndex < 0) return
    val outputPosition = outputNode.get.position + Position(NODE_WIDTH, outputPortIndex * PORT_HEIGHT)
    val inputPosition = inputNode.get.position + Position(0, inputPortIndex * PORT_HEIGHT)
    g.drawLine(outputPosition.x, outputPosition.y, inputPosition.x, inputPosition.y)
  }

  def paintNode(g: Graphics2D, node: Node) {
    g.drawRect(node.position.x, node.position.y, NODE_WIDTH, NODE_HEIGHT)
  }
}