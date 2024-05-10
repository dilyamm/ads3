import java.util.ArrayList;
import java.util.List;

// 2.1
public class BST<K extends Comparable<K>, V> {
    private Node root; // root of BST
    private int size;  // size of the BST

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public int size() {
        return size;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        return x;
    }

    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.val;
            }
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.left == null) {
                size--;
                return x.right;
            }
            if (x.right == null) {
                size--;
                return x.left;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    private Node min(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            size--;
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

    public class Pair {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public Iterable<Pair> iterator() {
        List<Pair> items = new ArrayList<>();
        inorder(root, items);
        return items;
    }

    private void inorder(Node x, List<Pair> items) {
        if (x != null) {
            inorder(x.left, items);
            items.add(new Pair(x.key, x.val));
            inorder(x.right, items);
        }
    }
}