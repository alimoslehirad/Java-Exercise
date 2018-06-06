import java.io.FileOutputStream;
public class Main {
    public static final int x=14;
    public static final int y=14;
    public static void main(String[] args) {
	// write your code here
       // playGroundMap_text();
        PlayGround g =new PlayGround("BomberMan Game");

        
    }
    public static void playGroundMap_text(){
        try{
            FileOutputStream fout=new FileOutputStream("PlayGroundMap.txt");
            String s="Welcome to javaTpoint.";
            byte b[]=s.getBytes();//converting string into byte array
            s="";
            for(int i=0;i<x;i++){
                s+="0 ";
            }
            s+="\n";
            for(int i=0;i<y;i++){
                byte c[]=s.getBytes();//converting string into byte array
                fout.write(c);

            }
            fout.close();

            System.out.println("success...");
        }catch(Exception e){System.out.println(e);}




    }
}
