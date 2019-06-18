package commands;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class CmdToBack implements Command {
	private Shape shape;
	private DrawingModel model;
	private int index;
	private String commandLog;

	public CmdToBack(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;
	}

	@Override
	public void execute() {
		index = model.getIndexOf(shape);
		model.removeAt(index);
		model.addAt(shape, index - 1);
		commandLog = "ToBack" + "_EXECUTE_" + shape;
	}

	@Override
	public void unexecute() {
		model.removeAt(index - 1);
		model.addAt(shape, index);
		commandLog = "ToBack" + "_UNEXECUTE_" + shape;

	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

}
