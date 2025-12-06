/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alton
 */
public class Exceptions {

    // ===== Item Not Found =====
    public static class ItemNotFoundException extends Exception {
        public ItemNotFoundException(String msg) {
            super(msg);
        }
    }

    // ===== Already Borrowed =====
    public static class AlreadyBorrowedException extends Exception {
        public AlreadyBorrowedException(String msg) {
            super(msg);
        }
    }

    // ===== Not Borrowed Yet =====
    public static class NotBorrowedException extends Exception {
        public NotBorrowedException(String msg) {
            super(msg);
        }
    }

    // ===== Array Full =====
    public static class ArrayFullException extends Exception {
        public ArrayFullException(String msg) {
            super(msg);
        }
    }

    // ===== Invalid Input =====
    public static class InvalidInputException extends Exception {
        public InvalidInputException(String msg) {
            super(msg);
        }
    }
}
