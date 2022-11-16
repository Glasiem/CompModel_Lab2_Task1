public class Main {

    public static double f(double x, double y){
        return Math.sqrt(x)*y+1;
    }

    public static void rungeKutta4(){
        double h = 0.1;
        double a = 1;
        double b = 2;
        int dots = (int) ((b-a)/h + 1);
        double[] x = new double[dots];
        x[0] = 1;
        for (int i = 1; i < dots; i++) {
            x[i] = x[i-1] + h;
        }
        double[] y = new double[dots];
        y[0] = 0;
        double k1;
        double k2;
        double k3;
        double k4;
        System.out.println("x" + 0 + " = " + x[0] + " " + "\t\t\t" + "y" + 0 + " = " + y[0]);
        for (int i = 0; i < dots - 1; i++) {
            k1 = h*f(x[i],y[i]);
            k2 = h*f(x[i] + h/2,y[i] + k1/2);
            k3 = h*f(x[i] + h/2,y[i] + k2/2);
            k4 = h*f(x[i] + h,y[i] + k3);
            y[i+1] = y[i] + (double)1/6*(k1 + 2*k2 + 2*k3 + k4);
            System.out.println("x" + (i+1) + " = " + String.format("%,.4f", x[i+1]) + " " + "\t\t" + "y" + (i+1) + " = " + String.format("%,.4f", y[i+1]));
        }
    }

    public static void eulerKoshi(){
        double h = 0.1;
        double a = 1;
        double b = 2;
        int dots = (int) ((b-a)/h + 1);
        double[] x = new double[dots];
        x[0] = 1;
        for (int i = 1; i < dots; i++) {
            x[i] = x[i-1] + h;
        }
        double[] y = new double[dots];
        y[0] = 0;
        double y_alter;
        System.out.println("x" + 0 + " = " + x[0] + " " + "\t\t\t" + "y" + 0 + " = " + y[0]);
        for (int i = 0; i < dots-1; i++) {
            y_alter = y[i] + h*f(x[i],y[i]);
            y[i+1] = y[i] + h*(f(x[i],y[i]) + f(x[i+1],y_alter))/2;
            System.out.println("x" + (i+1) + " = " + String.format("%,.4f", x[i+1]) + " " + "\t\t" + "y" + (i+1) + " = " + String.format("%,.4f", y[i+1]));
        }
    }

    public static void main(String[] args) {
        System.out.println("Рунге Кутта 4");
        rungeKutta4();
        System.out.println("Ейлера Коші");
        eulerKoshi();
    }
}