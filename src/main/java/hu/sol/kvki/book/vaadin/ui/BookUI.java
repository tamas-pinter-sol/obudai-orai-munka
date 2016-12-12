package hu.sol.kvki.book.vaadin.ui;

import hu.sol.kvki.book.bean.Book;
import hu.sol.kvki.book.dao.BookDao;
import hu.sol.kvki.book.dao.BookDaoImpl;
import hu.sol.kvki.book.service.BookService;
import hu.sol.kvki.book.service.ServiceUtil;

import java.util.Set;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.NullValidator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class BookUI extends UI {

	private BookService bookService;
	private BeanContainer<Long, Book> newDataSource;
	private Window editwindow;
	private Table bookTable;

	@Override
	protected void init(VaadinRequest request) {
		bookService = ServiceUtil.getBookService();
		this.setContent(createBookTableLayout());
	}

	private Component createBookTableLayout() {
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setMargin(true);
		verticalLayout.setSpacing(true);
		verticalLayout.setSizeFull();
		verticalLayout.addComponent(createBookTable());
		verticalLayout.addComponent(createFunctionButtons());
		return verticalLayout;
	}

	private Component createFunctionButtons() {
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setWidth("100%");
		Button newBookButton = new Button("Új könyv");
		newBookButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				createWindow(new Book(), "Könyv felvilel");
			}

		});
		horizontalLayout.addComponent(newBookButton);
		Button deleteSelectedButton = new Button("Kijelöltek törlése");
		deleteSelectedButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Set<Integer> selectedValues = (Set<Integer>) bookTable.getValue();
				for (Integer b : selectedValues) {
					Book book = ((BeanItem<Book>) bookTable
							.getContainerDataSource().getItem(b)).getBean();
					bookService.deleteBook(book);
				}
				refreshTable();
			}
		});
		horizontalLayout.addComponent(deleteSelectedButton);
		return horizontalLayout;
	}

	private void createWindow(Book book, String string) {
		editwindow = new Window(string);
		editwindow.setWidth("90%");
		editwindow.setHeight("90%");
		editwindow.center();
		editwindow.setContent(createBookEditLayout(book));
		UI.getCurrent().addWindow(editwindow);
	}

	private Component createBookEditLayout(Book book) {
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setSizeFull();
		verticalLayout.setMargin(true);
		FormLayout formLayout = new FormLayout();
		final BeanFieldGroup<Book> binder = new BeanFieldGroup<Book>(Book.class);
		binder.setItemDataSource(book);
		TextField title = binder.buildAndBind("Cím", "name", TextField.class);
		title.setNullRepresentation("");
		title.addValidator(new NullValidator("Kötelezõ kitöltése", false));
		formLayout.addComponent(title);
		TextField desc = binder.buildAndBind("Leírás", "description",
				TextField.class);
		desc.setNullRepresentation("");
		desc.addValidator(new NullValidator("Kötelezõ kitöltése", false));
		formLayout.addComponent(desc);

		TextField author = binder.buildAndBind("Szerzõ", "author",
				TextField.class);
		author.setNullRepresentation("");
		author.addValidator(new NullValidator("Kötelezõ kitöltése", false));
		formLayout.addComponent(author);

		Field<?> pubYear = binder.buildAndBind("Publikálás", "pubYear");
		pubYear.addValidator(new NullValidator("Kötelezõ kitöltése", false));
		formLayout.addComponent(pubYear);
		verticalLayout.addComponent(formLayout);
		Button button = new Button("Mentés");
		button.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					binder.commit();
					Book bean = binder.getItemDataSource().getBean();
					if (bean.getId() != null) {
						bookService.updateBook(bean);
					} else {
						bookService.addBook(bean);
					}
					editwindow.close();
					refreshTable();
				} catch (CommitException e) {
					Notification.show("Hibás adatok kérem ellenõrizze!");
				}

			}

		});
		verticalLayout.addComponent(button);
		return verticalLayout;
	}

	private void refreshTable() {
		newDataSource.removeAllItems();
		newDataSource.addAll(bookService.listBooks());
	}

	private Component createBookTable() {
		bookTable = new Table("Könyvek listája");
		bookTable.setSelectable(true);
		bookTable.setMultiSelect(true);
		bookTable.setSizeFull();
		newDataSource = new BeanContainer<Long, Book>(Book.class);
		newDataSource.setBeanIdProperty("id");
		newDataSource.addAll(bookService.listBooks());
		bookTable.setContainerDataSource(newDataSource);
		bookTable
				.setVisibleColumns("name", "description", "author", "pubYear");
		bookTable.setColumnHeader("name", "Cím");
		bookTable.setColumnHeader("description", "Leírás");
		bookTable.setColumnHeader("author", "Szerzõ");
		bookTable.setColumnHeader("pubYear", "Publikálás");
		bookTable.addGeneratedColumn("editBook", new ColumnGenerator() {

			@Override
			public Object generateCell(final Table source, final Object itemId,
					Object columnId) {

				Button button = new Button("Szerkesztés");
				button.addClickListener(new ClickListener() {

					@Override
					public void buttonClick(ClickEvent event) {
						BeanItem<Book> item = ((BeanItem) source
								.getItem(itemId));
						createWindow(item.getBean(), "Könyv szerkesztése");

					}
				});
				return button;
			}
		});
		return bookTable;
	}
}
