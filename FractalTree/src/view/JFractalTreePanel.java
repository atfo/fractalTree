package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

import javax.swing.JPanel;

public class JFractalTreePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2851470085583390447L;

	private Random rng = new Random();
	public static int xOrigin;
	public static int yOrigin;
	public static int angle;
	public static int branchLength = 250;
	public static double coeff = 2.2/3.0;

	public JFractalTreePanel() {
		this.setSize(new Dimension(1000, 1000));
		initVars();
	}

	private void initVars() {
		System.out.println(this.getWidth());
		xOrigin = this.getWidth() / 2;
		yOrigin = this.getHeight();
		angle = 45;
		System.out.println(xOrigin + ", " + yOrigin);
	}

	private void resetGraphics(Graphics2D g2d) {
		g2d.translate(xOrigin, yOrigin - branchLength);
	}

	@Override
	public void paintComponent(Graphics g) {
		// initVars();
		Graphics2D g2d = (Graphics2D) g.create();
		resetGraphics(g2d);
		drawTree(g2d, branchLength, 1);
		// drawTree(g2D);
	}
	
	public void newSize(int width, int height){
		this.setSize(new Dimension(width, height));
		initVars();
	}

	private double drawTree(Graphics2D g2d, double length, int id) {
		System.out.println(id);
		// g2d.fillRect(0, 0, getWidth(), getHeight());
		// System.out.println(angle);
		// System.out.println(yOrigin);

		if (length > 10) {
			AffineTransform old = g2d.getTransform();
			g2d.fillRect(-3, 0, 6, (int) length);
			System.out.println("length: " + length);
			int r = rng.nextInt(255), g = rng.nextInt(255), b = rng.nextInt(255);
			System.out.println(r + ", " + g + ", " + b);
			
			g2d.setColor(new Color(r, g, b));
			g2d.rotate(Math.toRadians(angle));
			g2d.translate(0, -length*coeff);
			drawTree(g2d, length*coeff, id + 1);
			g2d.setTransform(old);
			g2d.rotate(Math.toRadians(-angle));
			g2d.translate(0, - length*coeff);
			g2d.setColor(new Color(r, g, b));

			System.out.println("End length: " + length);
			drawTree(g2d, length*coeff, id + 1);
		}
		System.out.println("bis" + id);
		return length;
	}
}
