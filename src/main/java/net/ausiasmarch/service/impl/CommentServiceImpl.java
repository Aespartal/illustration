package net.ausiasmarch.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import net.ausiasmarch.domain.Comment;
import net.ausiasmarch.service.dto.CommentDTO;
import net.ausiasmarch.domain.mapper.CommentMapper;
import net.ausiasmarch.repository.CommentRepository;
import net.ausiasmarch.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public CommentDTO save(CommentDTO commentDTO) {
        Comment comment = commentMapper.toEntity(commentDTO);
        comment = commentRepository.save(comment);
        return commentMapper.toDto(comment);
    }

    @Override
    public CommentDTO get(int id) {
        return commentRepository.findById(id).map(commentMapper::toDto).orElse(null);
    }

    @Override
    public List<CommentDTO> findAll() {
        return commentRepository.findAll().stream().map(commentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Long count() {
        return commentRepository.count();
    }

    @Override
    public Page<CommentDTO> getPage(Pageable oPageable) {
        return commentRepository.findAll(oPageable).map(commentMapper::toDto);
    }

    @Override
    public Boolean delete(int id) {
        return commentRepository.findById(id).map(comment -> {
            commentRepository.delete(comment);
            return true;
        }).orElse(false);
    }
    @Override
    public Long countByImageId(int id) {
        return commentRepository.countByImageId(id);
    }

    @Override
    public List<CommentDTO> findAllById(Integer id) {
        return commentRepository.findAllById(id).stream().map(commentMapper::toDto).collect(Collectors.toList());
    }
}
