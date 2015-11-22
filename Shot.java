import greenfoot.*;
/**
 * this class controls the general behavior of the shots
 */
public class Shot extends Actor
{
  //indicates if the direction of the shot is set
  protected boolean directionSet; 
  public Shot()
  {
      directionSet = false;
  }
  
  /**
   * sets the direction of the shot, according to the position
   * where the mouse is clicked.
   */
  public void setDirection()
  {
   MouseInfo mouse = Greenfoot.getMouseInfo();
   int x = mouse.getX();
   int y = mouse.getY();
   turnTowards(x, y);
   directionSet = true;
  }
  
  /**
   * first, it sets the direction of the shot.
   * then, if the shot touches a target, the target pops,
   * if it touches a bomb the game is over.
   */
  public void actAsShot()
  {
    if(!directionSet){
      setDirection();
     }
    FlyingObject flyingObject = (FlyingObject) getOneIntersectingObject(FlyingObject.class);
    if(getX() >= 599 || getY() <= 5) getWorld().removeObject(this);
     if(flyingObject != null) {
       if(flyingObject instanceof Bomb){
          ((CannonWorld) getWorld()).gameOver();
       }
      explosion(this); 
      flyingObject.pop();
      getWorld().removeObject(this);
    }
  }
  
  /**
   * creates an explosion that depends on the kind of shot
   */
  public void explosion(Shot shot)
    {
      getWorld().addObject(new Explosion(shot), getX(), getY());
    }
  
}