/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem;

import DB.DB_;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author emad
 */
public class Manager extends Staff {
    ArrayList<Integer>adminID;
    String Contnet;
    public Manager()
    {
        this.adminID=new ArrayList<>();
    }

public boolean AddStaff(Staff staff)
    {
        DB_ DB =DB_.Get_DB_controller();
        DB.Connect();
        
        HashMap<String , String> user_data = new HashMap<>();
        user_data.put("F_NAME" , staff.FNAME);
        user_data.put("L_NAME", staff.LNAME);
        user_data.put("Email",staff.login.Mail);
        user_data.put("Password",staff.login.Password);
        user_data.put("Type_User_id", Integer.toString(staff.Type));
        user_data.put("Balance", Double.toString(staff.Balance));
        user_data.put("Country_ID",""+ Sys.GetSystem().Get_Country_ID(Country));
        int user_ID = DB.Insert("user", user_data);
       
        
        if(user_ID != -1){
            HashMap<String , String> staff_data = new HashMap<>();
            staff_data.put("SSN", staff.SSN);
            staff_data.put("Salary", Float.toString(staff.Salary));
            staff_data.put("Age",Integer.toString(staff.Age));
            staff_data.put("Birth_Date", staff.BirthDate);
            staff_data.put("work_hours",Integer.toString(staff.WorkHour));
            staff_data.put("User_ID", Integer.toString(user_ID));
            
            int staff_id = DB.Insert("staff", staff_data);
            
            
            HashMap<String , String> question_id = null;
            if(staff_id != -1){
                question_id = DB.Select("ID","securityq" , "Question = " + "'" + staff.login.SequrityQuestion + "'");
                
                
                if(question_id != null){
                    HashMap<String , String> sequrity_question_data = new HashMap<>();
                    sequrity_question_data.put("SequrityQ_ID", question_id.get("ID"));
                    sequrity_question_data.put("User_ID", Integer.toString(user_ID));
                    sequrity_question_data.put("Answer_Question", staff.login.AnswerQuestion);
                    
                    int sequrity_id = DB.Insert("sequrityq_user", sequrity_question_data);
                  
                }else{
                    return false;
                }
                
            }else{
                return false;
            }
        }else{
            return false;
        }
        
        
        DB.Close();
        return true;
    }
    public boolean AddNewActor(Actor actor)
    {
        return true;
    }
    public boolean DeleteActor(int ActorID)
    {
        return true;
    } 


public boolean PaySalary()
    {
Calendar cal = Calendar.getInstance();
int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);


if(dayOfMonth!=1)
{
    return false;
}
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        
        //get manager salary only
        HashMap<String , String> Managerbalance = DB.Select("Balance", "user" , "User_ID = " + 1);
        double manager_Balance = Double.parseDouble(Managerbalance.get("Balance"));
        
        //Count the record of staff table 
        int count_record = DB.SelectCount("staff","staff_id");
        int mini=DB.SelectMinimum("staff","staff_id");
        
        HashMap<String , String> Salary_hash;    
        ArrayList <Float> salary_array = new ArrayList<Float>();
        //store the salary according to user id in array list start count from record number = 2
        for(int i = mini ; i<=count_record ; i++){
            Salary_hash = DB.Select("Salary", "staff", "User_ID = " + i);
            salary_array.add(Float.parseFloat(Salary_hash.get("Salary")));
        }
        
        HashMap<String , String> Userid_hash;
        ArrayList userid_array = new ArrayList();
        
        for(int i = mini ; i<=count_record ; i++){
            Userid_hash = DB.Select("User_ID", "staff", "User_ID = " + i);
            userid_array.add(Userid_hash.get("User_ID"));
        }
        
        
        HashMap<String , String> Balance_User;
        ArrayList<Double> userbalance = new ArrayList();
        for(int i =1 ; i<=userid_array.size() ; i++){
            Balance_User = DB.Select("Balance", "user", "User_ID = " + "'" + userid_array.get(i-1) + "'");
            userbalance.add(Double.parseDouble(Balance_User.get("Balance")));
        }
        
        
        ArrayList<Double> New_Balance = new ArrayList();
        float totalsalary = 0;
        for(int i = 1 ; i<=userid_array.size() ; i++){
            New_Balance.add(salary_array.get(i-1) + userbalance.get(i-1));
            totalsalary = totalsalary +salary_array.get(i-1);
        }
            manager_Balance = New_Balance.get(0);
            manager_Balance = manager_Balance - totalsalary;
            New_Balance.set(0, manager_Balance);
            
        
        boolean check =false;
        for(int i = 1 ; i<= userid_array.size() ; i++){
           check = DB.Update("user", "Balance = " + New_Balance.get(i-1) , "User_ID = " + "'" + userid_array.get(i-1) +"'");
        }
        DB.Close();
        
        return check;
    }

public Report Report()
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        try{
            ArrayList <Integer>  item= new ArrayList(); 
            ArrayList <Integer>  user= new ArrayList(); 
             ArrayList <Integer>  type= new ArrayList();
             ArrayList <Integer>  bidder= new ArrayList();
             ArrayList <Integer>  seller= new ArrayList();
            HashMap <String , String> result = new HashMap();
            HashMap <String , String> result2 = new HashMap();
            HashMap <String , String> result3 = new HashMap();
             HashMap <String , String> result4 = new HashMap();
             HashMap <String , String> result5 = new HashMap();
             HashMap <String , String> result6 = new HashMap();
              HashMap <String , String> result7 = new HashMap();
          
                int numberOfItem = DB.SelectCount("feedback","ID");
                int mini=DB.SelectMinimum("feedback","ID");
               
                for (int q=mini ; q<=numberOfItem ;q++){
              result = DB.Select("Item_ID", "feedback", "ID =" +q ); 
              if(result !=null){
              int x = Integer.parseInt(result.get("Item_ID"));
                  
              item.add(x);
                   
                }  }
                 int re =-1;
             for(int i=0 ; i<item.size() ; i++){
             result2 = DB.Select("User_ID", "item", "ID = " + item.get(i)); 
             if(result2 != null){
              re = Integer.parseInt(result2.get("User_ID"));
              user.add(re);
               
            }
             }
             
             for(int i=0 ; i<user.size() ; i++){
             result3 = DB.Select("Type_User_id", "user", "User_ID = " + user.get(i));
             if(result3 != null)
             {
             int ids = Integer.parseInt(result3.get("Type_User_id"));
             type.add(ids);
               
                    
               }
             }
            int i2;
            for( i2=0 ; i2<type.size() ; i2++){
                int x = user.get(i2);
                
              if (type.get(i2) == 4)
              {
                  bidder.add(x);  
                 
              }
              else 
              {
                  seller.add(x);
            
              }
            }
             Feedback f = new Feedback();
                  Report r = new Report();
                  double sum=0;
                  for(int i=0 ; i<bidder.size() ; i++){
                  result5 = DB.Select("Ratenum", "feedback join item on feedback.Item_ID = item.ID", "User_ID = " + bidder.get(i));
                    
                   sum += Integer.parseInt(result5.get("Ratenum"));
                    f.RateNumber = sum;
                  }
                 
                  sum = (sum/(bidder.size()*100))*100;
                  r.Persantage_Bidder = (int)sum;
                 
            
          
            double sum2 =0;
            for(int i1=0 ; i1<seller.size() ; i1++){
                
                  result6 = DB.Select("Ratenum", "feedback join item on feedback.Item_ID = item.ID", "User_ID = " + seller.get(i1));
                     
                   sum2 += Integer.parseInt(result6.get("Ratenum"));
                    f.RateNumber = sum2;
                  }
                 
                  
                  sum2 = (sum2/(seller.size()*100))*100;
                  r.Persantage_Seller = (int)sum2;
                
                  
                  double sum3 =0;
            for(int i1=0 ; i1<user.size() ; i1++){
                
                  result7 = DB.Select("SysQuality", "feedback join item on feedback.Item_ID = item.ID", "User_ID = " + user.get(i1));
                     
                   sum3 += Integer.parseInt(result7.get("SysQuality"));
                    f.SystemQuality = sum3;
                  }
                 
                  sum3 = (sum3/(user.size()*100))*100;
                  r.SystemQuality = (int)sum3;
                 
             r.NumberOfDeals = numberOfItem; 
            
                  return r;
        }catch(Exception e)
        {
          
        }
        return null;
    }

public Person SearchPerson(int PersonID) 
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        try{
        HashMap<String , String> user = DB.Select("*", "User", "User_ID = " + PersonID );
        
        Person person = new Person() ;
        person.ID = Integer.parseInt(user.get("User_ID"));
        person.FNAME = user.get("F_NAME");
        person.LNAME = user.get("L_NAME");
        person.login.Mail=user.get("Email");
        person.Type = Integer.parseInt(user.get("Type_User_id"));
        person.Balance = Double.parseDouble(user.get("Balance"));
        return person;
        }
        catch(Exception ex){
           
        }
        
        return null;
    }
    public HashMap<String,String>OthersPersonTable(int PersonID)
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String,String>St=DB.Select("*", "staff", "User_ID="+PersonID);
        if(St!=null)
        {
        String Region=this.GetRegion(PersonID);
        if(Region!=null)
        {
            St.put("Region",Region);
        } 
        return St;
        }

        return null;
    }

public String GetRegion(int RegionID){
         DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        try{
        HashMap<String , String> region =  DB.Select("Region" ,"region" , "ID = " + RegionID);
        String regionn = region.get("Region");
        return regionn;
        }
        catch(Exception ex){
            return null;
        }
        
    }
    public boolean DeletePerson(int PersonID)
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String,String> H=DB.Select("Type_User_id","User","User_Id="+PersonID);
        int Type_=Integer.parseInt(H.get("Type_User_id"));
        if(Type_==2)
        {
             DB.Delete("User","User_ID");
             DB.Delete("staff","User_ID="+PersonID);
             DB.Delete("sequrityq_user","User_ID="+PersonID);
             return true;
        }
        else if(Type_==3)
        {
            HashMap<String,String>Result=DB.Select("DM_ID","order_of_item","DM_ID="+PersonID);
            if(Result!=null)
            {
                return false;
            }
            else
            {
             DB.Delete("User","User_ID");
             DB.Delete("staff","User_ID="+PersonID);
             DB.Delete("sequrityq_user","User_ID="+PersonID);             
             return true;
            }
        }
        return false;
    }
    
public void Get_Observers()
   {
       DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        
       HashMap <String , String > result = new HashMap();
       
     
       try {
             int count = DB.SelectCount("Observers", "ID");
             int mini=DB.SelectMinimum("Observers","ID");
             int id=-1;
             for(int i=mini ; i<=count ; i++)
             {
                 result = DB.Select("Admin_ID", "Observers", "ID = " + i);
                 if(result!=null)
                 {
                   id = Integer.parseInt(result.get("Admin_ID"));
                   adminID.add(id);
                 }
             }
            
           
       }catch(Exception e)
       {
          
       }
     
   }
   public void SetState(String St)
   {
       this.Contnet=St;
       this.NotiAll();
   }

    public void NotiAll()
   {
       DB_ DB = DB_.Get_DB_controller();
       DB.Connect();
      
       HashMap <String , String > result2 = new HashMap();
       HashMap <String , String > result3 = new HashMap();
        HashMap <String , String > data = new HashMap(); 
        ArrayList<Integer> idds = new ArrayList();
      
        
       try {
            
             String state2="Not Seen";
            int state_id2=-1;
             result3 = DB.Select("State_id", "state", "State =" +"'"+state2+"'");
             if(result3!=null)
             {
               state_id2 = Integer.parseInt(result3.get("State_id"));
             }
            
            for(int i=0 ;i<adminID.size() ; i++)
            {
                int count = DB.SelectCount("Observer", "Observer_id");
             int mini=DB.SelectMinimum("Observer","Observer_id");
             int id=-1;
             for(int j=mini ; j<=count ; j++)
             {
                result2 = DB.Select("User_ID", "Observer", "Observer_id = " + "'"+j +"'"+"and User_ID ="+"'"+adminID.get(i)+"'");
                if(result2!=null)
                {
                    idds.add(Integer.parseInt(result2.get("User_ID")));
                    for(int i1=0 ;i1<idds.size() ; i1++)
                     {
                      DB.Update("Observer","Content = "+ "'"+Contnet+"'" +" ,State_id=2", "User_ID =" +adminID.get(i1)) ;
                    }
               }
            } 
            }

            ArrayList<Integer> union = new ArrayList<>(adminID);
            union.addAll(idds);
            ArrayList<Integer> intersection = new ArrayList<>(adminID);
            intersection.retainAll(idds);
            union.removeAll(intersection);
         
           
                       for (int i=0 ; i<union.size() ; i++) {
                           
                     data.put("User_ID", ""+union.get(i));
                     data.put("Content", Contnet);
                     data.put("State_id", ""+state_id2);
                     DB.Insert("observer", data);   
                       }
      }catch(Exception e)
       {
          
       } 
   }}
