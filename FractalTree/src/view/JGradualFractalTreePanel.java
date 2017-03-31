package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Timer;

public class JGradualFractalTreePanel extends JFractalTreePanel2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2208740552110733532L;

	private Timer animate;
	private int delay = 1000;
	
	
    public JGradualFractalTreePanel() {
		super();
//		animate = new Timer(delay, new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Repaint");
//				repaint();
//			}
//		});
//		animate.setRepeats(true);
//		animate.setCoalesce(true);
//		animate.start();
	}
    
    
    @Override
    public synchronized void paintComponent(Graphics g) {
		java.awt.EventQueue.invokeLater(new Executor(g, this));
    }
    
	
	@Override
	protected double drawTree(Graphics2D g2d, double length) {
		System.out.println("Tree");
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return super.drawTree(g2d, length);
	}

	class Executor implements Runnable {
		private Graphics g;
		private JGradualFractalTreePanel tree;
		
		public Executor(Graphics g, JGradualFractalTreePanel tree) {
			super();
			this.g = g;
			this.tree = tree;
		}

		@Override
		public void run() {
//			initVars();
			Graphics2D g2d = (Graphics2D) g;
//			resetGraphics(g2d);
			g2d.fillRect(0, 0, 50, 50);
//			drawTree(g2d, branchLength);
		}
		
	}
	
}
