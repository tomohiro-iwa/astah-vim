package avim.command;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.presentation.INodePresentation;
import com.change_vision.jude.api.inf.view.IDiagramViewManager;

public class RenameCommand implements ICommand{
	private String newName = "";
	public RenameCommand(String name)
	{
		newName = name;
	}
	public void excute() throws Exception
	{
		AstahAPI api = AstahAPI.getAstahAPI();
		IDiagramViewManager diagramView = api.getViewManager().getDiagramViewManager();
		INodePresentation currentP = (INodePresentation) diagramView.getSelectedPresentations()[0];
		currentP.setLabel(newName);
	}

}
