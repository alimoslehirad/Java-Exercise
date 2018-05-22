
package com.company.Cmds;
import  com.company.objects.*;
public class Deposit_c extends ReserveSysCmds{
    int sharj;
    String studentNum;
    public void run(ObjectPool v){
        this.commandSplit(v,this.studentNum,this.sharj);
        if(findStudent(v,this.studentNum)){
            v.students.sharj+=this.sharj;
            v.studentAlist.add(v.indexOfStudent,v.students);
        }
        else
            System.out.println("student Number is wrong!");

    }
    private	void commandSplit(ObjectPool v, String StudentNum , int sharj){
        this.studentNum=v.strArray[1];
        sharj=Integer.parseInt(v.strArray[2]);

    }


}
