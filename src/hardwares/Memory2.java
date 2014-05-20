package hardwares;

public class Memory2 {
	private static Memory2 MEMORY = null;
	private String[] theMemory;
	
	public static Memory2 get_instance(){
		if (MEMORY == null)
			return MEMORY = new Memory2();
		return MEMORY;
	}

	private Memory2(){
		theMemory = new String[1000000];
	}
	
	public String getData(int address){
		return theMemory[address];
	}

}
