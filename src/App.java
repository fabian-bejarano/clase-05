import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import javax.naming.spi.DirStateFactory.Result;

public class App {
    public static void main(String[] args) throws Exception {


        Connection connection;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:hr.db");
            if (connection != null){
                System.out.println("Conexion exitosa");
                
            }

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("Select * from employees");
            while(rs.next())
            {
                // read the result set 
                System.out.println("apellido = " + rs.getString("last_name"));
                System.out.println("nombre = " + rs.getString("first_name"));
                System.out.println("email = " + rs.getString("email"));
            }


        } catch (Exception e) {
            // Todo: handle exception
            System.err.println(e.getClass().getName()+ ":" +e.getMessage());
            System.out.println("Error en la conexion");
        }

    }
}
