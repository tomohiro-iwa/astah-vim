package avim.mode;

import java.util.Arrays;
import java.util.List;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.editor.IDiagramEditorFactory;
import com.change_vision.jude.api.inf.editor.ITransactionManager;
import com.change_vision.jude.api.inf.editor.MindmapEditor;
import com.change_vision.jude.api.inf.presentation.INodePresentation;
import com.change_vision.jude.api.inf.project.ProjectAccessor;
import com.change_vision.jude.api.inf.view.IDiagramViewManager;

import avim.command.ICommand;

public class CreateTopicCommand implements ICommand {

	public void excute() throws Exception {
		AstahAPI api = AstahAPI.getAstahAPI();

		IDiagramViewManager diagramView = api.getViewManager().getDiagramViewManager();
		INodePresentation currentP = (INodePresentation) diagramView.getSelectedPresentations()[0];
		INodePresentation parentP = ((INodePresentation) currentP).getParent();
		List<INodePresentation> childrenPs = Arrays.asList(parentP.getChildren());
		int currentIndex = childrenPs.indexOf(currentP);

		ProjectAccessor projectAccessor = api.getProjectAccessor();
		ITransactionManager transactionManager = projectAccessor.getTransactionManager();
		IDiagramEditorFactory diagramEditorFactory = projectAccessor.getDiagramEditorFactory();
		MindmapEditor mindmapEditor = diagramEditorFactory.getMindmapEditor();

		try {
			transactionManager.beginTransaction();
			mindmapEditor.createTopic(parentP, " ", currentIndex + 1);
			transactionManager.endTransaction();

		} catch (Exception e) {

			transactionManager.abortTransaction();

		}
	}

}
