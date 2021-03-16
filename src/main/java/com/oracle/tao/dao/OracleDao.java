package com.oracle.tao.dao;


import org.springframework.stereotype.Component;

import java.sql.*;
@Component
public class OracleDao {
   // static String URL="jdbc:oracle:thin:@toyota_low?TNS_ADMIN=C:/test/Wallet_toyota2";
    static String URL="jdbc:oracle:thin:@db202103151034_low?TNS_ADMIN=C:/test/Wallet_toyota2";
    static String URL2="jdbc:oracle:thin:@db202103151034_low?TNS_ADMIN=./Wallet_toyota2";
    static String USER="toyota";
    static String PASSWORD="WElcome##123";
    static String driver = "oracle.jdbc.driver.OracleDriver";



    // public static Connection conn;

    // 定义一个用于放置数据库连接的局部线程变量（使每个线程都拥有自己的连接）
    private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();



    // 获取连接
    public static Connection getConnection() {


        Connection conn = connContainer.get();
        try {
            if (conn == null || conn.isClosed()) {

                if(System.getProperty("os.name").toLowerCase().contains("linux")){
                    //URL="jdbc:oracle:thin:@toyota_low?TNS_ADMIN=./Wallet_toyota2";
                    URL=URL2;

                }

                Class.forName(driver);
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connContainer.set(conn);
        }
        return conn;
    }

    // 关闭连接
    public static void closeConnection() {
        Connection conn = connContainer.get();
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connContainer.remove();
        }
    }


    public void insertJSON(Connection conn,String jsonData) throws SQLException {

        //HEAT01,230.123,1613697334
        String sql="INSERT INTO VIDEO_JSON(FRAME)VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1,jsonData);
        ps.execute();

    }







}

