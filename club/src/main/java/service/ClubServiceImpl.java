package service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import entity.Club;
import repository.IClubRepository;

@Service
public class ClubServiceImpl implements IClubService {

	private final IClubRepository clubRepository;

	public ClubServiceImpl(IClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}

	@Override
	public List<Club> findAll() {
		return (List<Club>) clubRepository.findAll();
	}

	public void save(Club club) {
		clubRepository.save(club);
	}

	@Override
	public Club FindOne(Long id) {
		Optional<Club> optionalClub = clubRepository.findById(id);
		return optionalClub.orElse(null);
	}

	@Override
	public void delete(Long id) {
		clubRepository.deleteById(id);
	}
}
