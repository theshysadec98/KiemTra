package DAO;

import DAO.ConnectSQL;
import Models.SanPham;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerSanPham {
    static Connection connection;
    static ArrayList<SanPham> list = new ArrayList<>();

    static {
            connection = ConnectSQL.getConnection();
    }


    public static List<SanPham> seclect() throws SQLException, ClassNotFoundException {
        String select = "select * from sanpham";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            double price = Double.parseDouble(resultSet.getString("price"));
            int quatity = Integer.parseInt(resultSet.getString("quatity"));
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            String directory = resultSet.getString("directory");
            list.add(new SanPham(id, name, price, quatity, color, description, directory));
        }
        return list;
    }

    public static void create(SanPham sanPham) throws SQLException {
        String CREATE = "insert into sanpham value(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
        preparedStatement.setInt(1, sanPham.getId());
        preparedStatement.setString(2, sanPham.getName());
        preparedStatement.setDouble(3, sanPham.getPrice());
        preparedStatement.setInt(4, sanPham.getQuantity());
        preparedStatement.setString(5, sanPham.getColor());
        preparedStatement.setString(6, sanPham.getDescription());
        preparedStatement.setString(7, sanPham.getDirectory());
        preparedStatement.execute();
    }

    public static void edit(SanPham sanPham) throws SQLException {
        String EDIT = "update sanpham set name=?,price=?,quatity=?, color=?, description=?, directory=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(EDIT);
        preparedStatement.setInt(7, sanPham.getId());
        preparedStatement.setString(1, sanPham.getName());
        preparedStatement.setDouble(2, sanPham.getPrice());
        preparedStatement.setInt(3, sanPham.getQuantity());
        preparedStatement.setString(4, sanPham.getColor());
        preparedStatement.setString(5, sanPham.getDescription());
        preparedStatement.setString(6, sanPham.getDirectory());
        preparedStatement.execute();
    }

    public static void delete(int id) throws SQLException {
        String DELETE = "delete from sanpham where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public static ArrayList<SanPham> findByName(String findName) throws SQLException {
        ArrayList<SanPham> findList = new ArrayList<>();
        String SEARCH = "select * from sanpham where name like '%" + findName +"%'";
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            double price = Double.parseDouble(resultSet.getString("price"));
            int quatity = Integer.parseInt(resultSet.getString("quatity"));
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            String directory = resultSet.getString("directory");
            findList.add(new SanPham(id, name, price, quatity, color, description, directory));
        }
        return findList;

    }

}
