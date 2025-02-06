package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Giu_Page extends StackPane{
		
	public Giu_Page(){
		//Create carBlockchain and Car
		HandleCarBlock carblock = new HandleCarBlock();
		
		//Main Page 
		GridPane gp = new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		Button UserPage = new Button("User Page");
		Button NewCar = new Button("New Car entry");
		Button UpdateCar = new Button("Update Car");
		Button Back = new Button("Back");
		
		//User Page
		TextField VIN = new TextField();
		Button EnterVIN = new Button("Enter VIN");
		TextArea CarInformation = new TextArea();
		CarInformation.setEditable(false); 
		Label CInfo = new Label("Car Information");
		
		//New Car Page
		TextArea VINText = new TextArea();
		Label VLabel = new Label("VIN");
		TextArea Year = new TextArea();
		Label YLabel = new Label("Year");
		TextArea Make = new TextArea();
		Label MakeLabel = new Label("Make");
		TextArea mileage = new TextArea();
		Label MileageLabel = new Label("Mileage");
		TextArea Model = new TextArea();
		Label ModelLabel = new Label("Model");
		TextArea Price = new TextArea();
		Label PriceLabel = new Label("Price");
		TextArea Message = new TextArea();
		Label TimeLabel = new Label("Message");
		Message.setEditable(false); 
		Button enterNewCar= new Button("Enter New Car");
		
		//Update Page 
		TextArea VINUpdate = new TextArea(); 
		Label VINupLabel = new Label("VIN");
		TextArea DamageReport = new TextArea(); 
		Label DLabel = new Label("Damage Report");
		TextArea RepairReport = new TextArea(); 
		Label RLabel = new Label("Repair Report");
		TextArea ServiceReport = new TextArea(); 
		Label SLabel = new Label("Service Report");
		TextArea NewPrice = new TextArea(); 
		Label NLabel = new Label("New Price");
		TextArea Mess = new TextArea(); 
		Label TLabel = new Label("Message");
		Mess.setEditable(false); 
		Button  UpdateButton = new Button("Update Car");
		
		//Enter New Car Button
		enterNewCar.setOnAction(e->{
			
			try {
				if(!VINText.getText().equals("")&!Year.getText().equals(null)&!Make.getText().equals(null)&!mileage.getText().equals(null)&!Model.getText().equals(null)&!Price.getText().equals(null)) {
					String vin = VINText.getText();
					int year = Integer.parseInt(Year.getText());
					String carmake =  Make.getText(); 
					int  carmileage= Integer.parseInt(mileage.getText()) ;
					String carModel = Model.getText();
					double  carprice = Double.parseDouble(Price.getText());
					CarData car = new CarData( vin,year, carmake, carModel, carmileage, carprice);
					carblock.addCar(car);
					Message.clear();
					Message.setText("Car added Successfully");
					VINText.clear();
					Year.clear();
					Make.clear();
					Model.clear();
					mileage.clear();
	                Price.clear();
				}else {
					Message.clear();
					Message.setText("Fill in missing information");
				}
				
			}catch(Exception ex) {
				Message.clear();
				Message.setText("ERROR ADDING CAR");
				ex.printStackTrace();
			}
			
			
			
		});
		//Update Car 
		UpdateButton.setOnAction(e->{
			
			try {
				
				String upvin = VINUpdate.getText() != null ? VINUpdate.getText() : "";
				String upDamage = DamageReport.getText() != null ? DamageReport.getText() : "";
				String Report = RepairReport.getText() != null ? RepairReport.getText() : "";
				String Service = ServiceReport.getText() != null ? ServiceReport.getText() : "";
				double nprice = !NewPrice.getText().isEmpty() ? Double.parseDouble(NewPrice.getText()) :0.0 ;
				CarData c = carblock.getCarByVin(upvin);
				if(c!=null) {
					 carblock.updateCar(upvin, upDamage, Report, Service, nprice);
					   VINUpdate.clear();
					    DamageReport.clear();
					    RepairReport.clear(); 
					    ServiceReport.clear();
					    NewPrice.clear();
						 Mess.setText("Car updated Succesfully"); 
				}else {
					Mess.setText("VIN IS INVALID OR DOES NOT EXIST");
				}
			
			}catch(Exception ex) {
				Mess.setText("ERORR UPDATING CAR");
				ex.printStackTrace();
				
			}
			
		
		     
		});
	    // User View Cars 
		EnterVIN.setOnAction(e->{
			try {
				String vinFetch = VIN.getText();
				String car = carblock.Print(vinFetch);
				CarData c = carblock.getCarByVin(vinFetch);
				if(c!=null) {
					CarInformation.setText(car);
				}else {
					CarInformation.setText("VIN IS INVALID OR DOES NOT EXIST");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			 
			
		});
		//Set Up Main Page Buttons Gui
		UserPage.setOnAction(e->{
			gp.getChildren().clear();
            gp.add(VIN, 0, 0);
        	gp.add(EnterVIN, 1, 0);
        	gp.add(CInfo, 0, 1);
        	gp.add(CarInformation, 0, 2);
        	gp.add(Back, 0, 3);
		});
		
		NewCar.setOnAction(e->{
			gp.getChildren().clear();
	            gp.add(VINText, 1, 0);
	             gp.add(VLabel, 0, 0);
	        	gp.add(Year, 1, 1);
	        	 gp.add(YLabel, 0, 1);
	        	gp.add(Make, 1, 2);
	        	 gp.add(MakeLabel, 0, 2);
	        	gp.add(mileage, 1, 3);
	        	 gp.add(MileageLabel, 0, 3);
	        	gp.add(Model, 1, 4);
	        	 gp.add(ModelLabel, 0, 4);
	        	gp.add(Price, 1, 5);
	        	 gp.add(PriceLabel, 0, 5);
	        	gp.add(Message, 1, 6);
	        	 gp.add(TimeLabel, 0, 6);
	        	gp.add(enterNewCar, 0, 7);
	        	gp.add(Back, 0, 8);
        	
		});
		
		UpdateCar.setOnAction(e->{
		
			gp.getChildren().clear();
			gp.add(VINUpdate, 1, 0);
			gp.add(VINupLabel, 0, 0);
			gp.add(DamageReport, 1, 1);
			gp.add(DLabel, 0, 1);
			gp.add(RepairReport, 1, 2);
			gp.add(RLabel, 0, 2);
			gp.add(ServiceReport, 1, 3);
			gp.add(SLabel, 0, 3);
			gp.add(NewPrice, 1, 4);
			gp.add(NLabel, 0, 4);
			gp.add(Mess, 1, 5);
			gp.add(TLabel, 0, 5);
			gp.add(UpdateButton, 1, 6);
			gp.add(Back, 0, 7);
		});
		
		Back.setOnAction(e->{
			Message.clear();
			VINText.clear();
			Year.clear();
			Make.clear();
			Model.clear();
			mileage.clear();
            Price.clear();
            VIN.clear();
            CarInformation.clear();
            VINUpdate.clear();
		    DamageReport.clear();
		    RepairReport.clear(); 
		    ServiceReport.clear();
		    NewPrice.clear();
			 Mess.clear();
			gp.getChildren().clear();
			gp.add(UserPage, 0, 0);
			gp.add(NewCar, 0, 1);
			gp.add(UpdateCar, 0, 2);
		});
		
		gp.add(UserPage, 0, 0);
		gp.add(NewCar, 0, 1);
		gp.add(UpdateCar, 0, 2);
		this.getChildren().addAll(gp);
	}

}
