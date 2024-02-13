import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Recursion extends JPanel implements ActionListener {

	/* this method should recursive draw concentric rings */
	public void concentricCircles(Graphics g, int width, int x, int y) {
		// if width is 1, too small
		if (width <= 1)
			return;
		else {
			g.setColor(Color.red);
			g.drawOval(x, y, width, width);
			concentricCircles(g, width - 4, x + 2, y + 2);
			;
		}
	}

	public void squares(Graphics g, int length, int x, int y) {
		// add the additional parameters (arguments) so that you can call
		// on the method recursively
//		int sqr = 1;
//		if (length < 1) return;
//		else {
//			g.setColor(Color.blue);
//			for (int i = 1; i <= sqr; i++) {
//			g.drawRect(x, y, length, length);
//			}
//			squares(g, length/4, (int)(x + length * 1.125), (int)(y + length * 1.125));  
//		}

	}

	public void clover(Graphics g, int width, int x, int y, int xSum, int ySum) { // What additional variables will you
																					// need to draw the shape?
		if (width <= 1)
			return;
		else {
			g.setColor(Color.green);
			g.drawOval(x, y, width, width);
			clover(g, width - 5, x + xSum, y + ySum, xSum, ySum);
		}
	}

	public void spinCircle(Graphics g, int centerX, int centerY, int radius, double angle) {

		if (radius > 80)
			return;
		else {
			g.setColor(Color.yellow);
			int x = centerX + (int) (radius * Math.cos(Math.toRadians(angle)));
			int y = centerY + (int) (radius * Math.sin(Math.toRadians(angle)));
			g.drawOval(x, y, 50, 50);
			spinCircle(g, centerX, centerY, radius + 1, angle + 10);
		}

	}

	public void snowflake(Graphics g, int x1, int y1, double angle, int depth) {
		if (depth == 0) {
			return;
		} else {
			g.setColor(Color.orange);
			int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 5);
			int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 5);

			g.drawLine(x1, y1, x2, y2);
			snowflake(g, x2, y2, angle - 20, depth - 1);
			snowflake(g, x2, y2, angle + 20, depth - 1);
		}

	}

	public void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
		if (depth == 0)
			return;
		else {
			g.setColor(Color.blue);
			g.drawLine(x1, y1, x1 + depth * 5, y1 + depth * 2);
			g.drawLine(x1, y1, x1 + depth * 5, y1 + depth * 2);
			g.drawLine(x1, y1, x1 + depth * 5, y1);
			//int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 5);
			//int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 5);

			//drawTree(g, x2, y2, angle - 20, depth - 1);
			//drawTree(g, x2, y2, angle + 20, depth - 1);
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 2000, 2000);

		this.concentricCircles(g, 200, 10, 20);

//		this.squares(g, 200, 400, 50);

		this.clover(g, 100, 350, 130, 0, 0);
		this.clover(g, 100, 250, 130, 5, 0);
		this.clover(g, 100, 350, 30, 0, 5);
		this.clover(g, 100, 250, 30, 5, 5);

		this.spinCircle(g, 570, 100, 5, 290);

		this.snowflake(g, 120, 500, -90, 8);

		this.drawTree(g, 400, 500, -90, 8);
	} // my code should go above this bracket unless I know about classes

	public static void main(String[] arg) {

		// line of code to create a MethodPractice object
		Recursion m = new Recursion();

	}// end of main method body

	// constructor for the class
	// kind of looks like a method but no return type!!!
	public Recursion() {
		JFrame f = new JFrame("Recursive Methods");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 600);
		f.add(this);
		f.setVisible(true);

	}

	Timer t = new Timer(16, this);

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

}// last curly - do not delete