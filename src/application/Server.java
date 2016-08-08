package application;

import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import application.Main;

public class Server extends Main implements ActionListener{
	static Thread t2;
	static Socket s;
	static ServerSocket ss;
	static String msgin;
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
	void btnStartClick() throws IOException {
		
		
		t2 = new Thread(new Runnable() {
			public void run() {
				try {
					ss = new ServerSocket(Integer.parseInt(tfPort.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				while(true)
				{
				try {
					s = ss.accept();
					DataInputStream din = new DataInputStream(s.getInputStream());
					System.out.println(s);
					msgin = din.readUTF();
					System.out.println(msgin + " MSG DO SERVER");
					tachat.appendText(msgin+"\n");
					t2.sleep(1000);
				} catch (InterruptedException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		t2.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
