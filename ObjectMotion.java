/* ObjectMotion
 * By: Jai Dey
 * Last Modified: 11/15/2022
 * Model class for the motion of the object. Performs calculations and stores values for all kinematics vectors. */

public class ObjectMotion
{
     //attributes
     private MotionView view; //stores a pointer the GUI
     private double velocity1, velocity2, acceleration, displacement, time; //each kinematics variable
     private boolean isPaused; //stores a value based on if the program is paused or not
     
     private int motionOffset; //position for the object to be drawn at
     private double motionModifier; //number of pixels the object is going to be moving
     
     //constructor - initializes the attributes
     public ObjectMotion()
     {
          this.motionOffset = 60;
          this.isPaused = false;
     }//end constructor

     //setGUI method - used to store a pointer in the motionView
     public void setGUI(MotionView gui)
     {
          this.view = gui;
     }//end constructor

     /**** Accessor Methods ****/

     //setV1 method
     public void setV1(double d)
     {
          this.velocity1 = d;
     }///end setV1

     //setV2
     public void setV2(double d)
     {
          this.velocity2 = d;
     }//end setV2

     //setAcceleration
     public void setAcceleration(double d)
     {
          this.acceleration = d;
     }//end setAcceleration

     //setDisplacement
     public void setDisplacement(double d)
     {
          this.displacement = d;
     }//end setDisplacement

     //setTime
     public void setTime(double d)
     {
          this.time = d;
     }//end setTime

     //setPause (Created by Jai)
     public void setPause(boolean b)
     {
          this.isPaused = b;
     }//end setPause

     //getV1
     public double getV1()
     {
          return this.velocity1;
     }//end getV1

     //getV2
     public double getV2()
     {
          return this.velocity2;
     }//end getV2

     //getAcceleration
     public double getAcceleration()
     {
          return this.acceleration;
     }//end getAcceleration

     //getDisplacement
     public double getDisplacement()
     {
          return this.displacement;
     }//end getDisplacement

     //getTime
     public double getTime()
     {
          return this.time;
     }//end getTime

     //getMotionView (coded by Jai)
     public MotionView getMotionView()
     {
          return this.view;
     }//end getMotionView

     //getMotionModifier
     public double getMotionModifier()
     {
          return this.motionModifier;
     }//end getMotionModifier

     //getMotionOffset
     public int getMotionOffset()
     {
          return this.motionOffset;
     }//end getMotionOffset

     //setMotionOffeset
     public void setMotionOffset(int x)
     {
          this.motionOffset = x;
     }//end setMotionOffset

     //setDisplacement method - calculates displacement based on the missing variable
     public void setDisplacement(char missing)
     {
          //v2 is missing
          if (missing == '2')
          {
               this.displacement = this.velocity1 * this.time + 0.5 * this.acceleration * this.time * this.time;
          }

          //v1 is missing
          else if (missing == '1')
          {
               this.displacement = this.velocity2 * this.time - 0.5 * this.acceleration * this.time * this.time;
          }

          //a is missing
          else if (missing == 'a')
          {
               this.displacement = (this.time * (this.velocity1 + this.velocity2)) / 2;
          }

          //t is missing
          else if (missing == 't')
          {
               this.displacement = ((this.velocity2 * this.velocity2)-(this.velocity1 * this.velocity1)) / (2 * this.acceleration);
          }//end if
     }//end setDisplacement

     //setAccleration method - calculates and sets acceleration based on missing variable
     public void setAcceleration(char missing)
     {
          //if d is missing
          if (missing == 'd')
          {
               this.acceleration = (this.velocity2 - this.velocity1) / this.time;
          }

          //if time is missing
          else if (missing == 't')
          {
               this.acceleration = (this.velocity2 * this.velocity2 - this.velocity1 * this.velocity1) / 2 * this.displacement;
          }

          //if v1 is missing
          else if (missing == '1')
          {
               this.acceleration = (this.displacement - this.velocity2 * this.time) / (-1)*0.5 * this.time * this.time;
          }

          ///if v2 is missing
          else if (missing == '2')
          {
               this.acceleration = (this.displacement - this.velocity1 * this.time) / (0.5 * this.time * this.time);
          }
     }//end setAcceleration

     //setTime method - calculates and sets time based on missing character
     public void setTime(char missing)
     {
          //quadratic formula variables
          double a, b, c;

          //if d is missing
          if (missing == 'd')
          {
               this.time = (this.velocity2 - this.velocity1) / this.acceleration;
          }

          //if a is missing
          else if (missing == 'a')
          {
               this.time = 2 * this.displacement /(this.velocity1 + this.velocity2);
          }

          //if v1 is missing
          else if (missing == '1')
          {
               a = 0.5 * this.acceleration;
               b = this.velocity1;
               c = this.displacement*-1;

               this.time = ((-1*b) + Math.sqrt((b*b)-4*a*c)) / (2*a);
          }

          //if v2 is missing
          else if (missing == '2')
          {
               a = -1 * 0.5 * this.acceleration;
               b = this.velocity2;
               c = this.displacement *-1;

               this.time = ((-1*b) + Math.sqrt((b*b)-4*a*c)) / (2*a);
          }//end if
     }//end setTime

     //setV1 method - calculates and sets v1 based on the missing variables
     public void setV1(char missing)
     {
          //if a is missing
          if (missing == 'a')
          {
               this.velocity1 = 2 * this.displacement/this.time - this.velocity2;
          }

          //if d is missing
          else if (missing == 'd')
          {
               this.velocity1 = this.velocity2 - this.acceleration * this.time;
          }

          //if t is missing
          else if (missing == 't')
          {
               this.velocity1 = Math.sqrt((this.velocity2 * this.velocity2)-2 * this.acceleration * this.displacement);
          }

          //if v2 is missing
          else if (missing == '2')
          {
               this.velocity1 = (this.displacement - 0.5 * this.acceleration * this.time * this.time) / this.time;
          }//end if

     }//end setV1

     //end setV2
     public void setV2(char missing)
     {
          //if a is missing
          if (missing == 'a')
          {
               this.velocity2 = 2 * this.displacement/this.time - this.velocity1;
          }

          //if d is missing
          else if (missing == 'd')
          {
               this.velocity2 = this.velocity1 + this.acceleration * this.time;
          }

          //if t is missing
          else if (missing == 't')
          {
               this.velocity2 = Math.sqrt((this.velocity1 * this.velocity1) + 2 * this.acceleration * this.displacement);
          }

          //if v1 is missing
          else if (missing == '1')
          {
               this.velocity2 = (this.displacement + 0.5 * this.acceleration * this.time * this.time) / this.time;
          }//end if

     }//end setV2

     /**** HELPER METHODS - CREATED BY JAI DEY ****/

     //reset method - resets all variables and repaints the screen (created by Jai)
     public void reset()
     {
          this.displacement = 0;
          this.acceleration = 0;
          this.time = 0;
          this.velocity1 = 0;
          this.velocity2 = 0;
          this.motionOffset = 60;
          this.motionModifier = 0;
          view.repaint();
     }//end reset

     //move method - makes the object move through a loop
     public void move()
     {
          //temp variables
          double totalTimeMillis = this.time * 1000 + System.currentTimeMillis(); //holds the total time for simulation
          double startTimeMillis = System.currentTimeMillis();  //holds the start time for simulation

          //while loop that the program runs in
          while(System.currentTimeMillis() < totalTimeMillis)
          {
               //if the program is paused, loop breaks and animation stops (Created by Jai)
               if(this.isPaused)
               {
                    break;
               }//end if

               //formulas and calculations for the movement of the object (Created by Jai)
               this.motionModifier = this.acceleration * ((System.currentTimeMillis() - startTimeMillis)/1000) + this.velocity1;
               this.motionOffset = this.motionOffset + (int)(this.motionModifier); 
               
               //sleep for 20 ms
               try
               {
                    Thread.sleep(20);
               }
               catch (InterruptedException ignored)
               {
                    
               }
               
               //repaint
               this.view.repaint(); 
          }//end while
          
     }//end move method
     
}//end of class - ObjectMotion