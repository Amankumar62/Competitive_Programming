import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

	private class Vertex{
		HashMap<String,Integer> nbrs = new HashMap<>();
	}
	
	HashMap<String,Vertex> vtces;
	
	public Graph(){
		vtces = new HashMap<>();
	}
	
	public int numVertex(){
		return this.vtces.size();
	}
	
	public boolean containsVertex(String vname){
		return this.vtces.containsKey(vname);
	}
	
	public void addVertex(String vname){
		Vertex vtx = new Vertex();
		this.vtces.put(vname, vtx);
	}
	
	public void removeVertex(String vname){
		Vertex vtx = this.vtces.get(vname);
		ArrayList<String> keys = new ArrayList<>();
		for(String key : keys){
			Vertex  vtxnbrs = this.vtces.get(key);
			vtxnbrs.nbrs.remove(vname);
		}
		this.vtces.remove(vname);
	}
	
	public int numEdges(){
		int count = 0;
		ArrayList<String> keys = new ArrayList(this.vtces.keySet());
		for(String key : keys){
			Vertex  vtx = this.vtces.get(key);
			count = count + vtx.nbrs.size();
		}
		return count/2;
	}
	
	public boolean containsEdge(String vname1,String vname2){
		Vertex vtx1 = this.vtces.get(vname1);
		Vertex vtx2 = this.vtces.get(vname2);
		if(vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)){
			return false;
		}
		return true;
	}
	public void addEdge(String vname1,String vname2,int cost){
		Vertex vtx1 = this.vtces.get(vname1);
		Vertex vtx2 = this.vtces.get(vname2);
		
		if(vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)){
			return ;
		}
		vtx1.nbrs.put(vname2,cost);
		vtx2.nbrs.put(vname1,cost);
	}
	public void removeEdge(String vname1,String vname2){
		Vertex vtx1 = this.vtces.get(vname1);
		Vertex vtx2 = this.vtces.get(vname2);
		if(vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)){
			return ;
		}
		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
		
	}
	public void display(){
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for(String key : keys){
			Vertex vtx = vtces.get(key);
			System.out.println(key + " - " + vtx.nbrs);
		}
		}
	
	public boolean hasPath(String vname1,String vname2,HashMap<String,Boolean> processed){
		processed.put(vname1, true);
		if(this.containsEdge(vname1,vname2)){
			return true;
		}
		Vertex vtx = this.vtces.get(vname1);
		
		ArrayList<String> nbrs = new ArrayList(vtx.nbrs.keySet());
		for(String nbr : nbrs){
			if( !processed.containsKey(nbr) && hasPath(nbr,vname2,processed )){
				return true;
			}
		}
		
		return false;
		
	}
	private class Pair{
	String vname;
	String vpath;
	}
	public boolean bfs(String src, String dst){
		HashMap<String,Boolean> processed = new HashMap();
		LinkedList<Pair> queue = new LinkedList();
		Pair sp = new Pair();
		sp.vname = src;
		sp.vpath = src;
		queue.addLast(sp);
		
		while(!queue.isEmpty()){
			Pair rp = queue.removeFirst();
			if(processed.containsKey(rp.vname)){
				continue;
			}
			processed.put(rp.vname, true);
			
			if(containsEdge(rp.vname,dst )){
				return true;
			}
			
		Vertex vtx = this.vtces.get(rp.vname);
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());
		for(String nbr : nbrs){
			if(!processed.containsKey(nbr)){
			Pair np = new Pair();
			np.vname = nbr;
			np.vpath = rp.vname + nbr;
			queue.addLast(np);
			}
		}
		
		}
		return false;
	}
	public boolean dfs(String src , String dst){
		HashMap<String,Boolean> processed = new HashMap();
		LinkedList<Pair> stack = new LinkedList();
		
		Pair sp = new Pair();
		sp.vname = src;
		sp.vpath = src;
		
		stack.addFirst(sp);
		
		while(!stack.isEmpty()){
			Pair rp = stack.removeFirst();
			if(processed.containsKey(rp.vname)){
				continue;
			}
			
			processed.put(rp.vname,true);
			
			if(containsEdge(rp.vname,dst)){
				return true;
			}
			
			Vertex vtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList(vtx.nbrs.keySet());
			for(String nbr : nbrs){
				if(!processed.containsKey(nbr)){
					Pair np = new Pair();
					np.vname = nbr;
					np.vpath = rp.vname+nbr;
					stack.addFirst(np);
				}
			}
			
		}
		return false;
	}
	public void bft(){
		HashMap<String,Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for(String key : keys){
			if(processed.containsKey(key)){
				continue;
			}
		Pair sp = new Pair();
		sp.vname = key;
		sp.vpath = key;
		queue.addLast(sp);
		
		while(!queue.isEmpty()){
			Pair rp = queue.removeFirst();
			
			if(processed.containsKey(rp.vname)){
				continue;
			}
			System.out.println(rp.vname + " via " + rp.vpath);
			
			Vertex vtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());
			for(String nbr : nbrs){
				Pair np = new Pair();
				np.vname = nbr;
				np.vpath = rp.vpath + nbr;	
				queue.addLast(np);
			}
			
		}
		}
	}
	
}
