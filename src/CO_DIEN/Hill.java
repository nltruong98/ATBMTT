package CO_DIEN;

import java.util.Arrays;

public class Hill {
    
    // Chuyển đổi văn bản thành số (A=0, B=1, ..., Z=25)
    public static int[] textToNumber(String text) {
        int[] numbers = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            int unicode = text.codePointAt(i);
            numbers[i] = unicode - 'A';
        }
        return numbers;
    }

    // Chuyển đổi số thành văn bản (0=A, 1=B, ..., 25=Z)
    public static String numberToText(int num) {
        return Character.toString((char) (num + 'A'));
    }

    // Chuyển đổi văn bản thành ma trận kích thước m x m
    public static int[][] textToMatrix(String text, int m) {
        int[][] matrix = new int[m][m];
        int[] numbers = textToNumber(text);
        for (int i = 0; i < numbers.length; i++) {
            matrix[i / m][i % m] = numbers[i];
        }
        return matrix;
    }

    // Nhân ma trận 'a' với vector 'b', modulo 'mod', tại cột 'j'
    public static int multiply(int[][] a, int[] b, int mod, int j) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i][j] * b[i];
        }
        sum=sum % mod;
        if(sum<0) sum+=mod;
        return sum ;
    }

    public static int dinhThuc(int[][] maTran) {
        int n = maTran.length;
        if (n != maTran[0].length) {
            throw new IllegalArgumentException("Ma trận không phải là ma trận vuông");
        }

        if (n == 1) {
            return maTran[0][0];
        }

        int det = 0;
        int[][] subMatrix = new int[n - 1][n - 1];

        for (int i = 0; i < n; i++) {
            getCofactor(maTran, subMatrix, 0, i);
            det += Math.pow(-1, i) * maTran[0][i] * dinhThuc(subMatrix);
        }

        return det;
    }

    // Hàm lấy ma trận con bằng cách loại bỏ dòng i và cột j
    public static void getCofactor(int[][] maTran, int[][] subMatrix, int i, int j) {
        int n = maTran.length;
        int rowIndex = 0, colIndex = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != i && col != j) {
                    subMatrix[rowIndex][colIndex++] = maTran[row][col];
                    if (colIndex == n - 1) {
                        colIndex = 0;
                        rowIndex++;
                    }
                }
            }
        }
    }

    // Hàm chuyển vị ma trận
    public static int[][] chuyenVi(double[][] maTran) {
        int m = maTran.length;
        int n = maTran[0].length;
        int[][] maTranChuyenVi = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maTranChuyenVi[j][i] = (int) maTran[i][j]; // Chuyển từ double sang int
            }
        }
        return maTranChuyenVi;
    }

    // Hàm tính ma trận nghịch đảo
    public static int[][] maTranNghichDao(int[][] maTran) {
        int n = maTran.length;
        int det = dinhThuc(maTran);
        if (det == 0) {
            System.out.println("Ma trận không có ma trận nghịch đảo.");
            return null;
        } else {
            int[][] maTranChuyenVi = chuyenVi(maTran);
            int[][] maTranNghichDao = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int[][] subMatrix = new int[n - 1][n - 1];
                    getCofactor(maTranChuyenVi, subMatrix, i, j);
                    maTranNghichDao[i][j] = (int) (Math.pow(-1, i + j) * dinhThuc(subMatrix) / det); // Chuyển từ double sang int
                }
            }
            return maTranNghichDao;
        }
    }


    // Mã hóa văn bản bằng thuật toán Hill với khóa 'key' và modulo 'mod'
    public static int[] encrypt(String plaintext, String key, int mod) {
        int m = (int) Math.sqrt(key.length());
        int[][] keyMatrix = textToMatrix(key, m);
        int[] plaintextNumbers = textToNumber(plaintext);
        int[] ciphertext = new int[plaintext.length()];

        for (int i = 0; i < plaintext.length(); i += m) {
            int[] block = Arrays.copyOfRange(plaintextNumbers, i, i + m);
            for (int j = 0; j < m; j++) {
                ciphertext[i + j] = multiply(keyMatrix, block, mod, j);
            }
        }

        return ciphertext;
    }

    public static String decrypt(int[] ciphertext, String key, int mod) {
        int m = (int) Math.sqrt(key.length());
        int[][] keyMatrix = maTranNghichDao(textToMatrix(key, m));

        if (keyMatrix == null) {
            System.out.println("Không thể giải mã do ma trận khóa không có ma trận nghịch đảo.");
            return "";
        }

        int[] plaintextNumbers = new int[ciphertext.length];

        for (int i = 0; i < ciphertext.length; i += m) {
            int[] block = Arrays.copyOfRange(ciphertext, i, i + m);
            for (int j = 0; j < m; j++) {
                plaintextNumbers[i + j] = multiply(keyMatrix, block, mod, j);
            }
        }

        StringBuilder plaintext = new StringBuilder();
        for (int num : plaintextNumbers) {
            plaintext.append(numberToText(num));
        }

        return plaintext.toString();
    }
    public static void main(String[] args) {
        String plaintext = "HOANGDUONG"; // Văn bản gốc cần mã hóa
        String key = "CDDG"; // Ma trận khóa (ma trận 3x3)
        int modulo = 26; // Modulo cho thuật toán Hill

        // Mã hóa văn bản
        int[] ciphertext = encrypt(plaintext, key, modulo);
        System.out.println("Văn bản mã hóa: " + Arrays.toString(ciphertext));

        // Giải mã văn bản
        String decryptedText = decrypt(ciphertext, key, modulo);
        System.out.println("Văn bản giải mã: " + decryptedText);
    }
}
