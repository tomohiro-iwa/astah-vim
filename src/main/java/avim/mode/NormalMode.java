package avim.mode;

import java.awt.event.KeyEvent;

import avim.InsertMode;
import avim.command.ICommand;
import avim.command.MoveCommand;

public class NormalMode implements IVimMode{
	public IVimMode update(String input)
	{
		IVimMode nextMode = null;
		ICommand command = null;
		if(input.equals("j"))
		{
			command = new MoveCommand(input);
		}
		if(input.equals("k"))
		{
			command = new MoveCommand(input);
		}
		if (input.equals("i"))
		{
			command = new CreateTopicCommand();
			nextMode = new InsertMode();
		}

		if (command != null)
		{
			try {
				command.excute();
			}catch (Exception e){
				System.out.println("error");
			}
		}
		return nextMode;
	}
	
	public IVimMode pressKey(KeyEvent e)
	{
		return null;
	}
	
	public boolean commandTerm()
	{
		return true;
	}
}
