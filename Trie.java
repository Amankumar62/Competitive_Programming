import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {
	private class Node{
		char data;
		HashMap<Character,Node> children;
		boolean isTerminal;
		
		Node(char data,boolean isTerminal){
			this.data = data;
			this.isTerminal = isTerminal;
			this.children = new HashMap<>();
		}
	}
	
	private Node root ;
	private int numWords;
	
	Trie(){
		this.root = new Node('\0',false);
		this.numWords = 0;
	}
	
	public int numWords(){
		return this.numWords;
	}
	public void addWord(String word){
		addWord(this.root,word);
	}
	private void addWord(Node parent,String word){
		if(word.length() == 0){
			if(parent.isTerminal){
			//Word is already present.
				}
			else{
				parent.isTerminal = true;
				this.numWords++;
				}
			return;
			}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(cc);
		if(child == null){
			child = new Node(cc,false);
			parent.children.put(cc,child);
		}
		
		addWord(child,ros);
	}
	
	public void display(){
		display(this.root,"");
	}
	private void display(Node node , String osf){
		if(node.isTerminal){
			String todisplay = osf.substring(1) + node.data;
			System.out.println(todisplay);
		}
		Set<Map.Entry<Character,Node>> entries = node.children.entrySet();
		for(Map.Entry<Character, Node> entry : entries){
			display(entry.getValue(),osf + node.data);
		}
	}
	
	public boolean search(String word){
		return search(this.root,word);
	}
	private boolean search(Node parent,String word){
		if(word.length() == 0){
			if(parent.isTerminal){
				return true;
			}
			else{
				return false;
			}
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(cc);
		if(child == null){
			return false;
		}
		
		return this.search(child,ros);
	}
	
	public void remove(String word){
		remove(this.root,word);
	}
	
	private void remove(Node parent, String word){
		if(word.length() == 0){
			if(parent.isTerminal){
				parent.isTerminal = false;
				this.numWords--;
			}
			else{
				//word does not exist
			}
			return;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(cc);
		if(child == null){
			return;
		}
		remove(child,ros);
		if(!child.isTerminal && child.children.size()==0){
			parent.children.remove(cc);
		}
		
	}
	
	
	
	
}
