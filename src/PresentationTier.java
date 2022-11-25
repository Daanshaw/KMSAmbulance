import java.sql.SQLException;
import java.util.Scanner;

public class PresentationTier {

    ApplicationTier ap = new ApplicationTier();
    public void presentationTier() throws SQLException {
        while (true) {
            System.out.println("Welcome to KWIK MEDICAL SYSTEM - Ambulance");
            System.out.println("Choose form one of the following options:");
            System.out.println("");
            System.out.println("1. Check for any patient info sent from hospital");
            System.out.println("2. Send callout details to the database");
            System.out.println("3. Exit program");

            Scanner scanner = new Scanner(System.in);  // Create a Scanner object


            int option = scanner.nextInt();  // Read user input

            if(option == 3){

                System.exit(0);


            }
            else if(option == 2){

            ap.sendCallout();


            }


        }
    }
}
