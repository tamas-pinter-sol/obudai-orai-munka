package hu.sol.kvki.book.vaadin.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class BookUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		this.setContent(new Label("hello KVKI!"));
	}

}
