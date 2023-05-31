import java.util.*;

public abstract class Search<Vertex> {
    private WeightedGraph<Vertex> graph;

    public Search(WeightedGraph<Vertex> graph) {
        this.graph = graph;  // Initializes the graph used for searching
    }

    public WeightedGraph<Vertex> getGraph() {
        return graph;  // Returns the graph being used for searching
    }

    public boolean doesPathExist(Vertex source, Vertex destination) {
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        visited.add(source);
        queue.offer(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current.equals(destination)) {
                return true;  // Returns true if the destination vertex is reached
            }

            List<Edge<Vertex>> adjacentEdges = graph.getAdjacentEdges(current);
            for (Edge<Vertex> edge : adjacentEdges) {
                Vertex neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);  // Adds the unvisited neighboring vertices to the queue
                }
            }
        }

        return false;  // Returns false if the destination vertex is not reachable
    }

    public abstract boolean pathExist(Vertex source, Vertex destination);
}