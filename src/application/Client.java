package application;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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

public class Client extends Main implements ActionListener {
	static Thread t1;
	public Socket socket;
	public DataInputStream  console;
	public DataOutputStream streamOut;
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
	public void btnStart1Click() throws NumberFormatException, UnknownHostException, IOException {
	Thread t2 = new Thread(new Runnable() {
		public void run() {

			 try
		        {  socket = new Socket(tfIp1.getText(), Integer.parseInt(tfPort1.getText()));

		           start1();
		           tachat.appendText(socket.toString());
		        }
		        catch(UnknownHostException uhe)
		        {  System.out.println("Host unknown: " + uhe.getMessage());
		        }
		        catch(IOException ioe)
		        {  System.out.println("Unexpected exception: " + ioe.getMessage());
		        }
		       
		        
		}
	});
	t2.start();
		
	}
       
	

	
	public void start1() throws IOException
	   {  console   = new DataInputStream(System.in);
	      streamOut = new DataOutputStream(socket.getOutputStream());
	   }
	   public void stop()
	   {  try
	      {  if (console   != null)  console.close();
	         if (streamOut != null)  streamOut.close();
	         if (socket    != null)  socket.close();
	      }
	      catch(IOException ioe)
	      {  System.out.println("Error closing ...");
	      }
	   }




	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}



}
