package view;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class JGradualFractalTreePanel extends JFractalTreePanel2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2208740552110733532L;

	private Timer animate;
	private int delay = 1000;
    private JFractalTreePanel2 tree = this;

	public JGradualFractalTreePanel() {
		super();
		animate = new Timer(delay, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Repaint");
				repaint();
			}
		});
		animate.setRepeats(true);
		animate.setCoalesce(true);
		animate.start();
	}
	
	@Override
	protected double drawTree(Graphics2D g2d, double length) {
		// TODO Auto-generated method stub
		return super.drawTree(g2d, length);
	}

}
