package application;

import javafx.scene.control.TextField;
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
	
	public String inputLine, outputLine;
    @FXML
    public ResourceBundle resources;

    @FXML
    public URL location;

    @FXML
    public TextField tfPort = new TextField();

    @FXML
    public PasswordField tfPw;

    @FXML
    public Button btnStart = new Button();

    @FXML
    public Button btnCancel;
    static Socket clientSocket;
    static int portNumber;
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
	    	portNumber = Integer.parseInt(tfPort.getText());

	    	try {
	    	    ServerSocket serverSocket = new ServerSocket(portNumber);
	    	    Socket clientSocket = serverSocket.accept();
	    	    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	    	    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	    	    System.out.println(serverSocket.getLocalSocketAddress());
	    	    System.out.println(serverSocket.isBound());
	    	}catch (Exception e) {
				// TODO: handle exception
			}

	    }   
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
