package data_structure.heap;

import java.util.*;

/**
 * All heap implemetation is min-heap
 */
public class Heap {
    private List<Integer> arr;

    public Heap(){
        arr = new ArrayList<>();
    }

    public void insert(int n){
        arr.add(n);
        heapify_up(arr.size()-1);
    }

    public int extract_min(){
        if(arr.size()==0)
            return 0;
        int min = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.remove(arr.size()-1);
        if(arr.size()>1)
            heapify_down(0);
        return min;
    }

    private void heapify_up(int i){
        if(i>0){
            int parent = (i%2!=0)? i/2 : i/2-1;
            if(arr.get(parent) > arr.get(i)){
                int temp = arr.get(parent);
                arr.set(parent, arr.get(i));
                arr.set(i, temp);
                heapify_up(parent);
            }
        }
    }

    private void heapify_down(int i){
        if(2*i+1 < arr.size()){
            int child;
            int left = 2*i+1;
            if(left==arr.size()-1)
                child = left;
            else{
                int right = 2*i+2;
                child = (arr.get(right)<arr.get(left))? right: left;
            }
            if(arr.get(i) > arr.get(child)){
                int temp = arr.get(child);
                arr.set(child, arr.get(i));
                arr.set(i, temp);
                heapify_down(child);
            }
        }
    }

    public void print(){
        for(int i: arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public boolean checkHeapProperty(){
        for(int i=0; i<arr.size(); i++){
            boolean test = bfs(i);
            if(!test)
                return false;
        }
        return true;
    }

    public boolean bfs(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while(!queue.isEmpty()){
            int curr = queue.poll();

            int left = 2*curr+1;
            int right = 2*curr+2;
            if(left < arr.size()){
                if(arr.get(left) < arr.get(curr))
                    return false;
                queue.add(left);
            }
            if(right < arr.size()){
                if(arr.get(right) < arr.get(right))
                    return false;
                queue.add(right);
            }
        -
         return true;
    }

    public static void main(String[] args){
        Heap heap = new Heap();
        Random rand = new Random();
        for(int i=0; i<15; i++){
            heap.insert(rand.nextInt(100));
        }

        heap.print();
        System.out.println(heap.checkHeapProperty());

        heap.extract_min();
        heap.print();
        System.out.println(heap.checkHeapProperty());

    }
}
