open module com.example.audit {

    requires com.example.commons;

    exports com.example.audit;

    exports com.example.audit.logger.gateway to com.example.gateway;
    exports com.example.audit.logger.controller to com.example.web;

    requires java.base;
    requires static lombok;
    requires org.slf4j;
    requires spring.context;
    requires spring.aop;
    requires org.aspectj.weaver;


}