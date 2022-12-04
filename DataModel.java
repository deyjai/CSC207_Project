import java.util.ArrayList;
import java.util.Arrays;


public class DataModel {

    public static java.util.ArrayList<double[]> kinematicsParameters = new ArrayList<>();

    public static void main(String [] args)
    {
        DataModel m = new DataModel();
        //System.out.println(kinematicsParameters);
        setParameters(1,2,3,4,5);
        setParameters(1,3,6,3,1);
        System.out.println(Arrays.toString(kinematicsParameters.get(0)));
        System.out.println(Arrays.toString(kinematicsParameters.get(1)));
        //System.out.println(Arrays.toString(m.getAverage()));
        System.out.println(Arrays.toString(m.getMax()));
    }


    public static void setParameters(double displacement, double acceleration, double v1, double v2, double time) {
        double[] hi = new double[5];
        hi[0] = displacement;
        hi[1] = acceleration;
        hi[2] = v1;
        hi[3] = v2;
        hi[4] = time;
        kinematicsParameters.add(hi);
    }


    // Public method
    public double[] getAverage() {
        double[] f = new double[5];
        double[] hi;
        double total_dis = 0;
        double total_acc = 0;
        double total_v1 = 0;
        double total_v2 = 0;
        double time = 0;
        double avg_dis = 0;
        double avg_acc = 0;
        double avg_v1 = 0;
        double avg_v2 = 0;
        double avg_time = 0;

        for(int i=0; i <kinematicsParameters.size(); i++) {
            hi  = kinematicsParameters.get(i);
            total_dis = total_dis + hi[0];
            total_acc = total_acc + hi[1];
            total_v1 = total_v1 + hi[2];
            total_v2 =  total_v2 + hi[3];
            time =  time + hi[4];
        }
        avg_dis = total_dis/kinematicsParameters.size();
        avg_acc = total_acc/kinematicsParameters.size();
        avg_v1 = total_v1/kinematicsParameters.size();
        avg_v2 = total_v2/kinematicsParameters.size();
        avg_time = time/kinematicsParameters.size();

        f[0] = avg_dis;
        f[1] = avg_acc;
        f[2] = avg_v1;
        f[3] = avg_v2;
        f[4] = avg_time;

        return f;
    }

    public double[] getMax() {
        double[] f = new double[5];
        double t = 0;
        double[] max_dis = new double[kinematicsParameters.size()+1];
        double[] max_acc = new double[kinematicsParameters.size()+1];
        double[] max_v1 = new double[kinematicsParameters.size()+1];
        double[] max_v2 = new double[kinematicsParameters.size()+1];
        double[] max_time = new double[kinematicsParameters.size()+1];

        for(int i=0; i <kinematicsParameters.size(); i++)
        {
            for(int j=0; j < kinematicsParameters.get(i).length; j++)
            {
                //System.out.println("In the second loop: " + Arrays.toString(new double[]{max_dis[j]}));
            }
        }
        return max_dis;
    }

    // Public method
    public double getMin() {
        System.out.println("get min");
        return 1;
    }

}
