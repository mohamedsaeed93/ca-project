import hardwares.Memory;


public class Main {
	public static void main(String[] args) {
		Memory m = Memory.get_instance();
		System.out.println(Integer.toBinaryString(200));
		m.setData(0, (byte)200);
		m.setLeftHalf(0, 8);
		m.setRightHalf(0, 4);
		System.out.println(m.getLeftHalf(0));
		System.out.println(m.getRightHalf(0));
	}
}
