package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class JAnimatedFractalTreePanel extends JGradualFractalTreePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -859972400811035616L;
	private Timer animate;
	private int delay = 50;

	public JAnimatedFractalTreePanel() {
		super();
		run();
	}

	public JAnimatedFractalTreePanel(int delay) {
		super();
		this.delay = delay;
		run();
	}

	private void run() {
		animate = new Timer(delay, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Animate");
				repaint();
			}
		});
		animate.setRepeats(true);
        animate.setCoalesce(true);
        animate.start();
	}

//	class Animate extends Thread {
//		@Override
//		public void run() {
//			for (;;){
//				try {
//					Thread.sleep(delay);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				repaint();
//			}
//		}
//	}

}
