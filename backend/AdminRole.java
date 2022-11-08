package lab.backend;

public class AdminRole {

    private final LibrarianUserDatabase libraianDb;

    public AdminRole() {
        this.libraianDb = new LibrarianUserDatabase("Librarians.txt");
    }

    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber) {

        if (libraianDb == null) 
            System.out.println("Database not found");
        else
            libraianDb.insertRecord(new LibrarianUser(librarianId, name, email, address, phoneNumber));

    }

    public LibrarianUser[] getListOfLibrarians() {
        return libraianDb.returnAllRecords().toArray(new LibrarianUser[0]);
    }

    public void removeLibrarian(String key) {
        libraianDb.deleteRecord(key);
    }

    public void logout() {
        libraianDb.saveToFile();
    }
}
