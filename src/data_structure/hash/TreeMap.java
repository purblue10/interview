package data_structure.hash;

/**
 * BST without duplications.
 */
public class TreeMap<K,V> implements Map<K,V> {
    private TreeEntry<K,V> root;
    private int size;

    public TreeMap(){
        this.root = null;
        this.size = 0;
    }

    public boolean containsKey(K key){
        return (findNode(root, key)!=null);
    }



    public V get(K key){
        TreeEntry<K,V> node = findNode(root, key);
        return (node!=null)? node.value:null;
    }

    public void put(K key, V value){
        root = insertNode(root, key, value);
    }

    public V remove(K key){
        V value = deleteNode(key);
        return value;
    }

    public TreeEntry<K,V> insertNode(TreeEntry<K,V> node, K key, V value){
        if(node==null){
            size++;
            return new TreeEntry<>(key, value);
        }

        if(key.hashCode() < node.h){
            node.left = insertNode(node.left, key, value);
        }else if(key.hashCode() > node.h){
            node.right= insertNode(node.right, key, value);
        }else{
            node.value = value;
        }
        return node;
    }

    public V deleteNode(K key){
        TreeEntry<K,V> curr = root;
        TreeEntry<K,V> parent = null;
        V value=null;
        while(curr!=null){
            if(key.hashCode() != curr.h){
                parent = curr;
                curr = (key.hashCode() < curr.h)? curr.left : curr.right;
            }else{
                value = curr.value;
                    // no child or one child
                if(curr.left == null){
                    if(parent==null)    root = curr.right;
                    else if(parent.left == curr)    parent.left = curr.right;
                    else   parent.right = curr.right;
                    break;
                }else if(curr.right == null){
                    if(parent==null)    root = curr.left;
                    else if(parent.left == curr)    parent.left = curr.left;
                    else parent.right = curr.left;
                    break;
                } // two child.
                else{
                    TreeEntry<K,V> successor = curr.right;
                    TreeEntry<K,V> successor_parent = curr;
                    while(successor.left!=null){
                        successor_parent = successor;
                        successor = successor.left;
                    }
                    curr.key = successor.key;
                    curr.h= successor.h;
                    curr.value= successor.value;
                    parent = successor_parent;
                    curr = successor;
                }
            }
        }
        if(value!=null) size--;
        return value;
    }

    private TreeEntry<K,V> deleteNode_rec(TreeEntry<K,V> node, K key){
        if(node==null)
            return null;
        if(key.hashCode() < node.h){
            node.left = deleteNode_rec(node.left, key);
        }else if(key.hashCode() > node.h){
            node.right = deleteNode_rec(node.right, key);
        }else{
            if(node.left == null){
                return node.right;
            }else if(node.right == null){
                return node.left;
            }

            TreeEntry<K,V> successor = findMin(node.right);
            node.key = successor.key;
            node.value = successor.value;
            node.h = successor.h;
            node.right = deleteNode_rec(node.right, successor.key);
        }
        return node;
    }

    private TreeEntry<K,V> findMin(TreeEntry<K,V> node){
        if(node.left==null)
            return node;
        else
            return findMin(node.left);
    }

    private TreeEntry<K,V> findNode(TreeEntry<K,V> node, K key){
        if(node==null)
            return null;

        if(node.key.equals(key)){
            return node;
        }else if(key.hashCode() < node.h){
            return findNode(node.left, key);
        }else{
            return findNode(node.right, key);
        }
    }


    public void print(){
        System.out.println("Treemap: size="+ size);
        inorderTraverse(root);
        System.out.println();
    }

    private void inorderTraverse(TreeEntry<K,V> node){
        if(node==null)
            return;
        inorderTraverse(node.left);
        System.out.print(node.key +"("+node.h+")"+"-" + node.value+" ");
        inorderTraverse(node.right);
    }

    public void printRoot(){
        System.out.println(root.key + "(" + root.h + ")" + "-" + root.value + " ");
    }
    public int size(){
        return size;
    }

    class TreeEntry<K,V> {
        int h;
        K key;
        V value;
        TreeEntry<K, V> left;
        TreeEntry<K, V> right;

        public TreeEntry(K key, V value){
            this.key = key;
            this.h = key.hashCode();
            this.value = value;
        }

        public TreeEntry(K key, V value, TreeEntry<K,V> left, TreeEntry<K,V> right){
            this.key = key;
            this.h = key.hashCode();
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
