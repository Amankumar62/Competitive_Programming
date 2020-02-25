
public class SUQPopEfficient {
	private DynamicQueue primary;
	private DynamicQueue secondary;
	
	public SUQPopEfficient (int capacity) throws Exception{
		this.primary = new DynamicQueue(capacity);
		this.secondary = new DynamicQueue(capacity);
	}
	//size O(n)
	public int size(){
		return this.primary.size();
	}
	//push O(n)
	public void push(int data) throws Exception{
		while(!this.primary.isEmpty()){
			this.secondary.enqueue(this.primary.dequeue());
		}
	 this.primary.enqueue(data);
	 while(!this.secondary.isEmpty()){
		 this.primary.enqueue(this.secondary.dequeue());
	 }
	}
	//pop O(1)
	public int pop() throws Exception{
		return this.primary.dequeue();
	}
	//top O(1)
	public int top() throws Exception{
		return this.primary.front;
	}
	//display O(n)
	public void display() throws Exception{
		this.primary.display();
	}
	public static void main(String args[]) throws Exception{
		SUQPopEfficient stack = new SUQPopEfficient(5);
		for(int i =1 ; i <=5;i++){
			stack.push(i*10);
		}
		stack.display();
	}
}
