package hu.sol.kvki.book.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ReqEncodingListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {

	}

	public void requestInitialized(ServletRequestEvent sre) {
		try {
			sre.getServletRequest().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}
