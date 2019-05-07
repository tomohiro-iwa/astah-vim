package avim.command;

import java.util.Arrays;
import java.util.List;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.presentation.INodePresentation;
import com.change_vision.jude.api.inf.presentation.IPresentation;
import com.change_vision.jude.api.inf.view.IDiagramViewManager;

public class MoveCommand implements ICommand{
	String direction = null;
	public MoveCommand(String input)
	{
		direction = input;
	}
	public void excute() throws Exception
	{
		AstahAPI api = AstahAPI.getAstahAPI();
		IDiagramViewManager diagramView = api.getViewManager().getDiagramViewManager();
		INodePresentation currentP = (INodePresentation) diagramView.getSelectedPresentations()[0];
		INodePresentation nextP = null;
		if(direction.equals("j"))
		{
			nextP = (INodePresentation)getDownPresentation(currentP);
		}
		if(direction.equals("k"))
		{
			nextP = (INodePresentation)getUpPresentation(currentP);
			
		}
		diagramView.select((IPresentation) nextP);
	}
	
	private IPresentation getDownPresentation(IPresentation currentP) {
		if (currentP instanceof INodePresentation) {
			INodePresentation parentP = ((INodePresentation)currentP).getParent();
			List<INodePresentation> childrenPs = Arrays.asList(parentP.getChildren());
			int currentIndex = childrenPs.indexOf(currentP);
			INodePresentation nextP = childrenPs.get(currentIndex + 1);
			return nextP;
		}
		return null;
	}
	private IPresentation getUpPresentation(IPresentation currentP) {
		if (currentP instanceof INodePresentation) {
			INodePresentation parentP = ((INodePresentation)currentP).getParent();
			List<INodePresentation> childrenPs = Arrays.asList(parentP.getChildren());
			int currentIndex = childrenPs.indexOf(currentP);
			INodePresentation nextP = childrenPs.get(currentIndex - 1);
			return nextP;
		}
		return null;
	}

}
