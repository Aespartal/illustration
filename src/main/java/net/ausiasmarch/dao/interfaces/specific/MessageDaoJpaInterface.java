
package net.ausiasmarch.dao.interfaces.specific;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import net.ausiasmarch.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MessageDaoJpaInterface extends JpaRepository<MessageEntity, Integer> {
    
    @Transactional
    @Modifying(clearAutomatically = false)
    @Query(value="INSERT INTO chat (to_user, from_user, body, date) VALUES (:to_id,:from_id,:body,:now)",nativeQuery=true)
    void send(Integer to_id, Integer from_id, String body, Date now);
    
    @Query(value="SELECT * FROM chat m WHERE (m.to_user = :to_id AND m.from_user = :from_id) OR (m.to_user = :from_id AND m.from_user = :to_id) limit :offset, :pageSize",nativeQuery=true)
    List<MessageEntity> getPageChat(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize, Integer to_id,Integer from_id);
    
    @Query(value="SELECT * FROM chat WHERE to_user = :to_id AND from_user = :from_id AND body = :body AND date = :now",nativeQuery=true)
    MessageEntity getMessage(Integer to_id, Integer from_id, String body, Date now);
    
}
