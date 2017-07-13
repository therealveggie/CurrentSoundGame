import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JPanel{
	CustomImage title;
	public MainMenu()
	{
		System.out.println("added this");
		this.setVisible(true);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		title = new CustomImage("src/Title1.jpg");
	
		this.setBackground(Color.black);
		this.revalidate();
		this.repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		System.out.println("painting");
		super.repaint();
		title.drawFullImage(g, 0, 0, this.getWidth(), this.getHeight());
	}
}
