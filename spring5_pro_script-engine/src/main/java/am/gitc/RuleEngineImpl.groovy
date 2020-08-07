package am.gitc

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component("ruleEngine")
class RuleEngineImpl implements RuleEngine {

    Logger logger = LoggerFactory.getLogger(RuleEngineImpl.class);

    @Override
    void run(Rule rule, Object object) {
        logger.info "Executing rule"

        def exit = false

        rule.parameters.each {ArrayList params ->
            def paramIndex = 0
            def success = true
            if (!exit) {
                logger.info "Condition Param index: " + paramIndex
                success = success && it(object, paramsparamIndex)
                logger.info "Condition success: " + success
                paramIndex++
            }
            if (success && !exit) {
                rule.actions.each {
                    logger.info "Action Param index: "+ paramIndex
                    it(object,paramsparamIndex)
                    paramIndex++
                }
                if (rule.singleHit) {
                    exit = true
                }
            }
        }
    }
}