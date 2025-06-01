package test.demov1;


import java.util.Map;
import java.util.WeakHashMap;

public class DemoTest  {


    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> stringIntegerWeakHashMap = new WeakHashMap<>();

        String x1="X1";
        String x2="X2";
        stringIntegerWeakHashMap.put(x1,1);
        stringIntegerWeakHashMap.put(x2,1);
        System.out.println("stringIntegerWeakHashMap = " + stringIntegerWeakHashMap);

        Integer x = stringIntegerWeakHashMap.get("X");


        System.gc();

         x1=null;
         x2=null;

        Thread.sleep(5000);

        System.out.println("After gc collected = " + stringIntegerWeakHashMap);

        /*the size of the cache is 3
        foo : 1
        foo : 2
        foo : 3

        and we doo, cache.put(foo,4)

        now it will evict the key which was least recently used and put foo,4*/
        LRUCacheMap<String, Integer> lruCacheMap = new LRUCacheMap<>(3);
        lruCacheMap.put("foo1",1);
        lruCacheMap.put("foo2",2);
        lruCacheMap.put("foo3",3);

        lruCacheMap.get("foo1");

        lruCacheMap.display();
        lruCacheMap.put("foo4",4);
        lruCacheMap.display();
    }
}
