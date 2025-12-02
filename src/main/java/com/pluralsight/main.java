package com.pluralsight;

import java.sql.*;

public class main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = args[0];
        String password = args[1];

        Connection connection = DriverManager.getConnection(url, username, password);
        // create statement

        //define your query
        String query = """
                SELECT productid, productname, supplierid, unitprice,
                unitsinstock
                FROM Products
                where productname LIKE ? or supplierID LIKE ?;
                """;

        // the statement is tied to the open connection
        PreparedStatement statement = connection.prepareStatement(query);

        String searchTerm = "%crab%";
        String searchTerm2 = "%25%";

        statement.setString(1, searchTerm);
        statement.setString(2, searchTerm2);


        // 2. Execute your query
        ResultSet results = statement.executeQuery();
        // process the results
        while (results.next()) {
            int productId = results.getInt(1);
            String products = results.getString("productName");
            int supplierId = results.getInt(3);
            int unitPrice = results.getInt(4);
            int unitsInStock = results.getInt(5);

            System.out.println("productId:" + productId);
            System.out.println("products:" + products);
            System.out.println("supplierId:" + supplierId);
            System.out.println("unitPrice:" + unitPrice);
            System.out.println("unitsInStock:" + unitsInStock);
            System.out.println("-----------------------");
        }
        // 3. Close the connection
        connection.close();
        statement.close();
        connection.close();


    }
}

/// / define your query
//String query = """
//                        SELECT title, description, release_year, length
//                        FROM film;
//                        """;
//
/// / create statement
/// / the statement is tied to the open connection
//PreparedStatement statement = connection.prepareStatement(query);
//
//// 2. Execute your query
//ResultSet results = statement.executeQuery();
//
//// process the results
//        while (results.next()) {
//String title = results.getString("title");
//String description = results.getString("description");
//int releaseYear = results.getInt("release_year");
//int length = results.getInt("length");
//
//            System.out.println(title);
//            System.out.println(description);
//            System.out.println(releaseYear);
//            System.out.println(length);
//            System.out.println("-----------------------");
//        }
//
//                results.close();
//        statement.close();
//        connection.close();