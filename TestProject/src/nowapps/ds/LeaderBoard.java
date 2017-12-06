package nowapps.ds;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Mahesh MK
 * @version 1.0 A class which displays Candidates Ranking Order based on their
 *          respective score for e.g. in a online quiz competition, where
 *          candidates attends and submits the quiz competition. As and when
 *          candidates submits the quiz, their ranking order is generated and
 *          displayed according to their respective score.
 */
public class LeaderBoard {

	/** List holding Candidate objects */
	List<Candidate> candList;
	public static void main(String[] args) {

		LeaderBoard lb = new LeaderBoard();
		lb.arrangeRankOrder(); // sets Rank Order for candidates already on board.

		doPrintln("\n\nTest Cases: ");
		lb.insertCandidate(lb.new Candidate("Sati", 150));
		lb.insertCandidate(lb.new Candidate("Seraph", 5));
		lb.insertCandidate(lb.new Candidate("Roland", 55));
		lb.insertCandidate(lb.new Candidate("Trainman", 20));
		lb.insertCandidate(lb.new Candidate("Niobe", 150));

		doPrintln("Candidate's  new Ranking Order: ");
		for (Candidate c1 : lb.candList) {
			doPrintln(c1.getName() + " : " + c1.getScore() + " " + c1.getRank());
		}
	}

	/**
	 * Default constructor. Add candidates to a list, who have submitted online quiz
	 * competition
	 */
	public LeaderBoard() {
		candList = new LinkedList<Candidate>();
		candList.add(new Candidate("xxx", 20));
		candList.add(new Candidate("Neo", 50));
		candList.add(new Candidate("Smith", 100));
		candList.add(new Candidate("Anderson", 100));
		candList.add(new Candidate("Trinity", 45));
		candList.add(new Candidate("Morpheous", 40));
		candList.add(new Candidate("Oracle", 20));
		candList.add(new Candidate("Link", 10));
	}

	/**
	 * Sets default ranking of Candidates based on their score(Score assumed in descending
	 * order)
	 */
	void arrangeRankOrder() {
		Collections.sort(candList, new SortByScore());
		//candList.sort(new SortByScore());
		doPrintln("Candidate initial default Ranking based on their score: ");
		int rank = 0;
		Candidate previous_cand = null;

		for (Candidate c : candList) {
			if (previous_cand == null) {
				previous_cand = c;
				c.setRank(++rank);
				doPrintln(c.getName() + " : " + c.getScore() + " : " + c.getRank());
				continue;
			}
			if (previous_cand.getScore() > c.getScore())
				c.setRank(++rank);
			else if (previous_cand.getScore() == c.getScore()) {
				c.setRank(rank);
			}
			previous_cand = c;
			doPrintln(c.getName() + " : " + c.getScore() + " : " + c.getRank());
		}
	}

	/**
	 * Insert new Candidate to its right position in a list based on score and sets
	 * appropriate ranking for further candidates in list if required
	 */
	void insertCandidate(Candidate cand) {
		int newScore = cand.getScore();
		int insertPos = 0;
		Candidate previousCand = null;
		int rank = 0;
		boolean isSetRanking = false;

		/*
		 * Get the insertion position in the list for new candidate based on his score
		 */
		Iterator<Candidate> iter = candList.iterator();
		while (iter.hasNext()) {
			Candidate c = iter.next();
			if (previousCand == null) { // check if new candidate score is top in list
				if (cand.getScore() > c.getScore()) {
					isSetRanking = true;
					rank = 1;
					// doPrintln("position for new candidat: " + cand.getName() + " " + insertPos +
					// "\n");
					break;
				} else if (cand.getScore() == c.getScore()) { // if new candidate score is same assign same rank
					rank = 1;
					// doPrintln("position for new candidat: " + cand.getName() + " " + insertPos +
					// "\n");
					break;
				}
				previousCand = c;
				continue;
			}

			if (newScore == c.getScore()) { // if new candidate score is same assign same rank
				rank = c.getRank();
				insertPos++;
				// doPrintln("position for new candidat: " + cand.getName() + " " + insertPos +
				// "\n");
				break;
			} else if (newScore < previousCand.getScore() && newScore > c.getScore()) {
				rank = previousCand.getRank() + 1;
				isSetRanking = true;
				insertPos++;
				// doPrintln("position for new candidat: " + cand.getName() + " " + insertPos +
				// "\n");
				break;
			} else if (!iter.hasNext() && newScore < c.getScore()) { // check if new candidate is in last position
				rank = c.getRank() + 1;
				insertPos++;
				// doPrintln("position for new candidat: " + cand.getName() + " " + insertPos +
				// "\n");
			}

			insertPos++;
			previousCand = c;
		}

		cand.setRank(rank); // set rank for new candidate
		candList.add(insertPos, cand); // inserts new candidate to its correct position

		// Set Rankings for further candidates -> index = insertPos + 1
		if (isSetRanking) {
			ListIterator<Candidate> listIter = candList.listIterator(insertPos + 1);
			while (listIter.hasNext()) {
				Candidate c1 = listIter.next();
				c1.setRank(c1.getRank() + 1);
			}
		}
	}

	/** Candidate Class */
	class Candidate {
		String name;
		int score;
		int rank;

		public Candidate(String name, int score, int rank) {
			this.name = name;
			this.score = score;
			this.rank = rank;
		}

		public Candidate(String name, int score) {
			this.name = name;
			this.score = score;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the score
		 */
		public int getScore() {
			return score;
		}

		/**
		 * @param score
		 *            the score to set
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
		 * @param rank
		 *            the rank to set
		 */
		public void setRank(int rank) {
			this.rank = rank;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Candidate other = (Candidate) obj;
			if (!getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if (name == null) {
				if (other.name != null) {
					return false;
				}
			} else if (!name.equals(other.name)) {
				return false;
			}
			return true;
		}

		private LeaderBoard getOuterType() {
			return LeaderBoard.this;
		}
	}

	// sorts score and name Descending order
	class SortByScore implements Comparator<Candidate> {
		@Override
		public int compare(Candidate c1, Candidate c2) {
			if (c1.getScore() > c2.getScore())
				return -1;
			if (c1.getScore() < c2.getScore())
				return 1;
			if (c1.getScore() == c2.getScore())
				return c1.getName().compareTo(c2.getName());
			return 0;
		}
	}

	// sorts Descending
	class SortByName implements Comparator<Candidate> {
		@Override
		public int compare(Candidate c1, Candidate c2) {
			return c1.getName().compareTo(c2.getName());
		}
	}

	static <T> void doPrintln(T t) {
		System.out.println(t);
	}

	/* other ways *//* other ways *//* other ways *//* other ways */
}
