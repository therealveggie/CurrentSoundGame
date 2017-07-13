import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.File;
import javax.imageio.ImageIO;

public class CustomImage 
{
	BufferedImage img;
	
	public CustomImage(String path)
	{
		img = null;
		try
		{
			img = ImageIO.read(new File(path));
		}catch(Exception e)
		{
			System.out.println("Image Loading issue. Path: "+path);
			e.printStackTrace();
			//System.exit(1);
		}
	}
	
	public void drawFullImage(Graphics g, int x1,int y1,int w,int h)
	{
		g.drawImage(img, x1, y1, x1+w, y1+h, 0, 0, img.getWidth(), img.getHeight(), null);
		//g.drawImage(img, 0, 0, null);
	}
	
}
