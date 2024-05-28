package ElGamal;

import java.util.Random;

public class ElGamal {
    public static int nghichdao(int e, int n) {
        int[] r = new int[100];
        int[] q = new int[100];
        int[] x = new int[100];
        int[] y = new int[100];

        int i = 1;
        r[0] = n;
        x[0] = 0;
        y[1] = 1;

        r[1] = e;
        x[1] = 1;
        y[0] = 0;

        while (r[i] != 0) {
            q[i] = r[i - 1] / r[i];
            r[i + 1] = r[i - 1] % r[i];
            x[i + 1] = x[i - 1] - q[i] * x[i];
            y[i + 1] = y[i - 1] - q[i] * y[i];
            i++;
        }
        if (x[i - 1] < 0)
            x[i - 1] += n;
        return x[i - 1];
    }

    public static int tinhmod(int a, int b, int n) {
        int[] np = new int[100];
        int i = 0;

        // Chuyển b thành dãy nhị phân
        while (b != 0) {
            np[i] = b % 2;
            b = b / 2;
            i++;
        }

        // Tính a^b % n
        int f = 1;
        for (int j = i; j >= 0; j--) {
            f = (f * f) % n;
            if (np[j] == 1) {
                f = (f * a) % n;
            }
        }

        return f;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false; // 1 và các số âm không phải là số nguyên tố
        }
        if (n <= 3) {
            return true; // 2 và 3 là số nguyên tố
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false; // Số chẵn hoặc chia hết cho 3 không phải là số nguyên tố
        }
        // Kiểm tra các số lẻ từ 5 đến căn bậc hai của n
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false; // Nếu n chia hết cho i hoặc i + 2, n không phải là số nguyên tố
            }
        }
        return true; // Nếu không có số nào từ 5 đến căn bậc hai của n chia hết cho n, n là số nguyên tố
    }

    public static int randomp(int n, int somax) {
        Random rand = new Random();
        int prime;
        do {
            prime = rand.nextInt(n) + 1; // Sinh một số ngẫu nhiên từ 1 đến n
        } while (!isPrime(prime) && prime <= somax); // Kiểm tra xem số vừa sinh có phải là số nguyên tố không
        return prime;
    }

    public static String textToDecimal(String text) {
        StringBuilder decimal = new StringBuilder();
        // Lặp qua từng ký tự trong văn bản
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            // Chuyển ký tự thành mã Unicode
            int unicode = c;
            decimal.append(unicode).append(" "); // Nối vào chuỗi thập phân và thêm dấu cách
        }
        return decimal.toString().trim(); // Xóa khoảng trắng cuối cùng và trả về kết quả
    }

    public static int[] mang10(String text) {
        String[] words = text.split(" ");
        int[] a = new int[words.length]; // Khởi tạo mảng số nguyên với độ dài là số lượng từ trong chuỗi

        // Gán giá trị cho từng phần tử trong mảng a từ chuỗi words
        for (int i = 0; i < words.length; i++) {
            a[i] = Integer.parseInt(words[i]);
        }

        return a; // Trả về mảng a sau khi đã gán giá trị cho các phần tử của nó
    }

    public static String convertToText(int number) {
        return Character.toString((char) number);
    }

    public static int randoma(int n) {
        Random rand = new Random();

        int prime = rand.nextInt(n - 1) + 1; // Sinh một số ngẫu nhiên từ 1 đến n-1

        return prime;
    }

    public static int randomx(int n) {
        Random rand = new Random();

        int prime = rand.nextInt(n - 2) + 1; // Sinh một số ngẫu nhiên từ 1 đến n-2

        return prime;
    }

    public static int max(int[] arr) {
        int max = arr[0]; // Giả sử phần tử đầu tiên là số lớn nhất
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // Cập nhật số lớn nhất nếu tìm thấy phần tử lớn hơn
            }
        }
        return max;
    }
    
}
