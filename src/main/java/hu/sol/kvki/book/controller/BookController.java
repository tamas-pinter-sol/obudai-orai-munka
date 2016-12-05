package hu.sol.kvki.book.controller;

import hu.sol.kvki.book.bean.Book;
import hu.sol.kvki.book.service.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/book_list")
	public String listBooks(Model model) {
		model.addAttribute("books", bookService.listBooks());
		return "book_list";
	}

	@RequestMapping("/book_details")
	public String detailsBook(Integer bookId, Model model) {
		Book book = bookService.getBookById(bookId);
		model.addAttribute("book", book);
		return "book_details";
	}
	
	@RequestMapping(path="/book_edit", method=RequestMethod.GET)
	public String editBookGet(@RequestParam(required=false) Integer bookId, Model model){
		Book book;
		if(bookId == null){
			book = new Book();
		}else{
			book = bookService.getBookById(bookId);
		}
		model.addAttribute("book", book);
		return "book_edit";
	}
	
	@RequestMapping(path="/book_edit", method=RequestMethod.POST)
	public String editBookPost(@ModelAttribute Book book){
		if(book.getId() == null){
			bookService.addBook(book);
		}else{
			bookService.updateBook(book);
		}
		return "redirect:bookList";
	}
	

}
