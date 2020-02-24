
public class EnqueueEfficient {
	public static final int DEFAULT_CAPACITY = 5;
	StackUsingArray primary;
	StackUsingArray secondary;
	public EnqueueEfficient() throws Exception{
		this(DEFAULT_CAPACITY); 
	}
	public EnqueueEfficient(int capacity) throws Exception {
		primary = new StackUsingArray(capacity);
		secondary = new StackUsingArray(capacity);
	}
	//enqueue
	public void enqueue(int data) throws Exception{
		primary.push(data);
	}
	//dequeue
	public int dequeue() throws Exception {
		while(primary.top != 1){
			secondary.push(primary.pop());
		}
		int rv = primary.pop();
		while(secondary.isEmpty()){
			primary.push(secondary.pop());
		}
		return rv;
	}
	//front
	public int front() throws Exception {
		while(primary.top != 1){
			secondary.push(primary.pop());
		}
	 int frontvalue = primary.pop();
	 primary.push(frontvalue);
	 while(secondary.isEmpty()){
		 primary.push(secondary.pop());
	 }
	 return frontvalue;
	} 
	//display
	public void display() {
		
	}

}
