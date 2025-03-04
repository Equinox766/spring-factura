package org.equinox.springfactura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Component
@RequestScope
@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {
    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String description;

    @Autowired
    @Qualifier("default")
    private List<Item> items;

    public Invoice(Client client, String description, List<Item> items) {
        this.client = client;
        this.description = description;
        this.items = items;
    }

    public Invoice() {
        System.out.println("Invoice created x2");
    }

    @PostConstruct
    public void init() {
        System.out.println("Invoice created");
        description = description.concat(" del cliente ").concat(client.getName()).concat(" ").concat(client.getLastName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Invoice destroyed");

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
/*        int total = 0;
        for (Item item : items) {
            total += item.getTotal();
        }
        return total;*/

        return items.stream().map(Item::getAmount).reduce(0, Integer::sum);
    }
}
