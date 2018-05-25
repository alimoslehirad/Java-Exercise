
package com.company.Cmds;
import  com.company.objects.*;
public class Deposit_c extends ReserveSysCmds{
    int sharj;
    String studentNum;
    public void run(ObjectPool v){
        this.commandSplit(v);
        if(findStudent(v,v.studentNum)){
            v.students.sharj+=v.intTeamp;
            v.studentAlist.add(v.indexOfStudent,v.students);
        }
        else
            System.out.println("student Number is wrong!");

    }
    private	void commandSplit(ObjectPool v ){
        v.studentNum=v.strArray[1];
        v.intTeamp=Integer.parseInt(v.strArray[2]);

    }


}
