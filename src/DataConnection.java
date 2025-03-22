import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
    private static final String URL="jdbc:mysql://127.0.0.1:3306/library_management";
    private static final String USER="root";
    private static final String PASSWORD = "11Akshay##";

    public static Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Data-base sucessfully Connected");

        }catch (ClassNotFoundException |SQLException e){
            System.out.println("Data-base Failed to connect ");
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
