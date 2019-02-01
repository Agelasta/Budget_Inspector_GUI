public class JarModel {

     /*BigDecimal wasn't used here, because it doesn't seem to be necessary in case of
     rough calculations for personal use only. Even rounding offered by program generates
     much bigger discrepancies than poor precision of double calculations.*/

    private double necessities;
    private double financial;
    private double longTerm;
    private double education;
    private double play;
    private double give;

    private final double NECESSITIES_RATE = 0.55;
    private final double FINANCIAL_RATE = 0.1;
    private final double LONG_TERM_RATE = 0.1;
    private final double EDUCATION_RATE = 0.1;
    private final double PLAY_RATE = 0.1;
    private final double GIVE_RATE = 0.05;

    public double getNecessities() {
        return necessities;
    }

    public double getFinancial() {
        return financial;
    }

    public double getLongTerm() {
        return longTerm;
    }

    public double getEducation() {
        return education;
    }

    public double getPlay() {
        return play;
    }

    public double getGive() {
        return give;
    }


    public void setNecessities(double salary) {
        necessities = salary * NECESSITIES_RATE;
    }

    public void setFinancial(double salary) {
        financial = salary * FINANCIAL_RATE;
    }

    public void setLongTerm(double salary) {
        longTerm = salary * LONG_TERM_RATE;
    }

    public void setEducation(double salary) {
        education = salary * EDUCATION_RATE;
    }

    public void setPlay(double salary) {
        play = salary * PLAY_RATE;
    }

    public void setGive(double salary) {
        give = salary * GIVE_RATE;
    }


    public void setCustomNecessities(double salary, double necessitiesCustomRate) {
        necessities = salary *
                necessitiesCustomRate;
    }

    public void setCustomFinancial(double salary, double financialCustomRate) {
        financial = salary * financialCustomRate;
    }

    public void setCustomLongTerm(double salary, double longTermCustomRate) {
        longTerm = salary * longTermCustomRate;
    }

    public void setCustomEducation(double salary, double educationCustomRate) {
        education = salary * educationCustomRate;
    }

    public void setCustomPlay(double salary, double playCustomRate) {
        play = salary * playCustomRate;
    }

    public void setCustomGive(double salary, double giveCustomRate) {
        give = salary * giveCustomRate;
    }


    public double roundNecessities(double necessities) {
        return Math.round(necessities);
    }

    public double roundFinancial(double financial) {
        return Math.round(financial);
    }

    public double roundLongTerm(double longTerm) {
        return Math.round(longTerm);
    }

    public double roundEducation(double education) {
        return Math.round(education);
    }

    public double roundPlay(double play) {
        return Math.round(play);
    }

    public double roundGive(double give) {
        return Math.round(give);
    }

}
