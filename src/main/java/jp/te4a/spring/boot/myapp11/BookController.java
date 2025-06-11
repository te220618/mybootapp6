package jp.te4a.spring.boot.myapp11;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @ModelAttribute
    public BookForm setUpForm() {
        return new BookForm();
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @PostMapping(path = "create")
    public String create(@Validated BookForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return list(model);
        }
        bookService.create(form);
        return "redirect:/books";
    }

    @PostMapping(path = "edit", params = "form")
    public String editForm(@RequestParam Integer id, BookForm form) {
        BookForm bookForm = bookService.findOne(id);
        BeanUtils.copyProperties(bookForm, form);
        return "books/edit";
    }

    @PostMapping(path = "edit")
    public String edit(@RequestParam Integer id, @Validated BookForm form, BindingResult result) {
        if (result.hasErrors()) {
            return editForm(id, form);
        }
        bookService.update(form);
        return "redirect:/books";
    }

    @PostMapping(path = "delete")
    public String delete(@RequestParam Integer id) {
        bookService.delete(id);
        return "redirect:/books";
    }

    @PostMapping(path = "edit", params = "goToTop")
    public String goToTop() {
        return "redirect:/books";
    }
}
