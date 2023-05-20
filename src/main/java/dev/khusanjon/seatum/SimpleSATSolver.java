package dev.khusanjon.seatum;

public class SimpleSATSolver {

    /*
     Input: "(a&b&c)|~a"
Output: yes
Input: "a&(b|c)&~b&~c"
Output: no
    * */



    static boolean calculateInter(String str, boolean a, boolean b, boolean c) {
        String[] arrS = str.split("&");
        boolean result = true;
        for(String s: arrS) {
            if (s.equals("0")) return false;
            if (s.equals("~1")) return false;
            if (s.equals("a")) result = result && a;
            if (s.equals("~a")) result = result && !a;
            if (s.equals("b")) result = result && b;
            if (s.equals("~b")) result = result && !b;
            if (s.equals("c")) result = result && c;
            if (s.equals("~c")) result = result && !c;
        }
        return result;
    }

    static boolean calculateSubtract(String str, boolean a, boolean b, boolean c) {
        String[] arrS = str.split("\\|");
        for(String s: arrS) {
            if (calculateInter(s, a, b, c)) return true;
        }
        return false;
    }

    static String subStatement(String str, boolean a, boolean b, boolean c) {
        return calculateSubtract(str, a, b, c) ? "1" : "0";
    }

    static boolean evalCase(String str, boolean a, boolean b, boolean c) {
        while (str.lastIndexOf('(')!=-1) {
            int start = str.lastIndexOf('(');
            int end =  start + str.substring(start).indexOf(')');
            str = str.substring(0, start) + subStatement(str.substring(start+1, end), a, b, c) + str.substring(end+1, str.length());
        }

        return calculateSubtract(str, a, b, c);
    }

    public static String SimpleSAT(String str) {
        boolean result =
                evalCase(str, false, false, false) || evalCase(str, false, false, true) || evalCase(str, false, true, false) ||
                        evalCase(str, false, true, true) || evalCase(str, true, false, false) || evalCase(str, true, false, true)  ||
                        evalCase(str, true, true, false) || evalCase(str, true, true, true);


        return result ? "yes" : "no";

    }

    public static void main(String[] args) {
        System.out.println(SimpleSAT("(a&(b&(~(c))))|~a"));
    }

}