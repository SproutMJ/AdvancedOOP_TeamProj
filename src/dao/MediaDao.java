package dao;

import java.util.List;

import entity.Media;

public interface MediaDao {

	List<Media> retrieveMediaListByNationId(int id);

}
