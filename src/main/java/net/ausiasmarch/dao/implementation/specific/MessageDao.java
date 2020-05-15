
package net.ausiasmarch.dao.implementation.specific;
import java.util.Date;
import java.util.List;
import net.ausiasmarch.dao.implementation.generic.GenericDaoImplementation;
import net.ausiasmarch.dao.interfaces.generic.GenericDaoInterface;
import net.ausiasmarch.dao.interfaces.specific.MessageDaoJpaInterface;
import net.ausiasmarch.entity.MessageEntity;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDao extends GenericDaoImplementation<GenericEntityInterface> implements GenericDaoInterface<GenericEntityInterface> {
            @Autowired
	protected MessageDaoJpaInterface oMessageRepository;

	@Autowired
	public MessageDao(MessageDaoJpaInterface oMessageRepository) {
		super(oMessageRepository);
	}
        
        public void send(Integer to_id,Integer from_id,String message,Date now){
            oMessageRepository.send(to_id,from_id,message,now);
        }

    public List<MessageEntity> getPageChat(Pageable oPageable, Integer to_id, Integer from_id) {
         return oMessageRepository.getPageChat(oPageable.getPageNumber(), oPageable.getPageSize(),to_id,from_id);
    }
    
    public MessageEntity getMessage(Integer to_id,Integer from_id, String message, Date now){
        return oMessageRepository.getMessage(to_id,from_id, message, now);
    }
}
