
public class BinaryTreeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] ={10,20,30,40,50,60,70};
			BST tree = new BST(arr);
			tree.display();
			System.out.println(tree.sumLeaf());
			
	}

}
