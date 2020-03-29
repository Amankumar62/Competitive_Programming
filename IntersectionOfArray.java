import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionOfArray ioa = new IntersectionOfArray();
		int [] one = {5,1,3,4,7};
		int [] two = {2,4,3,5,7,10,15};
		System.out.println(ioa.intersection(one, two));
	}

	public ArrayList<Integer> intersection(int[] one, int[] two){
		HashMap<Integer,Boolean> map = new HashMap<>();
		for(int i=0;i<one.length;i++){
			map.put(one[i], false);
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<two.length;i++){
			if(map.containsKey(two[i])){
				list.add(two[i]);
			}
		}
		return list;
	}
}
