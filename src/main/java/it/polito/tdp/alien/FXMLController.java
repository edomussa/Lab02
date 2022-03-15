package it.polito.tdp.alien;

import java.net.URL;
import java.util.*;

import it.polito.tdp.alien.traduttore.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	List<Parola> parole;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnTraduci;

    @FXML
    private TextField txtTesto;

    @FXML
    private TextArea txtTraduzione;

    @FXML
    void handeClear(ActionEvent event) {
    	txtTraduzione.clear();
    }

    @FXML
    void handleTraduci(ActionEvent event) {
    	String testo[]=txtTesto.getText().split(" ");
    	String res="";
    	
    	if(testo.length == 1) {
    		
    		String cerca=testo[0].toLowerCase();
    		
    		if(cerca.matches("[a-zA-Z]+")) {
    			for(Parola pa: parole) {
        			if(pa.getParola().toLowerCase().equals(cerca))
        				for(String s:pa.getTraduzioni()) {
        					res+=s+"\n";
        				}
        			txtTraduzione.setText(res);
        		}
    		}
    		else {
    			txtTraduzione.setText("Impossibile tradurre");
    		}
    		
    	}
    	if(testo.length == 2){
    		
    		if(testo[0].matches("[a-zA-Z]+") && testo[1].matches("[a-zA-Z]+")) {
    			Parola p= new Parola(testo[0]);
    			parole.add(p);
    			p.aggiungiTraduzione(testo[1]);
    		}
    		else {
    			txtTraduzione.setText("Errore inserimento traduzione");
    		}
    	}
    	
    	txtTesto.clear();
    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTraduci != null : "fx:id=\"btnTraduci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTraduzione != null : "fx:id=\"txtTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";
        parole=new LinkedList <Parola>();
    }

}
