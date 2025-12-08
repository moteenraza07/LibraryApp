/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alton
 */
/**
 * LibraryTester.java
 * Demo runner. No user input — all data passed via constructors and method calls.
 */
public class MiniLibraryTester {
    public static void main(String[] args) {
        // Create an instance and run the demo
        new MiniLibraryTester().runDemo();
    }

    public void runDemo() {
        System.out.println("=== MINI LIBRARY DEMO START ===");
        
        // Create library manager and services
        LibraryManager manager = new LibraryManager(100); // lobrary capacity 100
        SearchService search = new SearchService(); // search service
        BorrowService borrowService = new BorrowService(); // borrowing service

        try {
            // create and add items
            Book b1 = new Book(1, "Clean Code", "Robert C. Martin");
            Book b2 = new Book(2, "Effective Java", "Joshua Bloch");
            Magazine m1 = new Magazine(100, "Tech Monthly", 7);

            manager.addItem(b1);
            manager.addItem(b2);
            manager.addItem(m1);

            System.out.println("--- Items Added ---");
            System.out.println(b1);
            System.out.println(b2);
            System.out.println(m1);
            
            // Show current items in the library
            System.out.println("\n--- Current Items ---");
            showItems(manager);
            
            // Search for an item by title
            System.out.println("\n--- Search by title 'Effective Java' ---");
            LibraryItem[] found = search.findByTitle(manager, "Effective Java");
            for (LibraryItem f : found) System.out.println("Found: " + f);
            
            // Borrowing items
            System.out.println("\n--- Borrowing ID 2 ---");
            borrowService.borrow(manager, 2);
            
            // Display all items with updated borrow status
            showItemsFull(manager);

            System.out.println("\n--- Borrowing ID 2 again (expected failure) ---");
            try {
                borrowService.borrow(manager, 2);
            } catch (Exceptions.AlreadyBorrowedException ex) {
                System.out.println("Failed to borrow: " + ex.getMessage());
            }
            
            // Calculate late fee
            System.out.println("\n--- Late fee for ID 2 (3 days) ---");
            double fee = borrowService.calculateLateFee(manager, 2, 3);
            System.out.printf("Late fee: $%.2f\n", fee);
            
            // Returning items
            System.out.println("\n--- Returning ID 2 ---");
            borrowService.returnItem(manager, 2);
            
            // Show final items in the library
            System.out.println("\n--- Final Items ---");
            showItemsFull(manager);

        } catch (Exceptions.ArrayFullException | Exceptions.InvalidInputException |
                 Exceptions.ItemNotFoundException | Exceptions.AlreadyBorrowedException |
                 Exceptions.NotBorrowedException ex) {
            // Catch any library-related exceptions
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println("\n=== MINI LIBRARY DEMO END ===");
    }
    // Display all items in the library
    private void showItems(LibraryManager manager) {
        LibraryItem[] items = manager.listItems();
        if (items.length == 0) {
            System.out.println("No items.");
            return;
        }
        for (LibraryItem it : items) it.displayInfo(); // polymorphic display
    }
    
    // Show full info for final item secion
    private void showItemsFull(LibraryManager manager) {
        LibraryItem[] items = manager.listItems();
        if (items.length == 0) {
            System.out.println("No items in the library.");
            return;
        }
        for (LibraryItem it : items) {
            System.out.println(it.toString()); // full format
        }
    }
}

