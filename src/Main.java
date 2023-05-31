import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a weighted graph
        WeightedGraph<String> graph = new WeightedGraph<>();

        // Add vertices to the graph
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        // Add edges to the graph
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 7);
        graph.addEdge("C", "D", 3);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 2);

        // Perform Dijkstra's algorithm
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph);
        List<String> shortestPathDijkstra = dijkstra.findShortestPath("A", "E");
        System.out.println("Shortest Path (Dijkstra): " + shortestPathDijkstra);

        // Perform breadth-first search
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
        List<String> shortestPathBFS = bfs.findShortestPath("A", "E");
        System.out.println("Shortest Path (BFS): " + shortestPathBFS);
    }
}
