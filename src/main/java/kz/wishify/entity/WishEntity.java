package kz.wishify.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
@Table(name = "wish")
public class WishEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String userName;
}
