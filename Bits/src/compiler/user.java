/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.*;






/**
 *
 * @author vAibHav
 */
public class user {
    String name;
    String email;
    String contact;
    String teamname;
    String college;
    session S1;
    
    user(String Teamname,String Name,String Email,String Contact,String College){
        name = Name;
        email = Email;
        contact = Contact;
        teamname = Teamname;
        college = College;
        double pass = Math.random();
        String password = Double.toString(pass);
        S1 = new session(teamname,password);
    }
    
    public void makeConnection(){
        Connection con = S1.makeConnection();
    }
        
    public boolean checkTeamname(){
        try{
            if(S1.getConnection()==null){
                return false;
            }
            
        
            String checkStatement = "SELECT * FROM Bits_team";
        
            PreparedStatement stmt1 = S1.getConnection().prepareStatement(checkStatement);
            
            ResultSet res = stmt1.executeQuery();
            while(res.next()){
                System.out.println(res.getString("teamname"));
                if(teamname.equals(res.getString("teamname"))){
                    return false;
                }
            }
        }catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
        
    }
    
    // false = connection not found
    public boolean addUser(){
        try{
            if(S1.getConnection()==null){
                return false;
            }
            //creating query
            String addUser = "INSERT INTO system.Bits_user(name, email, contact, teamname, college) VALUES (?,?,?,?,?)";
            PreparedStatement stmt1 = S1.getConnection().prepareStatement(addUser);
            
            //adding into statement
            stmt1.setString(1, name);
            stmt1.setString(2, email);
            stmt1.setString(3, contact);
            stmt1.setString(4, teamname);
            stmt1.setString(5, college);
            
            //executing the statement
            stmt1.executeQuery();

            //closing the statement
            stmt1.close();
        }catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }
    public boolean addTeam(){
        try{
            if(S1.con==null){
                return false;
            }
            //creating query
            String addUser = "INSERT INTO system.Bits_team(teamname, password, score, starttime) VALUES (?,?,?,?)";
            PreparedStatement stmt1 = S1.getConnection().prepareStatement(addUser);
            
            //adding into statement
            stmt1.setString(1, teamname);
            stmt1.setString(2, S1.getPassword());
            stmt1.setString(3, "0");
            stmt1.setString(4, "0");
            
            
            //executing the statement
            stmt1.executeQuery();

            //closing the statement
            stmt1.close();
        }catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }
    public void deleteUserAndTeam(){//not used anywhere till now
        try{
            
            //creating query
            String del = "DELETE system.Bits_team Where teamname=?";
            PreparedStatement stmt1 = S1.getConnection().prepareStatement(del);
            
            //adding into statement
            stmt1.setString(1, teamname);
            
            //executing the statement
            stmt1.executeQuery();

            //closing the statement
            stmt1.close();
            
            String del1 = "DELETE system.Bits_user Where teamname=?";
            PreparedStatement stmt2 = S1.getConnection().prepareStatement(del1);
            
            //adding into statement
            stmt2.setString(1, teamname);
            
            //executing the statement
            stmt2.executeQuery();

            //closing the statement
            stmt2.close();
        }catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
