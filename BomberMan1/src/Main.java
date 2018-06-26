import java.util.*;
import BomberInit.*;
import BomberGame.*;
public class Main {
    public static final int x=14;
    public static final int y=14;
    public int key;
    public static void main(String[] args) {

//       new BomberMapMake("BomberMan Initialize Game",x,y);
         new BomberMap("BomberMan Game",x,y);

         System.out.println("program end");
        
    }

}


class MyRunnable implements Runnable{

    public void run(){

        go();
    }

    public void go(){
        while(true) {
            System.out.println("Tread is run ");

        }
    }
}