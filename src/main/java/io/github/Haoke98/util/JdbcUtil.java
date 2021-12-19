package io.github.Haoke98.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 存储数据库
 */
public class JdbcUtil {

    /**
     * 批量执行插入、更新语句
     *
     * @param driver
     * @param url
     * @param username
     * @param password
     * @param sql
     * @return
     */
    public static List<Map<String, Object>> batchInsert(String driver, String url, String username
            , String password, String sql) {
        List<Map<String, Object>> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            // 初始化对象
            // 1.加载驱动
            Class.forName(driver);
            // 2.得到连接
            System.out.println("开始连接conn");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("连接conn成功");
            // 3.创建statement,创建数据
            long start = System.currentTimeMillis();
            preparedStatement = connection.prepareStatement(sql);
            int commitSize = 1000;
            for (int i = 100001; i < 1000000; i++) {
                preparedStatement.setLong(1, i);
                preparedStatement.setString(2, "zhangsan" + i);
                preparedStatement.setInt(3, 22);
                preparedStatement.addBatch();
                //每1000次提交一次
                if (i != 0 && i % commitSize == 0) {
                    preparedStatement.executeBatch();
                    connection.commit();
                    preparedStatement.clearBatch();
                    System.out.println(commitSize + "条已提交");
                }
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (rs != null) rs.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return list;
    }

    /**
     * 执行sql语句，insert、update、delete
     *
     * @return
     */
    public static int executeUpdate(String driver, String url, String username, String password, String sql, Object... params) {
        int res = 0;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            // 初始化对象
            // 1.加载驱动
            Class.forName(driver);
            // 2.得到连接
            System.out.println("开始连接conn");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("连接conn成功");
            // 3.创建statement,创建数据
            long start = System.currentTimeMillis();
            preparedStatement = connection.prepareStatement(sql);
            int i = 1;
            for (Object obj : params) {
                preparedStatement.setObject(i, obj);
                i++;
            }
            res = preparedStatement.executeUpdate();
            // connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return res;
    }

}
