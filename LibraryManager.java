/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alton
 */
public class LibraryManager {
    private final LibraryItem[] items; // Array storing library items
    private int count;   // Number of items currently stored
    
    // Default constructor: maximum of 100 items
    public LibraryManager() {
        this(100);
    }
    
    // Constructor with custome capacity
    public LibraryManager(int capacity) {
        items = new LibraryItem[capacity];
        count = 0;
    }
    
    // Adds a libraryItem to the array
    public void addItem(LibraryItem item) throws Exceptions.ArrayFullException, Exceptions.InvalidInputException {
        if (item == null) throw new Exceptions.InvalidInputException("Cannot add null item");
        if (count >= items.length) throw new Exceptions.ArrayFullException("Library is full.");
        items[count++] = item;
    }
    
    // Find a libraryItem by its ID and returns null if not found.
    public LibraryItem findByID(int id) {
        for (int i = 0; i < count; i++) {
            if (items[i].getId() == id) return items[i];
        }
        return null;
    }
    
    // Alias for findByID
     public LibraryItem findById(int id) {
        return findByID(id);
    }
    
    // Retrieve items with titles that include the given string    
    public LibraryItem[] findByTitle(String title) {
        LibraryItem[] temp = new LibraryItem[count];
        int found = 0;
        String frag = (title == null) ? "" : title.toLowerCase();
        for (int i = 0; i < count; i++) {
            if (items[i].getTitle().toLowerCase().contains(frag)) {
                temp[found++] = items[i];
            }
        }
        LibraryItem[] result = new LibraryItem[found];
        for (int i = 0; i < found; i++) result[i] = temp[i];
        return result;
    }
    
    // Deletes an item byID and shifts the array
     public void deleteItem(int id) throws Exceptions.ItemNotFoundException {
         int idx = -1;
         for (int i = 0; i < count; i++) {
             if (items[i].getId() == id) { idx = i; break; }
         }
         if (idx == -1) throw new Exceptions.ItemNotFoundException("No item with ID " + id);
         for (int i = idx; i < count - 1; i++) items[i] = items[i + 1];
         items[--count] = null;
     }
     
     // Returns a copy of the currently stored items
     public LibraryItem[] listItems() {
         LibraryItem[] out = new LibraryItem[count];
         for (int i = 0; i < count; i++) out[i] = items[i];
         return out;
     }
     
     // Reutrns the urrent number of tiem stored
     public int getCount() {
         return count;
     }
     
     // Simple String
     @Override
     public String toString() {
         return "LibraryManager: capacity=" + items.length + ", count=" + count;
     }
     
     
}


