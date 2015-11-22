import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hello, this is a very simple game, you control a cannon with the mouse.
 * The cannon follows the mouse and creates shots if the mouse is clicked.
 * You get points by hitting different targets, but be careful, if you hit a bomb
 * you are done. 
 * The cannon gets upgraded everytime you reach 150 points
 * 
 * Enjoy!
 * 
 * Created by Alex Plaza
 * July 17th, 2014
 */

public class CannonWorld extends World
{
    Counter counter = new Counter("Score: ");
    Cannon cannon= new Cannon1();
    boolean upgrade;
    public CannonWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setPaintOrder(ScoreBoard.class, Explosion.class,Aim.class, Cannon.class, Shot.class, FlyingObject.class, Counter.class);
        populate();
    }
    
    public void act()
    {
        if(counter.getValue() % 150 == 0 && counter.getValue() != 0 ) //ugprade every 150 points
        {
            counter.add(1); //This is needed so that the cannon does not upgrade several times
            upgradeCannon(); // changes the cannon
        }
        
        // creates a shot every time the mouse is clicked, the shot type depends on the current cannon
        if(Greenfoot.mouseClicked(null)){
            if(cannon instanceof Cannon1) addObject(new CannonBall(), 0, 400);
             if(cannon instanceof Cannon2) addObject(new RedShot(),0 , 400);
               if(cannon instanceof Cannon3) {
                   addObject(new GreenShot(), 0 , 400);
                   addObject(new GreenShot(), 5 , 400);
                   addObject(new GreenShot(), 10 , 400);
                }
        }
        
        //randomly creates different flying objects
        if(Greenfoot.getRandomNumber(100) < 3) {// objects are created horizontally between 80px and 530px
          if(Greenfoot.getRandomNumber(10) == 3){addObject(new Bomb(), Greenfoot.getRandomNumber(450) + 80, 400);}
          if(Greenfoot.getRandomNumber(10) <= 1){addObject(new BlueTarget(), Greenfoot.getRandomNumber(450) + 80, 400);}
          addObject(new RedTarget(), Greenfoot.getRandomNumber(450) + 80, 400);
        }
        
    }
    
    
    /**
     * changes the cannon to a better cannon
     */
    public void upgradeCannon()
    {
           
            if(cannon instanceof Cannon1){
            removeObject(cannon);
            cannon = new Cannon2();
            addObject(cannon, 0, 600);
            return;
           }
           
             if(cannon instanceof Cannon2){
            removeObject(cannon);
            cannon = new Cannon3();
            addObject(cannon, 0, 600);
            return;
           }
         
    }
    
    /**
     * add point to the counter depending on the flyingObject hit
     */
    public void countPop(FlyingObject flyingObject)
    {
        if(flyingObject instanceof RedTarget) counter.add(20);
        if(flyingObject instanceof BlueTarget) counter.add(50);
    }
     
    /**
     * populates the intial world
     */
    private void populate()
    {
        addObject(cannon, 0, 600);
        addObject(counter, 520, 30);
        addObject(new Aim(), 300,200);
    }  
    
    /**
     * ends the game and creates the most annoying sound one could ever hear
     */
    public void gameOver() 
    {
        addObject(new ScoreBoard(counter.getValue()), getWidth()/2, getHeight()/2);
        Greenfoot.playSound("buzz.wav");
        Greenfoot.stop();
    }
}
