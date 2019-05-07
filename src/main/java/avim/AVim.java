// Dirty
package avim;

import java.awt.event.KeyEvent;

import avim.command.ICommand;
import avim.command.MoveCommand;
import avim.mode.IVimMode;
import avim.mode.NormalMode;

public class AVim {
	private NormalMode normalMode = new NormalMode();
	private InsertMode insertMode = new InsertMode();
	private IVimMode mode = null;

	private boolean isTerm = false;
	public AVim()
	{
		mode = normalMode;
	}
	
	public void textUpdate(String input)
	{
		mode.update(input);
		isTerm = mode.commandTerm();
	}

	public void pressKey(KeyEvent e)
	{
		mode.pressKey(e);
	}
	
	public boolean commandTerm()
	{
		boolean result = isTerm;
		isTerm = false;
		return result;
	}
}
