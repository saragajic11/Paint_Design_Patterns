package commands;

import org.omg.CORBA.PRIVATE_MEMBER;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class CmdToFront implements Command {

	private Shape shape;
	private DrawingModel model;
	private int index;
	private String commandLog;

	public CmdToFront(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;

	}

	@Override
	public void execute() {
		index = model.getIndexOf(shape);
		model.removeAt(index);
		model.addAt(shape, index + 1);
		commandLog = "ToFront" + "_EXECUTE_" + shape;

	}

	@Override
	public void unexecute() {
		model.removeAt(index + 1);
		model.addAt(shape, index);
		commandLog = "ToFront" + "_UNEXECUTE_" + shape;
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

}
