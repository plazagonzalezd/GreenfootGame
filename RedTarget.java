import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedTarget here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedTarget extends FlyingObject
{
    /**
     * Act - do whatever the RedTarget wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         goUpDown();
         removeIfBack();
    } 
}
