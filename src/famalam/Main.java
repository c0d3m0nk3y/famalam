/**
 * 
 */
package famalam;

/**
 * @author user
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FootballResultsGenerator frg = new FootballResultsGenerator();
		frg.PrintUserInstructions();
		frg.Run();
		frg.End();
	}

}
