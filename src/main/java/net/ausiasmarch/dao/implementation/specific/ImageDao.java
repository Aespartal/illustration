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
        
        public Boolean existLike(Integer user_id, Integer image_id){
            boolean state;
            
            if(!oImageRepository.existLike(user_id, image_id).isEmpty()){
                oImageRepository.removetLike(user_id, image_id);
                System.out.print("Ha quitado el like");
                state = true;
            } else {
                oImageRepository.saveLike(user_id, image_id);
                System.out.print("Ha dado a like");
                state = false;
            }       
            return state;
        }
        
}
