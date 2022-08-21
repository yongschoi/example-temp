package yongs.temp.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import yongs.temp.inf.UserService;

@RequiredArgsConstructor
@Configuration
public class CxfServerConfig {
	private final Bus bus;
	private final UserService userService;

	/*
	 * 서버는 cxfServlet을 정의한다. 서버는 웹 서비스의 urlMapping을 지정하기 위해 cxfServlet을 정의해야 하며, 
	 * 이는 Bean을 구성하거나 어플리케이션에서 직접 구현할 수 있다.
	 * 
	 * /ws/ 는 서버 경로의 ws에 해당, http://localhost:8080/ws/user?wsdl 으로 접근한다.
	 */
	@Bean
	public ServletRegistrationBean cxfServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/ws/*");
	}

	/*
	 * 서버는 endPoint를 구성하여 서비스를 게시할 수 있다. 이때 서비스는 wsdl에 해당된다.
	 */
	@Bean
	public Endpoint userEndpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, userService);
		endpoint.publish("/user");
		return endpoint;
	}
}
