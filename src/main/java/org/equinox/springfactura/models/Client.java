package org.equinox.springfactura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@JsonIgnoreProperties({"targetSource", "advisors"})
public class Client {
    @Value("${client.name}")
    private String name;

    @Value("${client.lastname}")
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public Client(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Client() {
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
