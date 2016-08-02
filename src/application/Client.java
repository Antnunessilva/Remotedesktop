package application;


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
import java.net.UnknownHostException;
import java.util.ResourceBundle;

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

public class Client implements ActionListener {
	static Thread t1;
	static Socket echoSocket;
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
	public void btnStart1Click() {

		hostName = tfIp1.getText();
		portNumber = Integer.parseInt(tfPort1.getText());


		try {
			echoSocket = new Socket(hostName, portNumber);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(echoSocket.isConnected()==true)
		{					
			System.out.println("CONNECT");
			t1 = new Thread(new Runnable() {

				@Override
				public void run() {
					while(true)
					{
						PrintWriter out;
						try {
							out = new PrintWriter(echoSocket.getOutputStream(), true);
							BufferedReader in =new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
							BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

							String userInput;
							while ((userInput = stdIn.readLine()) != null)
							{
								out.println(userInput);
								in.readLine();
								System.out.println("echo: " + in.readLine());
							}

							t1.sleep(1000);
						}catch(Exception io)
						{
							System.out.println("asasas");		
						}
					}
				}
				});
			t1.start();

			}
			else
			{
				System.out.println("Não ligou");
			}
		


	}





	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}



}
