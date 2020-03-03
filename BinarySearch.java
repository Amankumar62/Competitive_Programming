import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size,lb,ub,mid,num,flag=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array\t");
		size=sc.nextInt();
        int[] arr=new int[size];
        System.out.println("Enter "+size+" elements");
        for(int i=0;i<size;i++) {
        	arr[i]=sc.nextInt();
        }
        System.out.println("Enter the number to search");
        num=sc.nextInt();
        lb=0;
        ub=size-1;
        mid=(lb+ub)/2;
        while(lb<=ub) {
        	if(arr[mid]==num) {
        		System.out.println("Element is at "+(mid+1)+"th position in the array");
        		flag=1;
        		break;
        	}
        	else if(num<arr[mid])
        		ub=mid-1;
        	else
        		lb=mid+1;
        	mid=(lb+ub)/2;
        }
        if(flag==0)
        	System.out.println(num+" not found");
	}

}
