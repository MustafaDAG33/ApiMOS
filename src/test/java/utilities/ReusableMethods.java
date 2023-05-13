package utilities;




import java.sql.*;


public class ReusableMethods {



    public static Connection DBConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management","select_user","43w5ijfso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static Statement DBStatement(){
        Statement statement = null;
        try {
            statement = DBConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    public static ResultSet preStatement(String table,Integer id){
        ResultSet resultSet;
        try {
            PreparedStatement pst1 = DBConnection().prepareStatement("select * from "+table+" where id = ?");
            pst1.setInt(1,id);
            resultSet=pst1.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }


}
