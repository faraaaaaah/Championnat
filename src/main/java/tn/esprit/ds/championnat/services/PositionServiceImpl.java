package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Position;
import tn.esprit.ds.championnat.repositories.PositionRepository;
@Service
@AllArgsConstructor
public class PositionServiceImpl implements IPositionService{
    private PositionRepository positionRepository;
    @Override
    public Position ajouterPosition(Position position) {
        return positionRepository.save(position);
    }
}
