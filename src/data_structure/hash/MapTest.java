package data_structure.hash;

/**
 * Created by purblue on 6/11/16.
 */
public class MapTest {
    public static void main(String[] args){
        TreeMap<String, Integer> treemap = new TreeMap<>();
        treemap.put("d",3);
        treemap.put("f",1);
        treemap.put("a",5);
        treemap.put("h",100);
        treemap.put("i",13);
        treemap.put("k",435);
        treemap.put("b",38);
        treemap.print();

        treemap.printRoot();
        System.out.println(treemap.remove("d"));
        treemap.printRoot();

    }

    public static void hash_map_test(){
        HashMap<String, Integer> map = new HashMap<>();
        for(char key='a'; key<= 'z'; key++){
            map.put(Character.toString(key), (int) key - 97);
        }
        map.print();

        map.remove("k");
        map.print();
        map.put("abc",104);
        System.out.println(map.get("abc"));
        map.print();
        map.put("abc",104);
        map.print();
    }
}
