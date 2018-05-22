package com.company.Cmds;
import  com.company.objects.*;
public class GetFoodForgetCode_c extends ReserveSysCmds{
    public void run(ObjectPool v){
        splitForgetCode(v);
        findStudent(v,v.studentNum);
        if(v.students.forgetCodeCnt<10) {
            v.students.sharj-=foodPrice(v.foodPlan,v.foodName,v.date);
            v.students.forgetCodeCnt++;
            findReserveHis(v.students,v.date);
            v.students.reserveHisAlist.add(v.students.indexOfReserveHis,v.students.reserveHis);
            v.studentAlist.add(v.indexOfStudent,v.students);

        }
    }

    private void splitForgetCode(ObjectPool v){
        v.strArray2=v.strArray[2].split(";");
        v.studentNum=v.strArray2[0];
        v.foodName=v.strArray2[2];
        v.date=v.strArray2[1];
    }


}
