/**
 * 
 * @author Sidd
 *
 */

public class Menu extends Interface{
	
	public void callMenu() {
		System.out.println(this);
		int a = 10;
		while (a != 0) {
			switch (a) {
				case 0:
					System.out.println("0");
					break;
				case 1:
					System.out.println("1");
					break;
				case 2:
					System.out.println("2");
					break;
				case 3:
					System.out.println("3");
					break;
				default:
					System.out.println("x");
					System.exit(0);
			}
		}
	}

	public String toString() {
		return "xyz";
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.run();
	}

}
