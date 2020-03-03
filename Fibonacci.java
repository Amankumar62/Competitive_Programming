public class Fibonacci {
    public static void main(String[] args) {
        int n1 = 0, n2 = 1, num=0;
        System.out.print(n1 + " " +
                n2 + " ");
 
        while(num<89) {
            num = n2 + n1;
            System.out.print(num + " ");
            n1 = n2;
            n2 = num;
        }
    }
}