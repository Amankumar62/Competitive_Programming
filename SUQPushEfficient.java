
public class SUQPushEfficient {
	private DynamicQueue primary;
	private DynamicQueue secondary;
	
	public SUQPushEfficient(int capacity) throws Exception{
		this.primary = new DynamicQueue(capacity);
		this.secondary = new DynamicQueue(capacity);
	}
	
	//size
	public int size() {
		 return this.primary.size();
	}
	//isEmpty
	public boolean isEmpty() {
		return this.primary.isEmpty();
	}
	//push
	public void push(int data) throws Exception{
		this.primary.enqueue(data);
	}
	//pop
	public int pop() throws Exception{
		while(this.primary.size() != 1){
			this.secondary.enqueue(this.primary.dequeue());
		}
		int rv = this.primary.dequeue();
		while(!this.secondary.isEmpty()){
			this.primary.enqueue(this.secondary.dequeue());
		}
		return rv;
	}
	//top
	public int top() throws Exception{
		while(this.primary.size() != 1){
			this.secondary.enqueue(this.primary.dequeue());
		}
		int rv = this.primary.dequeue();
		this.primary.enqueue(rv);
		while(!this.secondary.isEmpty()){
			this.primary.enqueue(this.secondary.dequeue());
		}
		return rv;
	}
	//display
	public void display() throws Exception{
		reverseQueue(this.primary);
		this.primary.display();
		reverseQueue(this.primary);
	}
	
	private void reverseQueue(DynamicQueue queue) throws Exception{
		if(queue.isEmpty()){
			return;
		}
		int item = queue.dequeue();
		reverseQueue(queue);
		queue.enqueue(item);
	}
	
	public static void main(String args[]) throws Exception{
		SUQPushEfficient stack = new SUQPushEfficient(5);
		for(int i = 1; i<=5;i++){
			stack.push(i * 10);
		}
		stack.display();
		System.out.println(stack.pop());
		stack.display();
	}
}

