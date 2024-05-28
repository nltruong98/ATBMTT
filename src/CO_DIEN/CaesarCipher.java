package CO_DIEN;

public class CaesarCipher {
    private static String  text;

	// Phương thức mã hóa Caesar cho văn bản sử dụng Unicode
    public static String caesarEncrypt(String text, int shift) {
        StringBuilder word = new StringBuilder();

        // Duyệt qua từng ký tự trong văn bản
        for (int i = 0; i < text.length(); i++) {
            char kytu = text.charAt(i);

            // Kiểm tra xem ký tự có phải là ký tự chữ cái không
            if (Character.isLetter(kytu)) {
                // Xác định chữ cái đầu ra bằng cách thay đổi shift
                char encryptedChar = (char) (kytu + shift);

                // Kiểm tra vượt quá biên
                if ((Character.isUpperCase(kytu) && encryptedChar > 'Z')
                        || (Character.isLowerCase(kytu) && encryptedChar > 'z')) {
                    encryptedChar = (char) (kytu - (26 - shift)); // Trừ đi 26 để quay vòng
                }

                word.append(encryptedChar);
            } else {
                // Nếu không phải là chữ cái, giữ nguyên ký tự
            	word.append(kytu);
            }
        }

        return word.toString();
    }

    // Phương thức giải mã Caesar cho văn bản sử dụng Unicode
    public static String caesarDecrypt(String text, int shift) {
        // Đảo ngược shift để giải mã
        return caesarEncrypt(text, -shift);
    }

    public static void main(String[] args) {
        // Văn bản gốc
        String text = "Hiếu";

        // Số lần dịch chuyển (shift)
        int shift = 3;

        // Mã hóa văn bản
        String encryptedText = caesarEncrypt( text, shift);
        System.out.println("Mã hóa: " + encryptedText);

        // Giải mã văn bản
        String decryptedText = caesarDecrypt(encryptedText, shift);
        System.out.println("Giai mã: " + decryptedText);
    }
}
