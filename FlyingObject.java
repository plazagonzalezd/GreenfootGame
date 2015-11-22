import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This super class controls the behavior of all Flying objects.
 * 
 */
public class FlyingObject extends Actor
{
    protected int speed; //controls the speed of the object
    public FlyingObject()
    {
        speed = -24; // it simulates gravity
    } 
    
    /**
     * pops the flying object
     */
    public void pop() 
    {
        Greenfoot.playSound("pop.mp3");
        ((CannonWorld) getWorld()).countPop(this);
        getWorld().removeObject(this);
    } 
    
    /**
     * creates the motion of the flying objects
     */
    public void goUpDown()
    {
        speed = speed + 1;
         setLocation(getX(), getY() + speed);
    }
    
    /**
     * if the flyingObject is back to where it started, removes it.
     */
    public void removeIfBack()
    {
        if (getY() == 399) {
        getWorld().removeObject(this);
        }
    }
}
