package com.company.Cmds;
import  com.company.objects.*;
public class Sell_c extends ReserveSysCmds{
    String foodName;
    String studentNum;
    int foodPrice;
    private void commandSplit(ObjectPool v,String foodName , String studentNum){
        studentNum=v.strArray[3];
        foodName=v.strArray[4];
    }
    public void run(ObjectPool v){
        Sell_c s =new Sell_c();
        s.commandSplit(v,s.foodName,s.studentNum);
        findStudent(v,s.studentNum);
        if(ifReserveFood(v.students,s.foodName,v.todayDate)){
            s.foodPrice= inDayFoodPriceCal(v,s);
            v.sellAlist.add(s);
        }
    }
    int inDayFoodPriceCal(ObjectPool v,Sell_c s){
        int x=0;
        x=(int)reserveCapacityEx(v,s.foodName,v.todayDate)/wait4BuyNum(v.buyAlist , s.foodName);
        return  v.students.reserveHis.foods.price*((int)(1.2+x));

    }
}//end of class sell
