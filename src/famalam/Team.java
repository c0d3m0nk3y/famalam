package famalam;

public class Team {

	private String name;
	private int awayGoals;
	private int homeGoals;
	
	public Team(String name) {
		this.name = name;
	}
	
	public String GetName() {
		return name;
	}
	
	public int GetTotalGoals() {
		return awayGoals + homeGoals;
	}
	
	public int GetHomeGoals() {
		return homeGoals;
	}
	
	public int GetAwayGoals() {
		return awayGoals;
	}
	
	public void AddResult(int goals, boolean home) {
		if(home) {
			homeGoals += goals;
		} else {
			awayGoals += goals;
		}
		
		// alternatively you could use the ternary (? :) operator
		// home ? homeGoals += goals : awayGoals += goals;
	}
}
