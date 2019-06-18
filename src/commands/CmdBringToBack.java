package commands;

import java.text.StringCharacterIterator;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class CmdBringToBack implements Command {
	private Shape shape;
	private DrawingModel model;
	private int index;
	private String commandLog;
	
	public CmdBringToBack(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;
	}
	@Override
	public void execute() {
		index = model.getIndexOf(shape);
		model.removeAt(index);
		model.addAt(shape, 0);
		commandLog = "BringToBack"+"_EXECUTE_"+shape;
		
	}

	@Override
	public void unexecute() {
		model.removeAt(0);
		model.addAt(shape, index);
		commandLog = "BringToBack"+"_UNEXECUTE_"+shape;
		
	}
	public String getCommandLog() {
		return commandLog;
	}
	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}
	

}
