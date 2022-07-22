open module com.example.gateway {

    exports com.example.gateway;

    requires com.example.audit;

    requires com.example.commons;
    requires spring.context;
}