/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.dao.interfaces.specific;

import net.ausiasmarch.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author espar
 */
public interface CategoryDaoJpaInterface extends JpaRepository<CategoryEntity, Integer> {
    
}
