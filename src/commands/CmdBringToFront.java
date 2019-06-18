package commands;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class CmdBringToFront implements Command {
	private Shape shape;
	private DrawingModel model;
	private int size;
	private int index;
	private String commandLog;
	
	public CmdBringToFront(Shape shape, DrawingModel model, int size) {
		this.shape = shape;
		this.model = model;
		this.size = size;
	}
	
	
	@Override
	public void execute() {
		index = model.getIndexOf(shape);
		model.removeAt(index);
		model.addAt(shape, size);
		commandLog = "BringToFront"+"_EXECUTE_"+shape;
		
	}

	@Override
	public void unexecute() {
		model.removeAt(size);
		model.addAt(shape, index);
		commandLog = "BringToFront"+"_UNEXECUTE_"+shape;
		
	}


	public String getCommandLog() {
		return commandLog;
	}


	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}
	
}
