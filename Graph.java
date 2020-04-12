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
			processed.put(rp.vname,true);
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
	public void dft(){
		HashMap<String,Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for(String key : keys){
			if(processed.containsKey(key)){
				continue;
			}
		Pair sp = new Pair();
		sp.vname = key;
		sp.vpath = key;
		stack.addFirst(sp);
		
		while(!stack.isEmpty()){
			Pair rp = stack.removeFirst();
			
			if(processed.containsKey(rp.vname)){
				continue;
			}
			processed.put(rp.vname,true);
			System.out.println(rp.vname + " via " + rp.vpath);
			
			Vertex vtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());
			for(String nbr : nbrs){
				Pair np = new Pair();
				np.vname = nbr;
				np.vpath = rp.vpath + nbr;	
				stack.addFirst(np);
			}
				
		}
		}
		}
	public boolean isCyclic(){
		HashMap<String,Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for(String key : keys){
			if(processed.containsKey(key)){
				return true;
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
			processed.put(rp.vname,true);
			
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
		return false;
	}
	public boolean isConnected(){
		HashMap<String,Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		int flag =0;
		for(String key : keys){
			if(processed.containsKey(key)){
				continue;
			}
			flag++;
		Pair sp = new Pair();
		sp.vname = key;
		sp.vpath = key;
		queue.addLast(sp);
		
		while(!queue.isEmpty()){
			Pair rp = queue.removeFirst();
			
			if(processed.containsKey(rp.vname)){
				continue;
			}
			processed.put(rp.vname,true);
		
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
		if(flag>=2){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isTree(){
		return !isCyclic() && isConnected();
	}
	public ArrayList<ArrayList<String>> getCC(){
		HashMap<String,Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for(String key : keys){
			if(processed.containsKey(key)){
				continue;
			}
			ArrayList<String> subarr = new ArrayList<>();
			Pair sp = new Pair();
			sp.vname = key;
			sp.vpath = key;
			queue.addLast(sp);
			
			while(!queue.isEmpty()){
				Pair rp = queue.removeFirst();
				if(processed.containsKey(rp.vname)){
					continue;
				}
				processed.put(rp.vname, true);
				subarr.add(rp.vname);
				System.out.println(rp.vname + "-" + rp.vpath);
				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());
				for(String nbr : nbrs){
					Pair np = new Pair();
					np.vname = nbr;
					np.vpath = rp.vpath + nbr;
					queue.addLast(np);
				}
			}
			ans.add(subarr);
		}
		return ans;
	}
	private class PrimsPair implements Comparable<PrimsPair>{
		String vname;
		String acqvname;
		int cost;
		@Override
		public int compareTo(PrimsPair o) {
			return o.cost - this.cost;
		}
	}
	public Graph prims(){
		Graph mst = new Graph();
		HashMap<String,PrimsPair> map = new HashMap<>();
		HeapGenerics<PrimsPair> heap = new HeapGenerics<>();
		//make a pair and add in heap
		for(String key : vtces.keySet()){
			PrimsPair np = new PrimsPair();
			np.vname = key;
			np.acqvname= null;
			np.cost = Integer.MAX_VALUE;
			heap.add(np);
			map.put(key, np);
		}
		//till the heap is not empty keep on removing the pairs
		while(!heap.isEmpty()){
			//remove a pair
			PrimsPair rp = heap.remove();
			map.remove(rp.vname);
			
			//add to mst
			if(rp.acqvname == null){
				mst.addVertex(rp.vname);
			}else{
				mst.addVertex(rp.vname);
				mst.addEdge(rp.vname, rp.acqvname, rp.cost);
			}
			
			//nbrs
			for(String nbr : vtces.get(rp.vname).nbrs.keySet()){
				if(map.containsKey(nbr)){
					int oc = map.get(nbr).cost;
					int nc = vtces.get(rp.vname).nbrs.get(nbr);
					if(nc < oc){
						PrimsPair gp = map.get(nbr);
						gp.acqvname = rp.vname;
						gp.cost = nc;
						heap.updatePriority(gp);
					}
				}
			}
			
		}
		return mst;
	}
	
	private class DijkstraPair implements Comparable<DijkstraPair>{
		String vname;
		String psf;
		int cost;
		
		@Override
		public int compareTo(DijkstraPair o) {
			// TODO Auto-generated method stub
			return o.cost - this.cost;
		}
		
	}
	public HashMap<String,Integer> dijkstra(String src){
		HashMap<String, Integer> ans = new HashMap<>();
		HashMap<String,DijkstraPair> map = new HashMap<>();
		HeapGenerics<DijkstraPair> heap = new HeapGenerics<>();
		
		for(String key : vtces.keySet()){
			DijkstraPair np = new DijkstraPair();
			np.vname = key;
			np.psf = "";
			np.cost = Integer.MAX_VALUE;
			
			if(key.equals(src)){
				np.cost = 0;
				np.psf=key;
			}
			heap.add(np);
			map.put(key,np);
		}
			while(!heap.isEmpty()){
				
				DijkstraPair rp = heap.remove();
				map.remove(rp.vname);
				
				ans.put(rp.vname,rp.cost);
				
				for(String nbr : vtces.get(rp.vname).nbrs.keySet()){
					if(map.containsKey(nbr)){
						int oc = map.get(nbr).cost;
						int nc = rp.cost + vtces.get(rp.vname).nbrs.get(nbr);
						
						if(nc < oc){
							DijkstraPair gp = map.get(nbr);
							gp.psf = rp.psf+nbr;
							gp.cost = nc;
							heap.updatePriority(gp);
						}
					}
				}
				}
			return ans;	
		
	}
	}
	

