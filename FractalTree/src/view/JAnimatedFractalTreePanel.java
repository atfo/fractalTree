package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class JAnimatedFractalTreePanel extends JGradualFractalTreePanel2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = -859972400811035616L;
	private Timer animate;
	private int animationDelay = 10000;

	public JAnimatedFractalTreePanel() {
		super();
		run();
	}

	public JAnimatedFractalTreePanel(int delay) {
		super();
		this.animationDelay = delay;
		run();
	}

	private void run() {
		animate = new Timer(animationDelay, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Animate");
				redraw();
			}
		});
		animate.setRepeats(true);
        animate.setCoalesce(true);
        animate.start();
	}

}
