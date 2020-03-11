
public class LL_as_Queue {

	private LinkedList queue;
	
	public LL_as_Queue(){
		this.queue = new LinkedList();
	}
	
	//size
	public int size(){
		return this.queue.size();
	}
	//isEmpty
	public boolean isEmpty(){
		return this.queue.isEmpty();
	}
	//enqueue
	public void enqueue(int data){
		this.queue.addLast(data);
	}
	//dequeue
	public int dequeue() throws Exception {
		return this.queue.removeFirst();
	}
	//front
	public int front() throws Exception{
		return this.queue.getFirst();
	}
	//display
	public void display(){
		this.queue.display();
	}
}
