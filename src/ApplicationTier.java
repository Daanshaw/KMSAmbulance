
import java.sql.*;


public class ApplicationTier {

    DataTier dt = new DataTier();
    void sendCallout() throws SQLException {

        dt.createTable();

    }
}
