package dao.util;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.*;

public class JDBCUtils {
    public static Connection getconnection(String url,String username,String password) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
        DruidDataSource datasource = new DruidDataSource();
//        jdbc.testConnectionOnCheckout=false
//        jdbc.testConnectionOnCheckin = true
//        jdbc.automaticTestTable = c3p0TestTable;
//        jdbc.idleConnectionTestPeriod = 90
//        jdbc.checkoutTimeout=3000
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
