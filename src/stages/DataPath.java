package stages;

import hardwares.Register;
import instructionSet.InstructionSet;
import instructionSet.InstructionString;
import abstracts.Instruction;
import exception.NoSuchAddressException;
import exception.NoSuchInstructionException;
import exception.NoSuchLabelException;
import exception.NoSuchRegisterException;
import exception.OverFlowException;
import exception.SyntaxErrorException;

public class DataPath {
	private static DataPath DATAPATH;
	private int PC = 0, CLOCK = 0;
	private InstructionSet InsSet;
	private InstructionString FetchedInstruction;
	private Instruction DecodedInstruction, ExecutedInstruction,
			MemoryInstruction;

	public static DataPath getInstance() throws SyntaxErrorException {
		if (DATAPATH == null)
			DATAPATH = new DataPath();
		return DATAPATH;
	}

	private DataPath() throws SyntaxErrorException {
		InsSet = InstructionSet.getInstance();
	}

	public static int getPC() throws SyntaxErrorException {
		return getInstance().PC;
	}

	public static void setPC(int pC) throws SyntaxErrorException {
		getInstance().PC = pC;
	}

	public void start(int address) throws InterruptedException,
			SyntaxErrorException {
		if (address < InsSet.getSize())
			PC = address;
		reset();
		CLOCK = 0;
		Register.reset();
		while (!InsSet.isFinished(PC)) {
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

	public void PiplineStart(int address) throws InterruptedException,
			SyntaxErrorException {
		CLOCK = 0;
		reset();
		if (address < InsSet.getSize())
			PC = address;
		Register.reset();
		while (!InsSet.isFinishedPiplined(PC)) {
			writeBack();
			memory();
			execute();
			decode();
			fetch();
			CLOCK++;
		}
		System.out.println("The Clock now is " + CLOCK);
	}

	private void fetch() throws SyntaxErrorException {
		FetchedInstruction = IF.fetch(PC);
		PC++;
	}

	private void decode() throws SyntaxErrorException {
		try {
			Instruction temp = ID.id(FetchedInstruction);
			DecodedInstruction = temp;
		} catch (NoSuchInstructionException | NoSuchRegisterException
				| OverFlowException | NoSuchLabelException e) {
			e.printStackTrace();
		}
	}

	private void execute() throws SyntaxErrorException {
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

	public static void IncPC() throws SyntaxErrorException {
		getInstance().PC++;
	}

	public static void reset() throws SyntaxErrorException{
		getInstance().FetchedInstruction = null;
		getInstance().DecodedInstruction = null;
		getInstance().ExecutedInstruction = null;
		getInstance().MemoryInstruction= null;
	}
}
