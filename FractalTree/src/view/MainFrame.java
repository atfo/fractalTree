package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8456560429229699542L;
	private static JFractalTreePanel2 tree;
	
	
	public MainFrame() {
		super("Fractal Tree");
		tree = new JAnimatedFractalTreePanel();
		this.setPreferredSize(new Dimension(1000, 1000));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(tree);
		this.setVisible(true);
		this.pack();
	}
	
	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
		tree.newSize(getWidth(), getHeight());
	}
}
