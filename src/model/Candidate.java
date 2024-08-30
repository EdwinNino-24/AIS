package model;

public class Candidate {
    private String firstName;
    private String lastName;
    private String ethnicity;
    private String registrationDate;
    private int icfesScore;
    private int mathScore;
    private int englishScore;

    public Candidate(String firstName, String lastName, String ethnicity, String registrationDate, int icfesScore, int mathScore, int englishScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ethnicity = ethnicity;
        this.registrationDate = registrationDate;
        this.icfesScore = icfesScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public int getIcfesScore() {
        return icfesScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

}
