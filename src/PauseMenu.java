import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PauseMenu extends JPanel implements MouseListener, MouseMotionListener
{
	public CustomImage pause1,pause2,resume, exit, quit;
	int mouse_x, mouse_y;
	boolean[] hover;
	public PauseMenu()
	{
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		pause1= new CustomImage("src/Pause1.png");
		pause2= new CustomImage("src/Pause2.png");
		
		resume=pause2.grabSection(820, 420, 240, 50);
		exit=pause2.grabSection(680, 540, 510, 50);
		quit=pause2.grabSection(775,660, 320, 50);
		
		hover= new boolean[3];
		for(int i = 0; i<3;i++)
			hover[i]=false;
	}
	
	private boolean inScaledReigon(int x, int y, int w, int h,int targ_x,int targ_y,int width,int height)
	{
		return ((targ_x>=width*x/1920 && targ_x>=width*(x+w)/1920) && (targ_y>=height*y/1080 && targ_y<=height*(y+h)/1080));
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mouse_x=e.getX();
		mouse_y=e.getY();
		
		for(int i = 0; i<3;i++)
			hover[i]=false;
		
		if (inScaledReigon(820, 420, 240, 50,mouse_x,mouse_y,this.getWidth(),this.getHeight()))
			hover[0]=true;
		if (inScaledReigon(680, 540, 510, 50,mouse_x,mouse_y,this.getWidth(),this.getHeight()))
			hover[1]=true;
		if (inScaledReigon(775, 660, 320, 50,mouse_x,mouse_y,this.getWidth(),this.getHeight()))
			hover[2]=true;
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.repaint();
		pause1.drawFullImage(g, 0, 0, this.getWidth(), this.getHeight(), this);
		if(hover[0])
			resume.drawFullImage(g, this.getWidth()*820/1920, this.getHeight()*420/1080, this.getWidth()*240/1920, this.getHeight()*50/1080, this);
		if(hover[1])
			exit.drawFullImage(g, this.getWidth()*680/1920, this.getHeight()*540/1820, this.getWidth()*510/1920, this.getHeight()*50/1080, this);
		if(hover[2])
			quit.drawFullImage(g, this.getWidth()*775, this.getHeight()*660/1080, this.getWidth()*320/1080, this.getHeight()*50/1080, this);
	}
	
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
