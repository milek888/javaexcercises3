package graphs;

public class Node {
    private int label;
    private String data;

    public Node(int label, String data) {
        this.label = label;
        this.data = data;
    }

    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public int getLabel() {
        return label;
    }

    public String getData() {
        return data;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        return label == node.label;
    }

    @Override
    public int hashCode() {
        return label;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("label=").append(label);
        sb.append(", data='").append(data).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
