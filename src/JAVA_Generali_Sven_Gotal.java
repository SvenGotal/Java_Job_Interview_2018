///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
/*
 *	Autor: Sven Gotal 																		Datum: 13:06:2018 - 22:51
 * 	
 * 	Program: citac iz zadanog .txt formata map-mock.txt
 */
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JAVA_Generali_Sven_Gotal {
	
	public static class info{
		
		String jezik;
		int bodovi;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/* Deklaracije */
		info[] Data = new info[11];		// Object Array za pohranu podataka iz .txt
		for(int i = 0; i < Data.length; ++i) Data[i] = new info(); // Instacijacija objekata u array Data
			
		BufferedReader br = new BufferedReader(new FileReader("map-mock.txt")); // citac za .txt
		Scanner scan = new Scanner(System.in);	// citac za user input
		
		String line, num;
		int counter = 0, temp = 1, j = 0, min = 0, max = 0;
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/* Citanje iz .txt linija po linija */
		while((line = br.readLine()) != null) {
					
			/* iteracija kroz string i rucno trazenje delimitera ';' */
			for(int i = 0; i < line.length() - 1; ++i) {
				if( line.charAt(i) != ';') {
					counter++;
				}																										
			}
			/* substring num za izvlacenje integera */
			num = line.substring(counter, line.length()).replace(";", "").trim();
			temp = Integer.parseInt(num);
			
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/* Inicijalizacija objekata sa podatcima iz .txt */
			Data[j].jezik = line.substring(0, counter).toString().replaceAll(";", " ").trim();			
			Data[j].bodovi = temp;
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			++j; temp = 0; counter = 0; // j - iterator kroz objekte | counter - pokazivac na duljinu prvog stringa
			
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		/* rucno sortiranje objekata unutar niza prema bodovima */
		info Temporary = new info(); // Privremeni objekt za pomoc u sortiranju		
		for(int i = 0; i < Data.length; ++i)
		{
			for( int z = 0; z < Data.length; ++z){
			
				if (Data[i].bodovi < Data[z].bodovi) {
					Temporary = Data[i];
					Data[i] = Data[z];
					Data[z] = Temporary;
				}
			}
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////					
	
		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/* Upis Granica za pretragu (Bonus dio) */
		System.out.print("Upišite donju granicu pretrage: ");
		min = scan.nextInt();
		System.out.print("Upišite gornju granicu pretrage: ");
		max = scan.nextInt();
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		/* Zavrsni ispis temeljen na unesenim granicama od strane korisnika */
		for(int i = 0; i < 11; ++i) {
			if( Data[i].bodovi >= min && Data[i].bodovi <= max) {
				System.out.print("Jezik: " + Data[i].jezik + "\n");
				System.out.print("Value: ");
				System.out.print(Data[i].bodovi);
				System.out.print("\n\n");
			}
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		/* zatvaranje citaca */
		br.close();
		scan.close();
	}
}
