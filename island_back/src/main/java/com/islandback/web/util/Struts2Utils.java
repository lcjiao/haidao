package com.islandback.web.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;





/**
 * Struts2工�?�类.
 * 
 * �???��?��??Request/Response/Session�?�?�?jsp/freemaker??��?��????��????????�??????��??.
 * 
 * @author abba
 */
public class Struts2Utils {

	//-- header 常�??�?�? --//
	private static final String HEADER_ENCODING = "encoding";
	private static final String HEADER_NOCACHE = "no-cache";
	private static final String DEFAULT_ENCODING = "UTF-8";
	private static final boolean DEFAULT_NOCACHE = true;

	private static ObjectMapper mapper = new ObjectMapper();

	//-- ???�?Request/Response/Session???�??????��?? --//
	/**
	 * ???�?HttpSession???�??????��??.
	 */
	public static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	/**
	 * ???�?HttpSession???�??????��??.
	 */
	public static HttpSession getSession(boolean isNew) {
		return ServletActionContext.getRequest().getSession(isNew);
	}

	/**
	 * ???�?HttpSession�?Attribute???�??????��??.
	 */
	public static Object getSessionAttribute(String name) {
		HttpSession session = getSession(false);
		return (session != null ? session.getAttribute(name) : null);
	}

	/**
	 * ???�?HttpRequest???�??????��??.
	 */
	public static HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * ???�?HttpRequest�?Parameter???�??????��??.
	 */
	public static String getParameter(String name) {
		return getRequest().getParameter(name);
	}

	/**
	 * ???�?HttpRequest�?Parameter???�??????��??.
	 */
	public static <T> T getParameter(String name, Class<T> cls) {
		return (T) getRequest().getParameter(name);
	}

	/**
	 * ???�?HttpResponse???�??????��??.
	 */
	public static HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	//-- �?�?jsp/freemaker??��?��????��??????????��?? --//
	/**
	 * ??��?��????��??容�??�?便�?��??.

	 * eg.
	 * render("text/plain", "hello", "encoding:GBK");
	 * render("text/plain", "hello", "no-cache:false");
	 * render("text/plain", "hello", "encoding:GBK", "no-cache:false");
	 * 
	 * @param headers ?????????header??��??�?????????��???????�为"encoding:"???"no-cache:",�?认�?��?????�?UTF-8???true.
	 */
	public static void render(final String contentType, final String content, final String... headers) {
		HttpServletResponse response = initResponseHeader(contentType, headers);
		try {
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static <T> void renderXML(final T object, Class<T> cls, final String... headers) {
		HttpServletResponse response = initResponseHeader(ServletUtils.XML_TYPE, headers);
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(cls);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(object, response.getWriter());
			response.getWriter().flush();
		} catch (JAXBException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}

	/**
	 * ??��?��????��?????.
	 * @see #render(String, String, String...)
	 */
	public static void renderText(final String text, final String... headers) {
		render(ServletUtils.TEXT_TYPE, text, headers);
	}

	/**
	 * ??��?��?????HTML.
	 * @see #render(String, String, String...)
	 */
	public static void renderHtml(final String html, final String... headers) {
		render(ServletUtils.HTML_TYPE, html, headers);
	}

	/**
	 * ??��?��?????XML.
	 * @see #render(String, String, String...)
	 */
	public static void renderXml(final String xml, final String... headers) {
		render(ServletUtils.XML_TYPE, xml, headers);
	}

	/**
	 * ??��?��?????JSON.
	 * 
	 * @param jsonString json�?�?�?.
	 * @see #render(String, String, String...)
	 */
	public static void renderJson(final String jsonString, final String... headers) {
		render(ServletUtils.JSON_TYPE, jsonString, headers);
	}

	/**
	 * ??��?��?????JSON,使�??Jackson�????Java对象.
	 * 
	 * @param data ???以�??List<POJO>, POJO[], POJO, �????�?Map?????��??.
	 * @see #render(String, String, String...)
	 */
	public static void renderJson(final Object data, final String... headers) {
		HttpServletResponse response = initResponseHeader(ServletUtils.JSON_TYPE, headers);
		try {
			mapper.writeValue(response.getWriter(), data);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * ??��?��????��?????跨�??Mashup???JSONP.
	 * 
	 * @param callbackName callback??��?��??.
	 * @param object Java对象,???以�??List<POJO>, POJO[], POJO ,�????�?Map?????��??, �?�?�????�?json�?�?�?.
	 */
	public static void renderJsonp(final String callbackName, final Object object, final String... headers) {
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(object);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}

		String result = new StringBuilder().append(callbackName).append("(").append(jsonString).append(");").toString();

		//渲�??Content-Type�?javascript???�???????�?,�???��?????�?javascript�????, �?callback197("{html:'Hello World!!!'}");
		render(ServletUtils.JS_TYPE, result, headers);
	}

	/**
	 * ??????并�?�置contentType�?headers.
	 */
	private static HttpServletResponse initResponseHeader(final String contentType, final String... headers) {
		//??????headers??????
		String encoding = DEFAULT_ENCODING;
		boolean noCache = DEFAULT_NOCACHE;
		for (String header : headers) {
			String headerName = StringUtils.substringBefore(header, ":");
			String headerValue = StringUtils.substringAfter(header, ":");

			if (StringUtils.equalsIgnoreCase(headerName, HEADER_ENCODING)) {
				encoding = headerValue;
			} else if (StringUtils.equalsIgnoreCase(headerName, HEADER_NOCACHE)) {
				noCache = Boolean.parseBoolean(headerValue);
			} else {
				throw new IllegalArgumentException(headerName + "�????�?�????�????header类�??");
			}
		}

		HttpServletResponse response = ServletActionContext.getResponse();

		//设置headers??????
		String fullContentType = contentType + ";charset=" + encoding;
		response.setContentType(fullContentType);
		if (noCache) {
			ServletUtils.setNoCacheHeader(response);
		}
		return response;
	}

	public static boolean isValidateURL(String url) {
		return StringUtils.startsWithIgnoreCase(url, "http://");
	}

	public static String getRealIP() {
		String ip = Struts2Utils.getRequest().getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			//nginx proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
			ip = Struts2Utils.getRequest().getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = Struts2Utils.getRequest().getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = Struts2Utils.getRequest().getRemoteAddr();
		}
		return ip;
	}

	public static int getRealPort() {
		return 80;
	}


}
