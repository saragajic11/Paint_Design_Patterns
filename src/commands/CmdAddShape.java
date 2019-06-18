package commands;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class CmdAddShape implements Command {

	private Shape shape;
	private DrawingModel model;
	private String commandLog;

	public CmdAddShape(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;
	}

	@Override
	public void execute() {
		model.add(shape);
		commandLog = "ADD" + "_EXECUTE_" + shape;
		System.out.println(shape);
	}

	@Override
	public void unexecute() {
		model.remove(shape);
		commandLog = "ADD" + "_UNEXECUTE_" + shape;

	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}
	

}
