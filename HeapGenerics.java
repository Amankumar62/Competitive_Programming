import java.util.ArrayList;

public class HeapGenerics<T extends Comparable<T>> {

	ArrayList<T> heap = new ArrayList<>();
	
	public void add(T item){
		heap.add(item);
		heapify(heap.size() -1);
	}
	
	private void heapify(int ci){
		int pi = (ci-1)/2;
		if(heap.get(ci) < heap.get(pi) ){
			swap(ci,pi);
			heapify(pi);
		}
		
	}
	
	public T remove(){
		swap(0,this.heap.size() -1);
		T rv = this.heap.remove(this.heap.size() -1);
		downHeapify(0);
		return rv;
		}
	
	private void downHeapify(int pi){
		int lci = 2*pi +1;
		int rci = 2*pi +2;
		
		int mini = pi;
		if(lci < this.heap.size() && this.heap.get(lci) < this.heap.get(mini)){
			mini = lci;
			}
		
		if(rci < this.heap.size() && this.heap.get(rci) < this.heap.get(mini)){
			mini = rci;
		}
		
		if(mini != pi){
			swap(pi,mini);
			downHeapify(mini);
		}
		}
		
	public T get(){
		return this.heap.get(0);
	}
	private void swap(int ci,int pi){
		T civ = heap.get(ci);
		T piv = heap.get(pi);
		
		heap.set(pi, civ);
		heap.set(ci, piv);
	}
	
	public int size(){
		return heap.size();
	}
	
	public boolean isEmpty(){
		return this.size() ==0;
	}
	public void display(){
		System.out.println(heap);
	}
	
}
