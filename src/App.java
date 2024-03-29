import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;


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
                
                System.out.println("nombre = " + rs.getString("first_name"));
                System.out.println("apellido = " + rs.getString("last_name"));
                System.out.println("email = " + rs.getString("email"));
                System.out.println("id = " + rs.getInt("employee_id"));
            }
            //-----------------------------------
            statement.executeUpdate("drop table if exists persona");
            statement.executeUpdate("create table persona (cedula integer, nombre string)");
            statement.executeUpdate("insert into persona values(1, 'Jhon')");
            statement.executeUpdate("insert into persona values(2, 'Patricia')");
            statement.executeUpdate("insert into persona values(3, 'Fabian')");
            
            PreparedStatement ps = connection.prepareStatement("insert into persona values(?, ?)");
            ps.setInt(1, 4);
            ps.setString(2, "Pedro");
            ps.executeUpdate();            
            
            ResultSet consulta = statement.executeQuery("SELECT * FROM persona");
            while(consulta.next())
            {

                // read the result set
                System.out.print("Cédula = " + consulta.getInt("cedula"));
                System.out.println(", Nombre = " + consulta.getString("nombre"));
            }
            

        } catch (Exception e) {
            // Todo: handle exception
            System.err.println(e.getClass().getName()+ ":" +e.getMessage());
            System.out.println("Error en la conexion");
        }

    }
}
