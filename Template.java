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
*/
public class Template extends JFrame
{
    public static void open()
    {
        //basics
        Template frame = new Template();
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
