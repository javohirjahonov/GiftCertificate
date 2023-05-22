package uz.pdp.giftcertificate.repsitory.TagRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.giftcertificate.entity.GiftEntity;
import uz.pdp.giftcertificate.entity.TagEntity;

import java.util.List;
import java.util.UUID;

public interface TagRepository extends JpaRepository<TagEntity, UUID> {
//    List<TagEntity> findTagEntitiesByName(String name);

    TagEntity findByName(String name);

    List<TagEntity> searchTagEntityByName(String tagName);
}
