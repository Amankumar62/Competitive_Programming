import java.util.Scanner;
import java.util.*;
public class BinaryTree {
	private class Node{
		int data;
		Node left;
		Node right;
		Node(int data,Node left,Node right){
			this.data= data;
			this.left = left;
			this.right= right;
		}
	}
	
	private Node root;
	private int size;
	
	BinaryTree(){
		Scanner s = new Scanner(System.in);
		this.root = takeInput(s,null,false);
	}
	private Node takeInput(Scanner s ,Node parent ,boolean isLeftOrRight){
		if(parent==null){
			System.out.println("Enter the value of the root node : ");
		}else{
			if(isLeftOrRight){
				System.out.println("Enter the value of left node : ");
			}else{
				System.out.println("Enter the value of right node : ");
			}
		}
		
		int nodedata = s.nextInt();
		Node node = new Node(nodedata,null,null);
		this.size++;
		boolean choice = false;
		System.out.println("Do "+node.data+" have a left child : ");
		choice = s.nextBoolean();
		if(choice){
			node.left = takeInput(s,node,true);
		}
		choice = false;
		System.out.println("Do "+node.data+" have a right child : ");
		choice = s.nextBoolean();
		if(choice){
			node.right = takeInput(s,node,false);
		}
		return node;
	}
	
	public void display(){
		this.display(this.root);
	}
	private void display(Node node){
		String str = "";
		if(node.left != null){
			str = node.left.data + " => ";
		}else{
			str = "END => ";
		}
		str = str + node.data;
		if(node.right != null){
			str = str +" <= "+node.right.data;
		}else{
			str = str +" <= END ";
		}
		System.out.println(str);
		if(node.left!=null){
			this.display(node.left);
		}
		if(node.right!=null){
			this.display(node.right);
		}
		
	}
	
	public int height(){
		return this.height(this.root);
	}
	
	private int height(Node node){
		if(node == null){
			return -1;
		}
		int lheight = this.height(node.left);
		int rheight = this.height(node.right);
		
		int height = Math.max(lheight,rheight)+1;
		return height;
	}
	
	public void preOrder(){
		this.preOrder(this.root);
	}
	private void preOrder(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data+" ");
		this.preOrder(node.left);
		this.preOrder(node.right);
	}
	
	public void inOrder(){
		this.inOrder(this.root);
	}
	private void inOrder(Node node){
		if(node == null){
			return;
		}
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	
	public void postOrder(){
		this.postOrder(this.root);
	}
	
	private void postOrder(Node node){
		if(node == null){
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}
	
	public void levelOrder() throws Exception{
		LinkedListGenerics<Node> queue = new LinkedListGenerics<>();
		queue.addLast(this.root);
		while(!queue.isEmpty()){
			Node rv = queue.removeFirst();
			System.out.print(rv.data+" ");
			if(rv.left != null){
				queue.addLast(rv.left);
			}
			if(rv.right !=null){
				queue.addLast(rv.right);
			}
		}
		System.out.print("END");
	}
}