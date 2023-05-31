public class Edge<Vertex> {
    private Vertex source;  // Represents the source vertex of the edge
    private Vertex dest;    // Represents the destination vertex of the edge
    private double weight;  // Represents the weight of the edge

    public Edge(Vertex source, Vertex dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;  // Returns the source vertex of the edge
    }

    public Vertex getDestination() {
        return dest;    // Returns the destination vertex of the edge
    }

    public double getWeight() {
        return weight;  // Returns the weight of the edge
    }
}