
public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StackUsingArray stack = new StackUsingArray(5);
		for(int i=1;i<=5;i++){
			stack.push(i*10);
		}
		StackUsingArray helper = new StackUsingArray(5);
		stack.display();
		reverseStack(stack,helper,0);
		stack.display();
	}
	
	public static void reverseStack(StackUsingArray stack,StackUsingArray helper,int index) throws Exception{
		if(stack.isEmpty()){
			return;
		}
		int item = stack.pop();
		reverseStack(stack,helper,index+1);
		helper.push(item);
		if(index == 0){
			while(!helper.isEmpty()){
				stack.push(helper.pop());
			}
		}
	}

}
