package am.gitc.model;

public class GreatGuitarist implements Singer {

    @Override
    public void sing(String title) {
        System.out.println("I shot the sheriff, \n"
                + "But I did not shoot the deputy");
    }
}
