package nowapps.nxton;

import java.util.HashMap;
import java.util.Map;

public class GoldenCrown {

	private static final String LAND_MSG = "Panda";
	private static final String WATER_MSG = "Octopus";
	private static final String ICE_MSG = "Mammoth";
	private static final String AIR_MSG = "Owl";
	private static final String FIRE_MSG = "Dragon";

	private static final int LAND_KINGDOM = 1;
	private static final int WATER_KINGDOM = 2;

	public static void main(String[] args) {

	}

	boolean checkSecretMessage(int kingdomType, String msg) {
		Map<String, Integer> codeMap = new HashMap<String, Integer>();
		switch (kingdomType) {
		case LAND_KINGDOM:
			for (int i = 0; i < LAND_MSG.length(); i++) {
				if
				return true;
			}
		}
		return false;
	}

	boolean decodeMessage(String msg) {

		return false;
	}

}
