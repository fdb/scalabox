package nodebox.app

import javax.swing.JFrame
import nodebox.node.SceneController

object Application extends JFrame("NodeBox") {
  val controller = new SceneController

  def main(args: Array[String]) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    add(new SceneView(controller))
    pack()
    setVisible(true)
  }
}