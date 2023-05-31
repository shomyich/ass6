import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private Map<Vertex, Integer> distance;
    private Map<Vertex, Vertex> parentMap;

    public DijkstraSearch(WeightedGraph<Vertex> graph) {
        super(graph);
    }

    public List<Vertex> findShortestPath(Vertex source, Vertex destination) {
        calculateShortestDistances(source);

        if (!distance.containsKey(destination)) {
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

    private void calculateShortestDistances(Vertex source) {
        distance = new HashMap<>();
        parentMap = new HashMap<>();

        for (Vertex vertex : getGraph().getVertices()) {
            distance.put(vertex, Integer.MAX_VALUE);  // Initialize all distances to infinity
        }

        distance.put(source, 0);  // Distance from the source to itself is 0
        parentMap.put(source, null);  // The source has no parent

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));
        queue.offer(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            List<Edge<Vertex>> adjacentEdges = getGraph().getAdjacentEdges(current);
            for (Edge<Vertex> edge : adjacentEdges) {
                Vertex neighbor = edge.getDestination();
                int weight = (int) edge.getWeight();
                int newDistance = distance.get(current) + weight;

                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);  // Update the distance to the neighboring vertex
                    parentMap.put(neighbor, current);  // Set the current vertex as the parent of the neighboring vertex
                    queue.offer(neighbor);  // Add the neighboring vertex to the priority queue
                }
            }
        }
    }
}