package org.fx.workout.designs.command;

import org.fx.constants.Constants;

public class CalculatorFactory {
	
	public Command process(String crossMatrixValue, String base, String term, double amount) {
		Command command = null;
		if (crossMatrixValue.equalsIgnoreCase(Constants.DIRECT)) {
			command = new DirectFeedCommand();
		} else if (crossMatrixValue.equalsIgnoreCase(Constants.INVERTED)) {
			command = new InvertedCommand(base, term, amount);
		} else if (crossMatrixValue.equalsIgnoreCase(Constants.UNITY)) {
			command = new UnityCommand();
		}
		command.execute();
		return command;
	}

}
