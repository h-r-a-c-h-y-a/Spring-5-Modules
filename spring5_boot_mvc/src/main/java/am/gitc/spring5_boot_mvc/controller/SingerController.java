package am.gitc.spring5_boot_mvc.controller;

import am.gitc.spring5_boot_mvc.entities.Singer;
import am.gitc.spring5_boot_mvc.service.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/singers")
public class SingerController {

    private final Logger logger = LoggerFactory.getLogger(SingerController.class);

    @Autowired
    private SingerService singerService;

    @GetMapping
    public String list(Model uiModel) {
        logger.info("Listing singers");
        var singers = singerService.findAll();
        uiModel.addAttribute("singers", singers);
        logger.info("No. of singers: " + singers.size());
        return "singers";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model uiModel) {
        var singer = singerService.findById(id);
        uiModel.addAttribute("singer", singer);
        return "show";
    }

    @GetMapping("/edit/{id}")
    public String updateForm(@PathVariable Long id, Model uiModel) {
        uiModel.addAttribute("singer", singerService.findById(id));
        return "update";
    }

    @GetMapping("/new")
    public String createForm(Model uiModel) {
        var singer = new Singer();
        uiModel.addAttribute("singer", singer);
        return "update";
    }

    @PostMapping
    public String saveSinger(@Valid Singer singer) {
        singer = singerService.save(singer);
        return "redirect:/singers/" + singer.getId();
    }
}
