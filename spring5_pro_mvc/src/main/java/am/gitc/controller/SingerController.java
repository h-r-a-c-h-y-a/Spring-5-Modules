package am.gitc.controller;

import am.gitc.util.Message;
import am.gitc.entities.Singer;
import am.gitc.service.SingerService;
import am.gitc.util.SingerGrid;
import am.gitc.util.UrlUtil;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/singers")
public class SingerController {

    private final Logger logger = LoggerFactory.getLogger(SingerController.class);

    public SingerController(SingerService singerService, MessageSource messageSource) {
        this.singerService = singerService;
        this.messageSource = messageSource;
    }

    private SingerService singerService;
    private MessageSource messageSource;

    @GetMapping
    public String list(Model uiModel) {
        logger.info("Listing singers");
        List<Singer> singers = singerService.findAll();
        uiModel.addAttribute("singers", singers);
        logger.info("No. of singers: " + singers.size());
        return "singers/list";
    }


    @ResponseBody
    @GetMapping(value = "/listgrid", produces = "application/json")
    public SingerGrid listGrid(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "rows", required = false) Integer rows,
            @RequestParam(value = "sidx", required = false) String sortBy,
            @RequestParam(value = "sord", required = false) String order
    ) {
        logger.info("Listing singers for grid with page: {}, rows: {}", page, rows);
        logger.info("Listing singers for grid with sort: {}, rows: {}", sortBy, order);
        Sort sort = null;
        String orderBy = sortBy;
        PageRequest pageRequest = null;
        if (orderBy != null && orderBy.equals("birthDateString"))
            orderBy = "birthDate";
        if (orderBy != null && order != null) {
            if (order.equals("desc")) {
                sort = Sort.by(Sort.Direction.DESC, orderBy);
            } else sort = Sort.by(Sort.Direction.ASC, orderBy);
        }
        if (sort != null)  pageRequest = PageRequest.of(page - 1, rows);
        else  pageRequest = PageRequest.of(page - 1, rows);
        Page<Singer> singerPage = singerService.findAllByPage(pageRequest);
        SingerGrid singerGrid = new SingerGrid();
        singerGrid.setTotalRecords(singerPage.getTotalPages());
        singerGrid.setCurrentPage(singerPage.getNumber() + 1);
        singerGrid.setTotalPages(singerPage.getTotalPages());
        singerGrid.setSingerData(Lists.newArrayList(singerPage.iterator()));
        return singerGrid;
    }


    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model uiModel) {
        var singer = singerService.findById(id);
        uiModel.addAttribute("singer", singer);
        return "singers/show";
    }

    @PostMapping(value = "/{id}", params = "form")
    public String update(@Valid Singer singer, BindingResult bindingResult,
                         Model uiModel, HttpServletRequest request,
                         RedirectAttributes redirectAttributes, Locale locale,
                         @RequestParam(value = "file", required = false) Part file) {
        logger.info("Updating singer");
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("message", new Message("error", messageSource.getMessage("singer_save_fail", new Object[]{}, locale)));
            uiModel.addAttribute("singer", singer);
            return "singers/update";
        }
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success", messageSource.getMessage(
                "singer_save_success", new Object[]{}, locale
        )));
        singer.setId(Long.parseLong(request.getParameter("id")));
        singer = singerService.save(singer, file);
        return "redirect:/singers/" + UrlUtil.encodeUrlPathSegment(singer.getId().toString(), request);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/{id}", params = "form")
    public String updateForm(@PathVariable Long id, Model uiModel) {
        uiModel.addAttribute("singer", singerService.findById(id));
        return "singers/update";
    }

    @PostMapping
    public String create(@Valid Singer singer, BindingResult bindingResult,
                         Model uiModel, HttpServletRequest request,
                         RedirectAttributes redirectAttributes, Locale locale,
                         @RequestParam(value = "file", required = false) Part file) {
        logger.info("Creating Singer");
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("message", new Message("error", messageSource.getMessage("singer_save_fail", new Object[]{}, locale)));
            uiModel.addAttribute("singer", singer);
            return "singers/create";
        }
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success", messageSource.getMessage(
                "singer_save_success", new Object[]{}, locale
        )));

        logger.info("Singer id: " + singer.getId());
        singerService.save(singer, file);
        return "redirect:/singers/";
    }

    @PreAuthorize("hasRole('USER_ROLE')")
    @GetMapping(params = "form")
    public String createForm(Model uiModel) {
        var singer = new Singer();
        uiModel.addAttribute("singer", singer);
        return "singers/create";
    }

    @ResponseBody
    @GetMapping("/photo/{id}")
    public byte[] downloadPhoto(@PathVariable Long id) {
        Singer singer = singerService.findById(id);
        if (singer.getPhoto() != null) {
            logger.info("Downloading photo for id: {} with"
                    + "size: {}", singer.getId(), singer.getPhoto() .length);
        }
        return singer.getPhoto();
    }
}
