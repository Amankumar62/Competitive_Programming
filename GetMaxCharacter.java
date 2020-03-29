import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;


public class GetMaxCharacter {

	public static void main(String[] args) {
		String str = "aabbbbbbaaabcdda";
		GetMaxCharacter gtm = new GetMaxCharacter();
    System.out.println(gtm.getMaxChar(str));
	}
	public char getMaxChar(String str){
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i =0;i<str.length();i++){
			char ch = str.charAt(i);
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch)+1);
			}
			else{
				map.put(ch, 1);
			}
		}
		int max = Collections.max(map.values());
		for(Entry<Character,Integer> entry : map.entrySet() ){
			if(entry.getValue() == max){
				return entry.getKey();
			}
		}
		return ' ';
	}

}
