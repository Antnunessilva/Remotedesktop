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
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client implements ActionListener {

	@FXML
	static ResourceBundle resources;

	@FXML
	static URL location;

	@FXML
	static TextField tfIp1;

	@FXML
	static TextField tfPort1;

	@FXML
	static PasswordField tfPw1;

	@FXML
	static Button btnStart1;

	@FXML
	static Button btnCancel1;

	public static void start() throws Exception
	{
		FXMLLoader f = new FXMLLoader(); 
		final Parent fxmlRoot = (Parent)f.load(new FileInputStream(new File("portwindow.fxml")));
		Stage st = new Stage();
		st.setScene(new Scene(fxmlRoot));
		st.setTitle("Connect to Server");
		st.show();

	} 
	@FXML
	public void btnCancel1Click() {

	}

	@FXML
	public void btnStart1Click() {
		//start connection 
		String hostName = tfIp1.getText();
		int portNumber = Integer.parseInt(tfPort1.getText());

				try {
					Socket echoSocket = new Socket(hostName, portNumber);
					PrintWriter out =new PrintWriter(echoSocket.getOutputStream(), true);
					BufferedReader in =new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
					BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
					
					String userInput;
					while ((userInput = stdIn.readLine()) != null)
					{
					    out.println(userInput);
					    System.out.println("echo: " + in.readLine());
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}



}
