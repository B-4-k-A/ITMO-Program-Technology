public class Alphabet {
    public static void main(String[] args) {
        char letter = 'a';
        for(int i = 0; i < 26; i++) {
            System.out.println((char)((int)letter++));
        }
    }
}
