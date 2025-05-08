package BattleField;
import SetField.Field;
import Ships.BattleShip;
import Ships.Carrier;
import Ships.Cruiser;
import Ships.Destroyer;
import Ships.Ship;
import Ships.Submarine;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   	int rows=11;
		int cols =10;
		char[][] coordinates= new char[11][10];
		Ship[] ships = new Ship[1];
		
		Carrier carrier = new Carrier("Barrier",100,5,100,coordinates,'#');
		BattleShip battleship = new BattleShip("Battleship",100,4,80,coordinates,'@');
		Cruiser cruiser = new Cruiser("Cruiser",100,3,60,coordinates,'=');
		Submarine submarine = new Submarine("Submarine",100,3,60,coordinates,'^');
		Destroyer destroyer = new Destroyer("Destroyer",100,2,40,coordinates,'o');
		
		ships[0]=carrier;
		//ships[1]=battleship;
		//ships[2]=cruiser;
		//ships[3]=submarine;
		//ships[4]=destroyer;
	
		Field field = new Field(rows,cols,ships);
	    field.viewFeild();
  
      }
     
	}


