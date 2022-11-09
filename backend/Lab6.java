package lab.backend;

import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.util.*;


public class Lab6 {
    
    public static void display(LibraryObject[] libObj){
        for(LibraryObject l : libObj){
            System.out.println(l.lineRepresentation());
            
        }
        System.out.println("------------------------------->");
    
    }
    
    
    
    public static void main(String []args){

//    LibrarianRole libRole = new LibrarianRole();
//   
//    libRole.addBook("B123", "Math", "Prof. Amr", "Alex U", 5);
//    libRole.addBook("B456", "Math 2", "Prof. Mervat", "Alex U", 10);
//    libRole.addBook("B123", "Math 3", "Elfahhar", "Alex U", 3);
//    libRole.logout();
//    }

        System.out.println("You are running main function. Shouldn't be running");
    
}}

//contains different book with same id
//If the file from the begining contains same id.
//If the user wanted to save directly without loading.
// check Id , data saved in file library. text
// book id unique.
// StudentBook need to be tested.
// If checking returnBook in -----> Librarian Role: check if Student Book exists
//DoubleSaving
//in returnBook we need try catch if there is no studentbooks in file.(NullPointerException).
//Two borrows same day
