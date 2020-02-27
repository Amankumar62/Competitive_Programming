
public class LinkedList {
	private class Node{
	 int data;
	 Node next;
	} 
	private Node head;
	private Node tail;
	private int size;
	
	public void display(){
		Node temp = this.head;;
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	public void addLast(int item){
		Node nn = new Node();
		nn.data = item;
		nn.next = null;
		
		//linking the nodes 
		if(this.size >=1){
			this.tail.next=nn;
		}
		//updating summary object
		if(this.size == 0){
			this.head = nn; 
			this.tail = nn;
			this.size++;
		}else{
			this.tail = nn;
			this.size++;
		}
	}
	public void addFirst(int item){
		Node nn = new Node();
		nn.data = item;
		nn.next = null;
		
		//linking nodes 
		if(this.size >=1){
			nn.next = this.head;
		}
		
		//updtaing summary object
		if(this.size ==0){
			this.head = nn;
			this.tail= nn;
			this.size++;
		}
		else{
			this.head = nn;
			this.size++;
		}
	}
		
		public int getAt( int index) throws Exception{
			if(this.size ==0){
				throw new Exception("Linked list is Empty");
			}
			if(index<0 || index >size){
				throw new Exception("Invalid Size");
			}
			
			Node temp = this.head;
			for(int i=1;i<=index;i++){
				temp = temp.next;
			}
			return temp.data;
		}
		
	public int getFirst() throws Exception{
		if(this.size==0){
			throw new Exception("Empty Linked list");
		}
		return this.head.data;
	}
	public int getLast() throws Exception{
		if(this.size ==0){
			throw new Exception("Empty Linked list");
		}
		return this.tail.data;
	}
	
	private Node getNodeAt(int index) throws Exception{
		if(this.size ==0){
			throw new Exception("Empty Linked list");
		}
		if(index <0 || index >this.size){
			throw new Exception("Invalid index");
		}
		
		Node temp = this.head;
		for(int i=1;i<=index;i++){
			temp = temp.next;
		}
		return temp;
		
	}
	public static void main(String A[]) throws Exception{
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addFirst(20);
		list.addLast(30);
		list.addFirst(40);
		list.display();
		System.out.println(list.getAt(2));
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
	}
}
