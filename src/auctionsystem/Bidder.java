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
public class Bidder extends User {

    public boolean PutPriceOnItem(int ItemID, float Price) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> result = new HashMap();
        HashMap<String, String> result2 = new HashMap();
        HashMap<String, String> result3 = new HashMap();
        HashMap<String, String> result4 = new HashMap();
        HashMap<String, String> result5 = new HashMap();
        HashMap<String, String> result6 = new HashMap();
        HashMap<String, String> result7 = new HashMap();
        HashMap<String, String> result8 = new HashMap();
        HashMap<String, String> result9 = new HashMap();
        ArrayList<Float> all = new ArrayList();
        ArrayList<Integer> all2 = new ArrayList();

        result9 = DB.Select("Item_ID", "details_Winner", "User_ID = " + this.ID);
        if (result9 != null) {
            return false;
        } else {
            result = DB.Select("Minimum_Price", "item", "ID = " + ItemID);
            float minimumprice = -1;
            if (result != null) {
                minimumprice = Float.parseFloat(result.get("Minimum_Price"));
            }
            if (Price >= minimumprice) {

                result8 = DB.Select("Item_ID", "during_Auction", "User_ID = " + this.ID);
                if (result8 == null) {
                    result5.put("User_ID", "" + this.ID);
                    result5.put("Item_ID", "" + ItemID);
                    result5.put("Price", "" + Price);

                    result6.put("User_ID", "" + this.ID);
                    result6.put("Item_ID", "" + ItemID);
                    result6.put("Total_Money", "" + Price);

                    DB.Insert("during_Auction", result5);
                    DB.Insert("Number_Of_Deals", result6);
                } else {
                    int count = DB.SelectCount("Number_Of_Deals", "ID");
                    int mini = DB.SelectMinimum("Number_Of_Deals", "ID");

                    for (int i = mini; i <= count; i++) {
                        result7 = DB.Select("ID", "Number_Of_Deals", "Item_ID = " + "'" + ItemID + "'" + "and User_ID = " + "'" + this.ID + "'");
                        int id = -1;
                        if (result7 != null) {
                            id = Integer.parseInt(result7.get("ID"));
                            all2.add(id);
                            if (result7.size() < 5) {
                                float sum = 0;
                                for (int q = mini; q <= count; q++) {
                                    result2 = DB.Select("Total_Money", "Number_Of_Deals", "User_ID = " + "'" + this.ID + "'" + "and ID = " + "'" + i + "'");
                                    float total_money = -1;

                                    if (result2 != null) {
                                        total_money = Float.parseFloat(result2.get("Total_Money"));
                                        all.add(total_money);

                                    }
                                }
                                for (int j = 0; j < all.size(); j++) {
                                    sum += all.get(j);
                                }
                               
                                float putitem = sum + Price;
                                result3 = DB.Select("Balance", "user", "User_ID = " + this.ID);
                                float balance = -1;
                                if (result3 != null) {
                                    balance = Float.parseFloat(result3.get("Balance"));
                                    
                                }
                                if (putitem < balance) {
                                    DB.Update("during_Auction", "Price = " + Price, "Item_ID = " + "'" + ItemID + "'" + "and User_ID = " + "'" + this.ID + "'");

                                    result4 = DB.Select("Total_Money", "Number_Of_Deals", "Item_ID =" + ItemID);
                                    float total = -1;
                                    float sum2 = 0;
                                    float sum3 = 0;
                                    if (result4 != null) {
                                        total = Float.parseFloat(result4.get("Total_Money"));
                                        sum2 = Price - total;
                                        sum3 = sum2 + total;
                                    }

                                    DB.Update("Number_Of_Deals", "Total_Money= " + sum3, "Item_ID = " + "'" + ItemID + "'" + "and User_ID = " + "'" + this.ID + "'");

                                } else {

                                    return false;
                                }

                            } else {
                                return false;
                            }
                        }

                    }

                }
            } else {
                return false;
            }
        }
        return true;

    }



    public boolean EnterAvailableTime(int Item_id, String Date) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        if(Sys.GetSystem().compare(Date))
        {
        int DateID;
        HashMap<String, String> Result = DB.Select("Details_ID", "details_Winner", "User_ID=" + this.ID + " and Item_ID=" + Item_id);
        if (Result != null) {
            Result = DB.Select("*", "user_avilable_time", "User_ID=" + this.ID + " and Item_ID=" + Item_id);
            if (Result != null) {
                return false;
            }
            HashMap<String, String> Data = new HashMap<>();
            Data.put("User_ID", "" + this.ID);
            HashMap<String, String> R = DB.Select("ID", "date", "Date='" + Date + "'");
            if (R != null) {
                DateID = Integer.parseInt(R.get("ID"));
            } else {
                HashMap<String, String> Da = new HashMap<>();
                Da.put("Date", "" + Date);
                DateID = DB.Insert("Date", Da);
            }
            Data.put("Date_ID", "" + DateID);
            Data.put("Item_ID", "" + Item_id);
            DB.Insert("user_avilable_time", Data);
            return true;
        }
        }
        return false;
    }

    public ArrayList MyItems() {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> all_items_id = new HashMap<>();
        ArrayList<Integer> item = new ArrayList();
        try {
            int count_details_winner = DB.SelectCount("details_winner", "Details_ID");
            int mini = DB.SelectMinimum("details_winner", "Details_ID");
            int ids = -1;

            for (int i = mini; i <= count_details_winner; i++) {
                all_items_id = DB.Select("Item_ID", "details_winner", "User_ID = " + "'" + this.ID + "'" + " AND Details_ID = " + "'" + i + "'");
                if (all_items_id != null) {
                    ids = Integer.parseInt(all_items_id.get("Item_ID"));
                    item.add(ids);
                }
            }
            return item;
        } catch (Exception e) {
          
        }
        return null;
    }
}
