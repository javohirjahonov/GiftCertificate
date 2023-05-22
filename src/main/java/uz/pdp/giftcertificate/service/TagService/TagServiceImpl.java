package uz.pdp.giftcertificate.service.TagService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.giftcertificate.DTO.TagsCreateDto;
import uz.pdp.giftcertificate.entity.GiftEntity;
import uz.pdp.giftcertificate.entity.TagEntity;
import uz.pdp.giftcertificate.repsitory.TagRepository.TagRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService{

    private final TagRepository tagRepository;
    private final ModelMapper modelMapper;

    @Override
    public TagEntity add(TagsCreateDto tagsCreateDto) {
        TagEntity tagEntity = modelMapper.map(tagsCreateDto, TagEntity.class);
        return tagRepository.save(tagEntity);
    }

    @Override
    public void deleteById(UUID id) {
        tagRepository.deleteById(id);
    }

    @Override
    public TagEntity update(TagsCreateDto tagsCreateDto, UUID id) {
        TagEntity tagEntity = modelMapper.map(tagsCreateDto, TagEntity.class);
        tagEntity.setId(id);
        tagRepository.save(tagEntity);
        return tagEntity;
    }

    @Override
    public List<TagEntity> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public List<TagEntity> getAllByName(String name) {
        return tagRepository.searchTagEntityByName(name);
    }

    @Override
    public List<TagEntity> getAllByDescription(String description) {
        return null;
    }
}
