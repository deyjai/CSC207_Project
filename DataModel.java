import java.util.ArrayList;
import java.util.Arrays;


public class DataModel {

    public static java.util.ArrayList<double[]> kinematicsParameters = new ArrayList<>();

    public static void main(String [] args)
    {
        DataModel m = new DataModel();
        //System.out.println(kinematicsParameters);
        setParameters(20.0,3.0,6.0,3.0,1.0);
        setParameters(10.0,2.0,3.0,4.0,5.0);

        //System.out.println(Arrays.toString(kinematicsParameters.get(0)));
        //System.out.println(Arrays.toString(kinematicsParameters.get(1)));
        //System.out.println(Arrays.toString(m.getAverage()));
        //System.out.println(Arrays.toString(m.getMax()));
        //System.out.println(Arrays.toString(m.getMin()));
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
        double max_dis = 0;
        double max_acc = 0;
        double max_v1 = 0;
        double max_v2 = 0;
        double max_time = 0;

        for (double[] internalArray : kinematicsParameters) {
            int j = 0;
            if (internalArray[j] >= max_dis) {
                max_dis = internalArray[j];
            }
            if (internalArray[j + 1] >= max_acc) {
                max_acc = internalArray[j + 1];
            }
            if (internalArray[j + 2] >= max_v1) {
                max_v1 = internalArray[j + 2];
            }
            if (internalArray[j + 3] >= max_v2) {
                max_v2 = internalArray[j + 3];
            }
            if (internalArray[j + 4] >= max_time) {
                max_time = internalArray[j + 4];
            }
        }
        return new double[]{max_dis, max_acc, max_v1, max_v2, max_time};

    }

    // Public method
    public double[] getMin() {
        double min_dis = 1000000;
        double min_acc = 1000000;
        double min_v1 = 1000000;
        double min_v2 = 1000000;
        double min_time = 1000000;

        for (double[] internalArray : kinematicsParameters) {
            int j = 0;
            if (internalArray[j] <= min_dis ) {
                min_dis = internalArray[j];
            }
            if (internalArray[j + 1] <= min_acc) {
                min_acc = internalArray[j + 1];
            }
            if (internalArray[j + 2] <= min_v1) {
                min_v1 = internalArray[j + 2];
            }
            if (internalArray[j + 3] <= min_v2) {
                min_v2 = internalArray[j + 3];
            }
            if (internalArray[j + 4] <= min_time) {
                min_time = internalArray[j + 4];
            }
        }
        return new double[]{min_dis, min_acc, min_v1, min_v2, min_time};

    }


    public ArrayList<double[]> getAllParameters(){
        return kinematicsParameters;
    }


}
