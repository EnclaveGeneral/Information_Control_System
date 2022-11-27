/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pages;

/**
 *
 * @author godpo
 */
public class CurrentUser {
    
    //Necessary fields
    private static String FirstName;
    private static String LastName;
    private static String UserName;
    private static String BirthDay;
    private static String EnclaveRank;
    
    //Universal Constructor
    public CurrentUser(String firstname, String lastname, String username, String birthday, String rank){
        CurrentUser.FirstName = firstname;
        CurrentUser.LastName = lastname;
        CurrentUser.UserName = username;
        CurrentUser.BirthDay = birthday;
        CurrentUser.EnclaveRank = rank;
    }
    
    public CurrentUser(){
        
    }
    
    public static String getFirstName(){
        return FirstName;
    }
    
    public static String getLastName(){
        return LastName;
    }
    
    public static String getUserName(){
        return UserName;
    }
    
    public static String getBirthDay(){
        return BirthDay;
    }
    
    public static String getEnclaveRank(){
        return EnclaveRank;
    }
}
