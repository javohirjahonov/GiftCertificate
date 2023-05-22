package uz.pdp.giftcertificate.repsitory.GiftRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.giftcertificate.entity.GiftEntity;
import uz.pdp.giftcertificate.entity.TagEntity;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface GiftRepository extends JpaRepository<GiftEntity, UUID> {
    List<GiftEntity> findGiftEntityByDescription(String description);
    List<GiftEntity> findGiftEntityByTagsIn(List<TagEntity> tags);
    List<GiftEntity> findGiftEntityByName(String name);
    void findGiftEntityByPrice(double price);
}
