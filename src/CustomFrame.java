import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomFrame extends JFrame {
	public CustomFrame()
	{
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(new GamePanel(),BorderLayout.CENTER);
	}

}
