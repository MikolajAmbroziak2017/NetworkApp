import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.EnableAspectJAutoProxy;
        import org.springframework.context.annotation.PropertySource;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;
        import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
@PropertySource("classpath:2.properties")
@ComponentScan("app")
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
public class Config extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{Config.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
