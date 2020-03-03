import java.util.*;
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long fact=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number to find factorial\t");
		int a=sc.nextInt();
for(int i=a;i>=1;i--) {
	fact=fact*i;
}
System.out.println("Factorial = "+fact);
	}

}
