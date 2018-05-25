package com.company.process;
import  com.company.objects.*;
import com.company.Cmds.*;
import java.util.*;
public class ProcessControl{
    Scanner datain =new Scanner(System.in);
    String command="jgjhg";
    void commandSplit(ObjectPool v){
        v.strArray=command.split(" ");
    }
    int commandIndex(ObjectPool v){
        v.strArray=command.split(" ");
        if(v.strArray[0].equals("get") && v.strArray[1].equals("food") && ! v.reserveSys[0].ifForgetCodeCmd(v)) return 0;
        else if(v.strArray[0].equals("get") && v.reserveSys[0].ifForgetCodeCmd(v) ) return 1;
        else if(v.strArray[0].equals("add") ) return 2;
        else if(v.strArray[0].equals("reserve") ) return 3;
        else if(v.strArray[0].equals("cancel") ) return 4;
        else if(v.strArray[0].equals("deposite") ) return 5;
        else if(v.strArray[0].equals("sell") ) return 6;
        else if(v.strArray[0].equals("buy") ) return 7;
        else if(v.strArray[1].equals("forget") ) return 8;
        else return 0;
    }
    public void commandProcess(ObjectPool v,boolean ifTerminalInput){

            while(!command.equals("closed")){
            	command=v.textIO.getCommandLine(v,v.ifTerminalInput);
            	if(!command.equals("closed")) {
                    System.out.println(command+"--"+ commandIndex(v) +" .......is running");
            	    commandSplit(v);
                    v.reserveSys[commandIndex(v)].run(v);
                }
            }//end of while("closed")
      
    }

   public void endProcess(ObjectPool v){
        System.out.println("--------------------Reserve Information is-----------------------:");
        for(int i=0; i<v.studentAlist.size();i++){
            v.students=v.studentAlist.get(i);
            System.out.println(v.students.studentNum + "    " + v.students.sharj+"..." + i+"  ReserveHis: ");
            for(int j=0;j<v.students.reserveHisAlist.size();j++){
                v.students.reserveHis=v.students.reserveHisAlist.get(j);
                System.out.print(v.students.reserveHis.date + "   " + v.students.reserveHis.foods.foodName);
                if(v.students.reserveHis.ifGetFood)
                    System.out.print("  " + "1");
                else
                    System.out.print("  " + "0");
                if(v.students.reserveHis.ifGetCode)
                    System.out.print("  " + "1");
                else
                    System.out.print("  " + "0");
            }
            System.out.println();

        }


    }

    public void getInitInf(ObjectPool v){
        String s;
        System.out.print("if use terminal for enter necessary information y/n?:  ");
        s=datain.nextLine();
        if(s.equals("y")){v.ifTerminalInput=true;}
        else v.ifTerminalInput=false;
        getSystemDate(v.ifTerminalInput,v);
        getStudentsNum(v, v.ifTerminalInput);

    }
    private void getSystemDate(boolean inputType , ObjectPool v){
        if(inputType){
            System.out.print("Enter Today date:  ");
            v.todayDate=datain.nextLine();
        }
        else {
            v.todayDate=v.textIO.getCommandLine(v,inputType);
        }
    }


    private void getStudentsNum(ObjectPool v,boolean inputType ){
        if(inputType){
            System.out.print(" Enter numbers of students:  ");
            v.studentNumber=datain.nextInt();
            v.studentNum=datain.nextLine();
            for(int i=0;i<v.studentNumber;i++){
                Student s1=new Student();
                s1.studentNum=datain.nextLine();
                v.studentAlist.add(s1);
            }
        }
        else {
            v.studentNumber=Integer.parseInt(v.textIO.getCommandLine(v,inputType));
            for(int i=0;i<v.studentNumber;i++) {
                Student s1=new Student();
                s1.studentNum = v.textIO.getCommandLine(v, inputType);
                v.studentAlist.add(s1);
            }
        }
    }


}//end of class process Control
