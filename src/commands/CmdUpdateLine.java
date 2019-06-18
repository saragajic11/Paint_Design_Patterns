package commands;

import java.io.Console;

import shapes.Command;
import shapes.Line;

public class CmdUpdateLine implements Command {

	private Line oldState;
	private Line newState;
	private Line originalState;
	private String commandLog;

	public CmdUpdateLine(Line oldState, Line newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		originalState = (Line) oldState.clone();
		oldState.getStartPoint().setX(newState.getStartPoint().getX());
		oldState.getStartPoint().setY(newState.getStartPoint().getY());
		oldState.getEndPoint().setX(newState.getEndPoint().getX());
		oldState.getEndPoint().setY(newState.getEndPoint().getY());
		oldState.setColor(newState.getColor());
		commandLog = "UPDATELINE" + "_EXECUTE_" + originalState + "->" + oldState;
	}

	@Override
	public void unexecute() {
		oldState.getStartPoint().setX(originalState.getStartPoint().getX());
		oldState.getStartPoint().setY(originalState.getStartPoint().getY());
		oldState.getEndPoint().setX(originalState.getEndPoint().getX());
		oldState.getEndPoint().setY(originalState.getEndPoint().getY());
		oldState.setColor(originalState.getColor());
		commandLog= "UPDATELINE" + "_UNEXECUTE_"+ oldState + "->" + originalState;
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

}
