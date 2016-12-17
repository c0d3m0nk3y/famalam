package famalam;

import java.util.ArrayList;
import java.util.Scanner;

public class FootballResultsGenerator {
	private ArrayList<Team> teams;
	private ArrayList<Match> matches;
	private Scanner userinput;
	private String result;
	
	public FootballResultsGenerator() {
		teams = new ArrayList<Team>();
	   	matches = new ArrayList<Match>();
	   	
		userinput = new Scanner(System.in);
	}
	
	public void Run() {
		for(int inputIndex = 0; inputIndex < 100; inputIndex++) {
			System.out.print("Input Results: ");
			result = userinput.nextLine().replace(" : ", ":");
			
			if(result.equals("stop")) {
				break;
			} else if(result.equals("totals")) {
				PrintTotals();
			} else {
				SaveInput(result);
			}
		}
		
		PrintAllMatchResults();
	}
	
	public void End() {
		userinput.close();
	}
	
	public void PrintUserInstructions() {
   		System.out.println("Please enter your football results in the format");
	   	System.out.println("home_team_name : away_team_name : home_team_score : away_team_score");
	   	System.out.println("E.g.");
	   	System.out.println("Manchester City : Manchester United : 2 : 1");
	   	System.out.println("To stop entering football results type stop");
	   	System.out.println("To see input statistics type Totals");
		
	}
	
	private void PrintAllMatchResults() {
		for(Match match : matches) {
			match.Print();
		}
	}
	
	private void SaveInput(String result) {
		String[] results = result.split(":");
		
		String homeTeamName = results[0];
		String awayTeamName = results[1];
		int homeTeamScore = Integer.parseInt(results[2]);
		int awayTeamScore = Integer.parseInt(results[3]);
		
		Team homeTeam = GetTeam(homeTeamName);
		homeTeam.AddResult(homeTeamScore, true);
		Team awayTeam = GetTeam(awayTeamName);
		awayTeam.AddResult(awayTeamScore, false);
		
		matches.add(new Match(homeTeam, homeTeamScore, awayTeam, awayTeamScore));
	}
	
	private Team GetTeam(String teamName) {
		for(Team team : teams) {
			if(team.GetName() == teamName) {
				return team;
			}
		}
		
		return CreateTeam(teamName);
	}
	
	private Team CreateTeam(String teamName) {
		Team team = new Team(teamName);
		teams.add(team);
		return team;
	}
	
	private void PrintTotals() {
		System.out.println("Total number of matches played: " + matches.size() );
		System.out.println("Total home scores of all matches: " + GetTotalHomeGoals() );
		System.out.println("Total away scores of all matches: " + GetTotalAwayGoals() );
		PrintHighestHomeGoals();
		PrintHighestAwayGoals();
		//System.out.println("Total number of invalid entries: " + invalidlc );
	}
	
	private void PrintHighestHomeGoals() {
		int highestHomeGoals = 0;
		for(Team team : teams) {
			if(team.GetHomeGoals() > highestHomeGoals) {
				highestHomeGoals = team.GetHomeGoals();
			}
		}
		
		System.out.println("Highest home score: " + highestHomeGoals);
	}

	
	private void PrintHighestAwayGoals() {
		int highestAwayGoals = 0;
		for(Team team : teams) {
			if(team.GetAwayGoals() > highestAwayGoals) {
				highestAwayGoals = team.GetAwayGoals();
			}
		}
		
		System.out.println("Highest away score: " + highestAwayGoals);
	}
	
	private int GetTotalHomeGoals() {
		int totalHomeGoals = 0;
		
		for(Team team : teams) {
			totalHomeGoals += team.GetHomeGoals();
		}
		
		return totalHomeGoals;
	}
	
	private int GetTotalAwayGoals() {
		int totalAwayGoals = 0;
		
		for(Team team : teams) {
			totalAwayGoals += team.GetAwayGoals();
		}
		
		return totalAwayGoals;
	}

}
