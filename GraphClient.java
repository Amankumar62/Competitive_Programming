
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
		
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 10);
		graph.addEdge("D", "C", 1);
		graph.addEdge("B", "C", 3);
		graph.addEdge("D", "E", 8);
		graph.addEdge("E", "F", 5);
		graph.addEdge("F", "G", 4);
		graph.addEdge("E", "G", 6);
		
		graph.display();
		System.out.println(graph.getCC());
//		graph.bft();
//		graph.dft();
//		);
		System.out.println(graph.dijkstra("A"));
		
		
	}

}
