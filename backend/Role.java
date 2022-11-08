package lab.backend;

public abstract class Role {

    private final Database db;

    public Role(Database db) {
        this.db = db;
    }

    public void addObject(LibraryObject obj, Database db) {

        if (db == null) {
            System.out.println("Database not found");
        } else {
            db.insertRecord(obj);
        }

    }

    public void removeObject(String key) {
        db.deleteRecord(key);
    }

    public LibraryObject[] getListOfObject() {
        return db.returnAllRecords().toArray(new LibraryObject[0]);
    }

    public void logout() {
        db.saveToFile();
    }
}
