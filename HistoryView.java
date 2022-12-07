
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;



public class HistoryView extends JFrame {

    public static java.util.ArrayList<double[]> kinematicsParameters = new ArrayList<>();

    public HistoryView(){
        super();
    }

    public static void main(String [] args)
    {
        DataModel m = new DataModel();
        DataModel.setParameters(20.0,3.0,6.0,3.0,1.0);
        DataModel.setParameters(10.0,2.0,3.0,4.0,5.0);
        DataModel.setParameters(6,2.0,3.0,4.0,5.0);
        open();
    }

    public void initHistoryView( DataModel m) {
        JPanel panel = new JPanel(new BorderLayout());
        this.setContentPane(panel);

        setLayout(new FlowLayout());
        String[] columns = {"Displacement", "Acceleration", "Initial Velocity", "Final Velocity", "Time"};

        String[][] f = new String[m.getAllParameters().size()][5];
        double[] hi;

        for (int i = 0; i < m.getAllParameters().size(); i++) {
            String[] d = new String[5];
            hi = m.getAllParameters().get(i);
            d[0] = String.valueOf(hi[0]);
            d[1] = String.valueOf(hi[1]);
            d[2] = String.valueOf(hi[2]);
            d[3] = String.valueOf(hi[3]);
            d[4] = String.valueOf(hi[4]);
           f[i] = d;
        }

        JTable table = new JTable(f, columns);
        JScrollPane sp = new JScrollPane(table);
        add(sp);


    }

    public static void open()
    {
        //basics
        HistoryView frame = new HistoryView();
        DataModel m = new DataModel();
        frame.initHistoryView(m);

        //changes from last week - exit to dispose, so the entire program doesn't terminate, only the particular window.
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        //some extra features
        frame.setTitle("Mission Engine");
        frame.setLocation(0,0);
        frame.setSize(new Dimension(500, 500));

    }
}
