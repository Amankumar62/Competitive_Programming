
public class CountNoOfBinary {

	public static int cNOB(int n){
		int ones[] = new int[n];
		int zeroes[] = new int[n];
		
		zeroes[0]=ones[0] =1;
		
		for(int i=1;i<zeroes.length;i++){
			zeroes[i] = zeroes[i-1]+ones[i-1];
			ones[i] = zeroes[i-1];
		}
		int ans = zeroes[n-1] + ones[n-1];
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(cNOB(3));

	}

}
