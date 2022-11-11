package lab.backend;

import java.time.*;
import java.util.*;
import lab.constants.FileNames;

public class LibrarianRole {

    private final BookDatabase bookDb;
    private final StudentBookDatabase studentBookDb;

    public LibrarianRole() {
        bookDb = new BookDatabase(FileNames.BOOKS_FILENAME);
        studentBookDb = new StudentBookDatabase(FileNames.STUDENTSBOOKS_FILENAME);
    }

    public void addBook(String bookId, String title, String authorName, String publisherName, int quantity) throws RepeatedIdException{
        if (bookDb == null) {
            System.out.println("Database not found");
        } else {
            
            bookDb.insertRecord(new Book(bookId, title, authorName, publisherName, quantity));
                
        }

    }

    public Book[] getListOfBooks() {
        return bookDb.returnAllRecords().toArray(new Book[0]);
    }
    
    public String[] getListOfBooksAsString() {
        Book[] books = this.getListOfBooks();
        String[] booksStrings = new String[books.length];
        for(int i=0; i< books.length; i++){
            booksStrings[i] = books[i].lineRepresentation();
        }
        return booksStrings;
    }

    public StudentBook[] getListOfBorrowingOperations() {
        return studentBookDb.returnAllRecords().toArray(new StudentBook[0]);
    }
    
    public String[] getListOfBorrowedBooksAsString() {
        StudentBook[] borrowedBooks = this.getListOfBorrowingOperations();
        String[] StudentsBooksStrings = new String[borrowedBooks.length];
        for(int i=0; i< borrowedBooks.length; i++){
            StudentsBooksStrings[i] = borrowedBooks[i].lineRepresentation();
        }
        return StudentsBooksStrings;
    }

    public int borrowBook(String studentId, String bookId, LocalDate borrowDate) throws RepeatedIdException{
        Book book = (Book) bookDb.getRecord(bookId);
        if(book==null)
        { System.out.println("Book id doesn't exist");
          return -1; 
        }
        
       
        StudentBook sBook = new StudentBook(studentId, bookId, borrowDate);
        
        if (studentBookDb.contains(sBook.getSearchKey())) {
            return 1;
        }
        
        if (book.getQuantity() == 0) { //Change 1 29
            return 0;
        }

        book.setQuantity(book.getQuantity() - 1);
        studentBookDb.insertRecord(sBook);
        //logout();

        return 2;

    }

    public double returnBook(String studentId, String bookId, LocalDate returnDate) throws IdNotFoundException {

        Book book = (Book) bookDb.getRecord(bookId);
        if(book==null)
        { System.out.println("Book id doesn't exist");
          return -1;
        }
        

        String searchKey = String.join(",", studentId, bookId);
        StudentBook sBook = (StudentBook) studentBookDb.getRecord(searchKey);
        if(sBook==null)
        { 
          System.out.println("Student Book id doesn't exist");
          return -1;
        }
        book.setQuantity(book.getQuantity() + 1);
        studentBookDb.deleteRecord(searchKey); //Change 2 29
        
        Period diff = Period.between(sBook.getBorrowDate(),returnDate );
        int totalDays = diff.getDays() + diff.getMonths() * 30 + diff.getYears() * 365;
        if (totalDays < 7) {
            return 0;
        }

        return (totalDays - 7) * 0.5;

    }

    public void logout() {
        bookDb.saveToFile();
        studentBookDb.saveToFile();

    }

}
