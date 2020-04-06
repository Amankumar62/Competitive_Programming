import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanEncoder {

	HashMap<Character,String> encoder;
	HashMap<String,Character> decoder;
	public HuffmanEncoder(String feeder){
		//1.) create a freq map of this feeder String
		HashMap<Character,Integer> fmap = new HashMap();
		for(int i=0;i<feeder.length();i++){
			char cc= feeder.charAt(i);
			fmap.put( cc , fmap.getOrDefault(cc, 0) + 1);
		}
		
		//2.) create the minHeap of trees.
		HeapGenerics<Node> minheap = new HeapGenerics();
		Set<Map.Entry<Character,Integer>> entries = fmap.entrySet();
		for(Map.Entry<Character,Integer> entry : entries){
			Node node = new Node(entry.getKey(),entry.getValue());
			minheap.add(node);
		}
		//combining the nodes
		while(minheap.size() != 1){
			Node minOne = minheap.remove();
			Node minTwo = minheap.remove();
			Node combined = new Node(minOne,minTwo);
			combined.data = '\0';
			combined.cost = minOne.cost + minTwo.cost;
			minheap.add(combined);
		}
		
		Node fs = minheap.remove();	
		this.encoder = new HashMap();
		this.decoder = new HashMap();
	}
	//filling the encoder and decoder
	private void initEncoderDecoder(Node node , String osf){
		if(node == null){
			return;
		}
		if(node.left == null && node.right == null){
			this.encoder.put(node.data, osf);
			this.decoder.put(osf, node.data);
		}
	initEncoderDecoder(node.left , osf+'0');
	initEncoderDecoder(node.right,osf+'1');
		
	}

	private class Node implements Comparable<Node>{
		char data;
		int cost;
		Node left;
		Node right;
		
		Node(char data , int cost){
			this.data = data;
			this.cost = cost;
		}
		Node(Node left,Node right){
			this.left = left;
			this.right= right;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	public String encode(String source){
		String rv = "";
		for(int i = 0 ;i<source.length();i++){
			String code = this.encoder.get(source.charAt(i));
			rv = rv + code;
		}
		return rv;
	}
	
	public String decode(String code){
		String rv = "";
		String key = "";
		for(int i = 0 ; i< code.length();i++){
		 key = key + code.charAt(i);
			if(this.decoder.containsKey(key)){
				rv = rv + this.decoder.get(key);
				key = "";
			}
		}
		return rv;
	}
	
}
