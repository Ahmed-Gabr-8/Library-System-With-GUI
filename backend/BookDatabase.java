package lab.backend;

class BookDatabase extends Database {
     BookDatabase(String filename) {
        super(filename);
    }

    @Override
     Book createRecordFrom(String line) {
        String[] bookDataAsStrings = line.split(",");
        return new Book(bookDataAsStrings[0], bookDataAsStrings[1],
                bookDataAsStrings[2], bookDataAsStrings[3], Integer.parseInt(bookDataAsStrings[4]) );

    }


}