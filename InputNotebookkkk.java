

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Array;
import java.util.ArrayList;


class InputNotebookkkk extends JFrame implements ActionListener {

    private DataModel dataModel;
    public MasterView masterView;

   public JComboBox colorChooser;
   public JPanel redBox, blueBox, greenBox, yellowBox;
   private int amount;

   private String[] attempts;
    public InputNotebookkkk() {
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


        // Now we create a simple JPanel that displays our four coloured boxes.

        JPanel boxPanel = new JPanel(new GridLayout(2, 2, 20, 20));

        redBox = createSquareJPanel(Color.red, 50);
        blueBox = createSquareJPanel(Color.blue, 50);
        greenBox = createSquareJPanel(Color.green, 50);
        yellowBox = createSquareJPanel(Color.yellow, 50);

        // This sets all bar the blue box to be hidden.

        redBox.setVisible(false);
        greenBox.setVisible(false);
        yellowBox.setVisible(false);

        boxPanel.add(redBox);
        boxPanel.add(blueBox);
        boxPanel.add(greenBox);
        boxPanel.add(yellowBox);

        // This sets the widgets on the screen to be layed out in a
        // top to bottom fashion with spacers inbetween.

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));

        bottomPanel.add(Box.createRigidArea(new Dimension(0,10)));
        bottomPanel.add(colorChooser);
        bottomPanel.add(Box.createRigidArea(new Dimension(0,20)));
        bottomPanel.add(boxPanel);
        bottomPanel.add(Box.createRigidArea(new Dimension(0,10)));

        totalGUI.add(bottomPanel);

        totalGUI.setOpaque(true);
        return totalGUI;
    }

    // In this method, we create a square JPanel of a colour and set size
    // specified by the arguments.

    private JPanel createSquareJPanel(Color color, int size) {
        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(color);
        tempPanel.setMinimumSize(new Dimension(size, size));
        tempPanel.setMaximumSize(new Dimension(size, size));
        tempPanel.setPreferredSize(new Dimension(size, size));
        return tempPanel;

        //
    }

    // This actionPerformed simply takes sets the visibility of each
    // coloured box depending on what is selected on the combo box.

    public void actionPerformed(ActionEvent e) {

        int temp;

        if(e.getSource() == colorChooser)
        {
            temp = colorChooser.getSelectedIndex();

            switch(temp){
                case 0:
                    //this.masterView.inputInitialV.setText("enter");
                    //this.masterView.initialV.add(this.masterView.promptInitialV);
                    //this.masterView.mainPanel.add(this.masterView.initialV);

                    redBox.setVisible(true);
                    blueBox.setVisible(false);
                    greenBox.setVisible(false);
                    yellowBox.setVisible(false);
                    break;
                case 1:
                    redBox.setVisible(false);
                    blueBox.setVisible(true);
                    greenBox.setVisible(false);
                    yellowBox.setVisible(false);
                    break;
                case 2:
                    redBox.setVisible(false);
                    blueBox.setVisible(false);
                    greenBox.setVisible(true);
                    yellowBox.setVisible(false);
                    break;
                case 3:
                    redBox.setVisible(false);
                    blueBox.setVisible(false);
                    greenBox.setVisible(false);
                    yellowBox.setVisible(true);
                    break;
            }
        }
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("View Attempts");

        InputNotebookkkk demo = new InputNotebookkkk();
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


