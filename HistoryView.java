
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;



public class HistoryView extends JFrame {

    public static java.util.ArrayList<double[]> kinematicsParameters = new ArrayList<>();

    public static ArrayList<double[]> getP(DataModel dataModel){
        return dataModel.getAllParameters();
    }

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
        JButton button = new JButton("Print History");
        panel.add(button, BorderLayout.PAGE_START);

        //adding custom components
        JComponent component = new JComponent() {

            //Note - whenever you resize the screen, the component calls the repaint() method, which calls the
            //paintComponent method again. This is why the lines "move" as you play with the margins.
            @Override
            public void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                String[] columns = {"Displacement", "Acceleration", "Initial Velocity", "Final Velocity", "Time"};
               DataModel m = new DataModel();

                String[][] f = new String[m.getAllParameters().size()][];
                String[] d = new String[5];
                String first = "";
               String sec = "";
            String third = "";
            String four = "";
            String fifth = "";
               for(int i =0; i <m.getAllParameters().size(); i++){
                   for(int j =0; i <m.getAllParameters().get(j).length; j++) {
                       double[] hi = kinematicsParameters.get(i);
                       first = String.valueOf(hi[0]);
                       sec = String.valueOf(hi[1]);
                       third = String.valueOf(hi[2]);
                       four = String.valueOf(hi[3]);
                       fifth = String.valueOf(hi[4]);
                       d[i] = Arrays.toString(new String[]{first, sec, third, four, fifth});
                   }
                   f[i] = d;
               }

                DefaultTableModel model = new DefaultTableModel(f, columns);

               //JTable.setModel(model);

            }



        };
        panel.add(component, BorderLayout.CENTER);
    }
}
