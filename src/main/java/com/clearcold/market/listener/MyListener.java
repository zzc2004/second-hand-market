package com.clearcold.market.listener;

import com.clearcold.market.bean.Product;
import com.clearcold.market.util.JDBCUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebListener
public class MyListener implements ServletContextListener, ServletRequestListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ArrayList<Product> products = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from products where status = '正常'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt("pid"), resultSet.getString("pname"),
                        resultSet.getDouble("oriPrice"), resultSet.getDouble("pprice"),
                        resultSet.getInt("pquantity"), resultSet.getString("publisher"),
                        resultSet.getString("publish_time"),
                        resultSet.getString("location"), resultSet.getString("path"),
                        resultSet.getString("status"), resultSet.getString("description"),resultSet.getString("type")));
            }
            ServletContext servletContext = sce.getServletContext();
            servletContext.setAttribute("products", products);
            int pageSize = 4;
            int pageNumber = 1;
            int totalPages = (int) Math.ceil((double) products.size() / pageSize);
            servletContext.setAttribute("pageSize", pageSize);
            servletContext.setAttribute("pageNumber", pageNumber);
            servletContext.setAttribute("totalPages", totalPages);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ArrayList<Product> products = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from products where status = '正常'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt("pid"), resultSet.getString("pname"),
                        resultSet.getDouble("oriPrice"), resultSet.getDouble("pprice"),
                        resultSet.getInt("pquantity"), resultSet.getString("publisher"),
                        resultSet.getString("publish_time"),
                        resultSet.getString("location"), resultSet.getString("path"),
                        resultSet.getString("status"), resultSet.getString("description"),resultSet.getString("type")));
            }
            ServletContext servletContext = sre.getServletContext();
            servletContext.setAttribute("products", products);
            int pageSize = 4;
            int pageNumber = 1;
            int totalPages = (int) Math.ceil((double) products.size() / pageSize);
            servletContext.setAttribute("pageSize", pageSize);
            servletContext.setAttribute("pageNumber", pageNumber);
            servletContext.setAttribute("totalPages", totalPages);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
    }
}

