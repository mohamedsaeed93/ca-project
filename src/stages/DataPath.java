package stages;

import instructionSet.InstructionSet;
import instructionSet.InstructionString;
import abstracts.Instruction;
import exception.NoSuchAddressException;
import exception.NoSuchInstructionException;
import exception.NoSuchLabelException;
import exception.NoSuchRegisterException;
import exception.OverFlowException;

public class DataPath {
	private static DataPath DATAPATH;
	private int PC = 0, CLOCK = 0;
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

	public void start2(int address) throws InterruptedException {
		if(address < InsSet.getSize())
			PC = address;
		CLOCK = 0;
		while (!InsSet.isFinished2(PC)) {
			fetch();
			CLOCK++;
			decode();
			CLOCK++;
			execute();
			CLOCK++;
			memory();
			CLOCK++;
			writeBack();
			CLOCK++;
		}
		System.out.println("The Clock now is " + CLOCK);
	}

	public void start(int address) throws InterruptedException {
		if(address < InsSet.getSize())
			PC = address;
		CLOCK = 0;
		while (!InsSet.isFinished(PC)) {
			writeBack();
			memory();
			execute();
			decode();
			fetch();
			CLOCK++;
		}
		System.out.println("The Clock now is " + CLOCK);
	}

	private void fetch() {
		FetchedInstruction = IF.fetch(PC);
		PC++;
	}

	private void decode() {
		try {
			Instruction temp = ID.id(FetchedInstruction);
			DecodedInstruction = temp;
		} catch (NoSuchInstructionException | NoSuchRegisterException
				| OverFlowException | NoSuchLabelException e) {
			e.printStackTrace();
		}
	}

	private void execute() {
		try {
			EXEC.exec(DecodedInstruction);
			ExecutedInstruction = DecodedInstruction;
		} catch (NoSuchRegisterException e) {
			e.printStackTrace();
		}
	}

	private void memory() {
		try {
			MEM.readOrWrite(ExecutedInstruction);
			MemoryInstruction = ExecutedInstruction;
		} catch (NoSuchAddressException e) {
			e.printStackTrace();
		}
	}

	private void writeBack() {
		WB.RegistetWriteBack(MemoryInstruction);
	}

}
