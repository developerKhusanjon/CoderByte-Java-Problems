package dev.khusanjon.easy;

public class AdditivePersistence {

    static int digitSum(int n) {
        int sum = 0;
        while (n>=1) {
            sum += n%10;
            n/=10;
        }

        return sum;
    }

    static int times(int num) {
        int times = 0;
        while (num > 9) {
            num = digitSum(num);
            times ++;
        }

        return times;
    }

    public static void main(String[] args) {
        System.out.println(times(19999));
    }
}
