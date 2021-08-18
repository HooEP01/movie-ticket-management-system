package application;

//-----Author: Hoo Ern Ping
//-----ID: B200152B

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TheMovieSystemFX extends Application {
	
	//-----instance of MovieTicketSystem class
	MovieTicketSystem arrayList = new MovieTicketSystem();
	
	String[][] seatID ={ {"A1","A2","A3","A4"},{"B1","B2","B3","B4"},{"C1","C2","C3","C4"},{"D1","D2","D3","D4"} };

	//-----Button
	Button addBtn = new Button("Add");
	
	//-----TextField
	TextField id = new TextField();
	TextField name = new TextField();
	TextField adultQty = new TextField();
	TextField kidQty = new TextField();
	TextField seat = new TextField();
	
	//-----ComboBox
	ComboBox<String> movie = new ComboBox<String>();
	
	//-----RadioButton
	RadioButton mem = new RadioButton("Member");
	RadioButton nonMem = new RadioButton("Non Member");
	
	@Override
	public void start(Stage primaryStage) {
		
		/*
		//-----GridPane
		GridPane gp = new GridPane();
		gp.setHgap(5);
		gp.setVgap(5);
		gp.setPadding(new Insets(30,30,30,30));
		gp.setAlignment(Pos.CENTER);
		
		//-----row 1
		gp.add(new Label(seatID[0][0]), 0, 0);
		gp.add(new Label(seatID[0][1]), 1, 0); 
		gp.add(new Label(seatID[0][2]), 2, 0);
		gp.add(new Label(seatID[0][3]), 3, 0);
		
		//-----row 2
		gp.add(new Label(seatID[1][0]), 0, 1);
		gp.add(new Label(seatID[1][1]), 1, 1); 
		gp.add(new Label(seatID[1][2]), 2, 1);
		gp.add(new Label(seatID[1][3]), 3, 1);
		
		//-----row 3
		gp.add(new Label(seatID[2][0]), 0, 2);
		gp.add(new Label(seatID[2][1]), 1, 2); 
		gp.add(new Label(seatID[2][2]), 2, 2);
		gp.add(new Label(seatID[2][3]), 3, 2);
		
		//-----row 4
		gp.add(new Label(seatID[3][0]), 0, 3);
		gp.add(new Label(seatID[3][1]), 1, 3); 
		gp.add(new Label(seatID[3][2]), 2, 3);
		gp.add(new Label(seatID[3][3]), 3, 3);
		*/
		
		
		//-----GridPane
		GridPane gp = new GridPane();
		gp.setHgap(5);
		gp.setVgap(5);
		gp.setPadding(new Insets(30,30,30,30));
		gp.setAlignment(Pos.CENTER);
		
		//-----ComboBoxItems
		movie.getItems().add("Movie Name 1");
		movie.getItems().add("Movie Name 2");
		movie.getItems().add("Movie Name 3");
		movie.getItems().add("Movie Name 4");
		movie.setValue("Movie Name 1");
		
		//------GridPaneAdd
		gp.add(new Label("ID: "), 0, 0);
		gp.add(id,1,0);
		gp.add(new Label("Name: "), 0, 1);
		gp.add(name,1,1);
		gp.add(new Label("Movie: "), 0, 2);
		gp.add(movie,1,2);
		gp.add(new Label("Adult: "), 0, 3);
		gp.add(adultQty,1,3);
		gp.add(new Label("Kid: "), 0, 4);
		gp.add(kidQty, 1, 4);
		gp.add(new Label("Seat: "), 0, 5);
		gp.add(seat, 1, 5);
		gp.add(mem, 0, 6);
		gp.add(nonMem, 1, 6);
		gp.add(addBtn, 0, 7);
		
		//-----group radio button
		ToggleGroup group = new ToggleGroup();
		mem.setToggleGroup(group);
		nonMem.setToggleGroup(group);

		//-----event handling - add button
		addBtn.setOnAction(e -> add());
		
		//-----BorderPane
		BorderPane p = new BorderPane();
		p.setCenter(gp);
		
		//-----set scene
		Scene scene = new Scene(p,400,400);
		
		//-----set stage
		primaryStage.setScene(scene);
		primaryStage.setTitle("SKYE MOVIE MANAGEMENT SYSTEM");
		primaryStage.show();
	}
	
	public void add() {
		int custId = Integer.parseInt(id.getText());
		String custName = name.getText();
		String custMovie = movie.getValue().toString();
		int aQty = Integer.parseInt(adultQty.getText());
		int kQty = Integer.parseInt(kidQty.getText());
		
		String info = "";
		
		String[] custSeat = seat.getText().split(",",aQty+kQty);

		int found = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < custSeat.length; k++) {
					if(custSeat[k].equalsIgnoreCase(seatID[i][j])) {
						found++;
					}
				}
			}	
		}
		
		if(found == custSeat.length) {
			if(mem.isSelected()) {
				info = arrayList.add(new Member(custId,custName,custMovie,custSeat,aQty,kQty));
				
			}else if(nonMem.isSelected()) {
				info = arrayList.add(new Non_Member(custId,custName,custMovie,custSeat,aQty,kQty));
			}
		}else {
			System.out.println("No found");
		}

		System.out.println(info);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
