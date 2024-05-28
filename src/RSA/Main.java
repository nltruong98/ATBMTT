package RSA;

public class Main {
    public static void main(String[] args) {
        int p = RSA.random(100); // Sinh một số nguyên tố ngẫu nhiên p
        int q = RSA.random(100); // Sinh một số nguyên tố ngẫu nhiên q

        RSA rsa = new RSA(p, q); // Khởi tạo RSA với hai số nguyên tố p và q

        int n = p * q; // Tính n
        int phi = (p - 1) * (q - 1); // Tính phi(n)
        System.out.println("timd "+rsa.timd(550, 1759));
        System.out.println("tinhmod "+rsa.tinhmod(7, 560, 561));
        int e = rsa.chooseE(phi); // Chọn số e
        int d = rsa.timd(e, phi); // Tính số d
        String text = "An toàn và bảo mật thông tin"; // Văn bản Unicode
        System.out.println("Van ma hoa la: "+ text);
        String chuoiso = rsa.textToDecimal(text);
        System.out.println("Decimal representation: " + chuoiso);
        int[] mang = rsa.mang10(chuoiso);
        System.out.print("Thap luc: ");
        for(int i=0;i<mang.length;i++) {
        	System.out.print(mang[i]+" ");
        }
        System.out.println();
        // Hiển thị khóa công khai và bí mật
        System.out.println("Public key (n, e): (" + n + ", " + e + ")");
        System.out.println("Private key (n, d): (" + n + ", " + d + ")");
        System.out.println("Ma hoa: ");
        for(int i=0;i<mang.length;i++)
        {
		int chuoimahoa = rsa.mahoa(mang[i], e, n); 
        System.out.print( chuoimahoa+" ");
        }
        System.out.println();
        System.out.println("Giai ma: ");
        for(int i=0;i<mang.length;i++)
        {
		int chuoimahoa = rsa.mahoa(mang[i], e, n); 
        int chuoigiaima=rsa.giaima(chuoimahoa, d, n);
        System.out.print(chuoigiaima+" ");
        }
        System.out.println();
        System.out.println("Ma hoa dang van ban: ");
        for(int i=0;i<mang.length;i++)
        {
		int chuoimahoa = rsa.mahoa(mang[i], e, n); 
        int chuoigiaima=rsa.giaima(chuoimahoa, d, n);
        String word = rsa.convertToText(chuoigiaima);
        System.out.print(word);
        }
    }

}

