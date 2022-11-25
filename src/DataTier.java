import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataTier {
    public static Connection getConnection(){
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseUrl = "jdbc:mysql://localhost:3306/kms";
            String username= "root";
            String password= "";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseUrl, username, password);
            System.out.println("Database connected");
            return conn;

        } catch (Exception e) {
            System.out.println(e);
        }


        return null;
    }


    public void createTable() throws SQLException {
        try {
            Connection conn = getConnection();
            PreparedStatement create = conn.prepareStatement("CREATE TABLE `kms`.`callout` ( `name` VARCHAR(255) NOT NULL , `surname` VARCHAR(255) NOT NULL , `acc_desc` VARCHAR(255) NOT NULL , `datetime` TIMESTAMP NOT NULL , `location` VARCHAR(255) NOT NULL , `action_taken_desc` VARCHAR(255) NOT NULL , `call_time_sec` INT NOT NULL ) ENGINE = InnoDB;");
            create.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        finally{
            System.out.println("Table created successfully.");
        }

    }

    public void insertCallout(Patient patient){

        try{
            Connection conn = getConnection();

            PreparedStatement insert = conn.prepareStatement("INSERT INTO callout(id, name, surname,acc_desc, datetime, location,action_taken_desc,call_time_sec)" + "VALUES (?,?, ?, ?, ?, ?,?,?,?)");

            insert.setNull(1, 1);
            insert.setString(2, patient.getName());
            insert.setString(3, patient.getSurname());
            insert.setInt(4, patient.getNhsRegistrationNo());
            insert.setString(5, patient.getAddress());
            insert.setString(6, patient.getMedicalCondition());
            insert.setString(7, patient.getMedicalCondition());
            insert.setString(8, patient.getMedicalCondition());

            insert.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println("Data inserted successfully.");
        }
    }
}
