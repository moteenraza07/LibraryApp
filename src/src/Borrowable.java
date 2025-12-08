// book and magazine implement borrowable interface to provide borrowing behaviour
public interface Borrowable {
    // item is borrowed
    // class to check whether the item is already borrowed
    // throw an exception if the borrow action is not allowed
    void borrow() throws Exceptions.AlreadyBorrwedException;
    // marks the item as returned
    // reset the borrowed status
    void returnItem();
}