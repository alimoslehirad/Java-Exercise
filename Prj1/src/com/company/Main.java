package com.company;
import com.company.Cmds.*;
import com.company.objects.*;
import com.company.process.*;

public class Main {

    public static void main(String[] args) {
        ReserveSysCmds reserveSys=new ReserveSysCmds();
        ObjectPool v = new ObjectPool();
        ProcessControl p =new ProcessControl();
        v.objectInit();
        p.getInitInf(v);
        System.out.println("main loop");
        p.commandProcess(v,v.ifTerminalInput);
        p.endProcess(v);




    }
}
