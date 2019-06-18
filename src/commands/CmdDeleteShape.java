package commands;

import java.awt.font.ShapeGraphicAttribute;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class CmdDeleteShape implements Command {

	private Shape shape;
	private DrawingModel model;
	private String commandLog;

	public CmdDeleteShape(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}
	

	@Override
	public void execute() {
		model.remove(shape);
		commandLog = "DELETE"+"_EXECUTE_"+shape;

	}

	@Override
	public void unexecute() {
		model.add(shape);
		commandLog = "DELETE"+"_UNEXECUTE_"+shape;

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
