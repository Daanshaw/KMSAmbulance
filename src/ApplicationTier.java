
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;


public class ApplicationTier {
    Scanner scanner = new Scanner(System.in);

    void calloutInput(){

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
    }

    DataTier dt = new DataTier();
    void sendCallout() throws SQLException {

        dt.createTable();

    }
}
