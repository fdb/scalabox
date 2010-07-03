package nodebox.node

class GeoPort(override val name: String, override val direction: Direction.Value, val geometry: Object) extends Port(name, direction) {

}