import java.util.Scanner;

public class Smallest {
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size,small,pos=0;
		System.out.println("Enter size of array\n");
		size=sc.nextInt();
		arr=new int[size];
		System.out.println("Enter elements of the array\n");
		for(int i=0;i<size;i++)
			arr[i]=sc.nextInt();
		small=arr[0];
		for(int i=1;i<size;i++) {
			if(arr[i]<small) {
				small=arr[i];
				pos=i;
			}
		}
		System.out.println("Smallest element in the array is "+small+" at "+(pos+1)+"th position");
	}

}
