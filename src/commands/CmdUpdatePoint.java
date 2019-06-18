package commands;

import shapes.Command;
import shapes.Point;

public class CmdUpdatePoint implements Command{

	private Point oldState;
	private Point newState;
	private Point originalState;
	private String commandLog;
	
	public CmdUpdatePoint(Point oldState,Point newState) {
		this.oldState=oldState;
		this.newState=newState;
	}
	@Override
	public void execute() {
		originalState = (Point) oldState.clone();
		oldState.moveTo(newState.getX(), newState.getY());
		oldState.setColor(newState.getColor());
		commandLog = "UPDATEPOINT" + "_EXECUTE_" + originalState + "->" + oldState;
	}

	@Override
	public void unexecute() {
		oldState.moveTo(originalState.getX(), originalState.getY());
		oldState.setColor(originalState.getColor());
		commandLog = "UPDATEPOINT" + "_UNEXECUTE_" + oldState + "->" + originalState;
	}
	public String getCommandLog() {
		return commandLog;
	}
	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

}
