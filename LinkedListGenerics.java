
public class LinkedListGenerics<T> {
	private class Node{
		 T data;
		 Node next;
		} 
		private Node head;
		private Node tail;
		private int size;
		
		public int size(){
			return this.size;
		}
		public boolean isEmpty(){
			return this.size <=0;
		}
		public void display(){
			Node temp = this.head;;
			while(temp!=null){
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
		public void addLast(T item){
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
		public void addFirst(T item){
			Node nn = new Node();
			nn.data = item;
			nn.next = null;
			
			//linking nodes 
			if(this.size >=1){
				nn.next = this.head;
			}
			
			//updating summary object
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
			
			public T getAt( int index) throws Exception{
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
			
		public T getFirst() throws Exception{
			if(this.size==0){
				throw new Exception("Empty Linked list");
			}
			return this.head.data;
		}
		public T getLast() throws Exception{
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
		public T removeFirst() throws Exception{
			if(this.size ==0){
				throw new Exception("Empty linked list");
			}
			T rv;
			if(this.size ==1){
				 rv = this.head.data;
				this.head = null;
				this.tail = null;
			    this.size =0;
			}
			else{
				rv = this.head.data;
				this.head = this.head.next;
			}
			return rv;
		}
		public T removeLast() throws Exception{
			if(this.size ==0){
				throw new Exception("Empty linked list");
			}
			T rv;
			if(this.size ==1){
				rv = this.tail.data;
				this.head = null;
				this.tail = null;
				this.size=0;
			}
			else{
				rv = this.tail.data;
				Node lm1 = this.getNodeAt(this.size -2);
				this.tail = lm1;
				this.tail.next = null;
				this.size --;
			}
			return rv;
		}
		
		public T removeAt(int index) throws Exception {
			if(this.size ==0 ){
				throw new Exception("Empty linked List");
			}
			if(index<0 || index>=this.size){
				throw new Exception("Invalid index");
			}
			
			if(index ==0){
				return this.removeFirst();
			}
			if(index==this.size-1){
				return this.removeLast();
			}
			Node nm1 = this.getNodeAt(index -1);
			Node n = nm1.next;
			T rv = n.data;
			Node np1 = n.next;
			nm1 = np1;
			n.next = null;
		    this.size--;
			return rv;
		}
		
		public void reverseData() throws Exception{
			int left =0;
			int right = this.size -1;
			 while(left < right){
				 Node ln = getNodeAt(left);
				 Node rn = getNodeAt(right);
				 
				 T temp = ln.data;
				 ln.data = rn.data;
				 rn.data = temp;
				 
				 left++;
				 right--;
			 }
		}
		
		public void reversePointer() {
			Node prev = this.head;
			Node curr= prev.next;
			
			while(curr!=null){
				Node ahead = curr.next;
				
				curr.next = prev;
				prev = curr;
				curr = ahead;
				}
			Node temp = this.head;
			this.head = this.tail;
			this.tail = temp;
			this.tail.next= null;
		}
		public T mid() {
			Node slow =this.head;
			Node fast = this.head;
			
			while(fast.next != null && fast.next.next !=null){
				slow=slow.next;
				fast = fast.next.next;
			}
			return slow.data;
		}
}
