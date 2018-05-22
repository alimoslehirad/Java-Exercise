package com.company.process;
import  com.company.objects.*;
import java.util.*;
public class ProcessControl{
    Scanner datain =new Scanner(System.in);
    String command="jgjhg";
    void commandSplit(ObjectPool v){
        v.strArray=command.split(" ");
    }
    int commandIndex(ObjectPool v){
        v.strArray=command.split(" ");
        if(v.strArray[0]=="get"&& v.strArray[1]=="food") return 0;
        else if(v.strArray[0].equals("get") && v.strArray[1].equals("forget") ) return 1;
        else if(v.strArray[0].equals("add") ) return 2;
        else if(v.strArray[0].equals("reserve") ) return 3;
        else if(v.strArray[0].equals("cancel") ) return 4;
        else if(v.strArray[0].equals("deposite") ) return 5;
        else if(v.strArray[0].equals("sell") ) return 6;
        else if(v.strArray[0].equals("buy") ) return 7;
        else if(v.strArray[1].equals("forget") ) return 8;
        else return 0;
    }
    public void mainLoop(ObjectPool v){

        while(!command.equals("closed")){
            command=datain.nextLine();
            commandSplit(v);
            v.reserveSys[commandIndex(v)].run(v);

        }//end of while("closed")
        endProcess(v);
    }

   public void endProcess(ObjectPool v){
        System.out.println("Reserve Information is:");
        for(int i=0; i<v.studentAlist.size();i++){
            v.students=v.studentAlist.get(i);
            System.out.println(v.students.studentNum + "    " + v.students.sharj+"..." + i);
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

        }


    }

    public void getInitInf(ObjectPool v){

        System.out.print("Enter Today date:  ");
        v.todayDate=datain.nextLine();
        System.out.print(" Enter numbers of students:  ");
        v.studentNumber=datain.nextInt();
        v.studentNum=datain.nextLine();
        for(int i=0;i<v.studentNumber;i++){
            Student s1=new Student();
            s1.studentNum=datain.nextLine();
            v.studentAlist.add(s1);
        }
    }


}//end of class process Control