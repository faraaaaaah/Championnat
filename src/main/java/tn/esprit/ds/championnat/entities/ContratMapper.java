package tn.esprit.ds.championnat.entities;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContratMapper {
    @Mapping(source = "equipe.libelle", target = "libelleEquipe")
    @Mapping(source = "sponsor.nom", target = "nomSponsor")
    ContratDTO contratToContratDTO(Contrat contrat);
}
