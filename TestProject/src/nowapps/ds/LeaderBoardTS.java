package nowapps.ds;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Mahesh MK
 * @version 1.0 A class which displays Candidates Ranking Order based on their
 *          respective score for e.g. in a online quiz competition, where
 *          candidates attends and submits the quiz competition. As and when
 *          candidates submits the quiz, his ranking order is generated and
 *          displayed according to his score.
 */
public class LeaderBoardTS {

	/** Set holding Candidate objects */
	SortedSet<Candidate> candSet;

	public static void main(String[] args) {
		LeaderBoardTS lb = new LeaderBoardTS();

		doPrintln("\n\n test cases: ");
		lb.insertCandidateTS(lb.new Candidate("Sati", 150, -1));
		lb.insertCandidateTS(lb.new Candidate("Seraph", 5, -1));
		lb.insertCandidateTS(lb.new Candidate("Roland", 45, -1));
		lb.insertCandidateTS(lb.new Candidate("Trainman", 20, -1));
		lb.insertCandidateTS(lb.new Candidate("Niobe", 150, -1));

		doPrintln("Candidate's  new Ranking Order: ");
		for (Candidate c1 : lb.candSet) {
			doPrintln(c1.getName() + " : " + c1.getScore() + " " + c1.getRank());
		}
	}

	/**
	 * Default constructor
	 */
	public LeaderBoardTS() {
		candSet = new TreeSet<Candidate>(new SortByScore());
		
		candSet.add(new Candidate("Morpheous", 40, 3));
		candSet.add(new Candidate("Smith", 100, 1));
		candSet.add(new Candidate("Neo", 50, 2));
		candSet.add(new Candidate("Trinity", 40, 3));
		candSet.add(new Candidate("Anderson", 100, 1));
		candSet.add(new Candidate("Link", 10, 6));
		candSet.add(new Candidate("Oracle", 20,4 ));
		candSet.add(new Candidate("xxx", 20, 5));
		
		doPrintln("Initial Candidate's Ranking Order: ");
		for (Candidate c1 : candSet) {
			doPrintln(c1.getName() + " : " + c1.getScore() + " " + c1.getRank());
		}
		doPrintln("\n\n");
	}

	/**
	 * Insert new Candidate to its right position in a Set based on score and name.
	 * Sets appropriate ranking for further candidates in the list if required
	 */
	void insertCandidateTS(Candidate cand) {
		candSet.add(cand);
		arrangeRankOrderTS(cand);
	}

	/**
	 * Sets ranking order of new Candidate based on score and further Candidates
	 * higher than new Candidate if needed
	 */
	void arrangeRankOrderTS(Candidate newCandidate) {
		Set<Candidate> set = candSet.tailSet(newCandidate);
		int rank = 0;
		Candidate cand1 = null;
		Candidate cand2 = null;
		Iterator<Candidate> iter = set.iterator();
		if (iter.hasNext())
			cand1 = iter.next();
		if (iter.hasNext()) {
			cand2 = iter.next();
			if (cand1.getScore() > cand2.getScore()) {
				rank = cand1.getRank();
				cand2.setRank(++rank);
				while (iter.hasNext()) {
					Candidate tmpCand = iter.next();
					tmpCand.setRank(tmpCand.getRank()+1);
				}
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

		private LeaderBoardTS getOuterType() {
			return LeaderBoardTS.this;
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
