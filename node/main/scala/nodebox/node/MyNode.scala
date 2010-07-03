package nodebox.node

/**
 * Created by IntelliJ IDEA.
 * User: fdb
 * Date: Jul 1, 2010
 * Time: 1:48:02 PM
 * To change this template use File | Settings | File Templates.
 */

 class MyNode(val prototype: MyNode) {
        private def this() = this(this)
    }

    object MyNode {
        val ROOT = new MyNode
    }