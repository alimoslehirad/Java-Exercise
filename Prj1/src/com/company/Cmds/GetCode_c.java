package com.company.Cmds;
import  com.company.objects.*;
public class GetCode_c extends ReserveSysCmds{

    void printForgetCode(ObjectPool v){
        System.out.println( v.strArray[3]+";"+v.todayDate + ";" + v.strArray[4]);
    }
    public void run(ObjectPool v){
        this.printForgetCode(v);
    }
}