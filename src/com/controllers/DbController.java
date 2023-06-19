package com.controllers;

import com.models.Produk;
import com.config.DbConnect;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DbController extends DbConnect {

    public static ArrayList<Produk> getDatabase() {
        connection();

        ArrayList<Produk> list_prod = new ArrayList<>();

        try {
            query = "SELECT name, price, stock FROM tb_products";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                list_prod.add(new Produk(resultSet.getString("name"), resultSet.getInt("price"), resultSet.getInt("stock")));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_prod;
    }

    public static void insertData(String nama, long harga, int stok) {
        connection();
        query = "INSERT INTO tb_products (name, price, stock) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setLong(2, harga);
            preparedStatement.setInt(3, stok);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void insertHistory(String nama, String Kembali) {
        connection();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        query = "INSERT INTO tb_history (time, name, change_) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dtf.format(now));
            preparedStatement.setString(2, nama);
            preparedStatement.setInt(3, Integer.parseInt(Kembali));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateProduct(String nama, int harga, int jumlah) {
        connection();
        query = "UPDATE tb_products SET price=?, stock=? WHERE name=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(3, nama);
            preparedStatement.setInt(1, harga);
            preparedStatement.setInt(2, jumlah);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStock(String nama) {
        connection();
        query = "UPDATE tb_products SET stock=stock - 1 WHERE name=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteData(String nama) {
        connection();
        query = "DELETE FROM tb_products WHERE name=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
