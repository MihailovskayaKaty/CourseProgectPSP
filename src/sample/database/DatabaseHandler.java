package sample.database;

import org.omg.PortableInterceptor.ServerRequestInfo;
import sun.dc.pr.PRError;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs{

    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString = "jdbs:mysql://" + dbHost
                + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbs.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(String login, String password) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO" + Const_db.USER_TABLE + "(" +
                Const_db.USER_LOGIN + "," + Const_db.USER_PASSWORD +")" +
                "VALUES(?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,login);
            prSt.setString(1,password);
            prSt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void signUpStudent (String surname, String name, String patronymic, String faculty_name,
                           String form_of_study, String avarage_mark)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO" + Const_db.STUDENT_TABLE + "(" +
                Const_db.STUDENT_SURNAME + "," + Const_db.STUDENT_NAME +
                Const_db.STUDENT_PATRONYMIC + "," + Const_db.FORM_OF_STUDY+
                Const_db.AVERAGE_MARK + ")" +
                "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt1 = getDbConnection().prepareStatement(insert);
            prSt1.setString(1,surname);
            prSt1.setString(1,name);
            prSt1.setString(1,patronymic);
            prSt1.setString(1,form_of_study);
            prSt1.setString(1,avarage_mark);
            prSt1.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }


}
