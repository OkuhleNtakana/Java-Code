package Ships;

public abstract class Ship {

	private int health;
	private int size;
	private int ammunition;
	private char[][] Coordinate;
	private char symbol;
	private String name;

	
	public Ship() {
		
	}
	
	public  Ship(String name,int health,int size,int ammunition,char[][] coordinates,char symbol) {
		this.name = name;
		this.health = health;
		this.size = size;
		this.ammunition = ammunition;
		this.Coordinate = coordinates;
		this.symbol=symbol;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getAmmunition() {
		return ammunition;
	}
	public void setAmmunition(int ammunition) {
		this.ammunition = ammunition;
	}
	public char[][] getCoordinate() {
		return this.Coordinate;
	}
	public void setCoordinate(char[][] Coordinate) {
		this.Coordinate = Coordinate;
	}
	
}
