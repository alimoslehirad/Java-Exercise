
package com.company.Cmds;
import  com.company.objects.*;
public class Cancel_c extends ReserveSysCmds {

    public void run(ObjectPool v){
        this.commandSplit(v,v.studentNum,v.foodName,v.reserveDate);
        if(findStudent(v,v.studentNum)){
            if(ifReserveFood(v.students,v.foodName,v.date)){
                updateStudentProfile(v.students);
                v.studentAlist.add(v.indexOfStudent,v.students);
            }
        }
        else
            System.out.println("student Number is wrong!");
    }
    private void commandSplit(ObjectPool v , String studentNum , String foodName , int[] intDate){
        studentNum=v.strArray[2];
        foodName=v.strArray[4];
        dateSplit(v.strArray[3],intDate);
    }

    private void updateStudentProfile(Student s){
        s.reserveHis.ifGetFood=false;
        s.sharj+=(int)s.reserveHis.foods.price/2;
        s.reserveHisAlist.add(s.indexOfReserveHis,s.reserveHis);
    }

}
