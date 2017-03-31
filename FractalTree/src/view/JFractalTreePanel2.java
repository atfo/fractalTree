package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

import javax.swing.JPanel;

public class JFractalTreePanel2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2851470085583390447L;

	protected static Random rng = new Random();
	protected static int xOrigin;
	protected static int yOrigin;
	protected static int angle;
	protected static int branchLength = 300;
	protected static double coeff = 2.2/3.0;

	public JFractalTreePanel2() {
		this.setSize(new Dimension(1000, 1000));
		initVars();
	}

	protected void initVars() {
		xOrigin = this.getWidth() / 2;
		yOrigin = this.getHeight();
		angle = 45;
	}

	public void newSize(int width, int height){
		this.setSize(new Dimension(width, height));
		initVars();
	}
	
	protected void resetGraphics(Graphics2D g2d) {
		g2d.setColor(new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255)));
		g2d.translate(xOrigin, yOrigin - branchLength);
	}

	@Override
	public void paintComponent(Graphics g) {
		initVars();
		Graphics2D g2d = (Graphics2D) g;
		resetGraphics(g2d);
		drawTree(g2d, branchLength);
		// drawTree(g2D);
	}
	
	

	protected boolean canContinue(double length){
		return length > 5;
	}
	
	protected double drawTree(Graphics2D g2d, double length) {
		System.out.println("Called");
		if (canContinue(length)) {
			AffineTransform old = g2d.getTransform();
			g2d.fillRect(-3, 0, 6, (int) length);
			System.out.println("length: " + length);
			int r = rng.nextInt(255), g = rng.nextInt(255), b = rng.nextInt(255);
			System.out.println(r + ", " + g + ", " + b);
			
			g2d.setColor(new Color(r, g, b));
			g2d.rotate(Math.toRadians(angle));
			g2d.translate(0, -length*coeff);
			drawTree(g2d, length*coeff);
			g2d.setTransform(old);
			g2d.rotate(Math.toRadians(-angle));
			g2d.translate(0, - length*coeff);
			g2d.setColor(new Color(r, g, b));

			System.out.println("End length: " + length);
			drawTree(g2d, length*coeff);
		}
		return length;
	}
}
