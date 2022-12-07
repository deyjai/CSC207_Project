/* Colour Contrast View
 * By: Dunia
 * Last Modified: 12/07/2022
 * Description: This class displays the interface for the change in color contrast of this application.
 * It shows the options to increase and decrease brightness.
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

public class ColourContrastView extends JFrame {
    public static void open() {
        //initializes a new instance of the class MusicAudio
        ColourContrastView frame = new ColourContrastView();

        //initialize and add the audio panel
        JPanel colourContrastPanel = new JPanel(); //BoxLayout can not be shared (meaning not allowed to be an attribute) so the JPanel has to be made here
        colourContrastPanel.setLayout(new BoxLayout(colourContrastPanel, BoxLayout.Y_AXIS));
        frame.setContentPane(colourContrastPanel);

        //initialize objects for the audio panel - holds text fields and sliders
        JPanel buttonPanel = new JPanel();

        //changes from last week - exit to dispose, so the entire program doesn't terminate, only the particular window.
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        //some extra features
        frame.setTitle("Colour Contrast");
        frame.setLocation(0, 0);
        frame.setSize(new Dimension(500, 200));

        //buttons
        JButton increaseBrightness = new JButton("Increase Brightness");
        JButton decreaseBrightness = new JButton("Decrease Brightness");


        //add all inputs to their input objects
        buttonPanel.add(increaseBrightness);
        buttonPanel.add(decreaseBrightness);


        //add all input objects to the first input panel
        colourContrastPanel.add(buttonPanel);


    }

}
