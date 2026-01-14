package easy;

// Даны две двоичные строки a и b. Верните их сумму в виде двоичной строки.
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

    public static String addBinary(String a, String b) {
        int carry = 0;
        int sum;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder r = new StringBuilder();
        while(i >= 0 || j >= 0 || carry > 0) {
            int bit_a = i >= 0 ? a.charAt(i) - '0' : 0;
            int bit_b = j >= 0 ? b.charAt(j) - '0' : 0;
            sum = bit_a + bit_b + carry;
            r.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        return r.reverse().toString();
    }
}
