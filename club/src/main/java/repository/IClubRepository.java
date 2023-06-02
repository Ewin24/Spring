package repository;

import org.springframework.data.repository.CrudRepository;

import entity.Club;

public interface IClubRepository extends CrudRepository<Club, Long> {

}
