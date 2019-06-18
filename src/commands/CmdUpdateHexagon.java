package commands;

import adapter.HexagonAdapter;
import shapes.Command;

public class CmdUpdateHexagon implements Command {

	private HexagonAdapter oldState;
	private HexagonAdapter newState;
	private HexagonAdapter originalState;
	private String commandLog;

	public CmdUpdateHexagon(HexagonAdapter oldState, HexagonAdapter newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		originalState = oldState.clone();
		oldState.getHexagon().setX(newState.getHexagon().getX());
		oldState.getHexagon().setY(newState.getHexagon().getY());
		oldState.setR(newState.getR());
		oldState.setEdgeColor(newState.getEdgeColor());
		oldState.setAreaColor(newState.getAreaColor());
		commandLog = "UPDATEHEX" + "_EXECUTE_" + originalState + "->" + oldState;

	}

	@Override
	public void unexecute() {
		oldState.getHexagon().setX(originalState.getHexagon().getX());
		oldState.getHexagon().setY(originalState.getHexagon().getY());
		oldState.setR(originalState.getR());
		oldState.setEdgeColor(originalState.getEdgeColor());
		oldState.setAreaColor(originalState.getAreaColor());
		commandLog= "UPDATEHEX" + "_UNEXECUTE_"+ oldState + "->" + originalState;
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}
	

}
