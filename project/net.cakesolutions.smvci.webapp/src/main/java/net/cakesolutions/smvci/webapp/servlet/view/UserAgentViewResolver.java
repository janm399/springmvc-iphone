package net.cakesolutions.smvci.webapp.servlet.view;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.PatternMatchUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class UserAgentViewResolver implements ViewResolver {
	private Map<String, ViewResolver> viewResolvers;
	private ViewResolver defaultViewResolver;

	public View resolveViewName(String viewName, Locale locale) throws Exception {
		ServletRequestAttributes servletAttrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		HttpServletRequest request = servletAttrs.getRequest();
		String userAgent = request.getHeader("User-Agent");
		View resolvedView;
		for (Map.Entry<String, ViewResolver> e : this.viewResolvers.entrySet()) {
			if (PatternMatchUtils.simpleMatch(e.getKey(), userAgent)) {
				resolvedView = e.getValue().resolveViewName(viewName, locale);
				if (resolvedView != null) return resolvedView;
			}
		}

		return this.defaultViewResolver.resolveViewName(viewName, locale);
	}

	public void setViewResolvers(Map<String, ViewResolver> viewResolvers) {
		this.viewResolvers = viewResolvers;
	}

	public void setDefaultViewResolver(ViewResolver defaultViewResolver) {
		this.defaultViewResolver = defaultViewResolver;
	}

}
