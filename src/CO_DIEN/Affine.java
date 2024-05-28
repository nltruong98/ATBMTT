package CO_DIEN;

import java.util.Random;

public class Affine {
    // Hàm chuyển đổi văn bản thành mảng các số, với A=0
    public static int[] textToNumber(String text) {
        int[] numbers = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            int unicode = text.codePointAt(i);
            numbers[i] = unicode - 'A';
        }

        return numbers;
    }
    public static int gcd(int a,int b)
    {
    	while(a!=0)
    	{
    		int tg=a;
    		a=b%a;
    		b=tg;
    	}
    	return b;
    }
    public static int random(int n) {
        Random rand = new Random();

        int prime = rand.nextInt(n-1 ) + 1; // Sinh một số ngẫu nhiên từ 1 đến n

        return prime;
    }
   public static int nghichdao(int a,int b)
   {
	   int []r=new int[100];
	   int []q=new int[100];

	   int []x=new int[100];
	   int []y=new int[100];
	   int i=0;
	   r[i]=b;
	   x[i]=0;
	   y[i]=1;
	   i++;
	   r[i]=a;
	   x[i]=1;
	   y[i]=0;
	   while(r[i]!=0)
	   {
		   q[i]=r[i-1]/r[i];
		   r[i+1]=r[i-1]%r[i];
		   x[i+1]=x[i-1]-q[i]*x[i];
		   y[i+1]=y[i-1]-q[i]*y[i];
		   i++;
	   }
	   if(x[i-1]<0) x[i-1]+=b;
	   return x[i-1];
   }
 public static int mahoa(int a,int b,int x,int m)
 {
	 int y=(a*x+b)%m;
	 return y;
 }
 public static int giaima(int a,int b,int y,int m)
 {
	 int h=(y-b) %m;
	 int k=nghichdao(a,m);
	 int x=(k*h)%m;
	 if(x<0) x+=m;
	 return x;
 } // Hàm chuyển đổi số thành ký tự, với A=0
 public static String numberToText(int y) {
     StringBuilder text = new StringBuilder();

      
         int unicode = y + 'A';
         text.appendCodePoint(unicode);
     

     return text.toString();
 }
 
    public static void main(String[] args) {
        String text = "HOT"; // Văn bản gốc
        int[] numbers = textToNumber(text);

        // In ra mảng số
        System.out.print("Số tương ứng với văn bản: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        int m=26;
        int a,b=7,y;
        do {
        	a=random(m);
        }while(gcd(a, m)!=1&&a>1);
        System.out.println();
        System.out.println("a="+a);
        System.out.println("Ma hoa: ");
        for (int x : numbers) {
            System.out.print(mahoa(a, b, x, m)+" ");
        }
        System.out.println();
        for (int x : numbers) {
        	y=mahoa(a, b, x, m);
        	System.out.print(numberToText(y)+" ");
        }
        System.out.println();
        System.out.println("Giai ma: ");
        
        for (int x : numbers) {
        	y=mahoa(a, b, x, m);
        System.out.print(giaima(a, b, y, m)+" ");	
        }
        System.out.println();
        for (int x : numbers) {
        	y=mahoa(a, b, x, m);
        x=giaima(a, b, y, m);	
        System.out.print(numberToText(x)+" ");
        }
    }
}
