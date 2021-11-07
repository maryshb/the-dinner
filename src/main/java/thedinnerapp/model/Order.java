package thedinnerapp.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name="torder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch=FetchType.EAGER)
    private User user;
    @ManyToOne(fetch=FetchType.EAGER)
    private Item item;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ORDERED,
        ACCEPTED,
        ENDED
    }
}
