import java.sql.*;

public class conn {

    Connection c;
    Statement s;

    public conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///projecthms","root","test1234");
            s=c.createStatement();


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
