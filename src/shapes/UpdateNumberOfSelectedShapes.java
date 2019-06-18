package shapes;

import controller.DrawingController;
import frame.DrawingFrame;
import model.DrawingModel;

public class UpdateNumberOfSelectedShapes implements Observer {
	DrawingController controller;

	@Override
	public void update(DrawingFrame frame, DrawingModel model, int numberOfSelected, int numberOfUndoCmd,
			int numberOfRedoCmd) {
		controller = new DrawingController(model, frame);
		frame.getBtnDelete().setEnabled(numberOfSelected > 0);
		frame.getBtnModify().setEnabled(numberOfSelected == 1);
		frame.getMntmUndo().setEnabled(numberOfUndoCmd>0);
		frame.getMntmRedo().setEnabled(numberOfRedoCmd>0);
		
		int numOfShapes = model.getAll().size();
		frame.getMntmBringToFront().setEnabled(numberOfSelected==1 && numOfShapes>1);
		frame.getMntmBringToBack().setEnabled(numberOfSelected == 1 && numOfShapes>1);
		frame.getMntmToFront().setEnabled(numberOfSelected == 1 && numOfShapes>1);
		frame.getMntmToBack().setEnabled(numberOfSelected == 1 && numOfShapes>1);
		

	}

}
