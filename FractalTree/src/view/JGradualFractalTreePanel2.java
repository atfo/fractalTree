package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class JGradualFractalTreePanel2 extends JFractalTreePanel2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2208740552110733532L;

	private Timer nextStep;
	private int stepDelay = 500;
	private int maxSteps;
	private int drawnSteps;
	private boolean finishedDrawing = true;

	public JGradualFractalTreePanel2() {
		super();
		init();
		nextStep = new Timer(stepDelay, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Repaint");
				maxSteps++;
				repaint();
			}
		});
		nextStep.setRepeats(true);
		nextStep.setCoalesce(true);
		nextStep.start();
	}

	private void init() {
		maxSteps = 1;
		drawnSteps = 0;
	}

	@Override
	protected boolean canContinue(double length) {
		// System.out.println("CanContinue");
		if (!super.canContinue(length)) {
			nextStep.stop();
			finishedDrawing = true;
		}
		System.out.println(drawnSteps + " <= " + maxSteps);
		System.out.println(drawnSteps <= maxSteps);
		return super.canContinue(length) && drawnSteps <= maxSteps;
	}

	@Override
	public void paintComponent(Graphics g) {
		if(finishedDrawing)
			g.fillRect(0, 0, getWidth(), getHeight());
		finishedDrawing = false;
		drawnSteps = 0;
		super.paintComponent(g);
		System.out.println(drawnSteps + "-" + maxSteps);
	}

	@Override
	protected double drawTree(Graphics2D g2d, double length) {
		drawnSteps++;
		double toReturn = super.drawTree(g2d, length);
		drawnSteps--;
		return toReturn;
	}

	public void redraw() {
		if (finishedDrawing) {
			System.out.println("redraw");
			init();
			nextStep.start();
			System.out.println(drawnSteps + "&" + maxSteps);
			repaint();
		}
	}

}
