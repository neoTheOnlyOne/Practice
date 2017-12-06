package nowapps.ds;

public class LeaderBoard1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score[] = {100, 100, 50, 40, 40, 20, 10};
		setPosition(score, 5);
		setPosition(score, 25);
		setPosition(score, 50);
		setPosition(score, 120);
	}
	
	public 
	
	static void insertCandidate(Candidate candidate) {
		
	}
	
	static void setPosition(int [] arrScore, int newScore) {
		int n = arrScore.length;
		int rank = 1;
		//doPrintln(rank);
		int prevScore = arrScore[0];
		
		for(int i=n-1; i > n; i--) {
			
			if(arrScore[i] == prevScore) {
				//doPrintln(rank);
			} else if(arrScore[i] < prevScore) {
				//doPrintln(++rank);
				++rank;
			}
			
			if(newScore == arrScore[i]) {
				doPrintln(rank + " ->Alice1");
				//prevScore = arrScore[i];
				//continue;
			} else if(newScore < prevScore && newScore > arrScore[i]) {
				doPrintln(++rank  + " ->Alice2");
				prevScore = arrScore[i];
				//continue;
			}
		}
		if(newScore < arrScore[n-1])
			doPrintln(++rank + " ->Alice3");
	}
	
	static void setRanks(int [] arrScore) {
		
	}
	
	static <T> void doPrintln(T t) {
		System.out.println(t);
	}

	class Candidate {
		int score;
		int rank;
		/**
		 * @return the score
		 */
		public int getScore() {
			return score;
		}
		/**
		 * @param score the score to set
		 */
		public void setScore(int score) {
			this.score = score;
		}
		/**
		 * @return the rank
		 */
		public int getRank() {
			return rank;
		}
		/**
		 * @param rank the rank to set
		 */
		public void setRank(int rank) {
			this.rank = rank;
		}
	}
}

