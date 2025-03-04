package org.equinox.springfactura;

import org.equinox.springfactura.models.Item;
import org.equinox.springfactura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {
    @Bean
    List<Item> itemsInvoice() {
        return Arrays.asList(
                new Item(new Product("Camara Sony", 800), 3),
                new Item(new Product("Bicicleta Bianchi 26", 1200), 54),
                new Item(new Product("Licuadora Arno", 130), 6)
        );
    }

    @Bean("default")
    List<Item> itemsInvoiceOffice() {
        return Arrays.asList(
                new Item(new Product("Monitor Asus 24", 800), 3),
                new Item(new Product("Notebook razer ", 2400), 54),
                new Item(new Product("Impresora HP", 500), 52),
                new Item(new Product("Standisk desk", 180), 199)
        );
    }
}
