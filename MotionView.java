/* MotionView
 * By: Jai Dey
 * Last Modified: 11/15/2022
 * View class for the animation. Draws the background and object based on the values from the objectMotion class*/

import java.awt.*;
import javax.swing.*;

public class MotionView extends JComponent 
{
     //attributes
     private ObjectMotion model; //instance for model
     private Image image; //image for background
     private String color; //colour for the object 
     private int startingHeight; //starting height for the object 
     private String compass; //compass string for direction
     
     //constructor - initializes attributes
     public MotionView(ObjectMotion o)
     {
          this.model = o;
          this.model.setGUI(this); 
          this.setPreferredSize(new Dimension(700, 400));
          this.image = new ImageIcon("images/standard.jpg").getImage();
          this.color = "black"; 
          this.startingHeight = 309;
     }//end constructor
     
     //setColor method - changes color to the parameter string 
     public void setColor(String s) 
     { 
          this.color = s; 
     } 
     
     //paintComponent method - draws the object relative to the position from the model
     protected void paintComponent(Graphics g)
     {
          super.paintComponent(g);
          
          //background
          g.drawImage(this.image, 0, 0, null);
          
          //changes compass text based on direction
          if(model.getMotionModifier() >= 0)
          {
               this.compass = "Direction = EAST";
          }
          else
          {
               this.compass = "Direction = WEST";
          }//end if
          
          //moves object to start of screen if it reaches the end
          if(model.getMotionModifier() >= 0 && model.getMotionOffset() >= this.getWidth()) 
          {
               model.setMotionOffset(0); 
          } 
          else if(model.getMotionModifier() < 0 && model.getMotionOffset() <= 0) 
          { 
               model.setMotionOffset(this.getWidth()); 
          }//end if
          
          //sets colour based on input 
          if(this.color.equals("red")) 
          { 
               g.setColor(Color.RED); 
          } 
          else if(this.color.equals("blue"))
          { 
               g.setColor(Color.BLUE);
          } 
          else if(this.color.equals("green"))
          { 
               g.setColor(Color.GREEN); 
          } 
          else if(this.color.equals("white"))
          { 
               g.setColor(Color.WHITE);
          } 
          else if(this.color.equals("black"))
          { 
               g.setColor(Color.BLACK); 
          } 
          
          g.fillOval(model.getMotionOffset(), this.startingHeight, 40, 40);

          g.setFont(new Font( "SansSerif", Font.PLAIN, 18 ));
          g.drawString(compass, 550, 115); //Draws compass at a set position on the screen
     }//end paintComponent
     
     //setBackgroundMario - sets the backround to mario theme (created by Jai
     public void setBackgroundMario() 
     { 
          this.startingHeight = 299; 
          this.image = new ImageIcon("images/mario.png").getImage(); 
          this.repaint(); 
     }//end setBackgroundMario 
     
     //setBackgroundStandard - sets the background to standard theme (created by Jai)
     public void setBackgroundStandard() 
     { 
          this.startingHeight = 309; 
          this.image = new ImageIcon("images/standard.jpg").getImage(); 
          this.repaint(); 
     }//end setBackgroundStandard 
     
}//end of class - MotionView