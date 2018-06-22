import java.awt.*;

public class Flame extends  Obstacle{
    Image img = Toolkit.getDefaultToolkit().getImage("flame.png");
    private int ID=10;
    private boolean crossPermition=true;
    public boolean isCrossPermition(){
        return crossPermition;
    }
    public Flame(int x,int y){
        this.xPos=x;
        this.yPos=y;
        probability=.3;
    }

    @Override
    public void bombReaction(){

    }


    @Override
    public boolean getToFireAction() {
        return false;
    }
    @Override
    public int getID() {
        return ID;
    }

    public void draw(BomberMap P , Graphics2D g){
        g.drawImage(this.img, xPos, yPos, P);

    }
}
