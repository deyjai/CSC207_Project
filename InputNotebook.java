

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


