/* ButtonController
 * By: Jai Dey
 * Last Modified: 11/15/2022
 * Program decides what should be done when either the start, stop, or reset button is presset. Includes data validation. */

import java.awt.event.*;

public class ButtonController implements ActionListener
{
     //attributes
     private MasterView masterView; //stores a pointer to the MasterView
     private ObjectMotion motionModel; //stores a pointer to the motionModel

     private char missing1, missing2; //stores characters to identify the missing variable in the input field
     
     //constructor - initializes all attributes to their default values
     public ButtonController(MasterView master)
     {
          this.masterView = master;
          this.motionModel = this.masterView.getMotionModel();
          this.missing1 = ' ';
          this.missing2 = ' ';
     }//end constructor
     
     //actionPerformed method - this is called when a button is pressed
     public void actionPerformed(ActionEvent e)
     {
          //if start was pressed
          if(e.getActionCommand().equals("Start"))
          {
               try //accounts for any rare NumberFormatException
               {
                    
                    //tries to set a value for V1, if it is blank then it will be recorded as missing.
                    try
                    {
                         this.motionModel.setV1(Double.parseDouble(masterView.getInputField("v1").getText()));
                    }
                    catch(NumberFormatException ex)
                    {
                         if(this.missing1 == ' ')
                         {
                              this.missing1 = '1';
                         }
                         else
                         {
                              this.missing2 = '1';
                         }//end if
                    }//end try catch
                    
                    //tries to set a value for V2, if it is blank then it will be recorded as missing.
                    try
                    {
                         this.motionModel.setV2(Double.parseDouble(masterView.getInputField("v2").getText()));
                    }
                    catch(NumberFormatException ex)
                    {
                         if(this.missing1 == ' ')
                         {
                              this.missing1 = '2';
                         }
                         else
                         {
                              this.missing2 = '2';
                         }//end if
                    }//end try catch
                    
                    //tries to set a value for displacement, if it is blank then it will be recorded as missing.
                    try
                    {
                         this.motionModel.setDisplacement(Double.parseDouble(masterView.getInputField("displacement").getText()));
                    }
                    catch(NumberFormatException ex)
                    {
                         if(this.missing1 == ' ')
                         {
                              this.missing1 = 'd';
                         }
                         else
                         {
                              this.missing2 = 'd';
                         }//end if
                    }//end try catch
                    
                    //tries to set a value for time, if it is blank then it will be recorded as missing.
                    try
                    {
                         this.motionModel.setTime(Double.parseDouble(masterView.getInputField("time").getText()));
                    }
                    catch(NumberFormatException ex)
                    {
                         if(this.missing1 == ' ')
                         {
                              this.missing1 = 't';
                         }
                         else
                         {
                              this.missing2 = 't';
                         }//end if
                    }//end try catch
                    
                    //tries to set a value for acceleration, if it is blank then it will be recorded as missing.
                    try
                    {
                         this.motionModel.setAcceleration(Double.parseDouble(masterView.getInputField("acceleration").getText()));
                    }
                    catch(NumberFormatException ex)
                    {
                         if(this.missing1 == ' ')
                         {
                              this.missing1 = 'a';
                         }
                         else if (this.missing2 == ' ')
                         {
                              this.missing2 = 'a';
                         }
                    }//try catch
                    
                    
                    //if v1 and v2 are missing
                    if((this.missing1 == '1' || this.missing2 == '1') && (this.missing1 == '2' || this.missing2 == '2') )
                    {
                         //calculate missing calues
                         this.motionModel.setV1('2');
                         this.motionModel.setV2('1');
                    }
                    
                    //if v1 and a are missing
                    else if((this.missing1 == '1' || this.missing2 == '1') && (this.missing1 == 'a' || this.missing2 == 'a'))
                    {
                         //calculate missing values
                         this.motionModel.setV1('a');
                         this.motionModel.setAcceleration('1');
                    }
                    
                    //if v1 and d are missing
                    else if((this.missing1 == '1' || this.missing2 == '1') && (this.missing1 == 'd' || this.missing2 == 'd'))
                    {
                         //calculate missing values
                         this.motionModel.setV1('d');
                         this.motionModel.setDisplacement('1');
                    }
                    
                    //if v1 and t are missing
                    else if((this.missing1 == '1' || this.missing2 == '1') && (this.missing1 == 't' || this.missing2 == 't'))
                    {

                         //calculate missing values
                         this.motionModel.setV1('t');
                         this.motionModel.setTime('1');
                    }//end if
                    
                    //if v2 and a are missing
                    else if((this.missing1 == '2' || this.missing2 == '2') && (this.missing1 == 'a' || this.missing2 == 'a'))
                    {
                         //calculate missing values
                         this.motionModel.setV2('a');
                         this.motionModel.setAcceleration('2');
                    }//end if
                    
                    //if v2 and d are missing
                    else if((this.missing1 == '2' || this.missing2 == '2') && (this.missing1 == 'd' || this.missing2 == 'd'))
                    {
                         //calculate missing values and sent them to motion model
                         this.motionModel.setV2('d');
                         this.motionModel.setDisplacement('2');
                    }//end if
                    
                    //if v2 and t are missing
                    else if((this.missing1 == '2' || this.missing2 == '2') && (this.missing1 == 't' || this.missing2 == 't'))
                    {
                         //sets values of v2 and time after calculating them
                         this.motionModel.setV2('t');
                         this.motionModel.setTime('2');
                    }//end if
                    
                    //if a and d are missing
                    else if((this.missing1 == 'a' || this.missing2 == 'a') && (this.missing1 == 'd' || this.missing2 == 'd'))
                    {
                         //calculates and sets missing values to the motion model
                         this.motionModel.setAcceleration('d');
                         this.motionModel.setDisplacement('a');
                    }//end if
                    
                    //if a and t are missing
                    else if((this.missing1 == 'a' || this.missing2 == 'a') && (this.missing1 == 't' || this.missing2 == 't'))
                    {
                         //calculates and sets missing values to the motion model
                         this.motionModel.setTime('a');
                         this.motionModel.setAcceleration('t');
                    }//end if
                    
                    //if d and t are missing
                    else if((this.missing1 == 'd' || this.missing2 == 'd') && (this.missing1 == 't' || this.missing2 == 't'))
                    {
                         //calculates and sets missing values to the motion model
                         this.motionModel.setDisplacement('t');
                         this.motionModel.setTime('d');
                    }//if
                    
                    //sets text to calculated values in input fields
                    //Math.round(*100)/100 does not work using the setText() method so a custom string must be created
                    this.masterView.getInputField("displacement").setText("" + (int)motionModel.getDisplacement() + "." + ((int)(motionModel.getDisplacement()*100) % 100));
                    this.masterView.getInputField("acceleration").setText("" + (int)motionModel.getAcceleration() + "." + ((int)(motionModel.getAcceleration()*100) % 100));
                    this.masterView.getInputField("v1").setText("" + (int)motionModel.getV1() + "." + ((int)(motionModel.getV1()*100) % 100));
                    this.masterView.getInputField("v2").setText("" + (int)motionModel.getV2() + "." + ((int)(motionModel.getV2()*100) % 100));
                    this.masterView.getInputField("time").setText("" + (int)motionModel.getTime() + "." + ((int)(motionModel.getTime()*100) % 100));

                    DataModel.setParameters(motionModel.getDisplacement(), motionModel.getAcceleration(), motionModel.getV1(), motionModel.getV2(), motionModel.getTime());

                    //sets the motion state in the master view to true. Now the program can start animation
                    this.masterView.setMotionState(true);
               }
               
               //if the rare error occurred, all text boxes will be set to invalide
               catch(NumberFormatException ex)
               {
                    this.masterView.getInputField("displacement").setText("Invalid");
                    this.masterView.getInputField("acceleration").setText("Invalid");
                    this.masterView.getInputField("v1").setText("Invalid");
                    this.masterView.getInputField("v2").setText("Invalid");
                    this.masterView.getInputField("time").setText("Invalid");
               }//end try catch
               
               //set all input boxes to disabled after button is pressed so user can't edit data mid simulation
               this.masterView.getInputField("displacement").setEnabled(false);
               this.masterView.getInputField("acceleration").setEnabled(false);
               this.masterView.getInputField("v1").setEnabled(false);
               this.masterView.getInputField("v2").setEnabled(false);
               this.masterView.getInputField("time").setEnabled(false);
          }//end if
          
          //if the user clicked the stop button, the pause button in the motion model is set to true, stops the program from moving
          else if(e.getActionCommand().equals("Stop"))
          {
               this.motionModel.setPause(true);
          }//end if
          
          //if the reset button is clicked
          else if(e.getActionCommand().equals("Reset"))
          {
               //all values from the motionModel are reset
               this.motionModel.reset();
               
               //all input fields are cleared
               this.masterView.getInputField("displacement").setText(null);
               this.masterView.getInputField("acceleration").setText(null);
               this.masterView.getInputField("v1").setText(null);
               this.masterView.getInputField("v2").setText(null);
               this.masterView.getInputField("time").setText(null);
               
               //all input fields are enabled, allowing the user to enter a second set of values if needed.
               this.masterView.getInputField("displacement").setEnabled(true);
               this.masterView.getInputField("acceleration").setEnabled(true);
               this.masterView.getInputField("v1").setEnabled(true);
               this.masterView.getInputField("v2").setEnabled(true);
               this.masterView.getInputField("time").setEnabled(true);
               
               //stops the motion state
               this.masterView.setMotionState(false);
               
               //resets value for pause
               this.motionModel.setPause(false);
          }//end if
          
          //program resets missing values for next use
          this.missing1 = ' ';
          this.missing2 = ' ';
     }//end actionPerformed method
     
}//end of class - ButtonController