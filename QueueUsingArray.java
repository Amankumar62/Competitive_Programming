
public class QueueUsingArray {
	protected int data[];
	protected int front;
	protected int size;
	public static final int DEFAULT_CAPACITY = 10;
	public QueueUsingArray() throws Exception{
		this(DEFAULT_CAPACITY);
	}
	public QueueUsingArray(int capacity) throws Exception{
		if(capacity<1){
			throw new Exception("Invalid Capacity");
		}
		data = new int[capacity];
		this.front = 0;
		this.size = 0;
	}
	//size()
	//enqueue()
	//dequeue()
	//display()
	//isEmpty()
	
	public int size(){
		return this.size;
	}
	
	public void enqueue(int value) throws Exception{
		if(this.size == this.data.length){
			throw new Exception("Size Exceeded");
		}
		int ai = (this.front + this.size)%this.data.length;
		this.data[ai] = value;
		this.size++;
	}
	public int dequeue() throws Exception
	{
		if(this.size == 0){
			throw new Exception("Queue is Empty");
		}
		int rv = this.data[this.front];
		this.data[this.front] = 0;
		this.front = (this.front+1)%this.data.length;
		this.size--;
		return rv;
	}
	public boolean isEmpty(){
		return this.size == 0;
	}
	public void display(){
		for(int i = 0 ; i<this.data.length;i++){
			int j = (this.front+i)%this.data.length;
		System.out.print(this.data[j]+"=>");
		}
		System.out.println("END");
	}
	
}
