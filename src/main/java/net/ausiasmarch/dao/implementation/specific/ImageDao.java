/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.dao.implementation.specific;

import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import net.ausiasmarch.dao.interfaces.specific.ImageDaoJpaInterface;
import net.ausiasmarch.entity.ImageEntity;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDao extends GenericDaoImplementation<GenericEntityInterface> implements GenericDaoInterface<GenericEntityInterface> {
        @Autowired
	protected ImageDaoJpaInterface oImageRepository;

	@Autowired
	public ImageDao(ImageDaoJpaInterface oImageRepository) {
		super(oImageRepository);
	}
   
        //------------------------------
        public Boolean findlike(Integer user_id, Integer image_id){
            if(!oImageRepository.findlike(user_id,image_id).isEmpty()){
                return true;
            }
            return false;
        }
        public Boolean removelike(Integer user_id, Integer image_id){
             if(oImageRepository.removeLike(user_id,image_id)){
                return true;
            }
            return false;
        }
         public Boolean saveLike(Integer user_id, Integer image_id){
            if(oImageRepository.saveLike(user_id,image_id)){
                return true;
            }
            return false;
        }
        //------------------------------
}
