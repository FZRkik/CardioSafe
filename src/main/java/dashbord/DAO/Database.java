package dashbord.DAO;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {

        static String url="jdbc:mysql://localhost:3306/cardiosafe";
        static String name="root";
        static String pw="A1k2f3m4@RKIK";


    private static Database instance = new Database();

    private  Connection conn;
    private  ResultSet rs;
    private  Statement st;

    public static  Database getInstance() {
        return instance;
    }



   public void connect() throws ClassNotFoundException, SQLException {
       if (conn != null)
            return;
       //Class.forName("com.mysql.jdbc.Driver"); //loading the driver
       conn=DriverManager.getConnection(url,name,pw);// establish the connection
       st=conn.createStatement();//create the statement

    }



    public  ResultSet query(String q) {

        try {
            connect();
            st = conn.createStatement();
            rs = st.executeQuery(q);

        } catch (Exception e) {
            System.err.println("Error Message : problem in query() method." + e);
        }

        return rs;
    }


    public  int maj(String query)  {

        try {
            connect();
            st = conn.createStatement();
            int rss = st.executeUpdate(query);
            return rss;

        } catch (Exception e) {
            System.err.println("Error Message : problem in maj() method." + e);
        }

        return 0;
    }


    public  int dmlQuery(String q) {
        try {
            connect();
            st = conn.createStatement();
            return st.executeUpdate(q, Statement.RETURN_GENERATED_KEYS);

        } catch (Exception e) {
            System.err.println("Error Message : problem in dmlQuery() method."+e);
        }

        return 0;
    }

    public  int dmlQuery2(String q) {
        try {
            connect();
            int insertedId = 0;
            st = conn.createStatement();
            int num = st.executeUpdate(q, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()){
                insertedId=rs.getInt(1);
            }
            return insertedId;

        } catch (Exception e) {
            System.err.println("Error Message : problem in dmlQuery() method." + e);
        }

        return 0;
    }

    public void disconnect() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Can't close connection" + e);
            }
        }

        conn = null;
    }


}


