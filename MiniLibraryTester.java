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
        new MiniLibraryTester().runDemo();
    }

    public void runDemo() {
        System.out.println("=== MINI LIBRARY DEMO START ===\n");

        // Create library manager and services
        LibraryManager manager = new LibraryManager(100);
        SearchService search = new SearchService();
        BorrowService borrowService = new BorrowService();

        try {
            // ----- Create and add items -----
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

            // ----- Show current items -----
            System.out.println("\n--- Current Library Items ---");
            showItems(manager);

            // ----- Search by title -----
            System.out.println("\n--- Search: 'Effective Java' ---");
            LibraryItem[] found = search.findByTitle(manager, "Effective Java");
            for (LibraryItem f : found) {
                System.out.println(f);
            }

            // ----- Borrowing an item -----
            System.out.println("\n--- Borrowing Book ID 2 ---");
            borrowService.borrow(manager, 2);
            System.out.println("Successfully borrowed: " + b2);

            System.out.println("\n--- Attempt to borrow Book ID 2 again ---");
            try {
                borrowService.borrow(manager, 2);
            } catch (Exceptions.AlreadyBorrowedException ex) {
                System.out.println("Failed to borrow: " + ex.getMessage());
            }

            // ----- Late fee calculation -----
            System.out.println("\n--- Calculating Late Fee for ID 2 (3 days) ---");
            double fee = borrowService.calculateLateFee(manager, 2, 3);
            System.out.printf("Late fee: $%.2f\n", fee);

            // ----- Returning item -----
            System.out.println("\n--- Returning Book ID 2 ---");
            borrowService.returnItem(manager, 2);
            System.out.println("Successfully returned: " + b2);

            // ----- Final library items -----
            System.out.println("\n--- Final Library Items ---");
            showItems(manager);

        } catch (Exceptions.ArrayFullException | Exceptions.InvalidInputException
                | Exceptions.ItemNotFoundException | Exceptions.AlreadyBorrowedException
                | Exceptions.NotBorrowedException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println("\n=== MINI LIBRARY DEMO END ===");
    }

    /**
     * Display all items in the library. Each item handles its own display
     * (polymorphic).
     */
    private void showItems(LibraryManager manager) {
        LibraryItem[] items = manager.listItems();
        if (items.length == 0) {
            System.out.println("No items in the library.");
            return;
        }
        for (LibraryItem it : items) {
            it.displayInfo();
        }
    }
}
