import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) throws Exception {


        Connection connection;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:hr.db");
            if (connection != null){
                System.out.println("Conexion exitosa");
                
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getClass().getName()+ ":" +e.getMessage());
            System.out.println("Error en la conexion");
        }

    }
}
