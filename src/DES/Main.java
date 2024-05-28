package DES;

public class Main {
    public static void main(String[] args) {
        String message = "Hello, World!";

        // Encrypt the message
        String encryptedMessage = DES.EncryptList(message);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Decrypt the encrypted message
        String decryptedMessage = DES.DecryptList(encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
