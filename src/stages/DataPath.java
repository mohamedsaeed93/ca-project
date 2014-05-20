package stages;

import abstracts.Instruction;
import exception.NoSuchAddressException;
import exception.NoSuchInstructionException;
import exception.NoSuchRegisterException;
import exception.OverFlowException;
import instructionSet.InstructionSet;
import instructionSet.InstructionString;

public class DataPath {
	private static DataPath DATAPATH;
	private int PC = 0;
	private InstructionSet InsSet = InstructionSet.getInstance();
	private InstructionString FetchedInstruction;
	private Instruction DecodedInstruction, ExecutedInstruction,
			MemoryInstruction;

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
			new Thread(fetch).start();
			new Thread(decode).start();
			new Thread(execute).start();
			new Thread(memory).start();
			new Thread(writeBack).start();
			Thread.sleep(1000);
		}
	}

	private Runnable fetch = new Runnable() {

		@Override
		public void run() {
			try {
				FetchedInstruction = IF.fetch(PC);
			} catch (NoSuchAddressException e) {
				PC = Integer.MAX_VALUE;
				e.printStackTrace();
			}
		}
	};

	private Runnable decode = new Runnable() {

		@Override
		public void run() {
			try {
				Instruction temp = ID.id(FetchedInstruction);
				Thread.sleep(50);
				DecodedInstruction = temp;
			} catch (NoSuchInstructionException | NoSuchRegisterException
					| OverFlowException | InterruptedException e) {
				PC = Integer.MAX_VALUE;
				e.printStackTrace();
			}
		}
	};

	private Runnable execute = new Runnable() {

		@Override
		public void run() {
			try {
				EXEC.exec(DecodedInstruction);
				Thread.sleep(50);
				ExecutedInstruction = DecodedInstruction;
			} catch (NoSuchRegisterException | InterruptedException e) {
				PC = Integer.MAX_VALUE;
				e.printStackTrace();
			}
		}
	};

	private Runnable memory = new Runnable() {

		@Override
		public void run() {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				PC = Integer.MAX_VALUE;
				e.printStackTrace();
			}
		}
	};

	private Runnable writeBack = new Runnable() {

		@Override
		public void run() {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				PC = Integer.MAX_VALUE;
				e.printStackTrace();
			}
		}
	};

}
