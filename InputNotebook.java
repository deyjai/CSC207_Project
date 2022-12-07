import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


class InputNotebook extends JFrame implements ActionListener {

    private DataModel dataModel;
    public MasterView masterView;

    public JComboBox Chooser;
    public JPanel redBox, blueBox, greenBox, yellowBox;
    private int amount;

    private String[] attempts;
    public InputNotebook(MasterView masterView, DataModel dataModel) {
        this.masterView = masterView;
        this.dataModel = MasterView.DATA_MODEL;
        this.amount = this.dataModel.kinematicsParameters.size();
    }

    public InputNotebook() {
        this.chooseFile();
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

    private static void createAndShowGUI() {
        InputNotebook n = new InputNotebook();

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Input Round");

        InputNotebook demo = new InputNotebook();
        frame.setContentPane(demo.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



    public JPanel createContentPane(){

        JPanel totalGUI = new JPanel();

        // To create a JComboBox, we need to pass in an array of Strings.
        // This gives the ComboBox the list of selections you can make.
        //this.amount = this.dataModel.kinematicsParameters.size();
        this.amount = 10;
        String[] attempts =new String[this.amount];
        int i = 0;
        int number = 1;
        while (i < this.amount) {
            attempts[i] = "Input " + String.valueOf(number);
            i++;
            number++;
        }
        this.attempts = attempts;

        String colors[] = this.attempts;

        Chooser = new JComboBox(colors);
        Chooser.setSelectedIndex(1);
        Chooser.addActionListener(this);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));

        bottomPanel.add(Box.createRigidArea(new Dimension(0,10)));
        bottomPanel.add(Chooser);
        bottomPanel.add(Box.createRigidArea(new Dimension(0,20)));
        bottomPanel.add(Box.createRigidArea(new Dimension(0,10)));

        totalGUI.add(bottomPanel);

        totalGUI.setOpaque(true);
        return totalGUI;
    }



    public void actionPerformed(ActionEvent e) {

        int temp;

        if(e.getSource() == Chooser)
        {

            temp = Chooser.getSelectedIndex();
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



    public void chooseFile() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "CSV Files", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //System.out.println("You chose to open this file: " +
            //        chooser.getSelectedFile().getName());
            loadfile(chooser.getSelectedFile().getName());
        }
    }


    private void loadfile(String name) {
        String filee = "/Users/laibakhan/Downloads/practice.csv";
        try  {
            File file = new File(filee);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            while((line = br.readLine()) != null) {
                tempArr = line.split(",");
                double[] parsed = new double[tempArr.length];
                parsed[0] = Double.valueOf(tempArr[0]);
                parsed[1] = Double.valueOf(tempArr[1]);
                parsed[2] = Double.valueOf(tempArr[2]);
                parsed[3] = Double.valueOf(tempArr[3]);
                parsed[4] = Double.valueOf(tempArr[4]);
                this.dataModel.kinematicsParameters.add(parsed);

            }
            br.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
