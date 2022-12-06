

import javax.swing.*;
import java.awt.*;


public class InputNotebook extends JPanel
{

    private DataModel dataModel;
    MasterView masterView;
    public void InputNotebook(MasterView masterView, DataModel dataModel) {

        this.masterView = masterView;
        this.dataModel = dataModel;
        this.inputFile(this.dataModel);
    }

    public void InputNotebook() {

        this.inputFile(this.dataModel);
    }

    public static void open()
    {
        OutputNotebook frame = new OutputNotebook();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public void inputFile(DataModel dataModel)
    {
        throw new UnsupportedOperationException();
        //method for when button is pressed
        //create buttons
        //select soemthing with a check box, adn input whatever is checked

    }
}


