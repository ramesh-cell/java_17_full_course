package test.demov1;

import java.util.LinkedHashMap;
import java.util.Map;



public class LRUCacheMap<K,V> extends LinkedHashMap<K,V>{

    private int capacity;
    private final LinkedHashMap<K,V> cache;

    public LRUCacheMap(int capacity){
        this.capacity=capacity;
        this.cache=new LinkedHashMap<K,V>(capacity,0.75f,true);


    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size()> LRUCacheMap.this.capacity;
    }

    public V put(K key, V value ){
        cache.put(key,value);
        return value;
    }


    public V get(Object key){
        return cache.getOrDefault(key,null);
    }
    public void display(){
        System.out.println("cache = " + cache);
    }
}
