package main.java.avim;


import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;
import com.change_vision.jude.api.inf.model.IDiagram;
import com.change_vision.jude.api.inf.model.IMindMapDiagram;
import com.change_vision.jude.api.inf.presentation.INodePresentation;
import com.change_vision.jude.api.inf.presentation.IPresentation;
import com.change_vision.jude.api.inf.project.ProjectAccessor;
import com.change_vision.jude.api.inf.ui.IPluginActionDelegate;
import com.change_vision.jude.api.inf.ui.IWindow;
import com.change_vision.jude.api.inf.view.IDiagramViewManager;

public class TemplateAction implements IPluginActionDelegate {

    public Object run(IWindow window) throws UnExpectedException {
        try {
            AstahAPI api = AstahAPI.getAstahAPI();
            ProjectAccessor projectAccessor = api.getProjectAccessor();
            projectAccessor.getProject();
            IDiagramViewManager diagramView = api.getViewManager().getDiagramViewManager();
            IDiagram diagram = diagramView.getCurrentDiagram();
            IPresentation[] currentP = diagram.getPresentations();
            diagramView.select(currentP[0]);
            if (diagramView.getCurrentDiagram() instanceof IMindMapDiagram) {
                System.out.println("mindmap");
            } else {
                System.out.println("athor");
            }

            JFrame frame = new JFrame("vim");
            frame.setSize(500, 500);
            frame.setVisible(true);
            JTextField text = new JTextField();
            text.setPreferredSize(new Dimension(15, 15));
            frame.add(text);
            VimCommandListener vimCommandListener = new VimCommandListener(text);
            text.getDocument().addDocumentListener(vimCommandListener);


        } catch (ProjectNotFoundException e) {
            String message = "Project is not opened.Please open the project or create new project.";
            JOptionPane.showMessageDialog(window.getParent(), message, "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(window.getParent(), "Unexpected error has occurred.",
                    "Alert", JOptionPane.ERROR_MESSAGE);
            throw new UnExpectedException();
        }
        return null;
    }

}