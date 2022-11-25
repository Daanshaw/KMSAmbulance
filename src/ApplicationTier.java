
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;


public class ApplicationTier {
    Scanner scanner = new Scanner(System.in);

    void applicationTier() throws SQLException {
        String name = scanner.next();
        String surname = scanner.next();
        String accountDesc = scanner.next();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String location = scanner.next();
        String actionTakenDesc = scanner.next();
        int callTimeSec = scanner.nextInt();

        //creating new patient with the attributes input from user

        Callout callout = new Callout(name, surname, accountDesc, timestamp, location, actionTakenDesc, callTimeSec);

        System.out.println(callout);



        //sendCallout();
        //dt.insertCallout(callout);

        try
        {
            // Set up the keyboard input
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Student RMI Server");

            // Ask for the IP address of the RMI Registry
            System.out.print("IP Address of RMI Registry: ");
            String ip = input.readLine();

            // Create a new student object
            //Patient patient = new Patient("John Dann", "01234567", 123, "1231", "sikc");

            // Create the remote version of the student object
            CalloutInterface callout_stub = (CalloutInterface) UnicastRemoteObject.exportObject(callout, 0);

            // Connect to the RMI Registry
            Registry registry = LocateRegistry.getRegistry(ip);

            // Declare the object with the registry
            registry.rebind("callout", callout_stub);
            System.out.println("Callout bound");
        }
        catch (Exception e)
        {
            System.err.println("Error Occured");
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }



    DataTier dt = new DataTier();
//    void sendCallout() throws SQLException {
//
//        dt.createTable();
//
//    }
}
