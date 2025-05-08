package SetField;
import java.util.Random;
import java.util.Scanner;

import Ships.*;

public class Field {
	public char[][] arrayBattle;
	private int row=0;
	private int col=0;
	private Random rand = new Random();
	
	public Field(int row,int col,Ship[] ships) {
		//Instantiate local variables
		this.row=row;
		this.col=col;
		this.arrayBattle = new char[this.row][this.col];
	    this.arrayBattle[0][0]=' ';
	    
	    askUserCoOrdinates(ships,this.row,this.col);
	 //   ComputerSetCoOrdinates(ships,this.row,this.col);
		
	  	  for(int c=1;c<=this.col-1;c++) {
	  		  this.arrayBattle[0][c]=(char) (c+'0');
	  	  }
	  	  for(int r=0;r<=this.row-2;r++) {
	  		  this.arrayBattle[r+1][0]=(char)('A'+r);
	  	  }
	    
	      for(int r=1;r<=row-1;r++) {
		  	  for(int c=1;c<=col-1;c++) {
		  		  this.arrayBattle[r][c]='*';
		  	  }
	    }
	      
           for(Ship s:ships) {
        	   char[][] coor = s.getCoordinate();
        	   for(int r=1;r<=row-1;r++) {
     		  	  for(int c=1;c<=col-1;c++) {
     		  		
     		  		  if(coor[r][c]!=' ') {
     		  			  this.arrayBattle[r][c]=s.getSymbol(); 
     		  		  }
     		  		
     		  	  }
     	    }
	  	  }
	}

	public void viewFeild() {
		for(int r=0;r<=this.row-1;r++) {
		  	  for(int c=0;c<=this.col-1;c++) {
		            if(c==(this.col-1)) {
		          	  System.out.println(this.arrayBattle[r][c]);
		            }else {
		          	  System.out.print(this.arrayBattle[r][c]);
		            }  
		            } 
		  	  }
	}
	
	public void askUserCoOrdinates(Ship[] ships,int row,int col) {
		 //Ask User for Co-Ordinates
	    Scanner sc = new Scanner(System.in);
		for(Ship ship:ships) {
			System.out.println("Please enter the coordinates for "+ship.getName());
			char[][] co= new char[11][11];
			for(int r=1;r<=row-1;r++) {
	   		  	  for(int c=1;c<=col-1;c++) {
	   		  			  co[r][c]=' '; 
	   		  	  } 
	   		  		
	   		  	  }
			for(int i=0;i<ship.getSize();i++) {
				 System.out.println("Enter row letter for part " + (i + 1) + " (A-J): ");
			    char rowChar = sc.next().charAt(0);
				int r =  rowChar - 'A';
				System.out.println("Enter column number for part " + (i + 1) + " (1-9): ");
				int c= sc.nextInt();
				co[r+1][c]= ship.getSymbol(); 
			}
			ship.setCoordinate(co);
		}
		sc.close();
	}
   
	public void ComputerSetCoOrdinates(Ship[] ships,int row,int col) {
		if(arrayBattle[row][col]== ' ') {
				 random(row,col,1,9);
	     }else{
	    	 arrayBattle[row][col]= ships[1].getSymbol();
	     }
	}
	
	public void random(int row,int col,int min, int max) {
		 row = rand.nextInt(max - min + 1) + min;
	     col = rand.nextInt(max - min + 1) + min;
	
	}
    
    
  	  
}
