package lab.backend;

public class LibrarianUserDatabase extends Database {

    public LibrarianUserDatabase(String filename) {
        super(filename);
    }

    @Override
    public LibrarianUser createRecordFrom(String line) {
        String[] librarianDataAsStrings = line.split(",");
        return new LibrarianUser(librarianDataAsStrings[0], librarianDataAsStrings[1],
                librarianDataAsStrings[2], librarianDataAsStrings[3], librarianDataAsStrings[4]);

    }
    


}
