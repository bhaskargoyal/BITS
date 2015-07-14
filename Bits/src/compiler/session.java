/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author vAibHav
 */
public class session {
    String Username;
    String Password;
    Connection con;
    String startTime;
    
    session(String user, String pass)
    {
        
        Username = user;
        Password = pass;
        con = null;
        startTime = null;
        System.out.println("\nIn Session Class:");
    }

//Function for making new JDBC connection
    public Connection makeConnection()
    {
        System.out.println("Making connection...");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String driver = "oracle.jdbc.OracleDriver";
        
        String user;
        String pass;
        
        user = "SYSTEM";
        pass = "admin";         /////    change this password 
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            if (con == null) 
            {
                System.out.println("Connection cannot be established!");
            }
            else 
            {
                System.out.println("Connection established!" + con);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
    
    // 0 = No connection, 1 = Success ,-1 = wrong password, -2 = username doesn't exists
     public int startSession()
    {
        System.out.println("Starting Session...");
        System.out.println(Username);
        System.out.println(Password);
        boolean valid;
        
        try {
            //creating connection
            con = makeConnection();
            if(con == null)
                return 0;
        
            /*Selecting employee ID of the current user.*/
            String str="SELECT * FROM SYSTEM.BITS_TEAM WHERE teamname=?";

            //preparing statement
            PreparedStatement stmt1 = con.prepareStatement(str);
            stmt1.setString(1, Username);
            
            //executing the statement
            ResultSet res = stmt1.executeQuery();
            res.next();
            String DbPass = res.getString("PASSWORD");
            
            System.out.println(DbPass);
            //closing the statement
            stmt1.close();
            
            //checking the password
            valid = checkPassword(Password,DbPass);
            if(!valid){
                return -1;
            }
            else
                return 1;
            
            } catch (SQLException ex) {
            System.out.print(ex);
            return -2;
        }
        
    }
    
     private boolean checkPassword(String password,String Dbpassword){
         if(Dbpassword.equals(Password)){
         return true;
         }
         else
             return false;
     }
     
     public Connection getConnection(){
        return con;
    }
    
    public String getUsername(){
        return Username;
    }
     
    public String getPassword(){
        return Password;
    }
    
    public static void main(String[] Args)
    {
       session snew = new session("xyz","xyz");
       snew.makeConnection();
    }
    
    public boolean destroySession()
    {
        System.out.println("Destroying Session...");
        
        //creating connection
        //con = makeConnection(0);
        
        try {
            //closing connection
            con.close();
            
        } catch (SQLException ex) {
            System.out.print(ex);
            return false;
        }
        
        return true;
    }
    
    public String getProblem(int x){      /// for the BtsInterface Class
        
            String str="SELECT * FROM SYSTEM.BITS_PROBLEMS WHERE SERIAL=?";
            String dataCompare = (String) Integer.toString(x);
            //preparing statement
            try{
                PreparedStatement stmt1 = con.prepareStatement(str);
                stmt1.setString(1, dataCompare);     //compare with Serial 

                //executing the statement
                ResultSet res = stmt1.executeQuery();
                res.next();
                String result = res.getString("Problem");

                System.out.println(result);
                //closing the statement
                stmt1.close();

                return result;
            }
            catch(Exception e){
                System.out.println(e);
                return null;
            }
            
    }
    
    
    
    
    
    
    
    
/*    public void updateCon(session ssn){
        con = ssn.getConnection();
        Username = ssn.getUsername();
        Password = ssn.getPassword();
        System.out.println("Con");
    }*/
}
    