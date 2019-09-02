package SwordingToOffer;

public class PowerByExponent {
    static double PowerWithExponent (double base, int exponent) {
        double res = 1, curr = base;
        int n;
        if (exponent > 0) {
            n = exponent;
        } else if (exponent < 0) {
            if (base == 0)
                throw new RuntimeException ("分母为0");
            n = -exponent;
        } else {
            return 1;
        }
        while (n != 0) {
            if ((n & 1) == 1)
                res *= curr;
            curr *= curr;
            n >>= 1;
        }
        return exponent > 0 ? res : (1 / res);
    }

    public static void main (String[] args) {
        System.out.println (PowerWithExponent (2.0, 4));
        System.out.println (PowerWithExponent (-2.0, 3));
        System.out.println (PowerWithExponent (-2.0, -3));
        System.out.println (PowerWithExponent (-2.0, 0));
        System.out.println (PowerWithExponent (2.0, -3));
        System.out.println (PowerWithExponent (0, 4));
        System.out.println (PowerWithExponent (1, 4));
        System.out.println (PowerWithExponent (1, 4));
        System.out.println (PowerWithExponent (0, -3));

    }

}
