package org.fx.workout.designs;

import org.fx.constants.Constants;

public class ValueFactory {

	public Value getValue(String crossViaMatrixValue) {
		if (crossViaMatrixValue == null) {
			return null;
		}
		if (crossViaMatrixValue.equalsIgnoreCase(Constants.DIRECT)) {
			return new Direct();
		} else if (crossViaMatrixValue.equalsIgnoreCase(Constants.INVERTED)) {
			return new Inverted();
		} else if (crossViaMatrixValue.equalsIgnoreCase(Constants.UNITY)) {
			return new Unity();
		}
		return null;
	}

}