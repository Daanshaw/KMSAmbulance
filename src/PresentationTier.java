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
    DataTier dt = new DataTier();
    public void presentationTier() throws SQLException {
        while (true) {
            System.out.println("Welcome to KWIK MEDICAL SYSTEM - Ambulance");
            System.out.println("Choose form one of the following options:");
            System.out.println("");
            System.out.println("1. Check for any patient info sent from hospital.");
            System.out.println("2. Check for rescue requests.");
            System.out.println("3. Enter and send callout details to the KMS.");
            System.out.println("4. Exit program.");

            Scanner scanner = new Scanner(System.in);  // Create a Scanner object


            int option = scanner.nextInt();  // Read user input

            if(option == 3){

                System.exit(0);


            }
            else if(option == 4){


                ap.applicationTier();




            }
            else if(option == 1){

                try
                {
                    // Set up keyboard input
                    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("RMI Client Program");

                    // Get IP address of the RMI Registry
                    System.out.print("Enter IP address of RMI Registry: ");
                    String ip = input.readLine();

                    // Connect to the registry
                    Registry registry = LocateRegistry.getRegistry(ip);

                    // Get the remotely declared student object
                    PatientInterface patient = (PatientInterface) registry.lookup("patient");

                    // Display the current student details
                    System.out.println("Patient details:");
                    System.out.println("Name: " + patient.getName());
                    System.out.println("Surname: " + patient.getSurname());
                    System.out.println("NHS number: " + patient.getNhsRegistrationNo());
                    System.out.println("Address: " + patient.getAddress());
                    System.out.println("Medical condition: " + patient.getMedicalCondition());

//			// Change the student details
//			System.out.print("Enter new student name: ");
//			String name = input.readLine();
//			patient.setName(name);
//			System.out.print("Enter new student matric: ");
//			String matric = input.readLine();
//			patient.setSurname(matric);
//			System.out.print("Enter new student programme: ");
//			String programme = input.readLine();
//			patient.setNhsRegistrationNo(Integer.parseInt(programme));
                }
                catch (IOException ioe)
                {
                    System.err.println("Error in I/O");
                    System.err.println(ioe.getMessage());
                    System.exit(-1);
                }
                catch (NotBoundException nbe)
                {
                    System.err.println("Object not declared on RMI Registry");
                    System.err.println(nbe.getMessage());
                    System.exit(-1);
                }
            }


        }
    }
}
