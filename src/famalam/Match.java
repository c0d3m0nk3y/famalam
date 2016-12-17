package famalam;

public class Match {
	private Team homeTeam;
	private Team awayTeam;
	private int homeTeamScore;
	private int awayTeamScore;
	
	public Match(Team homeTeam, int homeTeamScore, Team awayTeam, int awayTeamScore) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
	}
	
	public void Print() {
		System.out.print(homeTeam.GetName());
		System.out.print(" [" + homeTeamScore + "]");
		
		System.out.print(" | ");
		
		System.out.print(awayTeam.GetName());
		System.out.print(" [" + awayTeamScore + "]");
		
		System.out.println();
	}
}
