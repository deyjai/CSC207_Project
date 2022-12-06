

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


class InputNotebookkkk extends JFrame implements ItemListener {

    // frame
    static JFrame f;

    // label
    static JLabel l, l1;

    // combobox
    static JComboBox c1;


    private DataModel dataModel;
    MasterView masterView;

    // main class
    public void InputNotebookkkk(MasterView masterView, DataModel dataModel) {

        this.masterView = masterView;
        this.dataModel = dataModel;
    }

    public void InputNotebookkkk() {

        this.inputFile(this.dataModel);
    }
    public static void open()

    {
        InputNotebookkkk frame = new InputNotebookkkk();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // create a new frame

    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        // if the state combobox is changed
        if (e.getSource() == c1) {

            l1.setText(c1.getSelectedItem() + " selected");
        }

    }

    public void inputFile(DataModel dataModel)
    {
        JPanel f = new JPanel();
        LayoutManager layout = new FlowLayout();
        f.setLayout(layout);
        f.setLayout(new FlowLayout());

        // array of string containing cities
        String s1[] = { "Jalpaiguri", "Mumbai", "Noida", "Kolkata", "New Delhi" };

        // create checkbox
        c1 = new JComboBox(s1);

        // add ItemListener
        c1.addItemListener(this);

        // create labels
        l = new JLabel("select your city ");
        l1 = new JLabel("Jalpaiguri selected");

        // set color of text
        l.setForeground(Color.red);
        l1.setForeground(Color.blue);

        // create a new panel
        JPanel p = new JPanel();

        p.add(l);

        // add combobox to panel
        p.add(c1);

        p.add(l1);

        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(400, 300);
        this.setContentPane(f);

        f.show();

    }
}


