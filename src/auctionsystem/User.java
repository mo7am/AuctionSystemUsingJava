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
public class User extends Person {

    public int NumberOfDeals;
    public ArrayList<Integer> ItemsID;
    public boolean Block;

    public HashMap SearchItem(int ItemID) {
      
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> result = new HashMap();
        HashMap<String, String> result2 = new HashMap();
        HashMap<String, String> result3 = new HashMap();
        HashMap<String, String> result4 = new HashMap();
        HashMap<String, String> item = new HashMap();
        int typeofauction = -1;
        try {
            result = DB.Select("ID", "nonreserved ", "Item_ID =" + ItemID);
            result2 = DB.Select("ID", "reserved ", "Item_ID =" + ItemID);

            if (result != null) {
                String id = result.get("ID");
                typeofauction = Integer.parseInt(id);
            } else if (result2 != null) {
                String id2 = result2.get("ID");
                typeofauction = Integer.parseInt(id2);
            }

            result3 = DB.Select("ID", "department", "Auction_ID = " + typeofauction);
            item.put("7omar", result3.get("ID"));
            result4 = DB.Select("*", "item", "ID=" + ItemID);
            item.put("Weight", result4.get("Weight"));
            item.put("Perioud_Usage", result4.get("Perioud_Usage"));
            item.put("Minimum_Price", result4.get("Minimum_Price"));
            item.put("User_ID", result4.get("User_ID"));
           
            return item;

        } catch (Exception e) {
         
        }
        return null;
    }

    public boolean BlockUser(int UserID) {
        return true;
    }

    public boolean UnBlockUser(int UserID) {
        return true;
    }

    public boolean MakeFeedback(Feedback F) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> Res = DB.Select("ID", "item", "ID=" + F.ItemID);
        if (Res != null) {
            HashMap<String, String> Values = new HashMap<>();
            Values.put("Item_ID", "" + F.ItemID);
            Values.put("Ratenum", "" + F.RateNumber);
            Values.put("SysQuality", "" + F.SystemQuality);
            DB.Insert("feedback", Values);
            return true;
        } else {
            return false;
        }
    }

    public HashMap departementInfo(int Dept_id) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> result = new HashMap();
        HashMap<String, String> result2 = new HashMap();
        HashMap<String, String> result3 = new HashMap();
        HashMap<String, String> result4 = new HashMap();

        HashMap<String, String> data = new HashMap();
        ArrayList<String> ids = new ArrayList();
        try {

            result = DB.Select("*", "department", "ID =" + Dept_id);
            int typeid = Integer.parseInt(result.get("DeptName_ID"));
            data.put("CompanyName", result.get("CompanyName"));

            result2 = DB.Select("*", "laps", "ID =" + typeid);
            result3 = DB.Select("*", "mobile", "ID =" + typeid);
            result4 = DB.Select("*", "cars", "ID =" + typeid);

            int DeptID;
            if (result2 != null) {
                DeptID = Integer.parseInt(result2.get("ID"));
                data.put("ID", result2.get("ID"));
                data.put("ScreenSize", result2.get("ScreenSize"));
                data.put("Processor", result2.get("Processor"));
                data.put("Hard", result2.get("Hard"));
                data.put("Ram", result2.get("Ram"));

            } else if (result3 != null) {
                DeptID = Integer.parseInt(result3.get("ID"));
                data.put("ID", result3.get("ID"));
                data.put("BatteryVolt", result3.get("BatteryVolt"));
                data.put("ToatlSize", result3.get("ToatlSize"));
            } else {
                DeptID = Integer.parseInt(result4.get("ID"));
                data.put("ID", result4.get("ID"));
                data.put("CarSpeed", result4.get("CarSpeed"));
                data.put("MotorPower", result4.get("MotorPower"));
                data.put("NumberOfPassengers", result4.get("NumberOfPassengers"));
            }

            return data;
        } catch (Exception e) {
           
        }

        return null;
    }

    public float Get_Max_Price(int Item_ID) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> Result = DB.Select("MAX(Price) as Price", "during_auction", "Item_ID=" + Item_ID);
        return Float.parseFloat(Result.get("Price"));

    }

    public boolean DeleteItem(int Item_id, int flage) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> result = new HashMap();
        HashMap<String, String> result2 = new HashMap();

        try {
            if (flage == 1) {

                HashMap<String, String> Result = DB.Select("Item_ID", "details_winner", "Item_ID=" + ItemsID);
                if (Result != null) {
                    return false;
                } else {
                    result2 = DB.Select("User_ID", "item", "ID =" + Item_id);
                    int user_id = -1;
                    if (result2 != null) {
                        user_id = Integer.parseInt(result2.get("User_ID"));

                    }
                    if (user_id == this.ID)
                    {
                        int AuctionID = -1;
                        DB.Delete("item", "ID = " + "'" + Item_id + "'" + "and User_ID = " + "'" + this.ID + "'");
                        HashMap<String, String> Resultt = DB.Select("ID", "nonreserved", "Item_ID=" + Item_id);
                        if (Resultt != null)
                        {
                            AuctionID = Integer.parseInt(Resultt.get("ID"));
                            DB.Delete("nonreserved","Item_ID="+Item_id);
                        } else 
                        {
                            Resultt = DB.Select("ID", "reserved", "Item_ID=" + Item_id);
                            AuctionID = Integer.parseInt(Resultt.get("ID"));
                            DB.Delete("reserved","Item_ID="+Item_id);                            
                        }
                        DB.Delete("during_Auction", "Item_ID =" + Item_id);
                        DB.Delete("department", "Auction_ID="+AuctionID);
                    } 
                    else 
                    {
                        return false;
                    }
                }
            } else {
                DB.Delete("during_Auction", "Item_ID = " + "'" + Item_id + "'" + "and User_ID = " + "'" + this.ID + "'");
                DB.Delete("Number_Of_Deals", "Item_ID = " + "'" + Item_id + "'" + "and User_ID = " + "'" + this.ID + "'");

            }
            return true;
        } catch (Exception e) {
           
        }

        return false;
    }

    public ArrayList<Integer> MyItems() {
        return null;
    }
}
