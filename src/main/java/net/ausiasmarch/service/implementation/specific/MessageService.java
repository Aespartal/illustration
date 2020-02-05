package net.ausiasmarch.service.implementation.specific;

import net.ausiasmarch.dao.implementation.specific.MessageDao;
import net.ausiasmarch.service.implementation.generic.GenericServiceImplementation;
import net.ausiasmarch.service.interfaces.generic.GenericServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends GenericServiceImplementation implements GenericServiceInterface {

    @Autowired
    public MessageService(MessageDao oMessageDao) {
        super(oMessageDao);
    }
}
