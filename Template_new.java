/* Template
 * By: Insert Name Here
 * Last Modified: 11/15/2022
 * Insert Description Here */

import javax.swing.*;
import java.awt.*;

/*
This will be your GUI. If you're making a model class, DO NOT mix it with this class. You'll need to create a separate
model class, and this class will hold a pointer, so you can access it.

For now, you should make your appropriate set/get methods and assume these methods will give you the info you need.
Again, PLEASE don't make multiple attributes for your kinematics parameters if you're using them.
    - If you're doing the DataModel class, there should be one private ArrayList <double[]> attribute that holds the
    history of all kinematics parameters. You only need one set method (with a parameter for each kinematics value) and
    one get method for this.
    - If any other class needs kinematics parameters, it should have an attribute that points to the DataModel class.
    You can get everything you need using one of the DataModel's get methods.
    - If you need to directly access one of the components in MasterView (this will likely only be for the Audio/AIHelper
    class), you should make an attribute that points to MasterView.

* As for controllers, you can pretend they don't exist for now. Just make an input component (ex. JButton) and a method
that you want to be executed when that button is called.

public class Template_new extends JFrame
{
    public static void open()
    {
        //basics
        Template_new frame = new Template_new();
        JPanel panel = new JPanel(new BorderLayout());
        frame.setContentPane(panel);

        //changes from last week - exit to dispose, so the entire program doesn't terminate, only the particular window.
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        //some extra features
        frame.setTitle("Mission Engine");
        frame.setLocation(0,0);
        frame.setSize(new Dimension(500, 500));

        //adding basic components
        JButton button = new JButton("X Marks The Spot");
        panel.add(button, BorderLayout.PAGE_START);

        //adding custom components
        JComponent component = new JComponent() {

            //Note - whenever you resize the screen, the component calls the repaint() method, which calls the
            //paintComponent method again. This is why the lines "move" as you play with the margins.
            @Override
            public void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);

                //set the color to red and draw a diagonal line
                graphics.setColor(Color.RED);
                graphics.drawLine(0, 0, this.getWidth(), this.getHeight());

                //set the color to blue and draw an opposite diagonal line
                graphics.setColor(Color.BLUE);
                graphics.drawLine(0, this.getHeight(), this.getWidth(), 0);
            }
        };
        panel.add(component, BorderLayout.CENTER);
    }
}



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class InputNotebook extends JFrame implements ActionListener {

    private DataModel dataModel;
    public MasterView masterView;

   public JComboBox colorChooser;
   public JPanel redBox, blueBox, greenBox, yellowBox;
   private int amount;

   private String[] attempts;
    public InputNotebook() {
        this.masterView = masterView;
        this.dataModel = dataModel;
        //this.amount = this.dataModel.kinematicsParameters.size();
    }

    public JPanel createContentPane(){

        JPanel totalGUI = new JPanel();

        // To create a JComboBox, we need to pass in an array of Strings.
        // This gives the ComboBox the list of selections you can make.
        this.amount = 10;
        String[] attempts =new String[this.amount];
        int i = 0;
        int number = 1;
        while (i < this.amount) {
            attempts[i] = "Attempt " + String.valueOf(number);
            i++;
            number++;
        }
        this.attempts = attempts;

        String colors[] = this.attempts;

        colorChooser = new JComboBox(colors);
        colorChooser.setSelectedIndex(1);
        colorChooser.addActionListener(this);



        // This sets all bar the blue box to be hidden.


        // This sets the widgets on the screen to be layed out in a
        // top to bottom fashion with spacers inbetween.

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));

        bottomPanel.add(Box.createRigidArea(new Dimension(0,10)));
        bottomPanel.add(colorChooser);
        bottomPanel.add(Box.createRigidArea(new Dimension(0,20)));
        bottomPanel.add(Box.createRigidArea(new Dimension(0,10)));

        totalGUI.add(bottomPanel);

        totalGUI.setOpaque(true);
        return totalGUI;
    }



    // This actionPerformed simply takes sets the visibility of each
    // coloured box depending on what is selected on the combo box.

    public void actionPerformed(ActionEvent e) {

        int temp;

        if(e.getSource() == colorChooser)
        {

            temp = colorChooser.getSelectedIndex();
            //System.out.println(temp);
            double[] hi;
            hi = DataModel.kinematicsParameters.get(temp);
            //DOES THIS ACCESS TEH RIGHT THING
            double dis = hi[0];
            double acc = hi[1];
            double v1 = hi[2];
            double v2 = hi[3];
            double time = hi[4];

            this.masterView.inputTime.setText(String.valueOf(time));
            this.masterView.inputInitialV.setText(String.valueOf(v1));
            this.masterView.inputFinalV.setText(String.valueOf(v2));
            this.masterView.inputAcceleration.setText(String.valueOf(acc));
            this.masterView.inputDisplacement.setText(String.valueOf(dis));


        }
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("View Attempts");

        InputNotebook demo = new InputNotebook();
        frame.setContentPane(demo.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void open() {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
*/