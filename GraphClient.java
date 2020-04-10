
public class GraphClient {

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "D", 1);
		graph.addEdge("D", "C", 1);
		graph.addEdge("B", "C", 1);
		graph.addEdge("D", "E", 1);
		graph.addEdge("E", "F", 1);
		graph.addEdge("F", "G", 1);
		graph.addEdge("E", "G", 1);
		
		graph.display();

		graph.bft();
	}

}
