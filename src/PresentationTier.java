import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.Scanner;

public class PresentationTier {

    ApplicationTier ap = new ApplicationTier();

    void presentationTier() throws Exception {

        while(true) {

            System.out.println("Welcome to KWIK MEDICAL SYSTEM - Ambulance");
            System.out.println("Choose form one of the following options:");
            System.out.println("");
            System.out.println("1. Check for any patient info sent from hospital.");
            System.out.println("2. Check for rescue requests.");
            System.out.println("3. Enter and send callout details to the KMS.");
            System.out.println("4. Exit program.");

            ap.applicationTier();
        }




    }


    void enterNameMsg(){

        System.out.println("Enter patient's name:");
    }
    void enterSurnameMsg(){

        System.out.println("Enter patient's surname:");
    }
    void enterNhsNoMsg(){

        System.out.println("Enter patient's NHS registration number:");
    }
    void enterAccDescMsg(){

        System.out.println("Enter patient's accident description:");
    }
    void enterLocationMsg(){

        System.out.println("Enter accident's location:");
    }
    void enterActionTakenDesc(){

        System.out.println("Enter description of action taken:");
    }
    void enterCallTimeMsg(){

        System.out.println("Enter call time:");
    }
}
