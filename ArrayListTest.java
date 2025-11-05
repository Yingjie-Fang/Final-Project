public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        // Add some elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        list.add("Elderberry");

        System.out.println("List after adding elements: " + list);
        System.out.println("Size: " + list.size());

        // Get elements
        System.out.println("Element at index 2: " + list.get(2));

        // Remove an element
        String removed = list.remove(1);
        System.out.println("Removed element: " + removed);
        System.out.println("List after removal: " + list);
        System.out.println("Size after removal: " + list.size());

        // Add more elements to trigger resizing
        for (int i = 0; i < 20; i++) {
            list.add("Fruit" + i);
        }

        System.out.println("\nList after adding more elements (resized):");
        System.out.println(list);
        System.out.println("Final size: " + list.size());
    }
}

