package java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CalculatingAverageAndSum {
    public boolean calculateTheValues(String query)
    {
        try
        {
            // create a java mysql database connection
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/payrollservices";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "aswathi123");

            // create the java mysql update preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            System.out.println(preparedStmt.executeUpdate());
            conn.close();
            return true;
        }
        catch (Exception e) {}
        return false;
    }
}
