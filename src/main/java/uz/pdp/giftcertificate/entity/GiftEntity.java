package uz.pdp.giftcertificate.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity(name = "gifts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GiftEntity extends BaseEntity{
    private String name;
    private String description;
    private double price;
    private int duration;

    @ManyToMany(cascade = CascadeType.ALL)
    @Column(unique = true, nullable = false)
//    @JoinColumn(name = "tags_id", referencedColumnName = "id")
    private List<TagEntity> tags;
}
