
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


class InputNotebook extends JFrame  {

    private DataModel dataModel;
    public MasterView masterView;

    public InputNotebook(MasterView masterView, DataModel dataModel) {
        this.masterView = masterView;
        this.dataModel = dataModel;
        //this.amount = this.dataModel.kinematicsParameters.size();
    }

    public InputNotebook() {
        this.create(this.dataModel);
    }

    public static void open() {
        InputNotebook frame = new InputNotebook();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void create(DataModel dataModel) {
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);

        JButton button = new JButton("Choose File to Load");
        final JLabel label = new JLabel();

        button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "CSV Files", "csv");
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                loadfile(selectedFile.getAbsolutePath());
                label.setText("File Chosen: " + selectedFile.getName());
            }else{
                label.setText("Save command canceled");
            }
        });

        panel.add(button);
        panel.add(label);
        this.setContentPane(panel);
    }



    private void loadfile(String name) {
        String filee = name;
        String row = "";
        try  {
            Scanner scanner = new Scanner(new File(filee));

            while (scanner.hasNextLine()) {
            //BufferedReader csvReader = new BufferedReader(new FileReader(filee));
           // String row = "";
            //while (row != null) {
                row = scanner.nextLine();
                String[] data = row.split(",");
                //System.out.println(Arrays.toString(data));
                double[] parsed = new double[data.length];
                parsed[0] = Double.valueOf(data[0]);
                parsed[1] = Double.valueOf(data[1]);
                parsed[2] = Double.valueOf(data[2]);
                parsed[3] = Double.valueOf(data[3]);
                parsed[4] = Double.valueOf(data[4]);
                System.out.println(parsed[0]);
                System.out.println(parsed[1]);
                System.out.println(parsed[2]);
                this.dataModel.kinematicsParameters.add(parsed);
                //System.out.println(String.valueOf(this.dataModel.kinematicsParameters));

            }
            scanner.close();
            //csvReader.close();
            } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (Exception e){
            System.out.println(e);
        }
    }
    }