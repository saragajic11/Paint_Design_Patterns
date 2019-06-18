package shapes;

import frame.DrawingFrame;
import model.DrawingModel;

public interface Observer {
	void update(DrawingFrame frame,DrawingModel model,int numberOfSelected,int numberOfUndoCmd,int numberOfRedoCmd);
}
