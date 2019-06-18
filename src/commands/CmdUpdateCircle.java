package commands;

import shapes.Circle;
import shapes.Command;

public class CmdUpdateCircle implements Command{

	private Circle oldState;
	private Circle newState;
	private Circle originalState;
	private String commandLog;
	
	
	public CmdUpdateCircle(Circle oldState, Circle newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		originalState = (Circle) oldState.clone();
		oldState.getCenter().setX(newState.getCenter().getX());
		oldState.getCenter().setY(newState.getCenter().getY());
		oldState.setRadius(newState.getRadius());
		oldState.setColor(newState.getColor());
		oldState.setColorInside(newState.getColorInside());
		
		commandLog= "UPDATECIRCLE" + "_EXECUTE_"+ originalState + "->" + oldState;
	}

	@Override
	public void unexecute() {
		oldState.getCenter().setX(originalState.getCenter().getX());
		oldState.getCenter().setY(originalState.getCenter().getY());
		oldState.setRadius(originalState.getRadius());
		oldState.setColor(originalState.getColor());
		oldState.setColorInside(originalState.getColorInside());
		
		commandLog= "UPDATECIRCLE" + "_UNEXECUTE_"+ oldState + "->" + originalState;
		
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

}
