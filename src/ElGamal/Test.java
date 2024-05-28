package ElGamal;

import RSA.RSA;

public class Test {
public static void main(String[] args) {
	String text="Hiếu";
	 System.out.println("Van ma hoa la: "+ text);
	 System.out.println("Van ma hoa la: "+ text);
     String chuoiso = ElGamal.textToDecimal(text);
     System.out.println("Decimal representation: " + chuoiso);
     int[] mang = ElGamal.mang10(chuoiso);
     System.out.print("Thap luc: ");
     for(int i=0;i<mang.length;i++) {
     	System.out.print(mang[i]+" ");
     }
	int p=ElGamal.randomp(10000, ElGamal.max(mang));
	int a=ElGamal.randoma(p);
	int x=ElGamal.randomx(p);
	System.out.println();
//	System.out.println(p+" "+a+" "+x);
	System.out.println(ElGamal.nghichdao(550, 1759));
	int y=ElGamal.tinhmod(a,x,p);
	System.out.println("Khoa ca nhan: "+p+" "+a+" "+x);
	System.out.println("Khoa cong khai: "+p+" "+a+" "+y);
	int k=ElGamal.randoma(p);
	System.out.println("Giai ma: ");
    for(int i=0;i<mang.length;i++)
    {   int K=ElGamal.tinhmod(y, k, p);
    	int c1=ElGamal.tinhmod(a, k, p);
    	int c2=ElGamal.tinhmod(K*mang[i], 1, p);
       System.out.print("("+c1+","+c2+")");
    }
    System.out.println();
    System.out.println("Giai ma");
    for(int i=0;i<mang.length;i++)
    {   int K=ElGamal.tinhmod(y, k, p);
    	int c1=ElGamal.tinhmod(a, k, p);
    	int c2=ElGamal.tinhmod(K*mang[i], 1, p);
    	int K2=ElGamal.tinhmod(c1, x, p);
    	int m=ElGamal.nghichdao(K2, p);
    	int m2=ElGamal.tinhmod(m*c2, 1, p);
       System.out.print(m2+" ");
       
    }
    System.out.println();
    System.out.println("Text: ");
    for(int i=0;i<mang.length;i++)
    {   int K=ElGamal.tinhmod(y, k, p);
    	int c1=ElGamal.tinhmod(a, k, p);
    	int c2=ElGamal.tinhmod(K*mang[i], 1, p);
    	int K2=ElGamal.tinhmod(c1, x, p);
    	int m=ElGamal.nghichdao(K2, p);
    	int m2=ElGamal.tinhmod(m*c2, 1, p);
    	 String word =ElGamal.convertToText(m2);
         System.out.print(word);
       
    }
	
	
	
}
}
