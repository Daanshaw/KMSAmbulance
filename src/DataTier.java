import java.sql.*;

public class DataTier {
//    public static Connection getConnection() {
//        try {
//            String driver = "com.mysql.cj.jdbc.Driver";
//            String databaseUrl = "jdbc:mysql://localhost:3306/kms";
//            String username = "root";
//            String password = "";
//            Class.forName(driver);
//            Connection conn = DriverManager.getConnection(databaseUrl, username, password);
//
//            return conn;
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//
//        return null;
//    }
//
//
//    public void createTable() throws SQLException {
//        try {
//            Connection conn = getConnection();
//            PreparedStatement create = conn.prepareStatement("CREATE TABLE `kms`.`callout` ( `name` VARCHAR(255) NOT NULL , `surname` VARCHAR(255) NOT NULL , `acc_desc` VARCHAR(255) NOT NULL , `datetime` TIMESTAMP NOT NULL , `location` VARCHAR(255) NOT NULL , `action_taken_desc` VARCHAR(255) NOT NULL , `call_time_sec` INT NOT NULL ) ENGINE = InnoDB;");
//            create.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//
//    }


}
