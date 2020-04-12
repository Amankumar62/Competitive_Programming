
public class SegmentTree {
	private class Node{
		int data;
		int startInterval;
		int endInterval;
		Node left;
		Node right;
	}
	
	Node root;
	
	public SegmentTree(int arr[]){
		this.root = this.constructTree(arr,0,arr.length -1);
	}
	private Node constructTree(int arr[] ,int si , int ei){
		if(si == ei){
			Node leafNode = new Node();
			leafNode.data = arr[si];
			leafNode.startInterval = si;
			leafNode.endInterval = ei;
			return leafNode;
		}
		Node node = new Node();
		node.startInterval = si;
		node.endInterval = ei;
		int mid = (si+ei)/2;
		node.left = this.constructTree(arr,si,mid);
		node.right = this.constructTree(arr,mid+1,ei);
		node.data = node.left.data + node.right.data;
		return node;
	}
	public void display(){
		this.display(this.root);
	}
	private void display(Node node){
		String str = "";
		if(node.left != null){
			str = str + "Interval ["+node.left.startInterval +"-"+node.left.endInterval+"]" +node.left.data + "=> ";
		}else{
			str= str + "No left Node => ";
		}
		str = str + "[ "+node.startInterval+ "-"+ node.endInterval + "] " + node.data;
		
		if(node.right != null){
			str = str + "<= "+ node.right.data + " Interval ["+node.right.startInterval +"-"+node.right.endInterval+"] ";
		}else{
			str = str + "<= No right Node ";
		}
		
		System.out.println(str);
		
		if(node.left!= null){
			this.display(node.left);
		}
		if(node.right!= null){
			this.display(node.right);
		}
	}
	
	public int query(int qsi,int qei){
		return query(this.root,qsi,qei);
	}
	private int query(Node node , int qsi , int qei){
		if(node.startInterval >=qsi && node.endInterval <= qei ){
			return node.data;
		}else if(node.startInterval > qei || node.endInterval < qsi){
			return 0;
		} else{
			int leftans = query(node.left,qsi,qei);
			int rightans = query(node.right,qsi,qei);
			return leftans + rightans;
		}
	}
	public void update(int index,int newValue){
		this.root.data = update(this.root,index,newValue);
	}
	
	private int update(Node node,int index,int newValue){
		if(index>=node.startInterval && index <= node.endInterval){
			if(node.startInterval == index && node.endInterval == index){
				node.data = newValue;
			}else{
				int leftans = update(node.left,index,newValue);
				int rightans= update(node.right,index,newValue);
				node.data = leftans+rightans;
			}
		}
		return node.data;
	}
	
}
