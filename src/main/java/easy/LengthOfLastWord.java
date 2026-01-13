package easy;

public class LengthOfLastWord {
    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        if (s.isEmpty()) return 0;
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ')
                count++;
            else if (count > 0)
                break;

        }
        return count;
    }
}
