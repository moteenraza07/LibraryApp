// extends the abstract superclass LibraryItem and implements borrowable interface
public class Magazine extends LibraryItem implements Borrowable {
    // magazine specific attribute
    private int issueNumber;

    // constructor
    public Magazine (int id, String title, int issueNumber) {
        super(id, title); // initialize superclass fields
        this.issueNumber = issueNumber;
    }

    // display information specific to the magazine
    @Override
    public void displayInfo() {
        System.out.println("Magazine " + getTitle() + "(Issue: " + issueNumber +  ")");
    }

    // calculate fee magazine charge 0.25 per day late
    @Override
    public double calculateFee(int daysLate) {
        return daysLate * 0.25;
    }

    // throws exception if magazine is already borrowed
    @Override
    public void borrow() throws Exceptions.AlreadyBorrowedException
    {
        if(isBorrowed()) {
            throw new Exceptions.AlreadyBorrowedException("Magazine is already borrowed");
        }
        setBorrowed(true);
    }

    // changes status to return for magazine
    @Override
    public void returnItem() {
        setBorrowed(false);
    }

    // returns formatted string with magazine details
    @Override
    public String toString() {
        return "Magazine " + super.toString() + ", Issue: " + issueNumber;
    }


}