package DAO;

import java.sql.*;

import Model.Account;
import Util.ConnectionUtil;

public class AccountDAO {

    public Account postNewUserRegistration(Account account) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            String sql = "INSERT INTO account(username,password) VALUES(?,?)" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());

            preparedStatement.executeUpdate();
            ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if(pkeyResultSet.next()){
                int generated_author_id = (int) pkeyResultSet.getLong(1);
                return new Account(generated_author_id, account.getUsername(),account.getPassword());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String getUserNameString(Account account) {
        Connection connection = ConnectionUtil.getConnection();
        String string = ""; 
        try {
            String sql = "SELECT username FROM account WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, account.getUsername());

            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            string =rs.getString(1);    
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return string;
    }


    public String getPasswordString(Account account) {
        Connection connection = ConnectionUtil.getConnection();
        String string = ""; 
        try {
            String sql = "SELECT password FROM account WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, account.getUsername());

            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            string =rs.getString(1);    
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return string;
    }

    public Account postUserLogin(Account account) {
        Connection connection = ConnectionUtil.getConnection();
        try {

            String sql = "SELECT * FROM account where username=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Account userAccount = new Account(rs.getInt(1),rs.getString(2),rs.getString(3));
                return userAccount;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    
    
}



    

