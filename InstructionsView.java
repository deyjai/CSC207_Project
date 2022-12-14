/* AIHelperView
 * By: Dunia
 * Last Modified: 12/06/2022
 * Description: This class displays the interface for the AI Helper. It shows the options to access the instructions,
 * as well as change the colour contrast.
 */

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
 */

public class InstructionsView extends JFrame{
    public static void open() {
        //basics
        InstructionsView frame = new InstructionsView();

        //initialize and add the instructions panel
        JPanel instructionsPanel = new JPanel(); //BoxLayout can not be shared (meaning not allowed to be an attribute) so the JPanel has to be made here
        instructionsPanel.setLayout(new BoxLayout(instructionsPanel, BoxLayout.Y_AXIS));
        frame.setContentPane(instructionsPanel);

        //initialize objects for the instructions scroll pane - holds text field
        JTextArea instructionsText = new JTextArea();
        instructionsText.setLineWrap(true);
        instructionsText.setWrapStyleWord(true);
        instructionsText.setEditable(false);
        String newLine = "\n";
        instructionsText.append("Hello and thank you for using our physics simulator application! To understand the " +
                "application better, we will provide you with instructions here." + newLine + newLine + "At the very top is our menu" +
                "bar. You will have options to access statistics, save and load notebooks, read the instructions, change the colour of the " +
                "ball, as well the background. " + newLine + newLine + "For the Statistics menu, you can see the " +
                "history of the game which demonstrates the history of the plays in a table format, in time sensitive order. " +
                "The same applies for the summary option however, we see 3 different tables showcasing the Average, Maximum and Minimum values for " +
                "all kinematics parameters inputted." + newLine + newLine + "For the Notebook menu," +
                " you are able to output a notebook by clicking save and choosing the file to save the simulator data in. To input a notebook, " +
                "you can click choose file and pick file to load into simulator." + newLine + newLine +
                "The User Support menu allows for users to read " +
                "through the instructions" +
                newLine + newLine + "There are several things you can input to move the ball. You can type in a value for time," +
                " as well as for initial velocity, final velocity, acceleration, and displacement. To get the ball moving, click " +
                "the Start button and to stop it, click the stop button. If you want to reset all of the values, click the " +
                "Reset button.");

        //initialize and add the JScrollPane, add scrolling capability,
        // and putting instructionsText (text area) in instructionsScrollPane (scroll pane)
        JScrollPane instructionsScrollPane = new JScrollPane(instructionsText);
        instructionsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        instructionsScrollPane.setPreferredSize(new Dimension(250, 250));

        //changes from last week - exit to dispose, so the entire program doesn't terminate, only the particular window.
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        //some extra features
        frame.setTitle("Instructions");
        frame.setLocation(0, 0);
        frame.setSize(new Dimension(500, 400));

        //add all input objects to the first input panel
        instructionsPanel.add(instructionsScrollPane);
    }

}
