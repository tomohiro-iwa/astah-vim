package avim;

import java.awt.event.KeyEvent;

import avim.command.RenameCommand;
import avim.mode.IVimMode;

public class InsertMode implements IVimMode{
	private boolean isTerm = false;
	String inputText = "";

	public IVimMode update(String input)
	{
		inputText = input;
		return null;
	}
	
	public IVimMode pressKey(KeyEvent e)
	{
		//if (e.getModifiers() &)
		if(e.getKeyCode()== KeyEvent.VK_ESCAPE)
		{
			RenameCommand command = new RenameCommand(inputText);
		}
		return null;
	}
	
	public boolean commandTerm()
	{
		return isTerm;
	}
}
