package application;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class Server implements ActionListener{
	
	static String inputLine, outputLine;
    @FXML
    static ResourceBundle resources;

    @FXML
    static URL location;

    @FXML
    static TextField tfPort;

    @FXML
    static PasswordField tfPw;

    @FXML
    static Button btnStart;

    @FXML
    static Button btnCancel;
    static Socket clientSocket;
	public static void start() throws Exception
	   {
	     FXMLLoader f = new FXMLLoader(); 
	     final Parent fxmlRoot = (Parent)f.load(new FileInputStream(new File("sw_layout.fxml")));
	     Stage st = new Stage();
	     st.setScene(new Scene(fxmlRoot));
	     st.setTitle("Listen");
	     st.show();
	      
	   } 
	 @FXML
	    void btnCancelClick() {

	    }

	    @FXML
	    void btnStartClick() {
	    	

	    }   
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
