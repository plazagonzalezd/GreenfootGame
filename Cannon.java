import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cannon extends Actor
{
    /**
     * dictates the behavior of the cannon, all cannons behave exactly the same
     */
    public Cannon()
    {
        turnTowards(400, -200);
    }
    
    public void actAsCannon()
    {
        //Follow the mouse
        if(Greenfoot.mouseMoved(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            turnTowards(mouse.getX(), mouse.getY());
        }
    }
}
