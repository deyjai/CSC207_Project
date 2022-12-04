/* Template
 * By: Insert Name Here
 * Last Modified: 11/15/2022
 * Insert Description Here */

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
public class OutputNotebook extends JFrame

{
    private String file;
    private saveStrategy strat;
    private DataModel dataModel;
    MasterView masterView;
    public void OutputNotebook(MasterView masterView, DataModel dataModel, saveStrategy strategy) {
        this.file = "";
        this.masterView = masterView;
        this.dataModel = dataModel;
        this.strat = strategy;
        /*DataModel dataModel*/
    }
    public static void open()
    {
        JFrame frame = new JFrame("Save File");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private static void createUI(JFrame frame) {
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);

        JButton button = new JButton("Choose File Location to Save");
        final JLabel label = new JLabel();

        button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(frame);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                try {
                    FileWriter fw = new FileWriter(file.getPath());
                    //fw.write(String.format("%20s %20s", "Average: " + this.dataModel.getAverage()));
                    //fw.write(String.format("%20s %20s", "Max: " + this.dataModel.getMax()));
                    //fw.write(String.format("%20s %20s", "Min: " + this.dataModel.getMin()));
                    fw.write("hello");
                    //write data into file
                    //format it
                    //DONT CANCEL WHOLE TAB
                    fw.close();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                label.setText("File Saved as: " + file.getName());
            }else{
                label.setText("Save command canceled");
            }
        });

        panel.add(button);
        panel.add(label);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }


    public void saveBoard() {
        // this.strat.saveBoard();
        //make abstract -> two options to save file as
    }
}



