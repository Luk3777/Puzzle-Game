package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class GameController {
	Button arr[]=new Button[10];
	HashMap<String, Button> map = new HashMap<String, Button>();
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    private Button bt3;
    @FXML
    private Button bt4;
    @FXML
    private Button bt5;
    @FXML
    private Button bt6;
    @FXML
    private Button bt7;
    @FXML
    private Button bt8;
    @FXML
    private Button bt9;
    @FXML
    private Label lbl_win;
    @FXML
    private Button res;
    
    @FXML
    void select(ActionEvent event) {
    	String clicked=event.getSource().toString().substring(10, 13);
    	if(checkValid(clicked)) {
    		String temp;
    		temp=map.get(clicked).getText();
    		map.get(findNull()).setText(temp);
    		map.get(clicked).setText("");
    		if(checkEnd()) {
    			lbl_win.setVisible(true);
        		end();
    		}
    	}
    }
    
    boolean checkValid(String btn) {
    	boolean check=false;
    	switch(btn) {
    	case "bt1":
    		if(findNull().equals("bt2")||findNull().equals("bt4"))
    			check=true;
    		break;
    	case "bt2":
    		if(findNull().equals("bt1")||findNull().equals("bt3")||findNull().equals("bt5"))
    			check=true;
    		break;
    	case "bt3":
    		if(findNull().equals("bt2")||findNull().equals("bt6"))
    			check=true;
    		break;
    	case "bt4":
    		if(findNull().equals("bt1")||findNull().equals("bt5")||findNull().equals("bt7"))
    			check=true;
    		break;
    	case "bt5":
    		if(findNull().equals("bt2")||findNull().equals("bt4")||findNull().equals("bt6")||findNull().equals("bt8"))
    			check=true;
    		break;
    	case "bt6":
    		if(findNull().equals("bt3")||findNull().equals("bt5")||findNull().equals("bt9"))
    			check=true;
    		break;
    	case "bt7":
    		if(findNull().equals("bt4")||findNull().equals("bt8"))
    			check=true;
    		break;
    	case "bt8":
    		if(findNull().equals("bt7")||findNull().equals("bt5")||findNull().equals("bt9"))
    			check=true;
    		break;
    	case "bt9":
    		if(findNull().equals("bt6")||findNull().equals("bt8"))
    			check=true;
    		break;
    	}
    	return check;
    }
    
    String findNull(){
    	int x=1;
    	do {
    		if(arr[x].getText()=="") {
    			return arr[x].getId();
    		}
    		x++;
    	}while(true);
    }
    
    boolean checkEnd() {
    	int conta=0;
    	for(int x=1;x<=9;x++) {
    		if(arr[x].getText().equals(Integer.toString(x)))
    			conta++;
    		else if(x==9&&arr[x].getText()=="")
    			conta++;
    	}
    	if(conta==9)
    		return true;
    	else
    		return false;
    }
    
    void gen() {
    	ArrayList<Integer> m = new ArrayList<Integer>();
    	for (int i = 1; i <= 9; i++) {
            m.add(i);
        }
    	int rand;
    	for(int x=1;x<10;x++) {
			rand = (int)(Math.random() * m.size());
			if(m.get(rand)==9)
				arr[x].setText("");
			else
				arr[x].setText(Integer.toString(m.get(rand)));
			m.remove(rand);
		}
    }
    
    void end() {
    	for(int x=1;x<10;x++) {
    		arr[x].setDisable(true);
    	}
    }
    
    @FXML
    void restart(ActionEvent event) {
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setTitle("Reset");
    	alert.setHeaderText("Vuoi Rigiocare?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get().equals(ButtonType.OK)) { 
    	       gen();
    	       for(int x=1;x<10;x++) {
    	    		arr[x].setDisable(false);
    	    	}
    	       lbl_win.setVisible(false);
    	}else if (result.get().equals(ButtonType.NO)) {
    	       alert.close();
    	}
    }

    @FXML
    void initialize() {
        assert bt1 != null : "fx:id=\"bt1\" was not injected: check your FXML file 'Game.fxml'.";
        assert bt2 != null : "fx:id=\"bt2\" was not injected: check your FXML file 'Game.fxml'.";
        assert bt3 != null : "fx:id=\"bt3\" was not injected: check your FXML file 'Game.fxml'.";
        assert bt4 != null : "fx:id=\"bt4\" was not injected: check your FXML file 'Game.fxml'.";
        assert bt5 != null : "fx:id=\"bt5\" was not injected: check your FXML file 'Game.fxml'.";
        assert bt6 != null : "fx:id=\"bt6\" was not injected: check your FXML file 'Game.fxml'.";
        assert bt7 != null : "fx:id=\"bt7\" was not injected: check your FXML file 'Game.fxml'.";
        assert bt8 != null : "fx:id=\"bt8\" was not injected: check your FXML file 'Game.fxml'.";
        assert bt9 != null : "fx:id=\"bt9\" was not injected: check your FXML file 'Game.fxml'.";
        assert lbl_win != null : "fx:id=\"lbl_win\" was not injected: check your FXML file 'Game.fxml'.";
        assert res != null : "fx:id=\"res\" was not injected: check your FXML file 'Game.fxml'.";
        
        arr[1]=bt1;
        arr[2]=bt2;
        arr[3]=bt3;
        arr[4]=bt4;
        arr[5]=bt5;
        arr[6]=bt6;
        arr[7]=bt7;
        arr[8]=bt8;
        arr[9]=bt9;
        
        map.put("bt1", bt1);
        map.put("bt2", bt2);
        map.put("bt3", bt3);
        map.put("bt4", bt4);
        map.put("bt5", bt5);
        map.put("bt6", bt6);
        map.put("bt7", bt7);
        map.put("bt8", bt8);
        map.put("bt9", bt9);
        
        gen();
    }
}
