
public class BST {
	private class Node{
		int data;
		Node left;
		Node right;
	}
	private Node root;
	
	public BST(int arr[]){
		this.root = this.construct(arr,0,arr.length-1);
	}
	private Node construct(int arr[],int lo,int hi){
		//base case
		if(lo>hi){
			return null;
		}
		//mid 
		int mid = (lo+hi)/2;
		//construct the node
		Node nn = new Node();
		nn.data = arr[mid];
		nn.left = this.construct(arr, lo, mid-1);
		nn.right = this.construct(arr,mid+1,hi);
		
		return nn;
	}
	
	public void display(){
		this.display(this.root);
	} 
	
	private void display(Node node){
		String str = "";
		if(node.left!=null){
			str = str +node.left.data+" => ";
		}else{
			str = str + "END => ";
		}
		str = str + node.data;
		
		if(node.right!=null){
			str = str + " <= "+node.right.data;
		}
		else{
			str = str + " <= END";
		}
		System.out.println(str);
		if(node.left!=null){
		this.display(node.left);
		}
		if(node.right!=null){
		this.display(node.right);
		}
	}
}
