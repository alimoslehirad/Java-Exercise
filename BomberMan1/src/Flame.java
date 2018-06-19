import java.awt.*;

public class Flame extends  Blank_c{
    Image img = Toolkit.getDefaultToolkit().getImage("flame.png");
    public Flame(int x,int y){
        this.xPos=x;
        this.yPos=y;
    }

    public void draw(BomberMap P , Graphics2D g){
        g.drawImage(this.img, xPos, yPos, P);

    }
}
