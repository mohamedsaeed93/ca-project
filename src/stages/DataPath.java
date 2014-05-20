package stages;

import instructionSet.InstructionSet;

public class DataPath {
	private static DataPath DATAPATH;
	private int PC = 0;
	private InstructionSet InsSet = InstructionSet.getInstance();

	public static DataPath getInstance() {
		if (DATAPATH == null)
			DATAPATH = new DataPath();
		return DATAPATH;
	}

	private DataPath() {
	}

	public static int getPC() {
		return getInstance().PC;
	}

	public static void setPC(int pC) {
		getInstance().PC = pC;
	}

	public void start() throws InterruptedException {
		while (!InsSet.isFinished(PC)) {
			Thread.sleep(1000);
		}
	}

}
