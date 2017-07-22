import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener{
	static int[] x,y;
	static GameInput gi;
	static ArrayList<ArrayList> bounds;
	static Timer timer;
	static Line [] lines;
	private static int time;
	static boolean pause;
	char[] keys;
	static Path[] paths;
	
	// Temp code
	//CustomImage pause;
	//end of temp code
	//@SuppressWarnings("deprecation")
	public GamePanel()
	{
		/////////////////////////////////////////////////////Temp code//////////////////////////////////////////////////////////////////
		keys = new char[6];
		keys[0]='s';
		keys[1]='d';
		keys[2]='f';
		keys[3]='j';
		keys[4]='k';
		keys[5]='l';	
		///////////////////////////////////////////////////end of temp code///////////////////////////////////////////////////////////
		this.setVisible(true);
		this.setFocusable(true);
		this.requestFocus();
		
		addKeyListener(new GameInput(keys));
		
		pause=false;
		paths = new Path[6];
		timer = new Timer(60, this);
		time=0;
		this.setBackground(Color.black);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		//this.setSize(800,800);
		//System.out.println(this.getWidth()+"     "+this.getHeight());
		//x= new int[4];
		//y=new int [4];
		//x[0]=0;									y[0]=this.getHeight();
		//x[1]=(int)(this.getWidth()*0.45);		y[1]=(int)(this.getHeight()*0.25);
		//x[2]=(int)(this.getWidth()*0.55);		y[2]=(int)(this.getHeight()*0.25);
		//x[3]=this.getWidth();					y[3]=this.getHeight();
		lines=new Line[7];
		int small_shift= (int)(this.getWidth()*0.1/6);
		int large_shift = (int)(this.getWidth()/6);
		ArrayList<Integer> temp;
		
		//bounds= new ArrayList<ArrayList>();
		for(int i=0;i<7;i++)
		{
			temp=new ArrayList<Integer>();
			temp.add((int)(i*large_shift));
			temp.add(this.getHeight());
			temp.add((int)(this.getWidth()*0.45+i*small_shift));
			temp.add((int)(this.getHeight()*0.25));
			lines[i]=new Line(temp.get(2),temp.get(3),temp.get(0),temp.get(1),new GradientPaint(0.0f, (float)(this.getHeight()*0.25) , new Color(50,50,50,50), 0.0f, getHeight(), new Color(250,250,250,15)));
			//bounds.add(temp);
		}
		
		Paint p1 = new GradientPaint(0.0f, (float)(this.getHeight()*0.25) , new Color(10,10,10,200), 0.0f, getHeight(), new Color(100,100,100,55));
		Paint p2 = new GradientPaint(0.0f, (float)(this.getHeight()*0.25) , new Color(10,10,10,200), 0.0f, getHeight(), new Color(0,0,100,200));
		
		for(int i=0;i<6;i++)
		{
			paths[i]=new Path(lines[i],lines[i+1], keys[i],p1,p2);
		}
		/*
		for(int i=0;i<6;i++)
		{
			tmp = new PressedAction(i);
			this.getInputMap().put(KeyStroke.getKeyStroke('a'), tmp);
			//this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keys[i].charAt(0), true), tmp);
			//this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keys[i].charAt(0), false), tmp);
		}
		*/
		
		//pause=new CustomImage("src/Pause1.png");
		
		timer.start();
		//this.add(new MyCanvas());
		this.setFocusable(true);
		//System.out.println("doing this");
		this.requestFocusInWindow();
		//System.out.println(this.isRequestFocusEnabled());
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(Line line:GamePanel.lines)
		{
			line.drawLine(g);
		}
		
		for (Path path:GamePanel.paths)
		{
			path.drawPath(g);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("repeat");
		if(!this.hasFocus())
			this.requestFocus();
		if(pause)
			this.pause();
		
		time++;
		this.repaint();
		
	}
	
	public void pause()
	{
		timer.stop();
		add(new PauseMenu());
	}
	
	public static void resume()
	{
		timer.start();
	}

	

}
/*
class MyCanvas extends Canvas
{
	public MyCanvas()
	{
		this.setBackground(Color.BLACK);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	
	public void paint(Graphics g)
	{
		for(Line line:GamePanel.lines)
		{
			line.drawLine(g);
		}
		
		for (Path path:GamePanel.paths)
		{
			path.drawPath(g);
		}
	}
}
*/


class Line
{
	Paint color;
	int x1,x2,y1,y2;
	public Line(int x1,int y1, int x2, int y2, Paint p1)
	{
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.color=p1;
	}
	
	public void drawLine(Graphics g)
	{
		if (g instanceof Graphics2D)
		{
			Graphics2D g2D = (Graphics2D)g;
			g2D.setPaint(color);
			g2D.drawLine(x1,y1,x2,y2);
		}
		
	}
	
	public int find_x(int y)
	{
		System.out.println(x1+" "+y1+"       "+x2+" "+y2);
		return (((y-y1)*(x1-x2))/(y1-y2))+x1;
	}
	
	public int[][] getCoord()
	{
		int[][] ans = new int[2][2];
		ans[0][0]=x1;
		ans[0][1]=y1;
		ans[1][0]=x2;
		ans[1][1]=y2;
		return ans;
	}
}


class Path //implements KeyListener
{
	int [][] bounds;
	int [] x,y;
	boolean pressed;
	char key;
	Line lLine, rLine;
	Paint def, press;
	
	public Path(Line l1, Line l2, char keys, Paint p1, Paint p2)
	{
		x = new int[4];
		y = new int[4];
		this.key = keys;
		pressed = false;
		bounds=new int[4][2];
		int [][] temp;
		temp=l1.getCoord();
		bounds[0]=temp[0];
		bounds[3]=temp[1];
		temp=l2.getCoord();
		bounds[1]=temp[0];
		bounds[2]=temp[1];
		
		for(int i=0; i<4; i++)
		{
			x[i]=bounds[i][0];
			y[i]=bounds[i][1];
		}
		
		this.lLine=l1;
		this.rLine=l2;
		
		this.def=p1;
		this.press=p2;
		
	}
	
	public void interact(boolean b)
	{
		pressed=b;
	}
	
	public void drawPath(Graphics g)
	{
		if (g instanceof Graphics2D)
		{
			Graphics2D g2D = (Graphics2D)g;
			if(!pressed)
				g2D.setPaint(def);
			else
				g2D.setPaint(press);
			g2D.fillPolygon(x, y, 4);
		}
	}
}

class GameInput implements KeyListener
{
	char[] keys;
	
	GameInput(char[] input)
	{
		keys = new char[6];
		for(int i=0;i<6;i++)
			keys[i]=input[i];
	}


	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("a key was pressed");
		for(int i=0; i<6;i++)
		{
			System.out.println(e.getKeyChar()+"\t"+keys[i]);
			if (e.getKeyChar()==keys[i])
			{
				GamePanel.paths[i].interact(true);
				
			}
			
			if(e.getKeyChar()=='p')
				GamePanel.pause=true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("a key was released");
		for(int i=0; i<6;i++)
		{
			if (e.getKeyChar()==keys[i])
			{
				GamePanel.paths[i].interact(false);
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("a key was typed");
		
	}
	
}
