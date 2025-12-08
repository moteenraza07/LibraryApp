// this class stores the attributes id, title and borrowed status
public abstract class LibraryItem {
    // unique identifier for each library item
    private int id;
    // title for each library item
    private String title;
    // track whether library item is currently being borrowed or not
    private boolean isBorrowed;

    // constructor that initializes the id, title and sets borrowed state to false
    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
        this.isBorrowed = false;

    }

    // getter
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // true if item is borrowed otherwise the status will be false
    public void setBorrowed(boolean status) {
        this.isBorrowed = status;
    }

    // abstract method that forces each subclass which would be book and magazine
    public abstract void displayInfo();

    // abtract method that calculates late fees based on number of days late
    // each sub class will have its own rate
    public abstract double calculateFee(int daysLate);

    // returns representation of item
    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title +  ", Borrowed: " + isBorrowed;
    }
}