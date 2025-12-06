public class Book extends LibraryItem implements Borrowable {
    private String author;

    public Book (int id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: " + getTitle() + "by " + author);
    }

    @Override
    public double calculateFee(int daysLate) {
        return daysLate * 0.50;
    }

    @Override
    public void borrow() throws AlreadyBorrowedException {
        if(isBorrowed) {
            throw new AlreadyBorrowedException("Book is already borrowed! ")
        }

        setBorrowed(true);
    }

    @Override
    public void returnItem() {
        setBorrowed(false);
    }

    @Override
    public String toString() {
        return "book " + super.toString() + "Author " + author;
    }
}