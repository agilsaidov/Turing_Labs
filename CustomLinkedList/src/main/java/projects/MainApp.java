package projects;


import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== CUSTOM LINKED LIST TEST SUITE ===\n");

        // Test 1: Default Constructor
        testDefaultConstructor();

        // Test 2: List Constructor
        testListConstructor();

        // Test 3: Array Constructor
        testArrayConstructor();

        // Test 4: Add Operations
        testAddOperations();

        // Test 5: Get Operations
        testGetOperations();

        // Test 6: Index Operations
        testIndexOperations();

        // Test 7: Set Operations
        testSetOperations();

        // Test 8: Remove Operations
        testRemoveOperations();

        // Test 9: Edge Cases
        testEdgeCases();

        // Test 10: Performance Test
        testPerformance();

        System.out.println("\n🎉 ALL TESTS COMPLETED! 🎉");
    }

    private static void testDefaultConstructor() {
        System.out.println("🧪 Test 1: Default Constructor");
        CustomLinkedList<String> list = new CustomLinkedList<>();

        assert list.isEmpty() : "New list should be empty";
        assert list.size() == 0 : "New list size should be 0";
        assert list.getFirst() == null : "First element should be null";
        assert list.getLast() == null : "Last element should be null";

        System.out.println("✅ Default constructor test passed!\n");
    }

    private static void testListConstructor() {
        System.out.println("🧪 Test 2: List Constructor");
        List<Integer> sourceList = Arrays.asList(1, 2, 3, 4, 5);
        CustomLinkedList<Integer> list = new CustomLinkedList<>(sourceList);

        assert list.size() == 5 : "Size should be 5";
        assert list.get(0).equals(1) : "First element should be 1";
        assert list.get(4).equals(5) : "Last element should be 5";
        assert list.getFirst().equals(1) : "getFirst() should return 1";
        assert list.getLast().equals(5) : "getLast() should return 5";

        System.out.print("List created from ArrayList: ");
        list.printList();
        System.out.println("✅ List constructor test passed!\n");
    }

    private static void testArrayConstructor() {
        System.out.println("🧪 Test 3: Array Constructor");
        String[] sourceArray = {"A", "B", "C", "D"};
        CustomLinkedList<String> list = new CustomLinkedList<>(sourceArray);

        assert list.size() == 4 : "Size should be 4";
        assert list.get(0).equals("A") : "First element should be A";
        assert list.get(3).equals("D") : "Last element should be D";

        System.out.print("List created from Array: ");
        list.printList();
        System.out.println("✅ Array constructor test passed!\n");
    }

    private static void testAddOperations() {
        System.out.println("🧪 Test 4: Add Operations");
        CustomLinkedList<String> list = new CustomLinkedList<>();

        // Test add()
        list.add("First");
        list.add("Second");
        list.add("Third");
        System.out.print("After adding three elements: ");
        list.printList();

        // Test addFirst()
        list.addFirst("Zero");
        System.out.print("After addFirst('Zero'): ");
        list.printList();

        // Test add(index, value)
        list.add(2, "Between");
        System.out.print("After add(2, 'Between'): ");
        list.printList();

        assert list.size() == 5 : "Size should be 5";
        assert list.get(0).equals("Zero") : "First should be Zero";
        assert list.get(2).equals("Between") : "Index 2 should be Between";

        System.out.println("✅ Add operations test passed!\n");
    }

    private static void testGetOperations() {
        System.out.println("🧪 Test 5: Get Operations");
        CustomLinkedList<Integer> list = new CustomLinkedList<>(Arrays.asList(10, 20, 30, 40, 50));

        // Test get by index
        assert list.get(0).equals(10) : "get(0) should return 10";
        assert list.get(2).equals(30) : "get(2) should return 30";
        assert list.get(4).equals(50) : "get(4) should return 50";

        // Test get by value
        assert list.get(30).equals(30) : "get(30) should return 30";
        assert list.get(99) == null : "get(99) should return null";

        // Test getFirst and getLast
        assert list.getFirst().equals(10) : "getFirst() should return 10";
        assert list.getLast().equals(50) : "getLast() should return 50";

        System.out.println("✅ Get operations test passed!\n");
    }

    private static void testIndexOperations() {
        System.out.println("🧪 Test 6: Index Operations");
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Apple"); // Duplicate
        list.add("Date");

        System.out.print("Test list: ");
        list.printList();

        // Test indexOf
        assert list.indexOf("Apple") == 0 : "indexOf('Apple') should return 0";
        assert list.indexOf("Cherry") == 2 : "indexOf('Cherry') should return 2";
        assert list.indexOf("NotFound") == -1 : "indexOf('NotFound') should return -1";

        // Test lastIndexOf
        assert list.lastIndexOf("Apple") == 3 : "lastIndexOf('Apple') should return 3";
        assert list.lastIndexOf("Date") == 4 : "lastIndexOf('Date') should return 4";
        assert list.lastIndexOf("NotFound") == -1 : "lastIndexOf('NotFound') should return -1";

        System.out.println("indexOf('Apple'): " + list.indexOf("Apple"));
        System.out.println("lastIndexOf('Apple'): " + list.lastIndexOf("Apple"));
        System.out.println("✅ Index operations test passed!\n");
    }

    private static void testSetOperations() {
        System.out.println("🧪 Test 7: Set Operations");
        CustomLinkedList<Integer> list = new CustomLinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        System.out.print("Original list: ");
        list.printList();

        // Test set
        list.set(0, 100);
        list.set(2, 300);
        list.set(4, 500);

        System.out.print("After setting indices 0, 2, 4: ");
        list.printList();

        assert list.get(0).equals(100) : "Index 0 should be 100";
        assert list.get(1).equals(2) : "Index 1 should still be 2";
        assert list.get(2).equals(300) : "Index 2 should be 300";
        assert list.get(4).equals(500) : "Index 4 should be 500";

        System.out.println("✅ Set operations test passed!\n");
    }

    private static void testRemoveOperations() {
        System.out.println("🧪 Test 8: Remove Operations");
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("B"); // Duplicate
        list.add("D");

        System.out.print("Original list: ");
        list.printList();

        // Test remove by value (removes first occurrence)
        list.remove("B");
        System.out.print("After remove('B'): ");
        list.printList();

        // Test removeFirst
        list.removeFirst();
        System.out.print("After removeFirst(): ");
        list.printList();

        // Test removeLast
        list.removeLast();
        System.out.print("After removeLast(): ");
        list.printList();

        // Test remove by index
        list.add("X");
        list.add("Y");
        System.out.print("After adding X and Y: ");
        list.printList();

        list.remove(1);
        System.out.print("After remove(1): ");
        list.printList();

        // Test removeLastOccurrence
        list.add("C");
        System.out.print("After adding another C: ");
        list.printList();

        list.removeLastOccurrence("C");
        System.out.print("After removeLastOccurrence('C'): ");
        list.printList();

        System.out.println("✅ Remove operations test passed!\n");
    }

    private static void testEdgeCases() {
        System.out.println("🧪 Test 9: Edge Cases");

        // Empty list operations
        CustomLinkedList<Integer> emptyList = new CustomLinkedList<>();
        assert emptyList.isEmpty() : "Empty list should return true for isEmpty()";
        assert emptyList.indexOf(1) == -1 : "indexOf on empty list should return -1";
        assert emptyList.get(1) == null : "get by value on empty list should return null";

        // Single element operations
        CustomLinkedList<String> singleList = new CustomLinkedList<>();
        singleList.add("Only");
        assert singleList.size() == 1 : "Single element list size should be 1";
        assert singleList.getFirst().equals("Only") : "First element should be 'Only'";
        assert singleList.getLast().equals("Only") : "Last element should be 'Only'";

        singleList.removeFirst();
        assert singleList.isEmpty() : "After removing only element, list should be empty";

        // Exception testing
        CustomLinkedList<Integer> list = new CustomLinkedList<>(Arrays.asList(1, 2, 3));

        try {
            list.get(-1);
            assert false : "Should throw IndexOutOfBoundsException for negative index";
        } catch (IndexOutOfBoundsException e) {
            System.out.println("✅ Correctly threw exception for get(-1)");
        }

        try {
            list.get(10);
            assert false : "Should throw IndexOutOfBoundsException for index >= size";
        } catch (IndexOutOfBoundsException e) {
            System.out.println("✅ Correctly threw exception for get(10)");
        }

        System.out.println("✅ Edge cases test passed!\n");
    }

    private static void testPerformance() {
        System.out.println("🧪 Test 10: Performance Test");

        CustomLinkedList<Integer> list = new CustomLinkedList<>();

        // Add performance
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Time to add 10,000 elements: " + (endTime - startTime) / 1_000_000 + "ms");

        // Get performance
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.get(i * 10); // Get every 10th element
        }
        endTime = System.nanoTime();
        System.out.println("Time to get 1,000 elements: " + (endTime - startTime) / 1_000_000 + "ms");

        System.out.println("Final list size: " + list.size());
        System.out.println("✅ Performance test completed!\n");
    }
}