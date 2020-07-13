package dao.util;

import java.sql.*;

public class JDBCUtils {
    public static Connection getconnection(String url,String username,String password) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=null;
            conn= DriverManager.getConnection(url,username,password);
            return conn;
    }
    public static void closeResource(Connection conn, Statement ps){
        if(ps!=null){
            try {
                ps.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeResource(Connection conn, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeResource(Connection conn, Statement ps,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
