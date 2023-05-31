import java.util.*;

public class WeightedGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> adjacencyList;

    public WeightedGraph() {
        adjacencyList = new HashMap<>();  // Initializes the adjacency list as a HashMap
    }

    public void addVertex(Vertex vertex) {
        adjacencyList.put(vertex, new ArrayList<>());  // Adds a vertex to the graph with an empty list of edges
    }

    public void addEdge(Vertex source, Vertex destination, int weight) {
        validateVertex(source);         // Validates the source vertex
        validateVertex(destination);    // Validates the destination vertex

        Edge<Vertex> edge = new Edge<>(source, destination, weight);  // Creates a new edge with the given source, destination, and weight
        adjacencyList.get(source).add(edge);  // Adds the edge to the list of adjacent edges for the source vertex
    }

    private void validateVertex(Vertex vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is not present in the graph");  // Throws an exception if the vertex is not in the graph
        }
    }

    public List<Edge<Vertex>> getAdjacentEdges(Vertex vertex) {
        validateVertex(vertex);  // Validates the vertex
        return adjacencyList.get(vertex);  // Returns the list of adjacent edges for the given vertex
    }

    public Set<Vertex> getVertices() {
        return adjacencyList.keySet();  // Returns a set of all vertices in the graph
    }
}
