package application;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.DataBufferDouble;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.net.ssl.HostnameVerifier;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Main implements ActionListener {
	static Thread t1;
	static Socket s;
	static String msgin="", msgout="";
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	public TextField tfIp1 = new TextField();

	@FXML
	public TextField tfPort1= new TextField();

	@FXML
	private PasswordField tfPw1= new PasswordField(); ;

	@FXML
	private Button btnStart1 = new Button();

	@FXML
	static Button btnCancel1;
	static String hostName="";
	static int portNumber=0;
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
	public void btnStart1Click() throws Exception {
		
		
	
		
		t1 = new Thread(new Runnable() {
			public void run() {
				try {
					s = new Socket(tfIp1.getText(), Integer.parseInt(tfPort1.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				while(true)
				{
				try {
					
					DataInputStream din = new DataInputStream(s.getInputStream());
					msgin = din.readUTF();
					System.out.println(msgin + " MENSAGEM ENTRADA CLIENT");
					tachat.appendText(msgin+"\n");
					t1.sleep(1000);
				} catch (InterruptedException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		t1.start();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}



}
