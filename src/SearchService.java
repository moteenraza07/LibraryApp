/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alton
 */
public class SearchService {
    // Find a LibraryItem  by its ID
    public LibraryItem findById(LibraryManager manager, int id) throws Exceptions.ItemNotFoundException {
        LibraryItem it = manager.findById(id); // Search the manager
        if (it == null) throw new Exceptions.ItemNotFoundException("No item found with ID " + id); // Throw not found
        return it; // Return the found item
    }
    
    // Find LibraryItems by their title
    public LibraryItem[] findByTitle(LibraryManager manager, String title) {
        return manager.findByTitle(title);
    }
    
    @Override
    public String toString() {
        return "SearchService";
    }
}
