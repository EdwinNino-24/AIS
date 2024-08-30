package model;

import java.util.Comparator;

public class CandidateComparator implements Comparator<Candidate> {
    @Override
    public int compare(Candidate c1, Candidate c2) {
        if (c1.getIcfesScore() != c2.getIcfesScore()) {
            return c2.getIcfesScore() - c1.getIcfesScore();
        } else if (c1.getMathScore() != c2.getMathScore()) {
            return c2.getMathScore() - c1.getMathScore();
        } else {
            return c2.getEnglishScore() - c1.getEnglishScore();
        }
    }
}
