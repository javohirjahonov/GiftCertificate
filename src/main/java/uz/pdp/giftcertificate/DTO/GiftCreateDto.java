package uz.pdp.giftcertificate.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.giftcertificate.entity.TagEntity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GiftCreateDto {
    private String name;
    private String description;
    private double price;
    private int duration;
    private List<TagEntity> tags;
}
