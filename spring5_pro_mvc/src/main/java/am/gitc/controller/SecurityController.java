package am.gitc.controller;

import am.gitc.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/security")
public class SecurityController {

    private static Logger logger = LoggerFactory.getLogger(SecurityController.class);

    private final MessageSource messageSource;

    public SecurityController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping("/loginfail")
    public String loginFail(Model uiModel, Locale locale) {
        logger.info("Login failed detected");
        uiModel.addAttribute("message", new Message("error", messageSource.getMessage("message_login_fail", new Object [] {}, locale)));
        return "singers/list";
    }
}
