package net.dreamlu.ext.render;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * JFinal-jade-extension
 * @author L.cm
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("rawtypes")
class JadeSession<K, V> extends HashMap<K, V> implements HttpSession {
	private static final long serialVersionUID = -719739616470614546L;
	
	private HttpSession session;

	public JadeSession(HttpSession session) {
		this.session = session;
	}

	public Object getAttribute(String key) {
		return session.getAttribute(key);
	}

	public Enumeration getAttributeNames() {
		return session.getAttributeNames();
	}

	public long getCreationTime() {
		return session.getCreationTime();
	}

	public String getId() {
		return session.getId();
	}

	public long getLastAccessedTime() {
		return session.getLastAccessedTime();
	}

	public int getMaxInactiveInterval() {
		return session.getMaxInactiveInterval();
	}

	public ServletContext getServletContext() {
		return session.getServletContext();
	}

	@Deprecated
	public javax.servlet.http.HttpSessionContext getSessionContext() {
		return session.getSessionContext();
	}

	@Deprecated
	public Object getValue(String key) {
		return session.getValue(key);
	}

	@Deprecated
	public String[] getValueNames() {
		return session.getValueNames();
	}

	public void invalidate() {
		session.invalidate();
	}

	public boolean isNew() {
		return session.isNew();
	}

	@Deprecated
	public void putValue(String key, Object value) {
		session.putValue(key, value);
	}

	public void removeAttribute(String key) {
		session.removeAttribute(key);
	}

	@Deprecated
	public void removeValue(String key) {
		session.removeValue(key);
	}

	public void setAttribute(String key, Object value) {
		session.setAttribute(key, value);
	}

	public void setMaxInactiveInterval(int maxInactiveInterval) {
		session.setMaxInactiveInterval(maxInactiveInterval);
	}
}