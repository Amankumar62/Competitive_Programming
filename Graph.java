import java.util.ArrayList;
import java.util.HashMap;

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
	
	public boolean hasPath(String vname1,String vname2){
		if(this.containsEdge(vname1,vname2)){
			return true;
		}
		Vertex vtx = this.vtces.get(vname1);
		
		ArrayList<String> nbrs = new ArrayList(vtx.nbrs.keySet());
		for(String nbr : nbrs){
			if(hasPath(nbr,vname2)){
				return true;
			}
		}
		
		return false;
		
	}
	
}
