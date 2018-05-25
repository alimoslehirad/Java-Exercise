

package com.company.Cmds;
import java.util.*;
import  com.company.objects.*;
public class ReserveSysCmds {
    public boolean ifForgetCodeCmd(ObjectPool v){
        if(v.strArray[2].indexOf(';')>=0)
            return true;
        else
            return false;
    }
    public boolean findReserveHis( Student s , String date){
        boolean state=false;
        for(int i=0;i<s.reserveHisAlist.size();i++){
            s.reserveHis=s.reserveHisAlist.get(i);
            if(date.equals(s.reserveHis.date)){ s.indexOfReserveHis=i;state=true; break;}
        }
        return state;
    }
    public boolean ifReserveFood(Student s , String foodName , String date){
        if(this.findReserveHis(s ,date ))
            if(s.reserveHis.foods.foodName==foodName)
                return s.reserveHis.ifResFood;
            else
                return false;
        else
            return false;

    }

    /**
     *find specefic student from student list and update v.students object
     */
    public boolean findStudent(ObjectPool v, String studentNum){
        boolean state=false;
        for(int i=0;i<v.studentAlist.size();i++){
            v.students=v.studentAlist.get(i);
            if(v.students.studentNum.equals(studentNum)){
                v.indexOfStudent=i;
                state=true;
                break;
            }
        }
        return state;
    }

    public void run(ObjectPool v){
        System.out.print("running program");

    }
    public void dateSplit(String date , int[] intDate){
        String[] strArray;
        strArray=date.split("/");
        System.out.println("date is ---------: " + strArray[0]);
        intDate[0]=Integer.parseInt(strArray[0]);
        intDate[1]=Integer.parseInt(strArray[1]);
        intDate[2]=Integer.parseInt(strArray[2]);
    }

    public int reserveCapacityEx(ObjectPool v,String foodName,String date){
        int reserveCnt=0;
        for(int i=0;i<v.studentAlist.size();i++){
            v.students=v.studentAlist.get(i);
            findReserveHis(v.students,date);
            if(foodName.equals(v.students.reserveHis.foods.foodName)){
                reserveCnt++;
            }

        }

        return reserveCnt;
    }
    public int foodPrice(FoodPlan_c f,String foodName,String date){
        int x=0;
        for(int i=0;i<f.foodAlist.size();i++){
            f.foods=f.foodAlist.get(i);
            if((f.foods.cookingDate==date) && f.foods.foodName==foodName){x= f.foods.price;break;}
            else
                x= -1;
        }
        return x;
    }

    public int wait4BuyNum(ArrayList<Buy_c> buyingList,String foodName){
        int n=0;
        Buy_c buy=new Buy_c();
        for(int i=0;i<buyingList.size();i++){
            if(foodName.equals(buy.foodName)){
                n++;
            }
        }
        return n;
    }


}
