package am.gitc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("documentarist")
public class NewDocurnentarist {
    private GrammyGuitarist guitarist;

    public void execute() {
        guitarist.sing("A song about love");
        guitarist.sing(new Guitar(){{setBrand("Gibson");}});
        guitarist.talk();
    }

    @Autowired
    @Qualifier("johnMayer")
    public void setGuitarist(GrammyGuitarist guitarist) {
        this.guitarist = guitarist;
    }
}
