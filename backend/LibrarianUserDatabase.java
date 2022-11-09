package lab.backend;

class LibrarianUserDatabase extends Database {

     LibrarianUserDatabase(String filename) {
        super(filename);
    }

    @Override
     LibrarianUser createRecordFrom(String line) {
        String[] librarianDataAsStrings = line.split(",");
        return new LibrarianUser(librarianDataAsStrings[0], librarianDataAsStrings[1],
                librarianDataAsStrings[2], librarianDataAsStrings[3], librarianDataAsStrings[4]);

    }
    


}
