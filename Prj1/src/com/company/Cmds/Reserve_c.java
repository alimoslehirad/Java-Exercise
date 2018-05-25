
package com.company.Cmds;
import  com.company.objects.*;
public class Reserve_c extends ReserveSysCmds {
    int[] reserveDate=new int[3];
    String foodName;
    String studentNum;

    public void run(ObjectPool v) {
        commandSplit(v, this.studentNum, this.foodName, this.reserveDate);
        if (findStudent(v, this.studentNum)) {
            if (!ifReserveTimeOver(v.students, v.date) && ifSharjEnough(v.students)) {
                v.students.sharj -= foodPrice(v.foodPlan, this.foodName, v.date);
                this.updateReserveHis(v.students, v);
                v.studentAlist.add(v.indexOfStudent, v.students);
            }
        } else
            System.out.println("student Number is wrong!");
    }

    private boolean ifReserveTimeOver(Student s, String date) {
        findReserveHis(s, date);
        if (this.reserveDate[2] > s.reserveHis.foods.deadlineDate[2])
            return true;
        else
            return false;
    }

    private boolean ifSharjEnough(Student s) {
        if (s.sharj > -20000)
            return true;
        else
            return false;
    }

    private void commandSplit(ObjectPool v, String studentNum, String foodName, int[] intDate) {
        studentNum = v.strArray[1];
        foodName = v.strArray[3];
        v.date = v.strArray[2];
        System.out.println("date(reserveCmd) is : " + v.date);
        dateSplit(v.strArray[2], intDate);

    }

    private void updateReserveHis(Student s, ObjectPool v) {
        s.reserveHis.ifResFood = true;
        s.reserveHis.date = v.date;
        s.reserveHis.foods.foodName = this.foodName;
        s.reserveHis.foods.cookingDate = v.date;
        s.reserveHis.foods.price = foodPrice(v.foodPlan, this.foodName, v.date);
        s.reserveHisAlist.add(s.reserveHis);

    }
}