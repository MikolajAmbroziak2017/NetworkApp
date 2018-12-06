package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "postID",
        "id",
        "name",
        "email",
        "body"
})


public class Comment {

@JsonProperty("postID")
public String postID;

@JsonProperty("id")
public String id;

@JsonProperty("name")
public String name;

@JsonProperty("email")
public String email;

@JsonProperty("body")
public String body;

public String toString(){
    return "postID: "+postID+"\nid: "+id+"\nname: "+name+"\nemail"+email+"\nbody: "+body+"\n\n\n";
}
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }
}
