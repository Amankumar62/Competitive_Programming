
public class HashTable<K,V> {
	private class HTPair{
		K key;
		V value;
		HTPair(K key,V value){
			this.key = key;
			this.value = value;
		}
		//equals is override to work inside find of
		//LinkList and do comparison on the basis of key
		public boolean equals(Object other){
			HTPair op = (HTPair) other;
			return this.key.equals(op.key);
		}
		//if toString was not overriden then address of the object would 
		//have been printed to print (key - value) pair of the object
		//toString is overriden. 
		public String toString(){
			return "{"+ this.key + "-" + this.value + "}";
		}
		}
	public final static int DEFAULT_CAPACITY = 10;
	private LinkedListGenerics<HTPair> [] bucketArray;
	private int size;
	
	public HashTable(){
		this(DEFAULT_CAPACITY);
	}
	public HashTable(int capacity){
		this.bucketArray = ( LinkedListGenerics<HTPair>[] ) new LinkedListGenerics[capacity];
				}
	
	
	public void put(K key, V value) throws Exception {
		int bi = hashFunction(key);
		LinkedListGenerics<HTPair> bucket = this.bucketArray[bi];
		HTPair pta = new HTPair(key,value);
		if(bucket == null){
			bucket = new LinkedListGenerics();
			bucket.addLast(pta);
			this.bucketArray[bi] = bucket;
			this.size++;
		}else{
			int findAt = bucket.find(pta);
			if(findAt == -1){
				this.bucketArray[bi].addLast(pta);
				this.size++;
			}
			else{
				bucket.getAt(findAt).value = value;
			}
		}
		
		double lamda = (this.size*1.0)/this.bucketArray.length;
		if(lamda > 2){
			this.rehash();
		}
	}
	
	private void rehash() throws Exception{
	LinkedListGenerics<HTPair>[] oba = this.bucketArray;	
	this.bucketArray  = ( LinkedListGenerics<HTPair> [] ) new LinkedListGenerics[2*this.bucketArray.length];
	this.size = 0;
	for(LinkedListGenerics<HTPair> ob : oba){
		while(ob != null && !ob.isEmpty()){
			HTPair pair = ob.removeFirst();
			this.put(pair.key, pair.value);
		}
	}
	}
	
	private int hashFunction(K key){
		int hc = key.hashCode();
		hc = Math.abs(hc);
		int bi = hc % this.bucketArray.length;
		return bi;
	}
	public void display(){
		for(LinkedListGenerics<HTPair> bucket : this.bucketArray)
		if(bucket != null ){
			bucket.display();
		}
		else {
			System.out.println("NULL");
		}
	}
	public V get(K key) throws Exception{
		int bi = hashFunction(key);
		LinkedListGenerics<HTPair> bucket = this.bucketArray[bi];
		HTPair ptf = new HTPair(key,null);
		if(bucket == null){
			return null;
		}
		else{
			int findAt = bucket.find(ptf);
			if(findAt == -1){
				return null;
			}
			else{
				return bucket.getAt(findAt).value;
			}
		}
	}
	
	public V remove(K key) throws Exception {
		int bi = hashFunction(key);
		LinkedListGenerics<HTPair> bucket = this.bucketArray[bi];
		HTPair ptf = new HTPair(key,null);
		if(bucket == null){
			return null;
		}
		else{
			int findAt = bucket.find(ptf);
			if(findAt == -1){
				return null;
			}
			else{
				HTPair pair = bucket.getAt(findAt);
				bucket.removeAt(findAt);
				this.size--;
				return pair.value;
			}
		}
	}
	
	}
	
	

