package strategy;

import java.io.File;

public class Context implements Strategy {

	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public void save(File file) {
		strategy.save(file);

	}

	@Override
	public void open(File file) {
		strategy.open(file);

	}

}
