open module com.example.util{

    exports com.example.util;

    requires com.example.commons;
    requires java.annotation;
    requires static lombok;
    requires org.slf4j;

    requires spring.core;
    requires spring.context;

}