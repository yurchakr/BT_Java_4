package by.bsuir.autobase.dao;

import by.bsuir.autobase.entity.User;

import java.sql.*;

public class UserDB {

    private static String url = "jdbc:mysql://localhost:3306/autobase?serverTimezone=Europe/Minsk&useSSL=false";
    private static String username = "root";
    private static String password = "root";

    public static User selectOne(String _name, String _password) {

        User user = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM users WHERE name=? AND password=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, _name);
                    preparedStatement.setString(1, _password);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        user = new User(_name, _password);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return user;
    }

    public static int insert(User user) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO users (name, password) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, user.getName());
                    preparedStatement.setString(2, user.getPassword());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }


}
