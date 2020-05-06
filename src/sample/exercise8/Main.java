package sample.exercise8;

public class Main {
    public static void main(String[] args) {
        System.out.println(getV(1, 3, Math.pow(10, -9)));
    }

    private static double getV(double l , double r, double e){
        double medium = (l+r)/2;
        final double valueOfMedium = f(medium);
        if (Math.abs(valueOfMedium)<=e)
            return medium;
        if (valueOfMedium<0)
            return getV(medium, r, e);
        else
            return getV(l, medium, e);
    }

    private static double f(double value){
        return Math.pow(value, 5)+Math.pow(value, 3)-3*value-2;
    }
}
