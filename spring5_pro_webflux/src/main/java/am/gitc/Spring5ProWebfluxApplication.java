package am.gitc;

import am.gitc.web.SingerHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ServletHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


import java.io.IOException;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@SpringBootApplication
public class Spring5ProWebfluxApplication {

//    private static Logger logger = LoggerFactory.getLogger(Spring5ProWebfluxApplication.class);
//
//    @Autowired
//    SingerHandler singerHandler;
//
//    private RouterFunction<ServerResponse> routingFunc() {
//        return route(GET("/test"), serverRequest -> ok()
//        .body(fromObject("works!")))
//                .andRoute(GET("/singers"), singerHandler.list)
//                .andRoute(GET("/singers/{id}"), singerHandler::show)
//                .andRoute(POST("/singers"), singerHandler.save)
//                .filter((request, next) -> {
//                    logger.info("Before handler invocation: " + request.path());
//                    return next.handle(request);
//                });
//    }
//
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        HttpHandler httpHandler = RouterFunctions.toHttpHandler(routingFunc());
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new ServletHttpHandlerAdapter(httpHandler), "/");
//        registrationBean.setLoadOnStartup(1);
//        registrationBean.setAsyncSupported(true);
//        return registrationBean;
//    }
//
//    public static void main(String[] args) throws IOException {
//        ConfigurableApplicationContext ctx = SpringApplication.run(Spring5ProWebfluxApplication.class, args);
//        assert (ctx != null);
//
//        System.in.read();
//
//        ctx.close();
//    }

}
