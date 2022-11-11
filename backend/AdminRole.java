package lab.backend;
import lab.constants.FileNames;

public class AdminRole {

    private final LibrarianUserDatabase libraianDb;

    public AdminRole() {
        this.libraianDb = new LibrarianUserDatabase(FileNames.LIBRARIANS_FILENAME);
    }

    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber) throws RepeatedIdException {

        if (libraianDb == null) 
            System.out.println("Database not found");
        else
           libraianDb.insertRecord(new LibrarianUser(librarianId, name, email, address, phoneNumber));

    }

    public LibrarianUser[] getListOfLibrarians() {
        return libraianDb.returnAllRecords().toArray(new LibrarianUser[0]);
    }
    
    public String[] getListOfLibrariansAsString() {
        LibrarianUser[] librarianUsers = this.getListOfLibrarians();
        String[] librarianUsersStrings = new String[librarianUsers.length];
        for(int i=0; i< librarianUsers.length; i++){
            librarianUsersStrings[i] = librarianUsers[i].lineRepresentation();
        }
        return librarianUsersStrings;
    }

    public void removeLibrarian(String key) throws IdNotFoundException {
        libraianDb.deleteRecord(key);
    }

    public void logout() {
        libraianDb.saveToFile();
    }
}
