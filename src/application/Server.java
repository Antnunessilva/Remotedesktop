package application;

import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
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
import application.Main;

public class Server extends Main implements ActionListener{
	static Thread t1;
	public Socket socket;
	public ServerSocket server;
	public DataInputStream streamIn;
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
		t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			
				try{
					server = new ServerSocket(Integer.parseInt(tfPort.getText()));
					tachat.appendText(server.toString());
			
					socket = server.accept();
				
				System.out.println(socket);

				
					open();
				
				boolean done = false;
			
					while (streamIn.readLine() != null)
					{ 
					
					 String line;
			
						line = streamIn.readUTF();
						tachat.appendText(line);

					}
				
				}
				catch(Exception io)
				{
					io.printStackTrace();
				}
			}
		});
		t1.start();

	}   

	public void open() throws IOException
	{  
		streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	}

	public void close() throws IOException
	{  if (socket != null)    
		socket.close();
	if (streamIn != null)
		streamIn.close();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
