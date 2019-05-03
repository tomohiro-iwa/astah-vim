// Dirty
package avim;

import avim.command.MoveCommand;
import avim.command.ICommand;

public class VimCommandMaker {
	public enum VimMode{
		NormalMode,
		VisualMode
	};
	private VimMode mode = VimMode.NormalMode;
	public VimCommandMaker()
	{
		
		
	}
	
	public ICommand make(String input)
	{
		if(input.equals("j"))
		{
			return new MoveCommand("j");
		}
		return null;
		
		
	}
}
