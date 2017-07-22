import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JPanel implements MouseMotionListener{
	CustomImage title,titleSelect,play,create,options,quit;
	boolean[] hover;
	int mouse_y,mouse_x;

	public MainMenu()
	{
		this.setLayout(null);
		addMouseMotionListener(this);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		title = new CustomImage("src/Title1.jpg");
		titleSelect = new CustomImage("src/Title2.jpg");
		
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
		//timer.start();
		this.repaint();
		
	}
	
	public void paintComponent(Graphics g)
	{
		//System.out.println("painting");
		super.repaint();
		title.drawFullImage(g		, 0							, 0						, this.getWidth()							, this.getHeight()							, this);
		if(hover[0])
			play.drawFullImage(g	, this.getWidth()*45/1920, this.getHeight()*210/1080, this.getWidth()*play.getWidth()/1920		, this.getHeight()*play.getHeight()/1080	, this);
		if(hover[1])
			create.drawFullImage(g	, this.getWidth()*35/1920, this.getHeight()*355/1080, this.getWidth()*create.getWidth()/1920	, this.getHeight()*create.getHeight()/1080	, this);
		if(hover[2])
			options.drawFullImage(g	, this.getWidth()*35/1920, this.getHeight()*510/1080, this.getWidth()*options.getWidth()/1920	, this.getHeight()*options.getHeight()/1080	, this);
		if(hover[3])
			quit.drawFullImage(g	, this.getWidth()*35/1920, this.getHeight()*675/1080, this.getWidth()*quit.getWidth()/1920		, this.getHeight()*quit.getHeight()/1080	, this);
		//g.setFont();
		//g.drawString("Play", x, y);
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
		if((mouse_x<=this.getWidth()*265/1920 && mouse_x>=this.getWidth()*45/1920) && (mouse_y>=this.getHeight()*210/1080 && mouse_y<=this.getHeight()*310/1080))
			hover[0]=true;
		
		else if((mouse_x<=this.getWidth()*375/1920 && mouse_x>=this.getWidth()*35/1920) && (mouse_y>=this.getHeight()*355/1080 && mouse_y<=this.getHeight()*450/1080)) //35, 355, 345, 80
			hover[1]=true;
		
		else if((mouse_x<=this.getWidth()*415/1920 && mouse_x>=this.getWidth()*35/1920) && (mouse_y>=this.getHeight()*510/1080 && mouse_y<=this.getHeight()*610/1080)) //35, 510, 380, 100
			hover[2]=true;
		
		else if((mouse_x<=this.getWidth()*255/1920 && mouse_x>=this.getWidth()*35/1920) && (mouse_y>=this.getHeight()*675/1080 && mouse_y<=this.getHeight()*775/1080)) //45, 675, 210, 100
			hover[3]=true;
		this.repaint();
		
	}

	
}
