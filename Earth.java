/**
* @author Shashank Sahu 
*/
import java.awt.*;
class Earth
{
    float x;//x -center of our earth
    float y;//y corrdinate of center of earth
    float radius=350;// radius of earth
    float mass=1000000;// mass of earth relative to ball's mass
    
    public Earth(float _x,float _y)
    {
        x=_x;
        y=_y;
    }
    
    public void paint(Graphics g)
    {
       g.setColor(Color.GREEN);
       drawCircle(g);
    }
    
    public void drawCircle(Graphics g)
    {
        //Draws our earth
        int offsetX=(int)(x-radius);
        int offsetY=(int)(y-radius);
        int diameter=(int)(2*radius);
        g.fillOval(offsetX,offsetY,diameter,diameter);
    
    }

    
}
