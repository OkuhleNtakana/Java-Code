package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import acsse.csc03a3.Block;
import acsse.csc03a3.Blockchain;
import acsse.csc03a3.Transaction;

public class HandleCarBlock extends Blockchain<CarData> {

	private List<Transaction<CarData>> transactions ;
	private List<Block<CarData>> blockList;

	 public HandleCarBlock() {
	        super();
	        this.transactions = new ArrayList<>();
	        blockList = new ArrayList<>();
	    }
    public void addCar(CarData carData) {
        Transaction<CarData> transaction = new Transaction<>("Dealer", "Owner", carData);
        Block<CarData>  block = new Block<CarData>("Dealer", transactions);
        
        Random random = new Random();
        int randomNumber =  random.nextInt(Integer.MAX_VALUE);;
        this.registerStake("localhost",randomNumber);
        transactions.add(transaction);
        this.addBlock(transactions);
        blockList.add(block);
    }

    public void updateCar(String vin, String damageReport, String repairReport, String serviceReport, double newPrice) {
      
            CarData carData = getCarByVin(vin);
            if (carData != null) {	
                CarData updatedCarData = new CarData(carData.getVin(), carData.getYear(), carData.getMake(), carData.getModel(), carData.getMileage(), newPrice);
                updatedCarData.setDamageReport(damageReport);
                updatedCarData.setRepairReport(repairReport);
                updatedCarData.setServiceReport(serviceReport);
                Transaction<CarData> transaction = new Transaction<>("Service", "Owner", updatedCarData);
                List<Transaction<CarData>> transactions = new ArrayList<>();
                transactions.add(transaction);
                this.addBlock(transactions);
                Block<CarData> block = new Block<CarData>("Service", transactions);
                blockList.add(block);
            }
        
    }


    
    	 public CarData getCarByVin(String vin) {
    	        List<Block<CarData>> blocks = getBlocksInBlockchain(); 
    	        if (blocks == null) {
    	            return null;
    	        }
    	        for (Block<CarData> block : blocks) {
    	            for (Transaction<CarData> transaction : block.getTransactions()) {
    	                if (transaction.getData() != null && transaction.getData().getVin().equalsIgnoreCase(vin)) {
    	                    return transaction.getData(); 
    	                }
    	            }
    	        }

    	        return null; 
    	    }  
    

    
    	 public String Print(String vin) {
    	        StringBuilder build = new StringBuilder();
    	        List<Block<CarData>> blocks = getBlocksInBlockchain(); 
    	        if (blocks == null) {
    	            return null;
    	        }
    	   
    	        for (Block<CarData> block : blocks) {
    	            for (Transaction<CarData> transaction : block.getTransactions()) {
    	                if (transaction.getData() != null && transaction.getData().getVin().equalsIgnoreCase(vin)) {
    	                    build.append(transaction.toString()).append("\n");
    	                }
    	            }
    	        }

    	        return build.toString(); 
    	    }


    private List<Block<CarData>> getBlocksInBlockchain() {
      return blockList; 
    }
}
