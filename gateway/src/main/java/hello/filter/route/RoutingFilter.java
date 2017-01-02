package hello.filter.route;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * {@link ZuulFilter} for routing.
 *
 * @author Johnny Lim
 */
public class RoutingFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "route";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		String target = request.getParameter("target");
		if (StringUtils.hasText(target)) {
			try {
				currentContext.setRouteHost(new URL("http://" + target));
			}
			catch (MalformedURLException ex) {
				throw new RuntimeException(ex);
			}
		}
		return null;
	}

}
