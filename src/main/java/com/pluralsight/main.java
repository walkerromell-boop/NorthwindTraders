package com.pluralsight;

import java.sql.*;

public class main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = args[0];
        String password = args[1];

//        displayAllProducts(url, username, password);
//        displayAllCustomers(url, username, password);
        displayCustomers(url, username, password);
    }

    private static void displayAllProducts(String url, String username, String password) {

        //define your query
        String query = """
                SELECT productid, productname, supplierid, unitprice,
                unitsinstock
                FROM Products;
                """;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             // create statement
             // the statement is tied to the open connection
             PreparedStatement statement = connection.prepareStatement(query)) {

//        String searchTerm = "%crab%";
//        String searchTerm2 = "%25%";
//
//        statement.setString(1, searchTerm);
//        statement.setString(2, searchTerm2);

            // 2. Execute your query
            try (ResultSet results = statement.executeQuery()) {
                // process the results
                while (results.next()) {
                    int productId = results.getInt(1);
                    String products = results.getString("productName");
                    int supplierId = results.getInt(3);
                    double unitPrice = results.getInt(4);
                    int unitsInStock = results.getInt(5);

                    System.out.println("productId: " + productId);
                    System.out.println("products: " + products);
                    System.out.println("supplierId: " + supplierId);
                    System.out.println("unitPrice: $" + unitPrice);
                    System.out.println("unitsInStock: " + unitsInStock);
                    System.out.println("-----------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        // 3. Close the connection
//        connection.close();
//        statement.close();
//        connection.close();
    }

    private static void displayAllCustomers(String url, String username, String password) {

        String query = """
                SELECT * FROM northwind.Customers;
                """;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             // create statement
             // the statement is tied to the open connection
             PreparedStatement statement = connection.prepareStatement(query)) {

//        String searchTerm = "%crab%";
//        String searchTerm2 = "%25%";
//
//        statement.setString(1, searchTerm);
//        statement.setString(2, searchTerm2);

            // 2. Execute your query
            try (ResultSet results = statement.executeQuery()) {
                // process the results
                while (results.next()) {
                    String customerId = results.getString(1);
                    String companyName = results.getString(2);
                    String contactName = results.getString(3);
                    String contactTitle = results.getString(4);
                    String address = results.getString(5);
                    String city = results.getString(6);


                    System.out.println("CustomerId: " + customerId);
                    System.out.println("Company Name: " + companyName);
                    System.out.println("Contact Name: " + contactName);
                    System.out.println("Contact Title: " + contactTitle);
                    System.out.println("Address: " + address);
                    System.out.println("City: " + city);
                    System.out.println("-----------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        // 3. Close the connection
//        connection.close();
//        statement.close();
//        connection.close();
    }

    private static void displayCustomers(String url, String username, String password) {

        String query = """
                    SELECT CompanyName,ContactName,City,Country,Phone
                    FROM northwind.Customers
                    order by country;
                """;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             // create statement
             // the statement is tied to the open connection
             PreparedStatement statement = connection.prepareStatement(query)) {

//        String searchTerm = "%crab%";
//        String searchTerm2 = "%25%";
//
//        statement.setString(1, searchTerm);
//        statement.setString(2, searchTerm2);

            // 2. Execute your query
            try (ResultSet results = statement.executeQuery()) {
                // process the results
                while (results.next()) {
                    String companyName = results.getString(1);
                    String contactName = results.getString(2);
                    String city = results.getString(3);
                    String country = results.getString(4);
                    String phone = results.getString(5);


                    System.out.println("Company Name: " + companyName);
                    System.out.println("Contact Name: " + contactName);
                    System.out.println("City: " + city);
                    System.out.println("country: " + country);
                    System.out.println("phone: " + phone);
                    System.out.println("-----------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        // 3. Close the connection
//        connection.close();
//        statement.close();
//        connection.close();
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
/// / 2. Execute your query
//ResultSet results = statement.executeQuery();
//
/// / process the results
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