
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

        PresentationTier pt = new PresentationTier();


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


                pt.patientDetailsMsg(patient.getName(), patient.getSurname(), patient.getNhsRegistrationNo(), patient.getAddress(),patient.getMedicalCondition() );



            } catch (IOException ioe) {
                pt.IOMsg();
                System.err.println(ioe.getMessage());
                System.exit(-1);
            } catch (NotBoundException nbe) {
                pt.noDataMsg();
                System.err.println(nbe.getMessage());
                System.exit(-1);
            }
        }

    }




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





        try {


            String ip = "192.168.0.3";


            // Create the remote version of the student object
            CalloutInterface callout_stub = (CalloutInterface) UnicastRemoteObject.exportObject(callout, 0);

            // Connect to the RMI Registry
            Registry registry = LocateRegistry.getRegistry(ip);

            // Declare the object with the registry
            registry.rebind("callout", callout_stub);

        } catch (Exception e) {

            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
}
