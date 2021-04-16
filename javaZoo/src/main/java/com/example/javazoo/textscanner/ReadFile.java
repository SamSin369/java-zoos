package com.example.javazoo.textscanner;

import com.example.javazoo.models.EmailList;
import com.example.javazoo.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

@Component
public class ReadFile {
    @Autowired
     EmailRepository emailsrepos;
    public void loadFile() {

        try {
            File myObj = new File("D:\\unit4java\\week2\\java-crudyrestaurants\\javaZoo\\src\\main\\java\\com\\example\\javazoo\\textscanner\\5000list.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                emailsrepos.save(new EmailList(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}