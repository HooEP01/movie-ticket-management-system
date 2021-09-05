package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.input.KeyCode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

public class TheMovieSystemFX extends Application {

    // Instance of MovieTicketSystem class
    MovieTicketSystem arrayList = new MovieTicketSystem();

    //----------------Movie Seat-------------------
    static String[][] sampleSeatID = {{"A1", "A2", "A3", "A4", "A5"}, 
    					 			  {"B1", "B2", "B3", "B4", "B5"}, 
    					 			  {"C1", "C2", "C3", "C4", "C5"}, 
    					 			  {"D1", "D2", "D3", "D4", "D5"}, 
    					 			  {"E1", "E2", "E3", "E4", "E5"}};
    
    // Four movies
    String[][] seatMovieID1 = new String[5][5];
    String[][] seatMovieID2 = new String[5][5];
    String[][] seatMovieID3 = new String[5][5];
    String[][] seatMovieID4 = new String[5][5];
    static String[][] seatID = new String[5][5];
    // Constraint
    final int seatNumber = 25;

    //-----------------UI control--------------------
    Button      btnDis = new Button("Display"),
    	        btnBuy = new Button("Purchase"),
    	        btnFind = new Button("Find"),
    	        btnDlt = new Button("Delete");
    TextArea    taTable = new TextArea(),
    		    taTable2 = new TextArea(),
    		    taTable3 = new TextArea();
    TextField   tfCustID = new TextField(),
    		    tfCustName = new TextField();
    RadioButton tfPCustType = new RadioButton("Member"),
    			tfRCustType = new RadioButton("Non-Member");
    TextField   tfAdultQty = new TextField(),
    			tfKidQty = new TextField(),
     			tfSeatID = new TextField(),
     			tfTotal = new TextField(),
     			tfDisc = new TextField(),
     			tfdelCustID = new TextField(),
     			tffindID = new TextField();
    ComboBox<String> tfMovie = new ComboBox<String>(),
    				 tfFindMovie = new ComboBox<String>();
    TabPane     tabPane = new TabPane();
    Label 		lbTitle = new Label("The SKYE Movie Ticketing System"),
    			adt = new Label("Adult:"),
    			kid = new Label("Kid:"),
    			lbbuy = new Label("Buy Ticket"),
    			lbdis = new Label("Display Seat"),
    			lbdlt = new Label("Remove Ticket"),
    			lbfind = new Label("Display Purchased Details");
    ScrollPane 	sp = new ScrollPane(taTable),
    			sp2 = new ScrollPane(taTable2),
    			sp3 = new ScrollPane(taTable3);
    ToggleGroup group = new ToggleGroup();
    //constraint
    final int   numID = 100;
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        //---------------------------------------------------------------------------------//
        //GridPane
    	
    	//Add tab (GridPane)
    	GridPane gp = new GridPane();
        gp.setHgap(15);
        gp.setVgap(15);
        gp.setPadding(new Insets(15, 50, 15, 50));
        //1st row
        gp.add(new Label("Customer ID:"), 0, 0);
        gp.add(tfCustID, 1, 0);
        //2nd row
        gp.add(new Label("Customer Name:"), 0, 1);
        gp.add(tfCustName, 1, 1);
        //3rd row
        gp.add(new Label("Customer Type:"), 0, 2);
        HBox pCenter = new HBox(20);
        pCenter.getChildren().addAll(tfPCustType, tfRCustType);
        gp.add((pCenter), 1, 2);
        tfPCustType.setToggleGroup(group);
        tfRCustType.setToggleGroup(group);
        //4th row
        gp.add(new Label("Movie:"), 0, 3);
        gp.add(tfMovie, 1, 3);
        //box
        tfMovie.getItems().add("Fast & Furious 9");
        tfMovie.getItems().add("Avenger: End Game");
        tfMovie.getItems().add("Godzilla vs Kong");
        tfMovie.getItems().add("The Conjuring");      
        //5th row
        gp.add(new Label("Quantity:"), 0, 4);
        HBox qty = new HBox(20);
        qty.getChildren().addAll(adt, tfAdultQty, kid, tfKidQty);
        qty.setPadding(new Insets(10, 0, 0, 10));
        gp.add((qty), 1, 4);
        tfAdultQty.setEditable(true);
        tfKidQty.setEditable(true);
        //6th row
        gp.add(new Label("Seat Display:"), 0, 5);
        gp.add(sp, 1, 5);
        //7th row
        gp.add(new Label("Seat ID:"), 0, 6);
        gp.add(tfSeatID, 1, 6);
        //8th row
        gp.add(new Label("Discount:"), 0, 7);
        gp.add(tfDisc, 1, 7);
        //9th row
        gp.add(new Label("Total Price:"), 0, 8);
        gp.add(tfTotal, 1, 8);
        tfDisc.setEditable(false);
        tfTotal.setEditable(false);

        //Delete Tab(GridPane)
        GridPane gp2 = new GridPane();
        gp2.setHgap(15);
        gp2.setVgap(15);
        gp2.setPadding(new Insets(15, 50, 15, 50));
        //1st row
        gp2.add(new Label("Customer ID:"), 0, 0);
        gp2.add(tfdelCustID, 1, 0);
        gp2.add(btnDlt, 2, 0);

        //Find Tab(GridPane)
        GridPane gp3 = new GridPane();
        gp3.setHgap(15);
        gp3.setVgap(15);
        gp3.setPadding(new Insets(15, 50, 15, 50));
        //1st row
        gp3.add(new Label("Customer ID:"), 0, 0);
        gp3.add(tffindID, 1, 0);
        gp3.add(btnFind, 2, 0);

        //---------------------------------------------------------------------------------------//
        //HBOX
        
        //Add tab
        //HBox (Button)
        HBox hb = new HBox();
        hb.getChildren().addAll(btnBuy);
        hb.setAlignment(Pos.BASELINE_RIGHT);
        hb.setSpacing(20);
        hb.setPadding(new Insets(10, 20, 10, 20));

        //Delete/Display tab
        //Hbox(combobox, button)
        HBox dishb = new HBox();
        tfFindMovie.getItems().add("Fast & Furious 9");
        tfFindMovie.getItems().add("Avenger: End Game");
        tfFindMovie.getItems().add("Godzilla vs Kong");
        tfFindMovie.getItems().add("The Conjuring");
        tfFindMovie.setValue("Fast & Furious 9");
        dishb.getChildren().addAll(tfFindMovie,btnDis);
        dishb.setAlignment(Pos.BASELINE_RIGHT);
        dishb.setSpacing(20);
        dishb.setPadding(new Insets(10, 20, 10, 20));
        
        //---------------------------------------------------------------------------------------------//
        //Style
        //Textfield BG
        tfCustID.setStyle("-fx-background-color: rgba(53,89,319,0.2);");
        tfCustName.setStyle("-fx-background-color: rgba(53,89,319,0.2);");
        tfCustID.setStyle("-fx-background-color: rgba(53,89,319,0.2);");
        tfAdultQty.setStyle("-fx-background-color: rgba(53,89,319,0.2);");
        tfKidQty.setStyle("-fx-background-color: rgba(53,89,319,0.2);");
        tfMovie.setStyle("-fx-background-color: rgba(53,89,319,0.2);");
        tfSeatID.setStyle("-fx-background-color: rgba(53,89,319,0.2);");
        tfdelCustID.setStyle("-fx-background-color: rgba(53,89,319,0.2);");
        tffindID.setStyle("-fx-background-color: rgba(53,89,319,0.2);");

        //Textfield BG dark
        tfDisc.setStyle("-fx-background-color: rgba(53,89,119,0.2);");
        tfTotal.setStyle("-fx-background-color: rgba(53,89,119,0.2);");
        
        //Button Style
        btnBuy.setStyle("-fx-background-radius:30, 30, 30, 30; "
                + "-fx-background-color:#d1e2ff");
        btnDlt.setStyle("-fx-background-radius:30, 30, 30, 30; "
                + "-fx-background-color:#d1e2ff");
        btnDis.setStyle("-fx-background-radius:30, 30, 30, 30; "
                + "-fx-background-color:#d1e2ff");
        btnFind.setStyle("-fx-background-radius:30, 30, 30, 30; "
                + "-fx-background-color:#d1e2ff");

        //Title Style
        lbTitle.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        lbTitle.setTextFill(Color.BLUE);
        lbTitle.setStyle("-fx-background-color:  ");
        lbTitle.setAlignment(Pos.CENTER);

        lbbuy.setFont(Font.font("Time New Romans", FontWeight.BOLD, 20));
        lbbuy.setTextFill(Color.BLUE);
        lbbuy.setPadding(new Insets(10, 20, 0, 20));

        lbdlt.setFont(Font.font("Time New Romans", FontWeight.BOLD, 20));
        lbdlt.setTextFill(Color.BLUE);
        lbdlt.setPadding(new Insets(10, 20, 0, 20));

        lbdis.setFont(Font.font("Time New Romans", FontWeight.BOLD, 20));
        lbdis.setTextFill(Color.BLUE);
        lbdis.setPadding(new Insets(10, 20, 0, 20));

        lbfind.setFont(Font.font("Time New Romans", FontWeight.BOLD, 20));
        lbfind.setTextFill(Color.BLUE);
        lbfind.setPadding(new Insets(10, 20, 0, 20));

        //----------------------------------------------------------------------
        //ScrollPane
        //add tab
        sp.setStyle("-fx-background: #B1FFFF; -fx-border-color: #90EE90;");
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setPrefViewportWidth(500);
        sp.setPrefViewportHeight(250);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        taTable.setEditable(false);
        //delete/display tab
        sp2.setStyle("-fx-background: #B1FFFF; -fx-border-color: #90EE90;");
        sp2.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp2.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp2.setPrefViewportWidth(750);
        sp2.setPrefViewportHeight(200);
        sp2.setFitToWidth(true);
        sp2.setFitToHeight(true);
        taTable2.setEditable(false);
        //find tab
        sp3.setStyle("-fx-background: #B1FFFF; -fx-border-color: #90EE90;");
        sp3.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp3.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp3.setPrefViewportWidth(750);
        sp3.setFitToWidth(true);
        taTable3.setEditable(false);
        
        
        //----------------------------------------------------------------------------------------------//
        // VBox & HBox
        //add
        VBox vb = new VBox(10);
        vb.getChildren().addAll(lbbuy, gp, hb);
        vb.setStyle("-fx-background-color: #a5c6ff ");
        HBox add = new HBox();
        add.getChildren().addAll(vb);
        //delete
        VBox vb2 = new VBox(10);
        vb2.getChildren().addAll(lbdis, dishb, sp2, lbdlt, gp2);
        vb2.setStyle("-fx-background-color: #a5c6ff ");
        HBox dlt = new HBox();
        dlt.getChildren().addAll(vb2);
        // Find tab
        VBox vb3 = new VBox(10);
        vb3.getChildren().addAll(lbfind, gp3, sp3);
        vb3.setStyle("-fx-background-color: #a5c6ff ");
        HBox find = new HBox();
        find.getChildren().addAll(vb3);

        //----------------------------------------------------------------------------------------------------------------------
        //Process event
        btnBuy.setOnAction(e -> Add());
        btnDis.setOnAction(e -> Display(taTable2));
        btnDlt.setOnAction(e -> Delete());
        btnFind.setOnAction(e -> Find());
        tfMovie.setOnAction(e -> DisplaySeat(taTable));

        //Key Press event
        tfCustID.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.TAB || e.getCode().isDigitKey()) 
                {} 
            else {
            	 Error("Invalid data","Enter digits only!");
            }
        });
        tfdelCustID.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.TAB || e.getCode().isDigitKey()) 
                {} 
            else {
            	 Error("Invalid data","Enter digits only!");
            }
        });
        tffindID.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.TAB || e.getCode() == KeyCode.SHIFT || e.getCode().isDigitKey()) 
            {} 
            else {
            	Error("Invalid data","Enter digits only!");
            }
        });
        tfCustName.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.TAB || e.getCode() == KeyCode.SHIFT || e.getCode() == KeyCode.SPACE || e.getCode().isLetterKey())
                {} 
            else {
                Error("Error in Customer Name","Name can only be Letter.");
            }
        });
        tfAdultQty.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.TAB || e.getCode().isDigitKey())
                {} 
            else {
            	Error("Invalid data","Enter digits only!");
            }
        });
        tfKidQty.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.TAB || e.getCode().isDigitKey())
                {} 
            else {
            	Error("Invalid data","Enter digits only!");
            }
        });
        tfSeatID.setOnKeyPressed(e -> {
        	if(e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.TAB || e.getCode() == KeyCode.SHIFT || e.getCode() == KeyCode.COMMA || e.getCode().isLetterKey() || e.getCode().isDigitKey())
            {} 
        	else {
        		Error("Invalid data","Please Insert SeatID into SeatID text field with comma between seatIDs.");
        	}
        });
        
        //------------------------------------------------------------------------------------------------//
        //Tab(Main)
        Tab tab1 = new Tab("Buy Ticket");
        Tab tab2 = new Tab("Display/Remove Ticket");
        Tab tab3 = new Tab("Find Ticket");
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        tabPane.setStyle("-fx-background-color: yellow");
        tabPane.setStyle("-fx-background-color: #a5c6ff ");
        tabPane.getTabs().add(tab1);
        tab1.setContent(add);
        tabPane.getTabs().add(tab2);
        tab2.setContent(dlt);
        tabPane.getTabs().add(tab3);
        tab3.setContent(find);
        
        //---------------------------------------------------------------------------------------------------//
        //Scene setting
        Scene scene = new Scene(tabPane);
        primaryStage.setTitle("SKYE Movie Ticketing System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void Add() {

        try {
            int custId = Integer.parseInt(tfCustID.getText());
            String custName = tfCustName.getText();
            int aQty = Integer.parseInt(tfAdultQty.getText());
            int kQty = Integer.parseInt(tfKidQty.getText());
            String custMovie = tfMovie.getValue();

            String str = "";
            String[] custSeat = tfSeatID.getText().split(",", aQty + kQty);

            //check seat duplication
            for(int i = 0; i < custSeat.length; i++) {
            	for (int j = i+1; j < custSeat.length; j++) {
                        if (custSeat[i].equalsIgnoreCase(custSeat[j])) {
                            Error("Error in Seat ID", "Duplicate the seat ID.");
                            Clear(4);
                            return;
                        }
                }
            }
            //check seat availability 
            int found = 0;
            for (int i = 0; i < custSeat.length; i++) {
                for (int j = 0; j <= 4; j++) {
                    for (int k = 0; k <= 4; k++) {
                        if (custSeat[i].equalsIgnoreCase(seatID[j][k])) {
                            found++;
                        }
                    }
                }
            }

            if (custId < numID) {
            	Error("Error in Customer ID","Enter atleast three integers!");
                Clear(1);
                return;
                
            } 
            if (custName.length() < 1) {
                Error("Error in Customer Name","Please enter your name!");
                Clear(2);
                return;
            }
            if (tfPCustType.isSelected() && tfRCustType.isSelected()) {
                Error("Error in Customer Type","Please select one customer type.");
                return;
            } 
            if (custMovie != null ) {
                
            }else {
            	Error("Error in Movie","Please select one Movie!");
                return;
            }
            if ((aQty + kQty > seatNumber)) {
                Error("Error in Adult and Kid Quantity","Please select quantity not more than number of seat available.");
                Clear(3);
                return;
            }
            if (!(custSeat.length == aQty + kQty)) {
                Error("Error in Seat ID","The number of selected seat is unmatch with quality of adult and kid.");
                Clear(4);
                return;
            }
            if (found == custSeat.length) {

                if (tfPCustType.isSelected()) {
                	Info("Added Successfully");
                    str = arrayList.add(new Member(custId, custName, custMovie, custSeat, aQty, kQty));
                    Clear(7);
                } else if (tfRCustType.isSelected()) {
                	Info("Added Successfully");
                    str = arrayList.add(new Non_Member(custId, custName, custMovie, custSeat, aQty, kQty));
                    Clear(7);
                }

                String[] temp;
                temp = str.split(",", 2);
                String disc = temp[0];
                String total = temp[1];
                tfDisc.setText(disc);
                tfTotal.setText(total);

                for (int i = 0; i < custSeat.length; i++) {
                    for (int j = 0; j <= 4; j++) {
                        for (int k = 0; k <= 4; k++) {
                            if (custSeat[i].equalsIgnoreCase(seatID[j][k])) {
                                seatID[j][k] = "XX";
                            }
                        }
                    }
                }

            } else if (!(found == custSeat.length)) {
                Error("Error in Seat ID","The selected seat(s) is or are not found");
                tfSeatID.setText("");
            }

        } catch (NumberFormatException ex) {
        	
        	Error("Invalid Data","Please enter integer number in Customer ID, Adult Quantity, and Kid Quantity!");
        }

    }

    public void Find() {
        String info = "";
        int custId = Integer.parseInt(tffindID.getText());

        if (custId < 100) { //at least three integer.
            Error("Invalid data in Customer ID","Enter atleast three integers!");
            Clear(5);
        } else {
            info = arrayList.search(custId);
            taTable3.setText(info);
        }
    }

    public void Delete() {
        int custId = Integer.parseInt(tfdelCustID.getText());
        String[] custSeat;
        String custMovie;
        String[][] theSeatMovie = null;
        if (custId < 100) {
        	Error("Invalid data in Customer ID","Enter atleast three integers!");
            Clear(6);
        } else { 
        	custMovie = arrayList.getMovie(custId);
            custSeat = arrayList.remove(custId);
            
            if (custSeat[0].equals("null")) {
            	Info("Remove Unsuccessfully, cannot find the customer id.");
                
            } else {
            	Info("Remove Successfully");
            	
            	if(custMovie.equals("Fast & Furious 9")) {
                	theSeatMovie = seatMovieID1;
                }else if(custMovie.equals("Avenger: End Game")) {
                	theSeatMovie = seatMovieID2;
                }else if(custMovie.equals("Godzilla vs Kong")) {
                	theSeatMovie = seatMovieID3;
                }else if(custMovie.equals("The Conjuring")) {
                	theSeatMovie = seatMovieID4;
                }else {
                	//empty
                }
            	
                char p;
                char q;
                int r = 0;
                int s = 0;

                for (int i = 0; i < custSeat.length; i++) {
                    p = custSeat[i].charAt(0);
                    if (p == 'A') {
                        r = 0;
                    } else if (p == 'B') {
                        r = 1;
                    } else if (p == 'C') {
                        r = 2;
                    } else if (p == 'D') {
                        r = 3;
                    } else if (p == 'E') {
                        r = 4;
                    }
                    q = custSeat[i].charAt(1);
                    s = Integer.parseInt(String.valueOf(q)) - 1;
                    theSeatMovie[r][s] = custSeat[i];
                    
                }
            }
        }
    }

    public void Display(TextArea a) {
    	String custMovie = tfFindMovie.getValue().toString();
    	if(custMovie.equals("Fast & Furious 9")) {
        	createSeatID(seatMovieID1);
        }else if(custMovie.equals("Avenger: End Game")) {
        	createSeatID(seatMovieID2);
        }else if(custMovie.equals("Godzilla vs Kong")) {
        	createSeatID(seatMovieID3);
        }else if(custMovie.equals("The Conjuring")) {
        	createSeatID(seatMovieID4);
        }else {
        	//empty
        }
        String output = "\n\t\t\t\t\t\t|\t\t\tMovie Screen\t\t\t\t|\n\n";
        
        for (int i = 0; i <= 4; i++) {
            output += "\t\t\t\t\t\t";
            for (int j = 0; j <= 4; j++) {
                output += " | " + seatID[i][j] + " | \t";

            }
            output += "\n";
        }
        a.setText(output);
    }

    public void DisplaySeat(TextArea a) {
    	String custMovie = tfMovie.getValue().toString();
        
        if(custMovie.equals("Fast & Furious 9")) {
        	createSeatID(seatMovieID1);
        }else if(custMovie.equals("Avenger: End Game")) {
        	createSeatID(seatMovieID2);
        }else if(custMovie.equals("Godzilla vs Kong")) {
        	createSeatID(seatMovieID3);
        }else if(custMovie.equals("The Conjuring")) {
        	createSeatID(seatMovieID4);
        }else {
        	//empty
        }
    	
    	
        String output = "Please Insert SeatID into SeatID text field with comma between seatIDs,"
                + "\nFor example, A1,A2,A3 or a1,a2,a3 for three seats.\n"
                + "\n\t\t|\t\t\tMovie Screen\t\t\t\t|\n\n";
        for (int i = 0; i <= 4; i++) {
            output += "\t\t";
            for (int j = 0; j <= 4; j++) {
                output += " | " + seatID[i][j] + " | \t";

            }
            output += "\n";
        }
        a.setText(output);
    	
    }
    
	public static void createSeatID(String[][] id) {
		boolean empty = true;
		
		
		for(int i=0; i<=4;i++) {
        	for(int j=0; j<=4; j++) {
        		if(id[i][j] != null) {
        			empty = false;
        			break;
        		}
        	}
    	}
	
		if(empty) {
	    	for(int i=0; i<=4;i++) {
	        	for(int j=0; j<=4; j++) {
	        		id[i][j] = sampleSeatID[i][j];
	        	}
	    	}
		}else {
		// empty	
		}
		seatID = id;

    }

    // Error Method
 	public void Error(String e1, String e2) {
 		Alert alert = new Alert(Alert.AlertType.ERROR);
 		alert.setTitle(e1);
 		alert.setHeaderText(null);
 		alert.setContentText(e2);
 		alert.show();
 	}
 	
 	// Inform Method
 	public void Info(String e) {
 		JOptionPane.showMessageDialog(null, e);
 	}
    
 	// Clear Method
 	public void Clear(int option) {
		switch(option) {
			case 1: tfCustID.clear();
					tfCustID.requestFocus();
					break;
			case 2:	tfCustName.clear();
					tfCustName.requestFocus();
					break;
			case 3: tfAdultQty.clear();
					tfAdultQty.requestFocus();
					tfKidQty.clear();
					break;
			case 4: tfSeatID.clear();
					tfSeatID.requestFocus();
				 	break;
			case 5: tffindID.clear();
					tffindID.requestFocus();
					break;
			case 6: tfdelCustID.clear();
					tfdelCustID.requestFocus();
					break;
			case 7: tfCustID.clear(); tfCustName.clear(); tfAdultQty.clear(); tfKidQty.clear(); tfSeatID.clear(); tfMovie.setValue(""); group.selectToggle(null); taTable.setText("");
					break;
			default:
					break;
		}
	}
 	
    //Spinner Coverter
    class MyConverter extends StringConverter<Integer> {

        @Override
        public String toString(Integer object) {
            return object + "";
        }

        @Override
        public Integer fromString(String string) {
            return Integer.parseInt(string);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}