package lab09;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;


public class SquareComponent extends JComponent {
	
	private static int howMany = 4;
	private List<Square> squares;
	private boolean state;

	public SquareComponent() throws InterruptedException {
		this.squares = new ArrayList<>();
		state = false;
		for (int i = 0; i < howMany; i++)
		{
			addSquare();
		}
	}
	public void addSquare() {
		int x1=0;
		int y1=0;
		 System.out.println((0 + ((int)Math.random()*(this.getWidth() - 10))));
		if (this.getWidth() != 0)
		{
			x1 = 0 + (int) (Math.random() * 300);
			y1 = 0;
		}
		else
		{
			x1 = 0 + (int) (Math.random() * 300);
			y1 = 0;
		}
		Square s;
		if (state) {
			s = new Square(x1,y1,10,new Color((0 + (int)(Math.random()*256)), (0 + (int)(Math.random() * 256)), (0 + (int)(Math.random() *256))),1, true);
		} else {
			s = new Square(x1,y1,10,new Color((0 + (int)(Math.random()*256)), (0 + (int)(Math.random()*256)) , (0 + (int)(Math.random()*256))),1, false);
		}
		squares.add(s);
		Runnable run = new SquareRunnable(s, this);
		Thread thr = new Thread(run);
		thr.start();

	}
	
	public void stopNow()
	{
		if(!state){
			for (Square s : squares)
			{
				s.stop();
			}
			state = true;
		}
	}
	public void resumeNow()
	{
		for (Square square : squares) {
			square.resume();
		}
		state = false;
	}

	public void paintComponent(Graphics graphics){
		
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

		for (Square square : squares) {
			square.draw(graphics);
		}
		}
}
