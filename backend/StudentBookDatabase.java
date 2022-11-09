package lab.backend;

import java.time.LocalDate;
class StudentBookDatabase extends Database {
    StudentBookDatabase(String filename) {
        super(filename);
    }

    @Override
    StudentBook createRecordFrom(String line) {
        String[] studentBookDataAsStrings = line.split(",");
        String[] dateParameters = studentBookDataAsStrings[2].split("-");

        LocalDate date = LocalDate.of(Integer.parseInt(dateParameters[2]), Integer.parseInt(dateParameters[1]),Integer.parseInt(dateParameters[0]));
        return new StudentBook(studentBookDataAsStrings[0], studentBookDataAsStrings[1],
                date);

    }


}