package com.company.objects;
import com.company.Cmds.*;
import java.util.*;
import com.company.process.*;
import java.io.*;

public class ObjectPool {
    public ArrayList<Student>  studentAlist;
    public Buy_c buy;
    public Sell_c  sell;
    public  ArrayList<Sell_c> sellAlist;
    public ArrayList<Buy_c> buyAlist;
    public FoodPlan_c foodPlan;
    public Scanner datain;
    public String command,s;
    public String todayDate;
    public String foodName;
    public String date;
    public String studentNum;
    public int studentNumber;
    public int indexOfReserveFood;
    public int indexOfStudent;
    public int indexOfReserveHis;
    public int indexOfSell;
    public int intTeamp;
    public Food foods;
    public FoodPlan_c foodPlans ;
    public String[] strArray;
    public String[] strArray2;
    public Student students;
    public int[] reserveDate;
    public TextIO textIO;
    public boolean ifTerminalInput;
    public ReserveSysCmds[] reserveSys;
    public  String fileName;
    // FileReader reads text files in the default encoding.
    public FileReader fileReader;
    // Always wrap FileReader in BufferedReader.
    public BufferedReader bufferedReader;
    public void objectInit(){
        reserveSys= new ReserveSysCmds[9];
        reserveSys[0]= new GetFood_c();
        reserveSys[1]= new GetFoodForgetCode_c();
        reserveSys[2]= new FoodPlan_c();
        reserveSys[3]= new Reserve_c();
        reserveSys[4]= new Cancel_c();
        reserveSys[5]= new Deposit_c();
        reserveSys[6]= new Sell_c();
        reserveSys[7]= new Buy_c();
        reserveSys[8]= new GetCode_c();
        students= new Student();
        foodPlans=new FoodPlan_c();
        foods=new Food();
        datain=new Scanner(System.in);
        studentAlist = new ArrayList<Student>();
        buy=new Buy_c();
        sell=new Sell_c();
        sellAlist= new ArrayList<Sell_c>();
        buyAlist= new ArrayList<Buy_c>();
        foodPlan = new FoodPlan_c();
        command="Init Val";
        textIO=new TextIO();

        try {
            fileName = "test.txt";
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
