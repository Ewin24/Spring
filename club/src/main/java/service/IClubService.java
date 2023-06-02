package service;

import java.util.List;

import entity.Club;

public interface IClubService {

	public List<Club> findAll();

	public void save(Club club);

	public Club FindOne(Long id);

	public void delete(Long id);

}
