package SetField;

public class Field {
	char[][] arrayBattle;
	int row=0;
	int col=0;
	
	public Field(int row,int col) {
		this.row=row;
		this.col=col;
		 arrayBattle = new char[this.row][this.col];
		  arrayBattle[0][0]=' ';
		    
	  	  for(int c=1;c<=this.col-1;c++) {
	  		  arrayBattle[0][c]=(char) (c+'0');
	  	  }
	  	  for(int r=0;r<=this.row-2;r++) {
	  		  arrayBattle[r+1][0]=(char)('A'+r);
	  	  }
	    
	    for(int r=1;r<=row-1;r++) {
	  	  for(int c=1;c<=col-1;c++) {
	  		  arrayBattle[r][c]='*';
	  	  }
	    }
	}

	public void viewFeild() {
		for(int r=0;r<=this.row-1;r++) {
		  	  for(int c=0;c<=this.col-1;c++) {
		            if(c==(this.col-1)) {
		          	  System.out.println(arrayBattle[r][c]);
		            }else {
		          	  System.out.print(arrayBattle[r][c]);
		            }  
		            } 
		  	  }
	}
  
    
    
  	  
}
