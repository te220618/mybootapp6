package jp.te4a.spring.boot.myapp9.mybootapp9;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public BookForm create(BookForm bookForm) {
        BookBean bookBean = new BookBean();
        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.save(bookBean);
        return bookForm;
    }

    public BookForm update(BookForm bookForm) {
        BookBean bookBean = new BookBean();
        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.save(bookBean);
        return bookForm;
    }

    //?
    public void delete(Integer id) {
        BookBean bookBean = bookRepository.findById(id).orElse(null);
        if (bookBean != null) {
            bookRepository.delete(bookBean);
        }
    }

    public List<BookForm> findAll() {
        List<BookBean> beanList = bookRepository.findAll();
        List<BookForm> formList = new ArrayList<BookForm>();
        for (BookBean bookBean : beanList) {
            BookForm bookForm = new BookForm();
            BeanUtils.copyProperties(bookBean, bookForm);
            formList.add(bookForm);
        }
        return formList;
    }

    //?
    public BookForm findOne(Integer id) {
        BookBean bookBean = bookRepository.findById(id).orElse(null);
        if (bookBean == null) {
            return null;
        }
        BookForm bookForm = new BookForm();
        BeanUtils.copyProperties(bookBean, bookForm);
        return bookForm;
    }
    
}