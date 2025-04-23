package BattleField;
import java.util.Scanner;

import SetField.Field;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Please enter number of row //NB 2<n<28");
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		System.out.println("Please enter number of colums //NB 2<n<10");
		int cols = sc.nextInt();
		
      Field field = new Field(rows,cols);
      field.viewFeild();
      }
     
	}


