/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem;

import DB.DB_;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author emad
 */
public class Person {

    public int ID;
    public int Type;
    public String FNAME;
    public String LNAME;
    public double Balance;
    public Login login;
    public String Country;

    public Person() {
        login = new Login();
    }

    public boolean UpdateProfile(HashMap<String, String> info) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        try {
            int type = Integer.parseInt(info.get("Type_User_id"));
            int user = Integer.parseInt(info.get("User_ID"));
            if (type == 1 | type == 2 | type == 3) {

                DB.Update("user", "F_NAME =" + "'" + info.get("F_NAME") + "',L_NAME = " + "'" + info.get("L_NAME") + "'," + "Email = " + "'" + info.get("Email") + "'", "User_ID =" + user);
                DB.Update("staff", "Birth_Date = " + "'" + info.get("Birth_Date") + "'," + "Age = " + "'" + info.get("Age") + "'", "User_ID = " + user);

            } else if (type == 4 | type == 5) {

                DB.Update("user", "F_NAME =" + "'" + info.get("F_NAME") + "',L_NAME = " + "'" + info.get("L_NAME") + "'," + "Email = " + "'" + info.get("Email"), "User_ID =" + user);
            } else {
            }

            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean ChangePassword(String OldPassword, String newPassword, String ConfirmPassword) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();

        try {
            HashMap<String, String> result = new HashMap();
            HashMap<String, String> result2 = new HashMap();
            result = DB.Select("Password", "user", "User_ID =" + this.ID);
            String pass = result.get("Password");
            if (OldPassword.equals(pass) && ConfirmPassword.equals(newPassword)) {
                return DB.Update("user", "Password = '" + newPassword+"'", "User_ID =" + this.ID);

            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean SendMessage(Message message) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        try {
            HashMap<String, String> messag = new HashMap();
            ArrayList<String> all = new ArrayList();
            messag.put("Sender_ID", "" + message.SenderID);
            messag.put("Reciever_ID", "" + message.ReciverID);
            messag.put("Content", message.Content);
            messag.put("State_id", "2");
            int flag = Sys.GetSystem().Get_Date_ID(message.Date);
            if (flag != -1) {
                messag.put("Date_ID", "" + flag);
            } else {
                HashMap<String, String> Date = new HashMap<>();
                Date.put("Date", "" + message.Date);
                int Date_ID = DB.Insert("date", Date);
                messag.put("Date_ID", "" + Date_ID);
            }

            DB.Insert("message", messag);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public ArrayList<Message> RecieveMessages() {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        try {
            HashMap<String, String> messag = new HashMap();
            HashMap<String, String> State = new HashMap();
            HashMap<String, String> State2 = new HashMap();
            HashMap<String, String> date1 = new HashMap();
            HashMap<String, String> result;
            ArrayList<Message> message = new ArrayList();
            ArrayList<Message> x = new ArrayList();;
            ArrayList<Integer> allid = new ArrayList();
            State = DB.Select("State_id", "state", "State = 'Not Seen'");
            int id = Integer.parseInt(State.get("State_id"));
            State2 = DB.Select("State_id", "state", "State = 'Seen'");
            int id2 = Integer.parseInt(State.get("State_id"));

            int number = DB.SelectCount("message", "ID");
            int mini = DB.SelectMinimum("message", "ID");
            for (int q = 1; q <= number; q++) {
                result = DB.Select("*", "message", "ID =" + "'" + q + "'" + "and Reciever_ID =" + "'" + this.ID + "'" + "and State_id =" + "'" + id + "'");

                if (result != null) {
                    Message m = new Message();
                    m.ID = Integer.parseInt(result.get("ID"));
                    m.SenderID = Integer.parseInt(result.get("Sender_ID"));
                    m.Content = result.get("Content");
                    int date = Integer.parseInt(result.get("Date_ID"));
                    date1 = DB.Select("Date", "date", "ID =" + "'" + date + "'");
                    m.Date = date1.get("Date");
                    message.add(m);
                }

            }
            ArrayList<Message> Mes = new ArrayList<Message>();
            try {
                for (int i = 0; i < 5; i++) {
                    Mes.add(message.get(i));
                    updateState(message.get(i).ID);
                }
                return Mes;
            } catch (Exception E) {
                return Mes;
            }

        } catch (Exception e) {
        }
        return null;
    }

    public boolean updateState(int MID) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> result = DB.Select("State_id", "state", "State='Seen'");

        try {
            DB.Update("message", "State_id =" + Integer.parseInt(result.get("State_id")), "ID=" + MID);

            return true;
        } catch (Exception e) {
        }

        return false;
    }

    public boolean TransferBalance(String Email, double Mount, String Password) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> result = new HashMap();
        HashMap<String, String> result2 = new HashMap();
        HashMap<String, String> result3 = new HashMap();
        HashMap<String, String> result4 = new HashMap();
        try {

            result4 = DB.Select("User_ID", "user", "Email =" + "'" + Email + "'");
            int PersonID = Integer.parseInt(result4.get("User_ID"));
            result = DB.Select("Balance", "user", "User_ID = " + this.ID);
            double balance = Double.parseDouble(result.get("Balance"));
            result2 = DB.Select("Password", "user", "User_ID = " + this.ID);
            String ownerPass = result2.get("Password");

            if (Password.equals(ownerPass) && Mount <= balance) {

                double operation = balance - Mount;
                DB.Update("user", "Balance =" + operation, "User_ID = " + this.ID);

                result3 = DB.Select("Balance", "user", "User_ID = " + PersonID);
                double balanceperson = Double.parseDouble(result3.get("Balance"));

                double endoperation = balanceperson + Mount;
                DB.Update("user", "Balance =" + endoperation, "User_ID = " + PersonID);
            } else {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Charge(I_PaymentMethod paymentmethod, double mount) {

        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        try {
            HashMap<String, String> result = new HashMap();
            result = DB.Select("Balance", "user", "User_ID = " + this.ID);
            if (result != null) {
                double balance = Double.parseDouble(result.get("Balance"));
                double money = paymentmethod.Charge(mount);
                double newbalance = balance + money;
                DB.Update("user", "Balance = " + newbalance, "User_ID = " + this.ID);
            }
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean Clear_Balance(double Value) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> R = DB.Select("Balance", "user", "User_ID=" + this.ID);
        double balance = Double.parseDouble(R.get("Balance"));
        balance = balance - Value;
        DB.Update("user", "Balance = " + balance, "User_ID = " + this.ID);
        DB.Close();
        return true;
    }
public boolean ChangeForgetInfo(String password , String Answer)
    {
        DB_ DB = DB_.Get_DB_controller() ;
        DB.Connect();
        
        if(this.login.Password.equals(password)){
               boolean check = DB.Update("sequrityq_user", "Answer_Question = " + "'" + Answer + "'", "User_ID = " + this.ID);
               if(check == true){
                   return true;
               }
        }else{
           
        }
        
        DB.Close();
        return false;
    }

}
