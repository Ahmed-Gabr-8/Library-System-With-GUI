package lab.backend;

import java.util.*;
import java.io.*;

abstract class Database {

    private ArrayList<LibraryObject> records = new ArrayList<>();
    private String filename;
    private boolean checkLoaded;

    Database(String filename) {
        this.filename = filename;
    }

    String getFilename() {
        return filename;
    }

    void setFilename(String filename) {
        this.filename = filename;
    }

    void setCheckLoaded(boolean checkLoaded) {
        this.checkLoaded = checkLoaded;
    }

    void correctLoaded() {
        if (!checkLoaded) {
            readFromFile();
        }
    }

    abstract LibraryObject createRecordFrom(String line);

    void readFromFile() {
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

    boolean contains(String key) {
        correctLoaded();
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;

    }

    ArrayList<LibraryObject> returnAllRecords() {
        correctLoaded();
        return records;
    }

    LibraryObject getRecord(String key) {

        if (contains(key)) {
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).getSearchKey().equals(key)) {
                    return records.get(i);
                }

            }
        }

        return null;
    }

    void insertRecord(LibraryObject record) throws RepeatedIdException {
        correctLoaded();
        if(contains(record.getSearchKey())){
            System.out.println("Repeated Id.");
            throw new RepeatedIdException();
        }
        else
            records.add(record);
    }

    void deleteRecord(String key) throws IdNotFoundException{
        LibraryObject temp = getRecord(key);
        if (temp == null){
            System.out.println("Record not found.");
            throw new IdNotFoundException();
        }
        else
        {
            records.remove(temp);
            System.out.println("Record is Removed.");
        }
    }

    void saveToFile() {
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
