open module com.example.commons{

    exports com.example.commons;
    exports com.example.commons.error;

    exports com.example.commons.web to com.example.web;

    requires static lombok;
    requires com.fasterxml.jackson.annotation;

    requires spring.web;



}