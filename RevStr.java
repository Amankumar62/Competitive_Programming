import java.util.Scanner;
public class RevStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
System.out.println("Enter a string\t");
String str=sc.nextLine();
String newstr="";
for(int i=str.length()-1;i>=0;i--) {
	newstr+=str.charAt(i);
}
System.out.println("New string is "+newstr);
	}
}
