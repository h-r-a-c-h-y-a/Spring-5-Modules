package javay.main.model.generating_pattern.abstract_factory;

public class ICICIBank implements Bank{
    @Override
    public void bankName() {
        System.out.println("ICICI Bank Ltd.");
    }
}
