package commands;

import shapes.Command;
import shapes.Rectangle;

public class CmdUpdateRectangle implements Command {

	private Rectangle oldState;
	private Rectangle newState;
	private Rectangle originalState;
	private String commandLog;

	public CmdUpdateRectangle(Rectangle oldState, Rectangle newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		originalState = oldState.clone();
		oldState.getUpperLeft().setX(newState.getUpperLeft().getX());
		oldState.getUpperLeft().setY(newState.getUpperLeft().getY());
		oldState.setPage(newState.getPage());
		oldState.setWidth(newState.getWidth());
		oldState.setColor(newState.getColor());
		oldState.setColorInside(newState.getColorInside());
		commandLog = "UPDATEREC" + "_EXECUTE_" + originalState + "->" + oldState;
	}

	@Override
	public void unexecute() {
		oldState.getUpperLeft().setX(originalState.getUpperLeft().getX());
		oldState.getUpperLeft().setY(originalState.getUpperLeft().getY());
		oldState.setPage(originalState.getPage());
		oldState.setWidth(originalState.getWidth());
		oldState.setColor(originalState.getColor());
		oldState.setColorInside(originalState.getColorInside());
		commandLog = "UPDATEREC" + "_UNEXECUTE_" + oldState + "->" + originalState;
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

}
