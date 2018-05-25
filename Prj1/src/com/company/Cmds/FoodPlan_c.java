package com.company.Cmds;
import  com.company.objects.*;
import com.company.process.*;
import java.util.*;
public class FoodPlan_c extends ReserveSysCmds{
    String planCmd="Init Val";
    Food foods = new Food();
    ArrayList<Food> foodAlist=new ArrayList<Food>();
    public void run(ObjectPool v){
        v.date=v.strArray[2];
        addFoodPlan(v);
    }
    void addFoodPlan(ObjectPool v){

        System.out.println("add food plan");
        while(!planCmd.equals("end")){
            planCmd = v.textIO.getCommandLine(v,v.ifTerminalInput);
            System.out.println(planCmd);
            Food foods2 = new Food();
            if(!planCmd.equals("end")){commandAnalisys(v,planCmd,foods2);}
            foodAlist.add(foods2);
        }
        planCmd="Init Val";
        System.out.println("adding foodPlan successfully Done");
    }
    private void commandAnalisys(ObjectPool v,String cmd, Food f){
        v.strArray=cmd.split(" ");
        f.foodName=v.strArray[0];
        f.price=Integer.parseInt(v.strArray[1]);
        f.cookingDate=v.date;
        dateSplit(v.strArray[2],f.deadlineDate);

    }
}
