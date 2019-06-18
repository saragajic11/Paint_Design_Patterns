package commands;

import shapes.Command;
import shapes.Square;

public class CmdUpdateSquare implements Command {

	private Square oldState;
	private Square newState;
	private Square originalState;
	private String commandLog;
	
	public CmdUpdateSquare(Square oldState, Square newState) {
		this.oldState=oldState;
		this.newState=newState;
	}
	@Override
	public void execute() {
		originalState = (Square) oldState.clone();
		oldState.getUpperLeft().setX(newState.getUpperLeft().getX());
		oldState.getUpperLeft().setY(newState.getUpperLeft().getY());
		oldState.setPage(newState.getPage());
		oldState.setColor(newState.getColor());
		oldState.setColorInside(newState.getColorInside());
		commandLog = "UPDATESQUARE" + "_EXECUTE_" + originalState + "->" + oldState;
	}

	@Override
	public void unexecute() {
		oldState.getUpperLeft().setX(originalState.getUpperLeft().getX());
		oldState.getUpperLeft().setY(originalState.getUpperLeft().getY());
		oldState.setPage(originalState.getPage());
		oldState.setColor(originalState.getColor());
		oldState.setColorInside(originalState.getColorInside());
		commandLog = "UPDATESQUARE" + "_UNEXECUTE_" + oldState + "->" + originalState;
	}
	public String getCommandLog() {
		return commandLog;
	}
	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}
	

}
