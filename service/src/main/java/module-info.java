module com.example.service{

    exports com.example.service;

    requires static lombok;

    requires com.example.commons;
    requires org.slf4j;
    requires spring.context;
    requires spring.beans;

}