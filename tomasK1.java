import java.io.*;
import java.util.StringTokenizer;

public class tomasK1 {

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
		File fd = new File ("duom.txt"); //Data file
		File fr = new File ("Rez.txt"); //result file
		int n = 0; //array A length.
		int m = 0; //array B length.
		PrintWriter rasyti = null;
		BufferedReader file_in = null;
		String s = null;
		
		tomasK1 L1 = new tomasK1();	//Create main class object
		
		try {
			file_in = new BufferedReader (new FileReader (fd));
			System.out.println("File found.");
			rasyti = new PrintWriter (new FileWriter (fr));
			
			System.out.println("Enter array length for array A:");
			s = in.readLine();
			n = Integer.parseInt(s);
			int A[] = new int[n];
						
			s = file_in.readLine();
			m = Integer.parseInt(s);
			int B[] = new int[m];
			
			A = L1.enter_array(in, n);
			L1.print_array_screen(A, n);
			L1.print_array_file(rasyti, A, n);
			
			B = L1.read_array(file_in, m);
			L1.print_array_file(rasyti, B, m);
			L1.print_array_screen(B, m);
			
			if (rasyti != null) rasyti.close();
		}
		catch (FileNotFoundException ex) {System.out.println("File not found"); }
		catch (IOException e) {System.out.println("Input error");}
	
	}
	
	public int[] read_array (BufferedReader file, int n){
		int A[] = new int [n]; //create array object
		String eilute;	// variable to read 1 line
		int sk = 0; //write to array counter
		while (true){
		try {
			if ((eilute = file.readLine()) == null) break; 
			StringTokenizer st = new StringTokenizer(eilute);
			int kiek_sk = st.countTokens();
			if (kiek_sk > n) kiek_sk = n;
			else n= n-kiek_sk;
			for (int i=0; i< kiek_sk; i++){
				A[sk]=Integer.parseInt(st.nextToken());
				sk ++;
				}
			if (kiek_sk==n) break;
		}
		catch (IOException e) {System.out.println("Input error");}
		catch (IndexOutOfBoundsException e) {System.out.println("Array out of bounds error");}
		}
		return A;
	}
	
	public int[] enter_array (BufferedReader input, int n) {
		int A[] = new int[n];
		String s = null;
		for (int i=0; i<n; i++){
			System.out.println("Enter array " + (i+1) +"-th element ");
			try {
				s = input.readLine();
				A[i] = Integer.parseInt(s);
			}
			catch (IOException e) {
				System.out.println("Error on array element input!");
				i--;
				}
			catch (NumberFormatException e) {
				System.out.println("Not an integer number!");
				i--;
				}
		}
		return A;
	}
	
	public void print_array_screen (int [] A, int n) {
		for (int i=0; i<n; i++) {
			System.out.print(A[i] +" ");
		}
		System.out.println();
	}
	
	public void print_array_file (PrintWriter rasyti, int [] A, int n) {

		rasyti.println(n);
		for (int i = 0; i < n; i++) {
			rasyti.print(A[i] + " ");
		}
		rasyti.println();
	}
}
