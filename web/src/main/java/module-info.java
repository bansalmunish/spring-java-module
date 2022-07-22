module com.example.web{
    exports com.example.controller;

    requires com.example.commons;
    requires com.example.service;
    requires com.example.util;
    requires com.example.audit;

    requires static lombok;

    requires spring.web;
    requires spring.boot;
    requires spring.context;
    requires spring.boot.autoconfigure;


}