/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alton
 */
public class BorrowService {
    public void borrow(LibraryManager manager, int id)
            throws Exceptions.ItemNotFoundException, Exceptions.AlreadyBorrowedException {

        LibraryItem item = manager.findById(id);  // now throws ItemNotFoundException

        if (!(item instanceof Borrowable)) {
            throw new IllegalStateException("Item with ID " + id + " is not borrowable.");
        }

        Borrowable borrowable = (Borrowable) item;
        borrowable.borrow();   // may throw AlreadyBorrowedException
    }

    public void returnItem(LibraryManager manager, int id)
            throws Exceptions.ItemNotFoundException, Exceptions.NotBorrowedException {

        LibraryItem item = manager.findById(id);

        if (!(item instanceof Borrowable)) {
            throw new IllegalStateException("Item with ID " + id + " cannot be returned because it is not borrowable.");
        }

        Borrowable borrowable = (Borrowable) item;
        borrowable.returnItem();   // may throw NotBorrowedException
    }

    public double calculateLateFee(LibraryManager manager, int id, int daysLate)
            throws Exceptions.ItemNotFoundException {

        LibraryItem item = manager.findById(id);  // throws ItemNotFoundException

        return item.calculateFee(daysLate);  // polymorphic: Book or Magazine version
    }


    @Override
    public String toString() {
        return "BorrowService (handles borrowing, returning, and fee calculation)";
    }
}
