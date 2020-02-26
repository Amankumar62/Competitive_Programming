
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
	public static void main(String A[]){
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.display();
	}
}
