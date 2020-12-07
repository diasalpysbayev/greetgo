import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestCase {
    static Connection con = null;
    private static Statement stmt;
    public static String DB_URL = "jdbc:postgresql://localhost:5436/students";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "123";

    @BeforeTest
    public void setUp() throws Exception {
        try{
            String dbClass = "org.postgresql.Driver";
            Class.forName(dbClass).getDeclaredConstructor().newInstance();

            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        try{
            String query = "select * from students";
            ResultSet res = stmt.executeQuery(query);
            while (res.next())
            {
                System.out.println(res.getString(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() throws Exception {

        if (con != null) {
            con.close();
        }
    }
}
