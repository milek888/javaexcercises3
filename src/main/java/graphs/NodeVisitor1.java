package graphs;

public class NodeVisitor1 implements Visitor {

    public static NodeVisitor1 getNodeVisitor1() {
        return new NodeVisitor1();
    }
    @Override
    public double visit(Node node) {
        return node.getLabel()*node.getLabel();
    }
}
