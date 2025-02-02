package kz.sheeshwish;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "wish")
public class WishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String userEmail;
}
