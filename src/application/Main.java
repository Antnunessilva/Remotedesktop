package application;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.glass.ui.Menu;
import com.sun.glass.ui.MenuBar;
import com.sun.glass.ui.MenuItem;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Main extends Application implements ActionListener
{
	static String bt="";
	static ResourceBundle resources;

	@FXML
	static URL location;

	@FXML
	static MenuBar mnb;

	@FXML
	static Menu mnFile;

	@FXML
	static MenuItem mniConn;

	@FXML
	static MenuItem mniExp;

	@FXML
	static MenuItem mniClose;

	@FXML
	static Menu mnTools;

	@FXML
	static MenuItem mniSett;

	@FXML
	static Menu mnHelp;

	@FXML
	static MenuItem mniAbout;

	@FXML
	static RadioButton rbServer;

	@FXML
	static RadioButton rbClient;

	@FXML
	static Button btStart2;

	@FXML
	static Button btStop2;

	@FXML
	public Pane paneView = new Pane();

	@FXML
	public Pane paneChat = new Pane();
	
	@FXML
	public TextArea tachat = new TextArea();

    @FXML
    public TextField taTextfield = new TextField();

    @FXML
    public Button tasend = new Button();



	public static void main(String[] arguments)
	{
		Application.launch(Main.class, arguments);
	}


	@Override
	public void start(final Stage stage) throws Exception
	{
		FXMLLoader f = new FXMLLoader(); 
		final Parent fxmlRoot = (Parent)f.load(new FileInputStream(new File("proj_layout.fxml")));
		stage.setScene(new Scene(fxmlRoot));
		stage.show();


	} //wow tive de declarar todos os metodos LOL 

	public void btStart2Click()
	{
		if(bt.equals("Client"))
		{
			try {
				application.Client.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(bt.equals("Server"))
		{
			try {
				application.Server.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	  @FXML
	  public void taSendClick() {
		String line = taTextfield.getText();
		tachat.appendText("Message: " +taTextfield.getText()+"\n");
		
		taTextfield.setText("");
		
		//adicionar metodo que envia mensagens através do socket
	    }
	  
	public void btStop2Click()
	{

	}
	

	public void mniAboutClick()
	{

	}
	public void mniCloseClick()
	{
			Platform.exit();
	}
	public void mniConnClick()
	{

	}
	public void mniExpClick()
	{

	}
	public void mniSettClick()
	{


	}
	public void rbClientClick()
	{
		bt="Client";
	}
	public void rbServerClick()
	{
		bt="Server";
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getSource().toString());
	}


}
