
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;



public class SummaryView extends JFrame {

    public static java.util.ArrayList<double[]> kinematicsParameters = new ArrayList<>();

    public SummaryView(){
        super();
    }

    public static void main(String [] args)
    {
        DataModel m = new DataModel();
        DataModel.setParameters(20.0,3.0,6.0,3.0,1.0);
        DataModel.setParameters(10.0,2.0,3.0,4.0,5.0);
        DataModel.setParameters(6,2.0,3.0,4.0,5.0);
        m.getAverage();
        m.getMin();
        m.getMax();
        open();
    }

    public void initSummaryView( DataModel m) {
        JPanel panel = new JPanel(new BorderLayout());
        this.setContentPane(panel);

        setLayout(new FlowLayout());
        //AVERAGES
        String[] avg_columns = {"Average Displacement", "Average Acceleration", "Average Initial Velocity",
                " Average Final Velocity", "Average Time"};

        int len_all = m.getAverage().length + m.getMax().length + m.getMin().length;
        String[][] f = new String[len_all][5];
        double[] avg;

        for (int i = 0; i < m.getAverage().length; i++) {
            String[] d = new String[5];
            avg = m.getAverage();
            d[0] = String.valueOf(avg[0]);
            d[1] = String.valueOf(avg[1]);
            d[2] = String.valueOf(avg[2]);
            d[3] = String.valueOf(avg[3]);
            d[4] = String.valueOf(avg[4]);
            f[i] = d;
        }

        //MAXIMUM
        String[] max_columns = {"Max Displacement", "Max Acceleration", "Max Initial Velocity", "Max Final Velocity", " Max Time"};
        String[][] f_max = new String[len_all][5];
        double[] max;

        for (int i = 0; i < m.getMax().length; i++) {
            String[] d = new String[5];
            max = m.getMax();
            d[0] = String.valueOf(max[0]);
            d[1] = String.valueOf(max[1]);
            d[2] = String.valueOf(max[2]);
            d[3] = String.valueOf(max[3]);
            d[4] = String.valueOf(max[4]);
            f_max[i] = d;
        }

        //MINIMUM
        String[] min_columns = {"Min Displacement", "Min Acceleration", "Min Initial Velocity", "Min Final Velocity", " Min Time"};
        String[][] f_min = new String[len_all][5];
        double[] min;

        for (int i = 0; i < m.getMin().length; i++) {
            String[] d = new String[5];
            min = m.getMin();
            d[0] = String.valueOf(min[0]);
            d[1] = String.valueOf(min[1]);
            d[2] = String.valueOf(min[2]);
            d[3] = String.valueOf(min[3]);
            d[4] = String.valueOf(min[4]);
            f_min[i] = d;
        }

        //Add Averages, Maximums and Minimums
        JTable avg_table = new JTable(f, avg_columns);
        JTable max_table = new JTable(f_max, max_columns);
        JTable min_table = new JTable(f_min, min_columns);
        JScrollPane sp = new JScrollPane(avg_table);
        JScrollPane mp = new JScrollPane(max_table);
        JScrollPane np = new JScrollPane(min_table);
        add(sp);
        add(mp);
        add(np);
    }

    public static void open()
    {
        //basics
        SummaryView frame = new SummaryView();
        DataModel m = new DataModel();
        frame.initSummaryView(m);

        //changes from last week - exit to dispose, so the entire program doesn't terminate, only the particular window.
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        //some extra features
        frame.setTitle(" Summary View");
        frame.setLocation(0,0);
        frame.setSize(new Dimension(500,800));

    }
}
