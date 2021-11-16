package createUpdateSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert_into
{
  public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt;
    stmt = null;
    try {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres",
              "postgres", "1234");

      System.out.println("Database open ok");

      stmt = c.createStatement();
      String sql = "UPDATE \"Dreamhome\".staff set saltopay = 12500.00 where staffno = 'KS03';";
      stmt.executeUpdate(sql);



      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }
    System.out.println("Database update ok");
  }
}
