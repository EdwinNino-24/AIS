package model;

import java.util.ArrayList;
import java.util.List;

public class InformationSystem {
    private final List<Candidate> candidates;

    public InformationSystem() {
        candidates = new ArrayList<>();
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

}
