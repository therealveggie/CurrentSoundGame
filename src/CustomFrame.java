import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomFrame extends JFrame {
	public CustomFrame()
	{
		PauseMenu pm =new PauseMenu();
		this.setSize(800,800);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setUndecorated(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		//this.add(new GamePanel(),BorderLayout.CENTER);
		this.add(new MainMenu(),BorderLayout.CENTER);
		//pm.setF();
		//this.add(pm,BorderLayout.CENTER);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
