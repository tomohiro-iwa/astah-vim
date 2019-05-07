package avim.mode;

import java.awt.event.KeyEvent;

public interface IVimMode {

	public IVimMode update(String text);
	public IVimMode pressKey(KeyEvent e);
	public boolean commandTerm();
	
}
