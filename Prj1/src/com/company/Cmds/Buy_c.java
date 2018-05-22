
package com.company.Cmds;
import  com.company.objects.*;
public class Buy_c extends ReserveSysCmds{
    String foodName;
    public void run(ObjectPool v){
        this.commandSplit(v);
        if( this.findFoodFromSellList(v, v.foodName)){
            this.updateSellerStudentProfile(v,v.sell.studentNum );
            this.removeFoodFromSellList(v);
        }
    }
    private boolean findFoodFromSellList(ObjectPool v, String foodName){
        boolean state=false;
        for(int i=0;i<v.sellAlist.size();i++){
            v.sell=v.sellAlist.get(i);
            if(foodName.equals(v.sell.foodName)){
                state=true;
                v.indexOfSell=i;
                break;
            }
        }
        return state;
    }
    private void updateSellerStudentProfile(ObjectPool v , String studentNum){
        findStudent(v, studentNum);
        findReserveHis(v.students,v.todayDate);
        v.students.reserveHis.ifGetFood=true;
        v.students.sharj+=v.sell.foodPrice;    //////////////////////////////
        v.studentAlist.add(v.indexOfStudent,v.students);
    }
    private void commandSplit(ObjectPool v){
        v.foodName=v.strArray[4];
        v.studentNum=v.strArray[3];

    }
    private void removeFoodFromSellList(ObjectPool v){
        v.sellAlist.remove(v.indexOfSell);
    }
}//end of Buy class