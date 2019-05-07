package avim;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VimFrame extends JFrame {

	private AVim vim = null;

	public VimFrame() {
		super("vim");
		setSize(500, 500);
		setVisible(true);
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(15, 15));
		add(text);
		vim = new AVim();

		text.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				update();
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				update();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				update();
			}
			private void update() {
				String input = text.getText();
				vim.textUpdate(input);
				if (vim.commandTerm()) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() { text.setText(""); }
					});
				}
			}
		});
		
		text.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				vim.pressKey(e);
			}
		});
		
		
		
	}
}
