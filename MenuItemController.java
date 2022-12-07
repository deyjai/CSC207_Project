/* MenuItemController
 * By: Jai Dey
 * Last Modified: 11/15/2022
 * Controller class that decides what to do when a menu item is clicked in Mission Engine. */

import java.awt.event.*;
import java.net.*;
import java.io.*;

public class MenuItemController implements ActionListener
{
     //attributes
     private MasterView masterView; //holds a pointer to the MasterView class
     
     //constructor - creates instance of MenuItemController
     public MenuItemController(MasterView m)
     {
          this.masterView = m;
     }//end constructor
     
     //actionPerformed method - performs this action when a menu item is clicked
     public void actionPerformed(ActionEvent e)
     {
          //if user manual is clicked - link to manual is opened
          if(e.getActionCommand().equals("Red"))
          {
               masterView.getMotionView().setColor("red");
               masterView.getMotionView().repaint();
          }
          
          //if blue colour is chosen - sets object to blue
          else if(e.getActionCommand().equals("Blue"))
          {
               masterView.getMotionView().setColor("blue");
               masterView.getMotionView().repaint();
          }
          
          //if blue colour is chosen - sets object to blue
          else if(e.getActionCommand().equals("Green"))
          {
               masterView.getMotionView().setColor("green");
               masterView.getMotionView().repaint();
          }
          
          //if white colour is chosen - sets object to white
          else if(e.getActionCommand().equals("White"))
          {
               masterView.getMotionView().setColor("white");
               masterView.getMotionView().repaint();
          }
          
          //if black colour is chosen - sets object to black
          else if(e.getActionCommand().equals("Black"))
          {
               masterView.getMotionView().setColor("black");
               masterView.getMotionView().repaint();
          }

          //if mario theme is chosen - sets background to mario
          else if(e.getActionCommand().equals("Mario Theme"))
          {
               this.masterView.getMotionView().setBackgroundMario();
          }
          
          //if standard theme is chosen - sets background to standard
          else if(e.getActionCommand().equals("Standard Theme"))
          {
               this.masterView.getMotionView().setBackgroundStandard();
          }

          //if the template is chosen - opens a Template JFrame with a static method
          else if(e.getActionCommand().equals("Summary"))
          {
               //Template.open();
          }
          //if the template is chosen - opens a Template JFrame with a static method
          else if(e.getActionCommand().equals("History"))
          {
               //Template.open();
          }
          //if the template is chosen - opens a Template JFrame with a static method
          else if(e.getActionCommand().equals("Audio"))
          {
               //Template.open();
          }
          //if the template is chosen - opens a Template JFrame with a static method
          else if(e.getActionCommand().equals("AI Helper"))
          {
               //Template.open();
          }
          else if(e.getActionCommand().equals("Save"))
          {
               //Template.open();
          }
          else if(e.getActionCommand().equals("Load"))
          {
               //Template.open();
          }
     }//end actionPerformed
     
}//end of class - MenuItemController