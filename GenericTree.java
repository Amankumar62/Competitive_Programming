import java.util.ArrayList;
import java.util.Scanner;
public class GenericTree{
	private class Node{
		int data;
		ArrayList<Node> children;  
		public Node(int data){
			this.data = data;
			this.children = new ArrayList<>();
		}
	}
	private Node root;
	private int size;
	
	public GenericTree(){
		Scanner s = new Scanner(System.in);
		this.root = takeInput(s,null,0);
}
	private Node takeInput(Scanner s , Node parent,int ithchild){
		if(this.root == null){
			System.out.println("Enter the value of the root node : ");
		}else{
			System.out.println("Enter the value of"+(ithchild+1)+"th child of "+parent.data+" : ");
		}
		
		int nodedata = s.nextInt();
		Node node = new Node(nodedata);
		this.size++;
		
		System.out.println("Enter the no of child nodes : ");
		int children = s.nextInt();
		for(int i=0;i<children;i++){
			Node child = takeInput(s,node,i);
			node.children.add(child);
		}
	return node;
		
	}
}