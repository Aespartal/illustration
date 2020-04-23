/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.dao.implementation.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import net.ausiasmarch.dao.interfaces.specific.ImageDaoJpaInterface;
import net.ausiasmarch.dao.interfaces.specific.LikeDaoJpaInterface;
import net.ausiasmarch.entity.ImageEntity;
import net.ausiasmarch.entity.LikeEntity;
import net.ausiasmarch.entity.LikeId;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDao extends GenericDaoImplementation<GenericEntityInterface> implements GenericDaoInterface<GenericEntityInterface> {
        @Autowired
	protected ImageDaoJpaInterface oImageRepository;
        @Autowired
        protected LikeDaoJpaInterface oLikeRepository;
	@Autowired
	public ImageDao(ImageDaoJpaInterface oImageRepository) {
		super(oImageRepository);
	}
        
        public List<ImageEntity> popular(Pageable pageable){
            return oImageRepository.popular(pageable.getPageNumber(), pageable.getPageSize());
        }
        
         public List<ImageEntity> imageslikes(int user_id){
            return oImageRepository.imageslikes(user_id);
        }

        public List<ImageEntity> favourite(Integer user_id) {
            return oImageRepository.favourite(user_id);
        }
        
        public List<ImageEntity> myimages(Integer user_id) {
            return oImageRepository.myimages(user_id);
        }
        
        //------------------------------
        public LikeEntity findlike(Integer user_id, Integer image_id){
            if(oLikeRepository.findlike(user_id,image_id) == null){
                return null;
            } else {
                LikeId oLiked = new LikeId(user_id, image_id);
                LikeEntity olikeEntity = new LikeEntity(oLiked);
                return olikeEntity;
            } 
        }
        public void removelike(Integer user_id, Integer image_id){
              oLikeRepository.removeLike(user_id,image_id);
        }
         public void saveLike(Integer user_id, Integer image_id){
             oLikeRepository.saveLike(user_id,image_id);
         
        }
        //------------------------------
         
         public List<ImageEntity> findFilter(String result){
             return oImageRepository.findFilter(result);
         }
         
         public List<ImageEntity> getAllByCategory(Integer category_id){
             return oImageRepository.getAllByCategory(category_id);
         }
}
