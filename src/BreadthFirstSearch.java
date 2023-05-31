import java.util.*;

public class BreadthFirstSearch<Vertex> extends Search<Vertex> {
    private Map<Vertex, Vertex> parentMap;

    public BreadthFirstSearch(WeightedGraph<Vertex> graph) {
        super(graph);
        parentMap = new HashMap<>();  // Initializes the parent map for tracking the path
    }

    public List<Vertex> findShortestPath(Vertex source, Vertex destination) {
        parentMap = new HashMap<>();  // Clears the parent map for each path finding

        if (!pathExist(source, destination)) {
            return null;  // If there is no path between the source and destination, return null
        }

        List<Vertex> path = new ArrayList<>();
        Vertex current = destination;
        while (!current.equals(source)) {
            path.add(0, current);  // Adds the current vertex to the beginning of the path list
            current = parentMap.get(current);  // Moves to the parent vertex
        }
        path.add(0, source);  // Adds the source vertex at the beginning of the path list

        return path;  // Returns the shortest path from the source to the destination
    }

    @Override
    public boolean pathExist(Vertex source, Vertex destination) {
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        visited.add(source);
        queue.offer(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current.equals(destination)) {
                return true;  // Returns true if the destination vertex is reached
            }

            List<Edge<Vertex>> adjacentEdges = getGraph().getAdjacentEdges(current);
            for (Edge<Vertex> edge : adjacentEdges) {
                Vertex neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);  // Sets the current vertex as the parent of the neighboring vertex
                    queue.offer(neighbor);  // Adds the unvisited neighboring vertex to the queue
                }
            }
        }

        return false;  // Returns false if the destination vertex is not reachable
    }
}