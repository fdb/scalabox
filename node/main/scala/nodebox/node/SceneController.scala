package nodebox.node

class SceneController {
  var scene: Scene = {
    val xPort = new IntPort("x", Direction.INPUT, 10)
    val yPort = new IntPort("x", Direction.INPUT, 20)
    val outputPort = new GeoPort("output", Direction.OUTPUT, null)
    val rectNode = new Node(Node.ROOT, "rect1", Position(20, 30), List(xPort, yPort, outputPort))
    val geoPort = new GeoPort("geo", Direction.INPUT, null)
    val renderNode = new Node(Node.ROOT, "render1", Position(100, 30), List(geoPort))
    val rectRenderConnection = new Connection("rect1", "output", "render1", "geo")
    val rootNet = new Node(Node.ROOT, "root", Position(0, 0), List.empty, List(rectNode, renderNode), List(rectRenderConnection))
    new Scene(rootNet)
  }
  var history: List[Scene] = List(scene)
  var activeParent: Node = scene.root


  def addNode() {

  }

}