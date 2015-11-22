import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.*;

/**
 * An explosion that expands. It's created after the shots intersects an object
 * I borrowed some of the methods of the ballon project, and made a few changes.
 */
public class Explosion extends Actor
{
    /** How many images should be used in the animation of the explostion */
    private final static int IMAGE_COUNT= 8;
    
    /** 
     * The images in the explosion.
     */
    private GreenfootImage[] images;
    
    /** Current size of the explosion */
    private int size=0;
    
    /** How much do we increment the index in the explosion animation. */
    private int increment=1;    
    
    /** the shot that creates the explosion. The color of the explosion depends on this*/
    private Shot shot;
    
    public Explosion(Shot ishot) {
        shot = ishot;
        initialiseImages();
        setImage(images[0]);        
    }     
    
    /** 
     * Create the images for explosion.
     */
    public synchronized void initialiseImages() {
        if(images == null) {
            //the explosion depend on the shot
            GreenfootImage baseImage = new GreenfootImage("blackexplosion.png");
            if(shot instanceof GreenShot){ baseImage = new GreenfootImage("greenexplsion.png"); }
            if(shot instanceof RedShot){baseImage = new GreenfootImage("explosion.png");}
            int maxSize = baseImage.getWidth()*3;
            int delta = maxSize / (IMAGE_COUNT+1);
            int size = 0;
            images = new GreenfootImage[IMAGE_COUNT];
            for(int i=0; i < IMAGE_COUNT; i++) {
                size = size + delta;
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
        }
    }
    
    
    /**
     * EXPLODE!
     */
    public void act()
    { 
        setImage(images[size]);

        size += increment;
        if(size>=IMAGE_COUNT) {
            increment = -increment;
            size += increment;
        }
        
        if(size <= 0) {
            getWorld().removeObject(this);
        }
    }
}


