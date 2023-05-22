package uz.pdp.giftcertificate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

import java.util.List;

@Entity(name = "tags")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TagEntity extends BaseEntity{

    @Column(nullable = false)
    private String name;

}
