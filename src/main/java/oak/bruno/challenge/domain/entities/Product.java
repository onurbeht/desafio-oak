package oak.bruno.challenge.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "product")
@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String info;
    private Integer price_in_cents;
    private Boolean available;

    public Product (String name, String info, Integer price_in_cents, Boolean available) {
        this.name = name;
        this.info = info;
        this.price_in_cents = price_in_cents;
        this.available = available;
    }

}
