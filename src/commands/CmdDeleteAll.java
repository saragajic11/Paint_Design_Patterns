package commands;

import java.util.ArrayList;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class CmdDeleteAll implements Command {

	private DrawingModel model;
	private ArrayList<Shape> listOfShapes;
	private String commandLog;

	public CmdDeleteAll(ArrayList<Shape> list, DrawingModel model) {
		this.listOfShapes = list;
		this.model = model;
	}

	@Override
	public void execute() {
		model.removeMultiple(listOfShapes);
		commandLog = "DELETEshapes"+"_EXECUTE_"+listOfShapes;
	}

	@Override
	public void unexecute() {
		model.addAll(listOfShapes);
		commandLog = "DELETEshapes"+"_UNEXECUTE_"+listOfShapes;

	}

	public ArrayList<Shape> getList() {
		return listOfShapes;
	}

	public void setList(ArrayList<Shape> list) {
		this.listOfShapes = list;
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}
	

}
