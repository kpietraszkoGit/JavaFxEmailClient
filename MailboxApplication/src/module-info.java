/**
 * Created by DELL on 2020-05-30.
 */
module FirstJavaFx {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires activation;
    requires java.mail;
    requires java.desktop;

    opens com.barosanu;
    opens com.barosanu.view;
    opens com.barosanu.controller;
    opens com.barosanu.model;
}