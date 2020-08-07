package am.gitc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngineManager;

public class ListScriptEngines {

    private static Logger logger = LoggerFactory.getLogger(ListScriptEngines.class);

    public static void main(String[] args) {
        var mgr = new ScriptEngineManager();
        mgr.getEngineFactories().forEach(factory -> {
            var engineName = factory.getEngineName();
            var languageName = factory.getLanguageName();
            var version = factory.getLanguageVersion();
            logger.info("\nEngine name: " + engineName
                    + "\n Language: " + languageName
                    + "\n Version: " + version);
        });
    }
}
