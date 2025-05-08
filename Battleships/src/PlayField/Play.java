package PlayField;

import java.util.Random;
import java.util.Scanner;

import SetField.Field;
import Ships.Ship;

public class Play {

	private Field field;
	//private Ship[] ships;
	private Random rand = new Random();
	private int min=1;
	private int max=11;
	private int row;
	private int col;
	private int tries =10;
	
	public Play(Field field,Ship[] ships) {
		this.field=field;
		//this.ships=ships;
	}
	
	public void ComputerPlays() {
		//	Computer Guesses Co-ordinates
		for(int i=0;i<tries;i++) {
			random(row,col,min,max);
			check(row,col,'x',tries,min,max,0);
			// Improvements: Get the computer to guess smarter, now its just random 
		} 
	   field.viewFeild();
	}
	
	public void PlayerPlays() {
        // Player Guesses Co-ordinates
			for(int i=0;i<tries;i++) {
				askUser(row,col);
				check(row,col,'x',tries,min,max,1);
			} 
		   field.viewFeild();

	}
	 
	
	public void random(int row,int col,int min, int max) {
		 row = rand.nextInt(max - min + 1) + min;
	     col = rand.nextInt(max - min + 1) + min;
	
	}
	public void askUser(int r,int c) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<tries;i++) {
			 System.out.println("Enter row letter for part " + (i + 1) + " (A-J): ");
		    char rowChar = sc.next().charAt(0);
			 r =  rowChar - 'A';
			System.out.println("Enter column number for part " + (i + 1) + " (1-9): ");
			 c= sc.nextInt();
		}
		sc.close();
	}
	
	public void check(int row,int col,char symbol,int tr,int mini,int maxi,int whoPlays) {
		 if(field.arrayBattle[row][col]== symbol) {
			 if(whoPlays==0) {
				 random(row,col,mini,maxi);
			 }else {
				 askUser(row,col);
			 }
	    	 
	    	 check(row,col,symbol,tr,mini,maxi,whoPlays);
	     }else if(field.arrayBattle[row][col]== '*'){
	    	 field.arrayBattle[row][col]= symbol;    
	     }else{
	    	 field.arrayBattle[row][col]= symbol;    
	    	 tr++;
	     }
	}
	
}
