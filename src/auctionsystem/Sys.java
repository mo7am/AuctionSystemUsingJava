/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem;

import DB.DB_;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author emad
 */
public class Sys implements I_Decorator {

    static private ArrayList<Integer> Users = null;
    static public ArrayList<Departement> Depts = null;
    static private Sys Sys = null;

    private Sys() {
        Users = new ArrayList<>();
        Depts = new ArrayList<>();
    }

    static public Sys GetSystem() {
        if (Sys == null) {
            Sys = new Sys();
            return Sys;
        } else {
            return Sys;
        }
    }

    public int Login(String Email, String Password) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();

        HashMap<String, String> ID = new HashMap();
        try {
            ID = DB.Select("User_ID", "user", "Email =" + "'" + Email + "'" + "and Password =" + "'" + Password + "'");
            int id = -1;
            id = Integer.parseInt(ID.get("User_ID"));
            return id;
        } catch (Exception e) {
        }

        return -1;
    }

    public boolean Regist(User user) {
       
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();

        HashMap<String, String> U = new HashMap();
        HashMap<String, String> email;
        U.put("F_NAME", user.FNAME);
        U.put("L_NAME", user.LNAME);
        U.put("Country_ID",""+Sys.Get_Country_ID(user.Country));
        U.put("Type_User_id", "" + user.Type);
        email = DB.Select("Email", "user", "Email =" + "'" + user.login.Mail + "'");

        if (email == null) {
            U.put("Email", user.login.Mail);
        } else {
            return false;
        }
//U.put("Email", user.login.Mail);
        U.put("Balance", "0");
        U.put("Password", user.login.Password);

        int Id = DB.Insert("user", U);
        HashMap<String, String> id_q;
        id_q = DB.Select("ID", "securityq", "Question = " + "'" + user.login.SequrityQuestion + "'");
        HashMap<String, String> add = new HashMap();
        add.put("SequrityQ_ID", id_q.get("ID"));
        add.put("User_ID", String.valueOf(Id));
        add.put("Answer_Question", user.login.AnswerQuestion);
        DB.Insert("sequrityQ_User", add);
        return true;
    }

    public ArrayList<Auction> Get_Whole_Auction() {
        return null;
    }

    public Bidder GetBidderData(int Bidder_id) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();

        try {
            HashMap<String, String> result;
            result = DB.Select("*", "user", "User_ID =" + Bidder_id);

            Bidder B = new Bidder();
            B.ID = Bidder_id;
            B.FNAME = result.get("F_NAME");
            B.LNAME = result.get("L_NAME");
            B.login.Mail = result.get("Email");
            B.login.Password = result.get("Password");
            B.Type = Integer.parseInt(result.get("Type_User_id"));
            B.Balance = Double.parseDouble(result.get("Balance"));

            return B;
        } catch (Exception e) {
        }
        return null;
    }

    public Seller GetSellerData(int Seller_id) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();

        try {
            HashMap<String, String> result;
            result = DB.Select("*", "user", "User_ID =" + Seller_id);

            Seller S = new Seller();
            S.ID = Seller_id;
            S.FNAME = result.get("F_NAME");
            S.LNAME = result.get("L_NAME");
            S.login.Mail = result.get("Email");
            S.login.Password = result.get("Password");
            S.Type = Integer.parseInt(result.get("Type_User_id"));
            S.Balance = Double.parseDouble(result.get("Balance"));

            return S;
        } catch (Exception e) {
        }
        return null;
    }

    public Admin GetAdminData(int AdminId) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        Admin A = new Admin();
        HashMap<String, String> result = new HashMap();
        HashMap<String, String> result2 = new HashMap();
        result = DB.Select("*", "user", "User_ID =" + AdminId);
        result2 = DB.Select("*", "Staff", "User_ID = " + AdminId);
        A.ID = AdminId;
        A.FNAME = result.get("F_NAME");
        A.LNAME = result.get("L_NAME");
        A.login.Mail = result.get("Email");
        A.login.Password = result.get("Password");
        A.Type = Integer.parseInt(result.get("Type_User_id"));
        A.Balance = Double.parseDouble(result.get("Balance"));

        A.SSN = result2.get("SSN");
        A.Salary = Float.parseFloat(result2.get("Salary"));
        A.Age = Integer.parseInt(result2.get("Age"));
        A.BirthDate = result2.get("Birth_Date");
        A.WorkHour = Integer.parseInt(result2.get("work_hours"));

        return A;
    }

    public Manager GetManagerData(int ManagerID) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        Manager M = new Manager();

        try {
            HashMap<String, String> result = new HashMap();
            HashMap<String, String> result2 = new HashMap();
            result = DB.Select("*", "user", "User_ID =" + ManagerID);
            result2 = DB.Select("*", "Staff", "User_ID = " + ManagerID);

            M.ID = ManagerID;
            M.FNAME = result.get("F_NAME");
            M.LNAME = result.get("L_NAME");
            M.login.Mail = result.get("Email");
            M.login.Password = result.get("Password");
            M.Type = Integer.parseInt(result.get("Type_User_id"));
            M.Balance = Double.parseDouble(result.get("Balance"));
            M.SSN = result2.get("SSN");
            M.Salary = Float.parseFloat(result2.get("Salary"));
            M.Age = Integer.parseInt(result2.get("Age"));
            M.BirthDate = result2.get("Birth_Date");
            M.WorkHour = Integer.parseInt(result2.get("work_hours"));

            return M;

        } catch (Exception e) {
        }

        return null;
    }

    public DM GetDmData(int DmID) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        try {
            HashMap<String, String> Deliverman = DB.Select("*", "user", "User_ID = " + DmID);
            DM delivery = new DM();
            delivery.ID = DmID;
            delivery.FNAME = Deliverman.get("F_NAME");
            delivery.LNAME = Deliverman.get("L_NAME");
            delivery.login.Mail=Deliverman.get("Email");
            delivery.Type = Integer.parseInt(Deliverman.get("Type_User_id"));
            delivery.Balance = Double.parseDouble(Deliverman.get("Balance"));
            HashMap<String, String> Deliverman2 = DB.Select("*", "staff", "User_ID = " + DmID);
            delivery.SSN = Deliverman2.get("SSN");
            delivery.BirthDate=Deliverman2.get("Birth_Date");
            delivery.Salary = Float.parseFloat(Deliverman2.get("Salary"));
            delivery.Age = Integer.parseInt(Deliverman2.get("Age"));
            delivery.WorkHour = Integer.parseInt(Deliverman2.get("work_hours"));

            return delivery;
        } catch (Exception ex) {
        }
        return null;
    }

    public Actor GetNewActorData(int ActorID) {
        return null;
    }
    //Check el Session Btgeb kol el items el expired w tms7ho mn ay 7eta f el DB w t7to f el ItemWinner 
    // b3d keda lma y5tar el winner m3ad a7ot el m3ad f el available time 
    //lma al admin y5tar order ashel b2a el item mn el available w el ItemWinner
    
    
    
    //---------------------------------------------------------- VeryImportant
    public void Delete_In_Last(int Item)//(After Select Appointement)
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
            DB.Delete("during_auction","Item_ID="+Item);        
        DB.Delete("number_of_deals","Item_ID="+Item);
        HashMap<String,String> Result=DB.Select("ID","nonreserved","Item_ID="+Item);
        int AuctionID=-1;
        if(Result!=null)
        {
            AuctionID=Integer.parseInt(Result.get("ID"));
            DB.Delete("nonreserved","Item_ID="+Item);
        }
        else
        {
        Result=DB.Select("ID","reserved","Item_ID="+Item);
        if(Result!=null)
        {
            AuctionID=Integer.parseInt(Result.get("ID"));
            DB.Delete("reserved","Item_ID="+Item);            
        }
        }
        int Dept_ID=-1;
        Result=DB.Select("ID","department","Auction_ID="+AuctionID);
        if(Result!=null)
        {
            Dept_ID=Integer.parseInt(Result.get("ID"));
        }
        DB.Delete("Item","ID="+Item);
        DB.Delete("department","Auction_ID="+AuctionID);
        DB.Delete("cars","ID="+Dept_ID);
        DB.Delete("mobile","ID="+Dept_ID);
        DB.Delete("laps","ID="+Dept_ID);
        
    }
    
    public HashMap<Integer,Float> CheckSessionForReserved()//Check for Auctions which expired law 7sl hklm hb3t el data lfunction MaximumPriceAuction w abl ma ab3t h7ot f gdwl winner
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        String Date = DB.CurDate();
        int dateID;
        HashMap<String, String> ResultDate = DB.Select("ID", "date", "Date='" + Date + "'");
        if (ResultDate != null) {
            dateID = Integer.parseInt(ResultDate.get("ID"));
        } else {
            HashMap<String, String> Data = new HashMap();
            Data.put("Date", "" + Date);
            dateID = DB.Insert("date", Data);
        }
        ArrayList<Integer> Item_ID = new ArrayList();
        int min = DB.SelectMinimum("reserved", "ID");
        int max = DB.SelectCount("reserved", "ID");
        for (int i = min; i <= max; i++) {
            HashMap<String, String> Result = DB.Select("Item_ID", "reserved", "ID=" + i + " and End_Date_ID=" + dateID);
            if (Result != null) {
                Item_ID.add(Integer.parseInt(Result.get("Item_ID")));
            }
        }
        HashMap<Integer, Float> Item_And_MaxPrice = new HashMap<>();
        ArrayList<Integer>Bidder_ID=new ArrayList<>();
        for (int i = 0; i < Item_ID.size(); i++)
        {
            HashMap<String, String> Result2 = DB.Select("MAX(Price) as Price ", "during_auction", "Item_ID=" + Item_ID.get(i));
            if (Result2 != null) {
                try 
                {
                    Float price = Float.parseFloat(Result2.get("Price"));
                        Item_And_MaxPrice.put(Item_ID.get(i), price);
                        
                } 
                catch(Exception E)
                {
                    
                }
            }
        }
        for(Map.Entry<Integer,Float>entry:Item_And_MaxPrice.entrySet())
        {
            HashMap<String, String> Result2 = DB.Select("User_ID ", "during_auction", "Price=" + entry.getValue());
            if (Result2 != null) {
                        Bidder_ID.add(Integer.parseInt(Result2.get("User_ID")));
                        
            }
        }
        
        int i=0;
        for(Map.Entry<Integer,Float>entry:Item_And_MaxPrice.entrySet())
        {
            TempWinnerTable(Bidder_ID.get(i),entry.getKey(),entry.getValue());
            Notifi_Items(Bidder_ID.get(i),entry.getKey(),entry.getValue());
            Delete_In_Last(entry.getKey());
            i++;
        }
        return Item_And_MaxPrice;

    }
    public HashMap<Integer,Float> CheckSessionForNonReserved()//Check for Auctions which expired law 7sl hklm hb3t el data lfunction MaximumPriceAuction w abl ma ab3t h7ot f gdwl winner
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        int min = DB.SelectMinimum("nonreserved", "ID");
        int max = DB.SelectCount("nonreserved", "ID");
        ArrayList<Integer> Items = new ArrayList<>();
        ArrayList<Float> MiniPrice = new ArrayList<>();
        for (int i = min; i <= max; i++) 
        {
            HashMap<String, String> Result = DB.Select("*", "nonreserved", "ID=" + i);
            if (Result != null) 
            {
                Items.add(Integer.parseInt(Result.get("Item_ID")));
                MiniPrice.add(Float.parseFloat(Result.get("Accepted_Price")));
            }
        }

        HashMap<Integer, Float> Item_And_MaxPrice = new HashMap<>();
        for (int i = 0; i < Items.size(); i++)
        {
            HashMap<String, String> Result2 = DB.Select("MAX(Price) as Price", "during_auction", "Item_ID=" + Items.get(i));
            if (Result2 != null) {
                try 
                {
                    Float price = Float.parseFloat(Result2.get("Price"));
                    if (MiniPrice.get(i) <= price) 
                    {
                        Item_And_MaxPrice.put(Items.get(i), price);
                    }
                } 
                catch (Exception E)
                {

                }
            }
        }
        ArrayList<Integer> Bidder_ID=new ArrayList<Integer>();
        for(Map.Entry<Integer,Float>entry:Item_And_MaxPrice.entrySet())
        {
            HashMap<String, String> Result2 = DB.Select("User_ID ", "during_auction", "Price=" + entry.getValue());
            if (Result2 != null) {
                        Bidder_ID.add(Integer.parseInt(Result2.get("User_ID")));
                        
            }
        }
        int i=0;
        for(Map.Entry<Integer,Float>entry:Item_And_MaxPrice.entrySet())
        {
            TempWinnerTable(Bidder_ID.get(i),entry.getKey(),entry.getValue());
            Notifi_Items(Bidder_ID.get(i),entry.getKey(),entry.getValue());
            DB.Delete("during_auction","Item_ID="+entry.getKey());
            Delete_In_Last(entry.getKey());            
            i++;
        }
        return Item_And_MaxPrice;
    }

    public void Notifi_Items(int UserID,int ItemID,float Price)
    {
        DB_ DB=DB_.Get_DB_controller();
        HashMap<String,String> Bidder=new HashMap<>();
        Bidder.put("User_ID",""+UserID);
        Bidder.put("Item_ID",""+ItemID);
        Bidder.put("Notification","1");
        Bidder.put("Price",""+Price);
        HashMap<String,String> Seller=new HashMap<>();
        Seller.put("User_ID",""+Get_Sa7eb_ElITem(ItemID));
        Seller.put("Item_ID",""+ItemID);
        Seller.put("Notification","1");
        Seller.put("Price",""+Price);
        DB.Insert("notification_after_session_end",Seller);
        DB.Insert("notification_after_session_end",Bidder);        
    }
    public void TempWinnerTable(int BidderID, int ItemID,float Price)
    {
        DB_ DB=DB_.Get_DB_controller();
        HashMap<String,String> Data=new HashMap<>();
        Data.put("User_ID",""+BidderID);
        Data.put("Item_ID",""+ItemID);
        DB.Insert("details_winner",Data);
        HashMap<String,String> Result= DB.Select("Balance","User","User_ID="+BidderID);
        float Balance=Float.parseFloat(Result.get("Balance"));
        Balance=Balance-Price;
        DB.Update("User","Balance="+Balance,"User_ID="+BidderID);
        int Sa7ebElitem=this.Get_Sa7eb_ElITem(ItemID);
        
        Result= DB.Select("Balance","User","User_ID="+Sa7ebElitem);
        Balance=Float.parseFloat(Result.get("Balance"));
        Balance=Balance+Price;        
        DB.Update("User","Balance="+Balance,"User_ID="+Sa7ebElitem);
    }
    
    
    //--------------------------------------------User Noti-------------------------------------------------------------
    public HashMap<Integer,Float> Get_My_Notification(int UserID)
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        int min=DB.SelectMinimum("notification_after_session_end","ID");
        int max=DB.SelectCount("notification_after_session_end","ID");   
        int count=0;
        HashMap<String,String> Result=null;
        HashMap<Integer,Float>Item_Price=new HashMap();
        for(int i=min;i<=max;i++)
        {
        Result=DB.Select("*","notification_after_session_end","ID="+i+" and User_ID="+UserID);
        if(Result!=null)
        {
            Item_Price.put(Integer.parseInt(Result.get("Item_id")),Float.parseFloat(Result.get("Price")));
        }
        } 
        DB.Delete("notification_after_session_end","User_ID="+UserID);
        return  Item_Price;
    }
    public int Get_My_Notifiation_Number(int UserID)
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();        
        int min=DB.SelectMinimum("notification_after_session_end","ID");
        int max=DB.SelectCount("notification_after_session_end","ID");   
        int count=0;
        for(int i=min;i<=max;i++)
        {
        HashMap<String,String> Result=DB.Select("ID","notification_after_session_end","ID="+i+" and User_ID="+UserID);
        if(Result!=null)
        {
            count++;
        }
        }
        return count;
    }
public int  Get_My_Notifiation_Order_Number(int DM_id)
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        
       HashMap <String , String > result = new HashMap();
       ArrayList <Integer> ids = new ArrayList<>();
       int allnumber ;
       try {
             int count = DB.SelectCount("order_of_item", "ID");
             int mini=DB.SelectMinimum("order_of_item","ID");
             int id=-1;
             for(int i=mini ; i<=count ; i++)
             {
                 result = DB.Select("*", "order_of_item", "ID = " + "'"+i+"'" +"and DM_ID = " + "'"+DM_id+"'");
                 if(result!=null)
                 {
                   id = Integer.parseInt(result.get("DM_ID"));
                   ids.add(id);
                 }
             }
             return ids.size();
           
       }catch(Exception e)
       {
         
       }
       return 0;
    }
public HashMap get_My_NotificationDM (int DM_id)
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<Integer,Integer> data = new HashMap<>();
        HashMap <String , String> result = new HashMap<>();
 
        
        try {
            int count = DB.SelectCount("order_of_item", "ID");
             int mini=DB.SelectMinimum("order_of_item","ID");
             int id=-1;
             for(int i=mini ; i<=count ; i++)
             {
            result = DB.Select("*", "order_of_item", "DM_ID = " + "'"+DM_id+"'" + "and ID = " + "'"+i+"'");
            int order_id=-1;
            int item_id = -1;
            if(result != null)
            {
               order_id = Integer.parseInt(result.get("ID"));
               item_id = Integer.parseInt(result.get("Item_ID"));
              data.put(order_id, item_id);
            }
         
            }
             
             return data;
        }catch(Exception e)
        {
           
        }
        return null;
    }
public int Get_Sa7eb_ElITem(int ItemID)
    {
        DB_ DB=DB_.Get_DB_controller();
        HashMap<String,String>H=DB.Select("User_ID","item","ID="+ItemID);
        return Integer.parseInt(H.get("User_ID"));
    }
    //---------------------------------------------------------------------------------------------------------

    
    public boolean ForgotPassword(String Email, String Question, String Answer) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();

        HashMap<String, String> user = DB.Select("User_ID", "user", "Email = " + "'" + Email + "'");
        if (user != null) {
            int ID = Integer.parseInt(user.get("User_ID"));

            HashMap<String, String> ques = DB.Select("ID", "securityq", "Question = " + "'" + Question + "'");
            int QuestionId = Integer.parseInt(ques.get("ID"));

            HashMap<String, String> Qanswer = DB.Select("Answer_Question", "SequrityQ_User", "SequrityQ_ID = " + QuestionId + " AND User_ID = " + "'" + ID + "'");

            if (Answer.equals(Qanswer.get("Answer_Question"))) {
                return true;
            }
        }
        return false;
    }

    public boolean updatePassword(String Email, String Password, String Confirm) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();

        try {

            if (Password.equals(Confirm)) {
                DB.Update("user", "Password = " + Password, "Email = '" + Email + "'");
            }
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public void Profits() {

    }

    public void NotifyAll() {

    }

    public Person GetPersonData(int ID) {
        return null;
    }

    public String GetUserTypeName(int TypeID) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();

        HashMap<String, String> result;
        try {
            result = DB.Select("Name", "type_user", "Type_User_id = " + "'" + TypeID + "'");
            String name = result.get("Name");
            return name;
        } catch (Exception e) {
        }
        return null;
    }

    public int GetUserTypeID(int UserID) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        try {
            HashMap<String, String> type = DB.Select("Type_User_id", "user", "User_ID = " + UserID);
            return Integer.parseInt(type.get("Type_User_id"));

        } catch (Exception e) {
        }
        return -1;
    }

    public int GetAdditionalAttributeID(String AdditionalName) {
        return -1;
    }

    public String GetAdditionalAttributeName(int ID) {
        return null;
    }

    public ArrayList<String> Get_User_AdditionalAttributes(int UserID) {
        return null;
    }

    public ArrayList<String> Get_User_Addtional_Functionalitites(int UserID) {
        return null;
    }



    public String GetDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        return format1.format(cal.getTime());
    }

    public int Get_Date_ID(String Date_) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> result = new HashMap();

        try {
            result = DB.Select("ID", "date", "Date = " + "'" + Date_ + "'");
            int date_id = Integer.parseInt(result.get("ID"));
            return date_id;
        } catch (Exception e) {
        }
        return -1;
    }

    public int Get_User_ID(String Email) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        try {
            HashMap<String, String> Em = DB.Select("User_ID", "User", "Email='" + Email + "'");
            return Integer.parseInt(Em.get("User_ID"));
        } catch (Exception E) {
            return -1;
        }
    }

    public int MyMessagesNumber(int PersonID) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        int count = DB.SelectCount("message", "ID");
        int mini = DB.SelectMinimum("message", "ID");
        int Number = 0;
        HashMap<String, String> H = DB.Select("State_id", "state", "State='Not Seen'");
        int NotSeenStateID = Integer.parseInt(H.get("State_id"));
        for (int i = mini; i <= count; i++) {
            HashMap<String, String> result = DB.Select("*", "message", "ID=" + i + " and Reciever_ID=" + PersonID + " and State_id=+" + NotSeenStateID);
            if (result != null) {
                Number++;
            }
        }
        return Number;
    }

    public String Get_Email(int PersonId) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> Result = DB.Select("Email", "User", "User_id=" + PersonId);
        String Email = Result.get("Email");
        return Email;
    }
    
    public int GetUserTypeID(String Type)
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String,String>Result=DB.Select("Type_User_id","type_user","Name='"+Type+"'");
        if(Result!=null)
            return Integer.parseInt(Result.get("Type_User_id"));
        return -1;
    }

    public double Get_Balance(int PersonID) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> Result = DB.Select("Balance", "User", "User_id=" + PersonID);
        double Balance = Double.parseDouble(Result.get("Balance"));
        return Balance;
    }
    public String Get_Date_String(int DateID)
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String,String> Result=DB.Select("Date","date","ID="+DateID);
        if(Result!=null)
        {
            return Result.get("Date");
        }
        return null;
    }
    public int Get_User_Country(int UserID)
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String,String> Result=DB.Select("Country_ID","User","User_ID="+UserID);
        if(Result!=null)
        {
            return Integer.parseInt(Result.get("Country_ID"));
        }
        return -1;
    }
    public int Get_Country_ID(String Country)
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String,String> Result=DB.Select("ID","region","Region='"+Country+"'");
        if(Result!=null)
        {
            return Integer.parseInt(Result.get("ID"));
        }
        return -1;
    }    
public int Count_DM_Orders(int DM_id)
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        
        int count;
        count = DB.SelectCount("`order`","`ID`");
        
        
        int count2=0;
        for(int i = 1 ; i <= count ;i++){
            HashMap<String , String> order = DB.Select("DM_ID", "`order`", "ID = " + i);
            int DM_ID = Integer.parseInt(order.get("DM_ID"));
            if(DM_ID == DM_id){
                count2++;
            }
        }
 
        return count2;
    }    
public ArrayList<String> GetAllUserType(){
        
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        
        ArrayList<String> user_type_name = new ArrayList<>();
        HashMap<String , String> user_type_name_hash = new HashMap<>();
        
        int Count_user_type_id = DB.SelectCount("type_user", "Type_User_id");
        int min = DB.SelectMinimum("type_user", "Type_User_id");
        
        for(int i = min ; i <= Count_user_type_id ; i++){
            user_type_name_hash = DB.Select("Name", "type_user" , "Type_User_id = " + i);
            if(!user_type_name_hash.isEmpty()){
                user_type_name.add(user_type_name_hash.get("Name"));
            }
            else{
               
                return null;
            }
        }
        
        DB.Close();
        
        return user_type_name;
    }

public ArrayList<String> GetAllCountry(){
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        
        ArrayList<String> Region_names = new ArrayList<>();
        HashMap<String , String> Region_name_hash = new HashMap<>();
        
            int Count_region_id = DB.SelectCount("region", "ID");
                 int min = DB.SelectMinimum("region", "ID");
        
        for(int i = min ; i <= Count_region_id ; i++){
            Region_name_hash = DB.Select("Region", "region" , "ID = " + i);
            if(!Region_name_hash.isEmpty()){
                Region_names.add(Region_name_hash.get("Region"));
            }
            else{
               
                return null;
            }
        }
        
        DB.Close();
        
        return Region_names;

    }
public ArrayList<String> GetAllQuestions(){
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        
        ArrayList<String> Questions = new ArrayList<>();
        HashMap<String , String> questions_hash = new HashMap<>();
        
        int Count_question_id = DB.SelectCount("securityq", "ID");
        
        for(int i = 1 ; i <= Count_question_id ; i++){
            questions_hash = DB.Select("Question", "securityq" , "ID = " + i);
            if(!questions_hash.isEmpty()){
                Questions.add(questions_hash.get("Question"));
            }
            else{
              
                return null;
            }
        }
        
        DB.Close();
        
        return Questions;

    }
public boolean compare(String checkdate)
         {
        try {
            java.util.Date today = new java.util.Date();
            Timestamp time = new java.sql.Timestamp(today.getTime());
            
            DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String text = date.format(time);
            Date checkdate1 = date.parse(checkdate);
            Date checkdatefromsql = date.parse(text);
            
             if(checkdate1.after(checkdatefromsql)||checkdate1.equals(checkdatefromsql)){
                 return true;
             }
             else {
                 return false;
             }
        } catch (Exception e) {
           
        }
          return false;
         }
}
