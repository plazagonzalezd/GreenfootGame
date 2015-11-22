import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * creates a red shoot
 */
public class RedShot extends Shot
{
    public RedShot()
    {
        Greenfoot.playSound("laser.mp3"); //plays when it's created
    }
    
    public void act() 
    {
     actAsShot();
     move(30); //controls the speed
    }    
}
