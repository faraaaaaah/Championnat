package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.PiloteRepository;

public class EquipeServiceImpl implements IEquipeService{
    private EquipeRepository equipeRepository;
<<<<<<< HEAD

=======
>>>>>>> c94fcd8759cfefba78caed5190cc547c6b6dc9ab
    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }
}
