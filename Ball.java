/**
* @author Shashank Sahu
* 
*/

import java.awt.*;

class Ball
{
    float x;// x position of our ball
    float y;// y position of our ball
    float sx;// dropping x position of our ball 
    float sy;// dropping y position of our ball
    /*Mass of earth is 5.972*10^24 kg. We will take mass of ball to be 1 kg(unit)*/
    float mass=1;
    
    float radius=5;//radius of the ball
    Earth earth;// reference to the earth
    float vy=0;//velocity of ball in the y-axis, i.e top-bottom movement
    
    public Ball(Earth _earth)
    {
        earth=_earth;
        // sets the x ,y sx and sy to the dropping position.
        x=earth.x;
        y=earth.y-earth.radius;
        sx=x;
        sy=y;
    }
    
    public void paint(Graphics g)
    {
       g.setColor(Color.BLACK);
       // drawing the ball with center at x and y and with the given radius
       g.fillOval((int)(x-radius),(int)(y-radius),(int)(2*radius),(int)(2*radius));
    
    }
    
    void update()
    {
       float gravity= calcGravity();
       gravity=gravity*getDirection();
       vy+=gravity;
       y+=vy;
    }
    
    /**Return either 1 or -1 depending upon the posion of ball's center with respect to the center of earth*/
    int getDirection()
    {
        if(this.y>earth.y)
            return -1;
        
        else
            return 1;
    }
    
    /**calculate gravity based on the distance of the ball from the center of the earth*/
    float calcGravity()
    {
        
        float force=calcForce();
        //System.out.println("FOrce="+force);
        float gravity=(force/this.mass);
        //System.out.println(gravity);
        return gravity;
    }
    
    /**Calculates distance between the centers of earth and ball*/
    float calcDis()
    {
       float dis=(float)Math.sqrt(Math.pow(earth.x-x,2)+Math.pow(earth.y-y,2));
       return dis;
    }
    
    /**calculate force experienced by the ball due to the earth*/
    float calcForce()
    {
         float dis=calcDis();
         //System.out.println("Dis="+dis);
         float massD=(earth.mass*dis*dis)/(earth.radius*earth.radius);//Mass of earth at a depth 
         //System.out.println("MASS D="+massD);
        if(dis==0)
           return 0;//prevent division by 0
        
        float force=((this.mass*massD)/(dis*dis));
        return force;
   }
}