package data_structure.hash;

/**
 * Created by purblue on 6/11/16.
 */
public class Entry<K,V> {
    K key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public Entry(K key, V value, Entry<K,V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
