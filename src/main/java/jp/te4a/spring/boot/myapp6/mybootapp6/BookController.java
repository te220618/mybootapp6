package jp.te4a.spring.boot.myapp6.mybootapp6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // インデックスページを表示する
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "this is setting message");
        return "index";
    }

    // フォーム送信後にデータを保存し、一覧を表示する
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ModelAndView postForm(@RequestParam("id") String id,
                                 @RequestParam("title") String title,
                                 @RequestParam("writter") String writter,
                                 @RequestParam("publisher") String publisher,
                                 @RequestParam("price") String price) {

        // 新しい本の情報を保存
        bookService.save(new BookBean(Integer.valueOf(id), title, writter, publisher, Integer.valueOf(price)));

        // 保存した本の情報をHTMLとして出力
        StringBuffer buff = new StringBuffer();
        buff.append("<hr>");
        for (BookBean bean : bookService.findAll()) {
            buff.append("ID: " + bean.getId() + "<br>");
            buff.append("タイトル: " + bean.getTitle() + "<br>");
            buff.append("著者: " + bean.getWritter() + "<br>");
            buff.append("出版社: " + bean.getPublisher() + "<br>");
            buff.append("価格: " + bean.getPrice() + "<br><hr>");
        }

        // 結果をページに表示
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("msg", buff.toString());
        return mv;
    }
}
