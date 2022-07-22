module com.example.audit {

    exports com.example.audit;
    exports com.example.audit.logger.impl;


    requires java.base;
    requires static lombok;
    requires org.slf4j;
    requires spring.context;
    requires spring.aop;
    requires org.aspectj.weaver;
}