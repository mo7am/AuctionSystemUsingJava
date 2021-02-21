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
public class Seller extends User{
 
   public boolean AddItem(Auction Auc,Departement Dept)
   {
       DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        
       
        HashMap<String , String> itemdata = new HashMap<>();
        HashMap<String , String> reserved = new HashMap<>();
        HashMap<String , String> result = new HashMap<>();
        HashMap<String , String> check_Start_Date = new HashMap<>();
            HashMap<String , String> Start_Date = new HashMap<>();
            HashMap<String , String> check_End_Date = new HashMap<>();
            HashMap<String , String> End_Date = new HashMap<>();
            HashMap<String , String> nonreserved = new HashMap<>();
            HashMap<String , String> car_data = new HashMap<>();
        HashMap<String , String> lap_data = new HashMap<>();
        HashMap<String , String> mobile_data = new HashMap<>();
        HashMap<String , String> Department_data = new HashMap<>();
        
        try{
             int count = DB.SelectCount("item", "ID");
             int mini=DB.SelectMinimum("item","ID");
              int C=0;
           
             for(int i=mini ; i<=count ; i++){ 
              result = DB.Select("ID", "item", "ID = " + "'"+i+"'" + "and User_ID = " + "'"+this.ID+"'");
              if(result!=null)
              {
                  C++;
              }
             }
             
             if(C > 5){
                 return false;
             }else{
                  itemdata.put("Weight", Float.toString(Auc.item.getWieght()));        
                  itemdata.put("Minimum_Price", Double.toString(Auc.item.getMinimumPrice()));
                  itemdata.put("Perioud_Usage", ""+Auc.item.getDateOfUsage());
                  itemdata.put("User_ID", Integer.toString(this.ID));
                  
                  int item_ID = DB.Insert("item", itemdata);
                  int Auction_id = -1;
                if(Auc instanceof Reserved)    
                 {
                     Reserved res = (Reserved) Auc;
                     int startdate_id =-1;
                     int enddate_id=-1;
           
                     reserved.put("Item_ID", Integer.toString(item_ID));
                     
                     check_Start_Date = DB.Select("ID", "date", "Date = " + "'" + res.StartDate + "'");
                     if(check_Start_Date != null){
                         startdate_id = Integer.parseInt(check_Start_Date.get("ID"));
                         reserved.put("Start_Date_ID", ""+startdate_id);
                        }else
                     {
                           Start_Date.put("Date", res.StartDate);
                           int id_Start_Date = DB.Insert("date", Start_Date);
                           reserved.put("Start_Date_ID",String.valueOf(id_Start_Date));
                     }
                     
                      check_End_Date = DB.Select("ID", "date", "Date = " + "'" + res.EndDate + "'");
                      if(check_End_Date != null){
                          enddate_id = Integer.parseInt(check_End_Date.get("ID"));
                          reserved.put("End_Date_ID", ""+enddate_id);
                      }else{
                          End_Date.put("Date", res.EndDate);
                         int id_End_Date = DB.Insert("date", End_Date);
                         reserved.put("End_Date_ID", String.valueOf(id_End_Date));
                           }
                      
                        Auction_id =  DB.Insert("reserved", reserved);
                }
                
            else if(Auc instanceof NonReserved)
              {
                NonReserved nonres = (NonReserved)Auc;
            
                nonreserved.put("Item_ID", Integer.toString(item_ID));
                nonreserved.put("Accepted_Price", String.valueOf(nonres.AcceptedPrice));
                Auction_id =  DB.Insert("nonreserved", nonreserved);
           
              }
            else{
                return false;
            }
              int ID=-1;  
              int Department_ID =-1;
           if(Dept instanceof Cars)
             {
                Cars car = (Cars)Dept;
                car_data.put("CarSpeed", Float.toString(car.CarSpeed));
                car_data.put("MotorPower", Float.toString(car.MotorPower));
                car_data.put("NumberOfPassengers", Integer.toString(car.NumOfPassengers));
                ID = DB.Insert("cars", car_data);
              
                Department_data.put("DeptName_ID", String.valueOf(ID));
                Department_data.put("Auction_ID", String.valueOf(Auction_id));
                Department_data.put("CompanyName", Dept.CompanyName);
                DB.Insert("department", Department_data);  
           
            
        }
          else if(Dept instanceof Laps){
            Laps lap = (Laps)Dept;
            lap_data.put("ScreenSize", Float.toString(lap.ScreenSize));
            lap_data.put("Processor", lap.Processor);
            lap_data.put("Hard", Integer.toString(lap.HardSize));
            lap_data.put("Ram", Integer.toString(lap.Ram));
            ID = DB.Insert("laps", lap_data);
          
                Department_data.put("DeptName_ID", String.valueOf(ID));
                Department_data.put("Auction_ID", String.valueOf(Auction_id));
                Department_data.put("CompanyName", Dept.CompanyName);
                DB.Insert("department", Department_data);
              
            
            }
          else if(Dept instanceof Mobiles){
            Mobiles mobile = (Mobiles)Dept;
            mobile_data.put("BatteryVolt", Integer.toString(mobile.Battary));
            mobile_data.put("ToatlSize", Integer.toString(mobile.TotalSize));
            ID = DB.Insert("mobile", mobile_data);
           
              
                Department_data.put("DeptName_ID", String.valueOf(ID));
                Department_data.put("Auction_ID", String.valueOf(Auction_id));
                Department_data.put("CompanyName", Dept.CompanyName);
                DB.Insert("department", Department_data);
            
                
             }
          else {
              return false;
          }
            
        }
             return true;
        }catch(Exception e)
        {
          
        }
        return false;
        
   }
   
   

    @Override
    public ArrayList<Integer> MyItems() {
        ArrayList<Integer>Items=new ArrayList<Integer>();
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        int mini=DB.SelectMinimum("item","ID");
        int max=DB.SelectCount("item","ID");
        for(int i=mini;i<=max;i++)
        {
        HashMap<String,String>Data=DB.Select("ID","item","User_ID="+this.ID +" and ID="+i);
        if(Data!=null)
            Items.add(Integer.parseInt(Data.get("ID")));
        }
      
        return Items;
    }

}
