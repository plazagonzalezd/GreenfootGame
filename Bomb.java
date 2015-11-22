import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Behaves just like the targets, but if you pop it you loose.
 * It also rotates as it moves :)
 */
public class Bomb extends FlyingObject
{
    public void act() 
    {
        goUpDown();
        turn(10); //turns on itself
        removeIfBack();      
    }
}