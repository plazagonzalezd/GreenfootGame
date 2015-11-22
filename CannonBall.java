import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * creates a cannon ball
 */
public class CannonBall extends Shot
{
    public CannonBall()
    {
        Greenfoot.playSound("fire.mp3"); // play this sound when it's created
    }
    public void act() 
    {
        actAsShot();
        move(20); // controls the speed
        turn(2); // makes it move in a parabolic fashion
    }    
}
