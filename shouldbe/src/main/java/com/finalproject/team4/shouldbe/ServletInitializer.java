package com.finalproject.team4.shouldbe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.descriptor.JspPropertyGroupDescriptor;
import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.JspPropertyGroup;
import org.apache.tomcat.util.descriptor.web.JspPropertyGroupDescriptorImpl;
import org.apache.tomcat.util.descriptor.web.JspConfigDescriptorImpl;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;


@Component
@Configuration
public class ServletInitializer extends SpringBootServletInitializer {

    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                super.postProcessContext(context);

                JspPropertyGroup jspPropertyGroup = new JspPropertyGroup();
                jspPropertyGroup.addUrlPattern("*.jsp");
                jspPropertyGroup.addUrlPattern("*.jspf");
                jspPropertyGroup.setPageEncoding("UTF-8");
                jspPropertyGroup.setScriptingInvalid("true");
                jspPropertyGroup.addIncludePrelude("/WEB-INF/resources/header.jspf");
                jspPropertyGroup.addIncludeCoda("/WEB-INF/resources/footer.jspf");
                jspPropertyGroup.setTrimWhitespace("true");
                jspPropertyGroup.setDefaultContentType("text/html; charset=UTF-8");
                JspPropertyGroupDescriptorImpl jspPropertyGroupDescriptor = new JspPropertyGroupDescriptorImpl(jspPropertyGroup);
                List<JspPropertyGroupDescriptor> jspPropertyGroupDescriptors = new ArrayList<>();
                jspPropertyGroupDescriptors.add(jspPropertyGroupDescriptor);

                JspConfigDescriptorImpl jspConfigDescriptor = new JspConfigDescriptorImpl(jspPropertyGroupDescriptors, Collections.emptyList());
                context.setJspConfigDescriptor(jspConfigDescriptor);
            }
        };
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ShouldbeApplication.class); // Replace ShouldbeApplication.class with your main application class
    }
}
