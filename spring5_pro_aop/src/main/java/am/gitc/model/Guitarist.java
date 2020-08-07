package am.gitc.model;

import am.gitc.annotations.AdviceRequired;

public class Guitarist implements Singer {
    private String lyric="You're gonna live forever in me";

    @Override
    public void sing(String title) {
        System.out.println(lyric);
    }

    @AdviceRequired
    public void sing(Guitar guitar) {
        System.out.println(guitar.play());
    }


    public void rest() {
        System.out.println("zzz");
    }
}
