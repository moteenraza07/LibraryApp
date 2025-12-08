public interface Borrowable {

    // Attempt to borrow an item.
    // Throws AlreadyBorrowedException if the item is already borrowed.
    void borrow() throws Exceptions.AlreadyBorrowedException;

    // Return item and reset borrowed status.
    void returnItem() throws Exceptions.NotBorrowedException;
}