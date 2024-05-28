package CO_DIEN;

import java.util.ArrayList;
import java.util.List;

public class Vigenere {
	// Hàm chuyển đổi văn bản thành mảng các số, với A=0
		    public static int[] textToNumber(String text) {
		        int[] numbers = new int[text.length()];

		        for (int i = 0; i < text.length(); i++) {
		            int unicode = text.codePointAt(i);
		            numbers[i] = unicode - 'A';
		        }

		        return numbers;
		    }
		public static int [] mahoa(String text,String key,int m)
		{
			int[] banma= textToNumber(text);
			int a=banma.length;
			 int[]mahoa=new int[a];
			int[] k=textToNumber(key);
			int b=k.length;
			int ma;
			for(int i=0;i<a;i++)
			{
				  ma=(banma[i]+k[i%b]) % m;
				  if(ma<0) ma+=m;
				  mahoa[i]=ma;
				
			}
			return mahoa;
		}
		public static int [] Giaima(int[]mahoa,String key,int m)
		{
			
			int a=mahoa.length;
			 int[]giaima=new int[a];
			int[] k=textToNumber(key);
			int b=k.length;
			int ma;
			for(int i=0;i<a;i++)
			{
				  ma=(mahoa[i]-k[i%b]) % m;
				  if(ma<0) ma+=m;
				  giaima[i]=ma;
				
			}
			return giaima;
		}
		 public static String numberToText(int y) {
		     StringBuilder text = new StringBuilder();

		      
		         int unicode = y + 'A';
		         text.appendCodePoint(unicode);
		     

		     return text.toString();
		 }
		 
		public static void main(String[] args) {
			String text="An toàn và bảo mật thông tin";
			String key="CIPHER";
			int []mahoa=mahoa(text, key, 256);
			int []giaima=Giaima(mahoa, key, 256);
			System.out.println( "Ma hoa: " );
			for(int i=0;i<mahoa.length;i++)
			{
				System.out.print(mahoa[i]+" ");
			}
			System.out.println();
			System.out.println("giai ma: ");
			for(int i=0;i<giaima.length;i++)
			{
				System.out.print(giaima[i]+" ");
			}
			System.out.println();
			for(int i=0;i<giaima.length;i++)
			{
				System.out.print(numberToText(giaima[i])+" ");
			}
		}
		    
}
