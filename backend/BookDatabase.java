package lab.backend;

public class BookDatabase extends Database {
    public BookDatabase(String filename) {
        super(filename);
    }

    @Override
    public Book createRecordFrom(String line) {
        String[] bookDataAsStrings = line.split(",");
        return new Book(bookDataAsStrings[0], bookDataAsStrings[1],
                bookDataAsStrings[2], bookDataAsStrings[3], Integer.parseInt(bookDataAsStrings[4]) );

    }


}