package web.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;    // Добавил я отсюда: https://github.com/NeilAlishev/SpringCourse/blob/master/Lesson23.CRUD_App3/src/main/java/ru/alishev/springcourse/config/MySpringMvcDispatcherSerlvetIntitializer.java
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;    // Добавил я отсюда: https://github.com/NeilAlishev/SpringCourse/blob/master/Lesson23.CRUD_App3/src/main/java/ru/alishev/springcourse/config/MySpringMvcDispatcherSerlvetIntitializer.java
import javax.servlet.ServletException;    // Добавил я отсюда: https://github.com/NeilAlishev/SpringCourse/blob/master/Lesson23.CRUD_App3/src/main/java/ru/alishev/springcourse/config/MySpringMvcDispatcherSerlvetIntitializer.java


// Этот класс вместо web.xml
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Метод, указывающий на класс конфигурации
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }


    /* Данный метод указывает url, на котором будет базироваться приложение */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    // Добавил я отсюда: https://github.com/NeilAlishev/SpringCourse/blob/master/Lesson23.CRUD_App3/src/main/java/ru/alishev/springcourse/config/MySpringMvcDispatcherSerlvetIntitializer.java
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*"); // Добавляем фильтр для работы со скрытым полем
    }
}