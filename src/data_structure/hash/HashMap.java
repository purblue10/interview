package data_structure.hash;

import java.util.Random;

/**
 * Created by purblue on 6/11/16.
 */
public class HashMap<K,V> implements Map<K,V>{
    private static final int DEFAULT_CAPACITY = 16;
    private static float LOAD_FACTOR_CUTOFF = 0.7f;

    private final int p = 1009;
    private int a;
    private int b;

    private Entry<K, V>[] table;

    private int capacity;
    private int size;


    public HashMap(){
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public HashMap(int capacity){
        this.capacity = capacity;
        table = new Entry[this.capacity];
        size = 0;
        Random rand = new Random();
        a = rand.nextInt(p-1)+1;
        b = rand.nextInt(p);
    }


    public boolean containsKey(K key){
        if(key==null)
            return false;
        int h = hash(key);
        Entry<K, V> curr = table[h];
        while(curr!=null){
            if(curr.key == key){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public V get(K key){
        if(key==null)
            return null;
        int h = hash(key);
        Entry<K, V> curr = table[h];
        while(curr!=null){
            if(curr.key.equals(key)){
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    public void put(K key, V value){
        if(key==null)
            return;
        if((float) size/capacity > LOAD_FACTOR_CUTOFF){
            resize();
        }

        int h = hash(key);
        Entry<K, V> curr = table[h];
        while(curr!=null){
            if(curr.key.equals(key)){
                return;
            }
            curr = curr.next;
        }
        table[h] = new Entry<>(key, value, table[h]);
        size++;
    }


    public V remove(K key){
        if(key==null)
            return null;
        int h = hash(key);
        Entry<K, V> curr = table[h];
        Entry<K, V> prev = null;
        while(curr!=null){
            if(curr.key.equals(key)){
                size--;
                if(prev==null){
                    table[h] = curr.next;
                }
                else
                    prev.next = curr.next;
                return curr.value;
            }
            prev= curr;
            curr = curr.next;
        }

        return null;
    }
    public int size(){
        return size;
    }

    public int hash(K key){
        return ((a * key.hashCode() + b) % p) % capacity;
    }

    public void print(){
        System.out.println("\thash table structure, size="+size + ", capacity="+capacity+", load factor = "+(float) size/capacity);
        int i =0;
        int cnt=0;
        for(Entry<K,V> node : table){
//            Entry<K,V> node = table[i];
            if(node!=null) {
                System.out.print((i++) + ": ");
                while (node != null) {
                    System.out.print(node.key + "-" + node.value + " ");
                    node = node.next;
                    cnt++;
                }
                System.out.println();
            }
        }
        System.out.println("\tActual count: "+ cnt +"\n");
    }

    @SuppressWarnings("unchecked")
    public void resize(){
        capacity = 2*capacity;
        Entry<K,V>[] new_table = new Entry[capacity];
        for(Entry<K,V> e : table){
            while(e!=null){
                Entry<K,V> next = e.next;
                int h = hash(e.key);
                e.next = new_table[h];
                new_table[h] = e;
                e = next;
            }
        }
        table = new_table;

    }
}
