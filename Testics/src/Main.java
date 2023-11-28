// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

class Calc {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String vStroka = scanner.nextLine();
        int j=0;
        char[] provgv=new char[10];
        for (int i=0;i<vStroka.length();i++){
           provgv[i]=vStroka.charAt(i);
           if ((provgv[i]=='+')||(provgv[i]=='-')||(provgv[i]=='/')||(provgv[i]=='*')){
           j++;
           }
        }
        if (j!=1){
            throw new Exception("Должен быть один знак действия");
        }
        System.out.println(parse(vStroka));
    }

    public static String parse(String vStroka) throws Exception {
        int s,su2;
        String sis,result;
        boolean roma;
        String[] jija = vStroka.split("[+\\-*/]");
        if (jija.length != 2) throw new Exception("неправильная запись");
        sis = jopakonya(vStroka);
        if (sis == null) throw new Exception("неверный знак действия");
        if (Roma.isRoma(jija[0]) && Roma.isRoma(jija[1])) {
            s = Roma.vAraba(jija[0]);
            su2 = Roma.vAraba(jija[1]);
            roma = true;
        }
        else if (!Roma.isRoma(jija[0]) && !Roma.isRoma(jija[1])) {
            s = Integer.parseInt(jija[0]);
            su2 = Integer.parseInt(jija[1]);
            roma = false;
        }
        else {
            throw new Exception("Числа должны быть в одном формате");
        }
        if ((s > 10) || (su2 > 10) || (s==0) || (su2==0)) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arab = calc(s, su2, sis);
        if (roma) {
            if (arab <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            result = Roma.vRomu(arab);
        } else {
            result = String.valueOf(arab);
        }
        return result;
    }

    static String jopakonya(String vStroka) {
    if (vStroka.contains("+")) {
        return "+";
    }
        if (vStroka.contains("-")) {
            return "-";
        }
        if (vStroka.contains("*")) {
            return "*";
        }
        if (vStroka.contains("/")) {
            return "/";
        }

 return null;



    }

    static int calc(int a, int b, String sis) {

        if (sis.equals("+")) return a + b;
        else if (sis.equals("-")) return a - b;
        else if (sis.equals("*")) return a * b;
        else return a / b;
    }

}

class Roma {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};


    public static boolean isRoma(String val) {
        for (int i = 0; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int vAraba(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String vRomu(int arabian) {
        return romanArray[arabian];
    }

}