
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
	
	public boolean find(int item){
		return find(this.root,item);
	}
	
	private boolean find(Node node,int item){
		if(node == null){
			return false;
		}
		if(item > node.data){
			return find(node.right,item);
		}
		else if(item < node.data){
			return find(node.left,item);
		}
		else{
			return true;
		}
	}
	
	public int max(){
		return max(this.root);
	}
	private int max(Node node){
		if(node.right == null){
			return node.data;
		}
		
		return max(node.right);
	}
	
	public void add(int item){
		add(this.root,item);
	}
	
	private void add(Node node , int item){
		if(item > node.data){
			if(node.right == null){
				Node nn = new Node();
				nn.data = item;
			   node.right = nn;
			}else{
				add(node.right,item);
			}
		}
		else{
			if(node.left == null){
				Node nn = new Node();
				nn.data= item;
				node.left = nn;
			}
			else{
				add(node.left,item);
			}
		}
	}
	
	public void remove(int item){
		remove(this.root,null,false,item);
	}
	private void remove(Node node,Node parent,boolean ilc,int item){
		if(node == null){
			return;
		}
		if(item > node.data){
			remove(node.right,node,false,item);
		}
		else if(item < node.data){
			remove(node.left,node,true,item);
		}
		else{
			if(node.left == null && node.right == null){
				if(ilc){
					parent.left = null;
				}
				else{
					parent.right = null;
				}
			}
			else if(node.left== null && node.right != null){
				 if(ilc){
					 parent.left = node.right;
				 }
				 else{
					 parent.right = node.right;
				 }
			}
			else if(node.left != null && node.right== null){
				if(ilc){
					parent.left = node.left; 
				}
				else{
					parent.right = node.left;
				}
			}
			
			else{
				int max = max(node.left);
				node.data = max;
				
				remove(node.left,node,true,max);
			}
		}
	}
	
	public boolean isBST(){
		return isBST(this.root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private boolean isBST(Node node,int min,int max){
		if(node == null){
			return true;
		}
		if(node.data >max || node.data < min){
			return false;
		}
		else if(!isBST(node.left,min,node.data)){
			return false;
		}
		else if(!isBST(node.right,node.data,max)){
			return false;
		}
		else{
			return true;
		}
	}
	
	public int sumLeaf(){
		return sumLeaf(this.root);
	}
	private int sumLeaf(Node node){
		if(node == null){
			return 0;
		}
		if(node.right == null && node.left == null){
			return node.data;
		}
		int lsum = sumLeaf(node.left);
		int rsum = sumLeaf(node.right);
		return (lsum+rsum);
	}
}
