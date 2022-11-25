import java.util.Scanner;

public class PresentationTier {
    public void presentationTier(){
        while (true) {
            System.out.println("Welcome to KWIK MEDICAL SYSTEM - Ambulance");
            System.out.println("Choose form one of the following options:");
            System.out.println("");
            System.out.println("1. Send callout details to hospital");
            System.out.println("2. Check for any patient info sent from hospital");
            System.out.println("2. Exit program");

            Scanner scanner = new Scanner(System.in);  // Create a Scanner object


            int option = scanner.nextInt();  // Read user input

            if(option == 2){

                System.exit(0);


            }


        }
    }
}
