
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;


public class ApplicationTier {

    Scanner scanner = new Scanner(System.in);


    void applicationTier() throws Exception {


        // Create a Scanner object


        int option = scanner.nextInt();  // Read user input

        if (option == 3) {

            sendCalloutDetails();


        } else if (option == 4) {

            System.exit(0);


        } else if (option == 1) {

            try {

                String ip = "192.168.0.3";

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
            } catch (IOException ioe) {
                System.err.println("Error in I/O");
                System.err.println(ioe.getMessage());
                System.exit(-1);
            } catch (NotBoundException nbe) {
                System.err.println("Object not declared on RMI Registry");
                System.err.println(nbe.getMessage());
                System.exit(-1);
            }
        }

    }


//    DataTier dt = new DataTier();
////    void sendCallout() throws SQLException {
////
////        dt.createTable();
////
////    }

    void sendCalloutDetails() {
        PresentationTier pt = new PresentationTier();


        pt.enterNameMsg();
        String name = scanner.next();
        pt.enterSurnameMsg();
        String surname = scanner.next();
        pt.enterNhsNoMsg();
        int nhsRegNo = scanner.nextInt();
        pt.enterAccDescMsg();
        String accountDesc = scanner.next();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        pt.enterLocationMsg();
        String location = scanner.next();
        pt.enterActionTakenDesc();
        String actionTakenDesc = scanner.next();
        pt.enterCallTimeMsg();
        int callTimeSec = scanner.nextInt();

        //creating new patient with the attributes input from user

        Callout callout = new Callout(name, surname, nhsRegNo, accountDesc, timestamp, location, actionTakenDesc, callTimeSec);

        System.out.println(callout);


        //sendCallout();
        //dt.insertCallout(callout);

        try {
            // Set up the keyboard input

            String ip = "192.168.0.3";

            // Create a new student object
            //Patient patient = new Patient("John Dann", "01234567", 123, "1231", "sikc");

            // Create the remote version of the student object
            CalloutInterface callout_stub = (CalloutInterface) UnicastRemoteObject.exportObject(callout, 0);

            // Connect to the RMI Registry
            Registry registry = LocateRegistry.getRegistry(ip);

            // Declare the object with the registry
            registry.rebind("callout", callout_stub);
            System.out.println("Callout bound");
        } catch (Exception e) {
            System.err.println("Error Occurred");
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
}
