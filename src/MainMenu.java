import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JPanel implements ActionListener, MouseMotionListener{
	CustomImage title,titleSelect,play,create,options,quit;
	boolean[] hover;
	Timer timer;
	int mouse_y,mouse_x;

	public MainMenu()
	{
		this.setLayout(null);
		addMouseMotionListener(this);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		title = new CustomImage("src/Title1.jpg");
		titleSelect = new CustomImage("src/Title2.jpg");
		timer = new Timer(60,this);
		
		play = titleSelect.grabSection(45, 210, 220, 100);
		create = titleSelect.grabSection(35, 355, 345, 80);
		options = titleSelect.grabSection(35, 510, 380, 100);
		quit = titleSelect.grabSection(35, 675, 210, 100);
		
		hover= new boolean[4];
		for(int i=0;i<4;i++)
			hover[i]=false;
		
		
		this.setBackground(Color.black);
		this.setVisible(true);
		validate();
		timer.start();
		this.repaint();
		
	}
	
	public void paintComponent(Graphics g)
	{
		//System.out.println("painting");
		super.repaint();
		title.drawFullImage(g, 0, 0, this.getWidth(), this.getHeight(),this);
		if(hover[0])
			play.drawFullImage(g, 45, 210, play.getWidth(), play.getHeight(), this);
		if(hover[1])
			create.drawFullImage(g, 35, 355, create.getWidth(), create.getHeight(), this);
		if(hover[2])
			options.drawFullImage(g, 35, 510, options.getWidth(), options.getHeight(), this);
		if(hover[3])
			quit.drawFullImage(g, 35, 675, quit.getWidth(), quit.getHeight(), this);
		//g.setFont();
		//g.drawString("Play", x, y);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.repaint();
		System.out.println(hover[0]);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouse_x=e.getX();
		mouse_y=e.getY();
		for (int i=0;i<4;i++)
			hover[i]=false;
		if((mouse_x<=265 && mouse_x>=45) && (mouse_y>=210 && mouse_y<=310))
			hover[0]=true;
		
		else if((mouse_x<=375 && mouse_x>=35) && (mouse_y>=355 && mouse_y<=430)) //35, 355, 345, 80
			hover[1]=true;
		
		else if((mouse_x<=415 && mouse_x>=35) && (mouse_y>=510 && mouse_y<=610)) //35, 510, 380, 100
			hover[2]=true;
		
		else if((mouse_x<=255 && mouse_x>=35) && (mouse_y>=675 && mouse_y<=775)) //45, 675, 210, 100
			hover[3]=true;
		
		
	}

	
}
