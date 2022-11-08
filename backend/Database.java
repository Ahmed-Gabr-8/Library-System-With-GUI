package lab.backend;

import java.util.*;
import java.io.*;

public abstract class Database {

    private ArrayList<LibraryObject> records = new ArrayList<>();
    private String filename;
    private boolean checkLoaded;

    public Database(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setCheckLoaded(boolean checkLoaded) {
        this.checkLoaded = checkLoaded;
    }

    public void correctLoaded() {
        if (!checkLoaded) {
            readFromFile();
        }
    }

    public abstract LibraryObject createRecordFrom(String line);

    public void readFromFile() {
        try {
            File file = new File(getFilename());
            Scanner scan = new Scanner(file);
            setCheckLoaded(true);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                records.add(createRecordFrom(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public boolean contains(String key) {
        correctLoaded();
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;

    }

    public ArrayList<LibraryObject> returnAllRecords() {
        correctLoaded();
        return records;
    }

    public LibraryObject getRecord(String key) {

        if (contains(key)) {
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).getSearchKey().equals(key)) {
                    return records.get(i);
                }

            }
        }

        return null;
    }

    public void insertRecord(LibraryObject record) {
        correctLoaded();
        if(contains(record.getSearchKey()))
            System.out.println("Repeated Id.");
        else
            records.add(record);
    }

    public void deleteRecord(String key) {
        LibraryObject temp = getRecord(key);
        if (temp == null)
            System.out.println("Record not found.");
        else
        {
            records.remove(temp);
            System.out.println("Record is Removed.");
        }
    }

    public void saveToFile() {
        correctLoaded();

        try {

            FileWriter fWriter = new FileWriter(getFilename());

            for (int i = 0; i < records.size(); i++) {
                fWriter.write(records.get(i).lineRepresentation());
                if (i != records.size() - 1) {
                    fWriter.write("\n");
                }
            }

            fWriter.close();

            System.out.println(filename +
                    " is saved successfully with the content.");
        } catch (IOException e) {

            System.out.print("Error in Saving to " + filename);
        }
    }

}
