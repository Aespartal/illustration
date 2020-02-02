/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.service.interfaces.specific;

import java.util.Map;
import net.ausiasmarch.entity.UserEntity;

/**
 *
 * @author espar
 */
public interface UserServiceInterface {
	UserEntity login(Map<String, String> mParametros);
}
