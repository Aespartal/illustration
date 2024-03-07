package net.ausiasmarch.domain.mapper;

import net.ausiasmarch.domain.Comment;
import net.ausiasmarch.service.dto.CommentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper extends EntityMapper<CommentDTO, Comment> {
    CommentDTO toDto(Comment comment);

    Comment toEntity(CommentDTO rolDTO);

    default Comment fromId(Integer id) {
        if (id == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.setId(id);
        return comment;
    }
}
