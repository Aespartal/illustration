
package net.ausiasmarch.dao.interfaces.specific;

import net.ausiasmarch.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageDaoJpaInterface extends JpaRepository<MessageEntity, Integer> {
    
}
