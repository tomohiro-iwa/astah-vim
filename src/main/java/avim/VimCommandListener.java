package avim;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import avim.command.ICommand;

public class VimCommandListener implements DocumentListener {
	private JTextField textField = null;

	public VimCommandListener(JTextField text) {
		textField = text;
	}

	public void changedUpdate(DocumentEvent e) {
		try {
			update();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void removeUpdate(DocumentEvent e) {
		try {
			update();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void insertUpdate(DocumentEvent e) {
		try {
			update();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void update() throws Exception {
		String input = textField.getText();
		VimCommandMaker commandMaker = new VimCommandMaker();
		ICommand command = commandMaker.make(input);
		if (command == null)
		{

		}else
		{
			command.excute();
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					textField.setText("");
				}
			});
		}
		
	}
}
