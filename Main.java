/**
* @author Shashank Sahu
* 
*/
import javax.swing.*;
import java.awt.*;
class Main extends JPanel
{
    private static final int HEIGHT=750;
    private static final int WIDTH=1080;
    Ball ball;//reference to the Ball object which will be thrown into the earth
    Earth earth;// Reference to the Earth object

    public Main()
    {
        setSize(WIDTH,HEIGHT);//setting our window size
        earth=new Earth(WIDTH/2,HEIGHT/2);//placing earth at the center of our window
        ball=new Ball(earth);//Creating a new ball position is determined by the earth's position
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        earth.paint(g);
        ball.paint(g);

    }
    
    public void update()
    {
        ball.update();//updating balls position
    }

    public static void main(String args[])
    {
        JFrame f=new JFrame("Tunnel through earth");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(WIDTH,HEIGHT);
        Main main=new Main();
        f.add(main);
        f.setVisible(true);
        while(true)
        {
            main.update();
            main.repaint();
            try
            {
                Thread.sleep(20);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }

    }

}