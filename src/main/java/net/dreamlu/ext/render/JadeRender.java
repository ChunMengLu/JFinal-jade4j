package net.dreamlu.ext.render;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.jfinal.core.JFinal;
import com.jfinal.render.Render;
import com.jfinal.render.RenderException;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.JadeTemplate;

/**
 * JFinal-jade-extension
 * @author L.cm
 */
public class JadeRender extends Render {
	
	private transient static final String encoding = getEncoding();
	private transient static final String contentType = "text/html; charset=" + encoding;
	JadeConfiguration config = null;

	public JadeRender(JadeConfiguration config, String view) {
		this.config = config;
		this.view = view;
	}
	
	@SuppressWarnings("unchecked")
	public void render() {
		response.setContentType(contentType);
		Map<String, Object> model = new HashMap<String, Object>();
		// request paras
		Enumeration<String> paras = request.getParameterNames();
		while (paras.hasMoreElements()) {
			String parasName = paras.nextElement();
			model.put(parasName, request.getParameter(parasName));
		}
		// request attrs
		Enumeration<String> attrs = request.getAttributeNames();
		while (attrs.hasMoreElements()) {
			String attrName = attrs.nextElement();
			model.put(attrName, request.getAttribute(attrName));
		}
		// session attrs
		HttpSession httpSession = request.getSession(false);
		if (null != httpSession) {
			Map<String, Object> session = new JadeSession<String, Object>(httpSession);
			for (Enumeration<String> names = httpSession.getAttributeNames(); names.hasMoreElements();) {
				String name = names.nextElement();
				session.put(name, httpSession.getAttribute(name));
			}
			model.put("session", session);
		}
		model.put("ctxPath", JFinal.me().getContextPath());
		// request and response
		model.put("request", request);
		model.put("response", response);
		// render model
		PrintWriter writer = null;
		try {
			JadeTemplate template = config.getTemplate(view);
			writer = response.getWriter();
			config.renderTemplate(template, model, writer);
		} catch (Exception e) {
			throw new RenderException(e);
		}
		finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
