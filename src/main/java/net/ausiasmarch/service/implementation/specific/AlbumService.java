package net.ausiasmarch.service.implementation.specific;

import net.ausiasmarch.dao.implementation.specific.AlbumDao;
import net.ausiasmarch.service.implementation.generic.GenericServiceImplementation;
import net.ausiasmarch.service.interfaces.generic.GenericServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService extends GenericServiceImplementation implements GenericServiceInterface {
    @Autowired
	public AlbumService(AlbumDao oAlbumDao) {
		super(oAlbumDao);
	}
}
