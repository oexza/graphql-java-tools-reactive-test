//package com.accessbankplc.harmony.config;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ThymeleafConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
//
//    @Autowired
//    private MessageSource messageSource;
//
//    @Value("${thymeleaf.templates.cache}")
//    String thymeleafCache;
//
//    private ApplicationContext applicationContext;
//
//    public void setApplicationContext(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
//
//    @Bean
//    public ITemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(applicationContext);
//        templateResolver.setPrefix("classpath:/templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML");
//        templateResolver.setCharacterEncoding("UTF-8");
//
//        if (thymeleafCache.equals("true")){
//            templateResolver.setCacheable(true);
//        } else {
//            templateResolver.setCacheable(false);
//        }
//
//        return templateResolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//
//        templateEngine.setEnableSpringELCompiler(true);
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setMessageSource(messageSource);
//        templateEngine.addDialect(new SpringDataDialect());
//
//        return templateEngine;
//    }
//
//    @Bean
//    public ViewResolver viewResolver() {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine());
//        return viewResolver;
//    }
//}