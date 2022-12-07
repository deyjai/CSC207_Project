/* MasterView
 * By: Jai Dey
 * Last Modified: 11/15/2022
 * Program extends a JFrame and displays all Views and a MenuBar in order to display the simulation. All JComponents are created as attributes to allow
 access to other classes if needed. */

import javax.swing.*;
import java.awt.*;

public class MasterView extends JFrame
{
     /**** ATTRIBUTES ****/

     //menu bar
     private JMenuBar menuBar; //stores an instance of the menu bar

     private JMenu colourMenu, helpMenu, backgroundMenu, templateMenu; //stores all menus in the menu bar

     private JMenuItem colour1, colour2, colour3, colour4, colour5; //menu items for object colours
     private JMenuItem userManual, donateHere; //menu items for the help menu
     private JMenuItem standardBackground, marioBackground; //menu items for backgrounds
     private JMenuItem templateItem; //menu item(s) for the template

     //main panels
     private JPanel mainPanel; //holds everything except the menu bar
     private JPanel outputPanel; //holds the motion
     private JPanel inputPanelHolder; //holds input panels
     private JPanel inputPanel2; //this is a second instance of an input panel - the other one is initialized in the drawLayout method
     
     //motion
     private MotionView motionView; //GUI for the animated motion
     private ObjectMotion motionModel; //model for the animated motion
     private boolean motionState; //will start animation if this is true
     
     //used for user input
     private JPanel time, initialV, finalV, acceleration, displacement; //panels to hold each prompt and input - stored in an input panel
     private JLabel promptTime, promptInitialV, promptFinalV, promptAcceleration, promptDisplacement; //labels for prompts
     private JTextField inputTime, inputInitialV, inputFinalV, inputAcceleration, inputDisplacement; //text fields for input
     
     //command buttons for the simulation
     private JButton start;
     private JButton stop;
     private JButton reset;


     //constructor - Initializes and starts the program. It will start looking for an input once initialized
     public MasterView()
     {
          super();
          this.drawLayout();
          this.registerControllers();
          this.setCharacteristics();
          this.motionState = false;
     }//end constructor
     
     /**** ACCESSOR METHODS ****/
     
     //getInputField method - returns a specific input field based on the parameter string
     public JTextField getInputField(String s)
     {
          if(s.equals("v1"))
          {
               return this.inputInitialV;
          }
          else if(s.equals("v2"))
          {
               return this.inputFinalV;
          }
          else if(s.equals("time"))
          {
               return this.inputTime;
          }
          else if(s.equals("acceleration"))
          {
               return this.inputAcceleration;
          }
          else if(s.equals("displacement"))
          {
               return this.inputDisplacement;
          }
          else
          {
               throw new RuntimeException("Cannot find input field(s)");
          }//end if
     }//end getInputField

     //getMotionView method
     public MotionView getMotionView()
     {
          return this.motionView;
     }//end getMotionView
     
     //getMotionModel method
     public ObjectMotion getMotionModel()
     {
          return this.motionModel;
     }//end getMotionModel
     
     //setMotionState method
     public void setMotionState(boolean b)
     {
          this.motionState = b;
     }//end setMotionState
     
     /**** HELPER METHODS ****/

     //drawLayout method - draws the main panel and menu bar
     private void drawLayout()
     {
          this.drawPanel();
          this.drawMenu();
     }//end drawLayout
     
     //drawPanel method - draws the main panel, consisting of the motion output and all input fields
     private void drawPanel()
     {
          //initialize panels
          this.mainPanel = new JPanel(new BorderLayout()); //main panel of this frame
          this.outputPanel = new JPanel(); //output panel of this frame
          
          //initialize motion objects
          this.motionModel = new ObjectMotion();
          this.motionView = new MotionView(this.motionModel);
          
          //add above objects to the main panel
          this.outputPanel.add(this.motionView);
          this.mainPanel.add(this.outputPanel, BorderLayout.WEST);
          
          //initialize input panel holder
          this.inputPanelHolder = new JPanel(new GridLayout(2,1));
          this.mainPanel.add(inputPanelHolder, BorderLayout.EAST);
          
          //initialize and add the first input panel
          JPanel inputPanel = new JPanel(); //BoxLayout can not be shared (meaning not allowed to be an attribute) so the JPanel has to be made here
          inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
          this.inputPanelHolder.add(inputPanel);

          //initialize and add the second input panel
          this.inputPanel2 = new JPanel(new GridLayout(3,1));
          this.inputPanelHolder.add(inputPanel2);
          
          //initialize objects for the first input panel - holds textfields and labels
          this.time = new JPanel();
          this.initialV = new JPanel();
          this.finalV = new JPanel();
          this.acceleration = new JPanel();
          this.displacement = new JPanel();
          
          //labels - prompts for input
          this.promptTime = new JLabel("                Time:");
          this.promptInitialV = new JLabel("Initial Velocity:");;
          this.promptFinalV = new JLabel("Final Velocity:");;
          this.promptAcceleration = new JLabel(" Acceleration:");;
          this.promptDisplacement = new JLabel("Displacement:");;
          
          //text fields - input
          this.inputTime = new JTextField(4);
          this.inputInitialV = new JTextField(4);
          this.inputFinalV = new JTextField(4);
          this.inputAcceleration = new JTextField(4);
          this.inputDisplacement = new JTextField(4);
          
          //add all inputs to their input objects
          this.time.add(this.promptTime);
          this.time.add(this.inputTime);
          this.initialV.add(this.promptInitialV);
          this.initialV.add(this.inputInitialV);
          this.finalV.add(this.promptFinalV);
          this.finalV.add(this.inputFinalV);
          this.acceleration.add(this.promptAcceleration);
          this.acceleration.add(this.inputAcceleration);
          this.displacement.add(this.promptDisplacement);
          this.displacement.add(this.inputDisplacement);
          
          //add all input objects to the first input panel
          inputPanel.add(this.time);
          inputPanel.add(this.initialV);
          inputPanel.add(this.finalV);
          inputPanel.add(this.acceleration);
          inputPanel.add(this.displacement);
          
          //initialize command buttons for the second input panel
          this.start = new JButton("Start");
          this.reset = new JButton("Reset");
          this.stop = new JButton("Stop");
          
          //add buttons to the second input panel
          this.inputPanel2.add(start);
          this.inputPanel2.add(stop);
          this.inputPanel2.add(reset);
          
          //set the content pane the main panel
          this.setContentPane(this.mainPanel);
     }//end drawPanel
     
     //drawMenu - creates the menu bar
     private void drawMenu()
     {
          //initializes the menu bar
          this.menuBar = new JMenuBar();
          
          //initializes all menus in the menu bar
          this.helpMenu = new JMenu("Help");
          this.colourMenu = new JMenu("Colours");
          this.backgroundMenu = new JMenu("Backgrounds");
          this.templateMenu = new JMenu("Templates");

          //initializes the menu item that opens up the template
          this.templateItem = new JMenuItem("Open Template 1");
          this.templateMenu.add(this.templateItem);

          //initializes the menu items for colour and adds them to the menu
          this.colour1 = new JMenuItem("Red");
          this.colour2 = new JMenuItem("Blue");
          this.colour3 = new JMenuItem("Green");
          this.colour4 = new JMenuItem("White");
          this.colour5 = new JMenuItem("Black");
          this.colourMenu.add(colour1);
          this.colourMenu.add(colour2);
          this.colourMenu.add(colour3);
          this.colourMenu.add(colour4);
          this.colourMenu.add(colour5);
          
          //initializes the help menu
          this.userManual = new JMenuItem("User Manual");
          this.donateHere = new JMenuItem("Donate Here");
          this.helpMenu.add(this.userManual);
          this.helpMenu.add(this.donateHere);
         
          //initializes the background menu items
          this.marioBackground = new JMenuItem("Mario Theme");
          this.standardBackground = new JMenuItem("Standard Theme");
          this.backgroundMenu.add(this.marioBackground);
          this.backgroundMenu.add(this.standardBackground);
          
          //adds all menus to the menu bar
          this.menuBar.add(this.templateMenu);
          this.menuBar.add(this.colourMenu);
          this.menuBar.add(this.backgroundMenu);
          this.menuBar.add(this.helpMenu);
     }//draws the menu
     
     //setCharacteristics method - sets the basic attributes of the JFrame
     private void setCharacteristics()
     {
          this.setJMenuBar(this.menuBar);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.pack();
          this.setTitle("Mission Engine");
          this.setVisible(true);
          this.setResizable(false);
          this.setLocationRelativeTo(null);
     }//end setCharacteristics
     
     //registerControllers method - adds listeners to all input options
     private void registerControllers()
     {
          //template menu items
          this.templateItem.addActionListener(new MenuItemController(this));

          //colour menu items
          this.colour1.addActionListener(new MenuItemController(this));
          this.colour2.addActionListener(new MenuItemController(this));
          this.colour3.addActionListener(new MenuItemController(this));
          this.colour4.addActionListener(new MenuItemController(this));
          this.colour5.addActionListener(new MenuItemController(this));
          
          //help menu items
          this.donateHere.addActionListener(new MenuItemController(this));
          this.userManual.addActionListener(new MenuItemController(this));
                    
          //background menu items
          this.marioBackground.addActionListener(new MenuItemController(this));
          this.standardBackground.addActionListener(new MenuItemController(this));
          
          //command buttons menu items
          this.start.addActionListener(new ButtonController(this));
          this.stop.addActionListener(new ButtonController(this));
          this.reset.addActionListener(new ButtonController(this));
     }//end registerControllers
     
     /**** COMMANDS ****/

     //start method - program checks for start
     public void start()
     {
          while(true)
          {
               //wait 300 ms in between each check
               try
               {
                    Thread.sleep(300);
               }
               catch (InterruptedException ex)
               {
                    
               }
               
               //start simulation
               if(this.motionState)
               {
                    this.motionModel.move();
                    this.motionState = false;
               }//end if
          }//end while
     }//end start
     
     //main method
     public static void main(String[] args)
     {
          new MasterView().start();
     }//end main method
}//end of class - MasterView