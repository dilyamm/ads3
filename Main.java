import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        // 1.2 Adding random elements
        for (int i = 0; i < 10000; i++) {
            int id = (int) (Math.random() * 10000);
            MyTestingClass key = new MyTestingClass(id);
            Student value = new Student("Student" + id, (int) (Math.random() * 100));
            table.put(key, value);
        }

        // 1.2 Printing the number of elements in each bucket using the new method
        List<Integer> bucketSizes = table.getBucketSizes();
        System.out.println("Bucket sizes:");
        for (int i = 0; i < bucketSizes.size(); i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes.get(i));
        }


        // 2.2 Testing
        BST<Integer, String> tree = new BST<>();
        tree.put(1, "One");
        tree.put(2, "Two");
        tree.put(3, "Three");

        for (var elem : tree.iterator()) {
            System.out.println("Key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}
