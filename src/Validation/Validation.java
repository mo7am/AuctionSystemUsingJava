/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author emad
 */
public class Validation {
    private static Validation Val=null;
    private Pattern R=null;
    private Matcher M=null;
    private Validation ()
    {
        
    }
    public static Validation Get_Validation_Instance()
    {
        if(Val==null)
        {
            Val=new Validation();
        }
      return Val;        
    }
    public boolean Is_Name(String S)
    {      
        this.R=Pattern.compile("([a-z]|[A-Z])[a-z]*");
        this.M=R.matcher(S);
        if(M.find())
        {
            return true;
        }
            return false;        
    }
    public boolean Is_Emil(String S)
    {
        this.R=Pattern.compile("([1-9]|[a-z]|[A-Z])([1-9]|[a-z]|[A-Z])*@[a-z]*\\.com");
        this.M=R.matcher(S);
        if(M.find())
        {
            return true;
        }
            return false;
    }
    public boolean Is_Password(String S)
    {                    //12453aa1a 
        if(S.length()<8)
            return false;
        this.R=Pattern.compile("([a-z]|[A-Z]|[0-9])*([a-z]|[A-Z])([a-z]|[A-Z])([a-z]|[A-Z]|[0-9])*");
        this.M=R.matcher(S);
        if(M.find())
        {
            return true;
        }
            return false;
    }
    public boolean Is_Date(String S)
    {
        this.R=Pattern.compile("[1-9][0-9][0-9][0-9]-([0][1-9]|[1][0-2])-([0][1-9]|[1-2][1-9])");
        this.M=R.matcher(S);
        if(M.find())
        {
            return true;
        }
            return false;
    }
    public boolean Is_Age(int S)
    {
        if(S>18&&S<110)
        {
            return true;
        }
        else
            return false;
    }
    public boolean Is_Perstage(double num)
    {
        if(num>=0&&num<=100)
            return true;
                    else
            return false;
    }
}
