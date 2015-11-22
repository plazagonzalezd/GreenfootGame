import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * creates a green shot
 */
public class GreenShot extends Shot
{
    public GreenShot()
    {
        Greenfoot.playSound("laser.mp3"); // plays sound when it's created
    }
    public void act() 
    {
        actAsShot(); 
        move(60); // this is how fast it goes
    }    
}
