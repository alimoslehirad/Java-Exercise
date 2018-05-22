package com.company.Cmds;
import  com.company.objects.*;
import java.util.*;
public class FoodPlan_c extends ReserveSysCmds{
    String planCmd="ads";
    Food foods = new Food();
    ArrayList<Food> foodAlist=new ArrayList<Food>();
    public void run(ObjectPool v){
        v.date=v.strArray[2];
        addFoodPlan(v);
    }
    void addFoodPlan(ObjectPool v){
        Scanner datain=new Scanner(System.in);
        System.out.print("add food plan");
        while(!planCmd.equals("end")){
            planCmd = datain.nextLine();
            Food foods2 = new Food();
            this.commandAnalisys(v,planCmd,foods2);
            foodAlist.add(foods2);
        }
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
