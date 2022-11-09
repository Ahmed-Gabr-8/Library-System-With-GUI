package lab.backend;

import java.time.LocalDate;

class StudentBook implements LibraryObject {

    private String studentId;
    private String bookId;
    private LocalDate borrowDate;

     StudentBook(String studentId, String bookId, LocalDate borrowDate) {
        this.studentId = studentId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

     String getStudentId() {
        return studentId;
    }

     String getBookId() {
        return bookId;
    }

     LocalDate getBorrowDate() {
        return borrowDate;
    }

    @Override
     public String getSearchKey() {
        return String.join(",",getStudentId(), getBookId());
    }
    
    @Override
     public String lineRepresentation() {
        String year = String.valueOf(borrowDate.getYear());
        String month = String.valueOf(borrowDate.getMonthValue() );
        String day = String.valueOf(borrowDate.getDayOfMonth());
        String dateString = String.join("-",day,month,year);
        return String.join(",", studentId, bookId,dateString);
    }
}
