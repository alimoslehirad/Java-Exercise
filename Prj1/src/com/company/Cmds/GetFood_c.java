
package com.company.Cmds;
import  com.company.objects.*;
public class GetFood_c extends ReserveSysCmds{

    public void run(ObjectPool v){
        this.commandSplit(v);
        findStudent(v,v.studentNum);
        if(ifGetFoodPermition(v.students,v.foodName,v.todayDate)){
            v.students.reserveHis.ifGetFood=true;
            v.students.reserveHisAlist.add(v.students.indexOfReserveHis,v.students.reserveHis);
            v.studentAlist.add(v.indexOfStudent,v.students);
        }
    }

    private boolean ifGetFoodPermition(Student s,String foodName, String date){
        findReserveHis(s,date);
        if( (foodName.equals(s.reserveHis.foods.foodName)) && (s.reserveHis.ifResFood) )
            return true;
        else
            return false;

    }
    private void commandSplit(ObjectPool v){
        v.studentNum=v.strArray[2];
        v.foodName=v.strArray[3];

    }
}
