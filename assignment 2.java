public class Encryptor 
{
    private final int key;
    public Encryptor(int key) {
        this.key = key;
    }
    public String encryptString(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                char encryptedChar = encryptChar(ch);
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }
    private char encryptChar(char ch) {
        int charValue = Character.isLowerCase(ch) ? ch - 'a' : ch - 'A';
        int encryptedValue = (charValue + key) % 26;
        char encryptedChar = (char) (encryptedValue + (Character.isLowerCase(ch) ? 'A' : 'a'));
        if (Character.isLowerCase(ch)) {
            encryptedChar = Character.toUpperCase(encryptedChar);
        } else {
            encryptedChar = Character.toLowerCase(encryptedChar);
        }

        return encryptedChar;
    }
    public static void main(String[] args) 
    {
        int key = 20; 
        Encryptor encryptor = new Encryptor(key);
        String input1 = "Wipro Tech";
        String encryptedString = encryptor.encryptString(input1);
        System.out.println("Original String: " + input1);
        System.out.println("Encrypted String: " + encryptedString);
    }
}
