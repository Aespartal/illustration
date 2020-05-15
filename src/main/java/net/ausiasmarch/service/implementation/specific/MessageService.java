package net.ausiasmarch.service.implementation.specific;

import java.util.Date;
import java.util.List;
import net.ausiasmarch.dao.implementation.specific.MessageDao;
import net.ausiasmarch.entity.MessageEntity;
import net.ausiasmarch.service.implementation.generic.GenericServiceImplementation;
import net.ausiasmarch.service.interfaces.generic.GenericServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends GenericServiceImplementation implements GenericServiceInterface {

    @Autowired
    protected MessageDao oMessageDao;
    
    @Autowired
    public MessageService(MessageDao oMessageDao) {
        super(oMessageDao);
    }
    
    public void send(Integer to_id,Integer from_id,String message,Date now){
        oMessageDao.send(to_id,from_id,message,now);
    }
    
    public List<MessageEntity> getPageChat(Pageable oPageable,Integer to_id,Integer from_id){
        return oMessageDao.getPageChat(oPageable,to_id,from_id);
    }
    
    public MessageEntity getMessage(Integer to_id,Integer from_id, String message, Date now){
        return oMessageDao.getMessage(to_id,from_id,message,now);
    }
}
