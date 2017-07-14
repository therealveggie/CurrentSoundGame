import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JPanel implements ActionListener{
	CustomImage title;
	Timer timer;
	JLabel play,create,options,quit;
	public MainMenu()
	{
		this.setLayout(null);
		
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		title = new CustomImage("src/Title1.jpg");
		timer = new Timer(60,this);
		
		Font font = new Font("Century Gothic Regular", Font.PLAIN, this.getHeight()/45);
		play=new JLabel();
		play.setFont(font);
		play.setBackground(Color.white);
		play.setText("Play");
		play.setLocation(100,300);
		this.add(play);
		
		this.setBackground(Color.black);
		this.setVisible(true);
		validate();
		timer.start();
		this.repaint();
		
	}
	
	public void paintComponent(Graphics g)
	{
		System.out.println("painting");
		super.repaint();
		title.drawFullImage(g, 0, 0, this.getWidth(), this.getHeight(),this);
		//g.setFont();
		//g.drawString("Play", x, y);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.repaint();
		
	}
}
