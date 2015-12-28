package net.dreamlu.ext.render;

import com.jfinal.core.JFinal;
import com.jfinal.kit.PathKit;
import com.jfinal.render.IMainRenderFactory;
import com.jfinal.render.Render;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.FileTemplateLoader;
import de.neuland.jade4j.template.TemplateLoader;

/**
 * JFinal-jade-extension
 * 
 * @author L.cm
 */
public class JadeRenderFactory implements IMainRenderFactory {

	private static String encoding = "UTF-8";
	public static String viewExtension = ".jade";
	public static JadeConfiguration config = null;
	
	public JadeRenderFactory() {
		init(PathKit.getWebRootPath());
	}

	private void init(String root) {
		if (config == null) {
			config = new JadeConfiguration();
		}

		TemplateLoader loader = new FileTemplateLoader(root, encoding);
		config.setTemplateLoader(loader);
		config.setPrettyPrint(true);
		boolean devMode = JFinal.me().getConstants().getDevMode();
		config.setCaching(!devMode);
	}

	public Render getRender(String view) {
		return new JadeRender(config, view);
	}

	public String getViewExtension() {
		return viewExtension;
	}
}