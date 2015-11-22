import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Behaves the same as the red target, but it is smaller, and it gives you 50 poins when poped
 */
public class BlueTarget extends FlyingObject
{
    public void act() 
    {
         goUpDown();
         removeIfBack();
    }    
}
