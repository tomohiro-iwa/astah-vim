package main.java.avim.command;

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
		if(direction.equals("j"))
		{
			INodePresentation parentP = currentP.getParent();
			List<INodePresentation> childrenPs = Arrays.asList(parentP.getChildren());
			int currentIndex = childrenPs.indexOf(currentP);
			INodePresentation nextP = childrenPs.get(currentIndex+1);
			diagramView.select((IPresentation) nextP);
		}
	}

}
