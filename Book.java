// extend the abstract class from library item to inherit attributes
// implement borrowable class
public class Book extends LibraryItem implements Borrowable {
    // name of the book's author
    private String author;

    // constructor book id, string title, string author
    public Book (int id, String title, String author) {
        super(id, title); // initialize id and title from library item
        this.author = author;
    }

    // display info for book
    @Override
    public void displayInfo() {
        System.out.println("Book: " + getTitle() + "by " + author);
    }

    // calculate fee for book
    // 0.50 charge per day late
    @Override
    public double calculateFee(int daysLate) {
        return daysLate * 0.50;
    }

    // mark books borrowed
    // throw exception if book is already borrowed
    @Override
    public void borrow() throws AlreadyBorrowedException {
        if(isBorrowed) {
            throw new AlreadyBorrowedException("Book is already borrowed! ")
        }

        setBorrowed(true);
    }

    // mark book as returned
    @Override
    public void returnItem() {
        setBorrowed(false);
    }

    // return book details
    @Override
    public String toString() {
        return "book " + super.toString() + "Author " + author;
    }
}