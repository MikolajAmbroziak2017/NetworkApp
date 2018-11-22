package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.omg.CORBA.TRANSACTION_UNAVAILABLE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.awt.*;

@Route("hello")
public class HelloGui extends VerticalLayout {
    @Autowired
    Service service;
    RestTemplate restTemplate=new RestTemplate();


    Button button1=new Button("Click me");
    Button button2=new Button("Click me");


    HorizontalLayout horizontalLayout=new HorizontalLayout();
    VerticalLayout verticalLayout=new VerticalLayout();
    TextField textField1=new TextField();
    TextField textfield2 = new TextField();

//    Label label=new Label();
    Label label= new Label();
    public HelloGui(){

        add(textfield2);
        button1.addClickListener(event -> label.setText("hello "+textField1.getValue()));
        horizontalLayout.add(textField1,button1);
        add(horizontalLayout,label);

    }

    public void send(String mess){

            restTemplate.exchange(
                    "http://localhost:8080/sendMessage",
                    HttpMethod.POST,
                    HttpEntity.EMPTY,
                    String.class,
                    mess);
    }
}
