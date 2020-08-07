package am.gitc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.Bindings;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JavaScriptTest {

    private static Logger logger = LoggerFactory.getLogger(JavaScriptTest.class);

    public static void main(String[] args) {
        var mgr = new ScriptEngineManager();
        var jsEngine = mgr.getEngineByName("nashorn");
        try {
//            jsEngine.eval("print('Hello JavaScript in Java!')");
            jsEngine.eval(new FileReader("src/main/resources/static/js/hello.js"));
        } catch (ScriptException e) {
            logger.error("JavaScript expression cannot "
                    + "Ье evaluated 1 ", e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
