package net.ausiasmarch.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import net.ausiasmarch.domain.Image;
import net.ausiasmarch.domain.Like;
import net.ausiasmarch.domain.mapper.ImageMapper;
import net.ausiasmarch.repository.LikeRepository;
import net.ausiasmarch.service.dto.ImageDTO;
import net.ausiasmarch.repository.ImageRepository;
import net.ausiasmarch.service.ImageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;
    private final LikeRepository likeRepository;

    public ImageServiceImpl(ImageRepository imageRepository, ImageMapper imageMapper, LikeRepository likeRepository) {
        this.imageRepository = imageRepository;
        this.imageMapper = imageMapper;
        this.likeRepository = likeRepository;
    }

    @Override
    public ImageDTO save(ImageDTO imageDTO) {
        Image image = imageMapper.toEntity(imageDTO);
        image = imageRepository.save(image);
        return imageMapper.toDto(image);
    }

    @Override
    public ImageDTO findOne(Integer id) {
        return imageRepository.findById(id.toString()).map(imageMapper::toDto).orElse(null);
    }

    @Override
    public List<ImageDTO> findAll() {
        return imageRepository.findAll().stream().map(imageMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Long count() {
        return imageRepository.count();
    }

    @Override
    public Page<ImageDTO> getPage(Pageable oPageable) {
        return imageRepository.findAll(oPageable).map(imageMapper::toDto);
    }

    @Override
    public Boolean delete(Integer id) {
        return imageRepository.findById(id.toString()).map(image -> {
            imageRepository.delete(image);
            return true;
        }).orElse(false);
    }
    @Override
    public List<ImageDTO> popular(Pageable pageable) {
        return imageRepository.popular(pageable.getOffset(), pageable.getPageSize()).stream().map(imageMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public Integer countLikes(Integer imageId){
        return imageRepository.countLikes(imageId);
    }
    @Override
    public List<ImageDTO> imageslikes(Integer userId) {
        return imageRepository.imageslikes(userId).stream().map(imageMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ImageDTO> favourite(Integer userId) {
        return imageRepository.favourite(userId).stream().map(imageMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ImageDTO> myimages(Integer userId) {
        return imageRepository.myimages(userId).stream().map(imageMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public Like like(Integer userId, Integer imageId) {
        if (likeRepository.findlike(userId, imageId) != null) {
            likeRepository.removeLike(userId, imageId);
        } else {
            likeRepository.saveLike(userId, imageId);
        }
        return likeRepository.findlike(userId, imageId);
    }
    @Override
    public List<ImageDTO> findFilter(String filter) {
        return imageRepository.findFilter(filter).stream().map(imageMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ImageDTO> getAllByCategory(Integer categoryId) {
        return imageRepository.findAllByCategoryId(categoryId).stream().map(imageMapper::toDto).collect(Collectors.toList());
    }
    @Override
     public List<ImageDTO> getPageImgFollows(Pageable oPageable, Integer userId) {
        return imageRepository.getPageImgFollows(oPageable.getOffset(), oPageable.getPageSize(), userId).stream().map(imageMapper::toDto).collect(Collectors.toList());
    }


}
