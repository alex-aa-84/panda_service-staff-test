package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.Relationship;
import wwf.org.staff.repository.RelationshipRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RelationshipServiceImpl implements RelationshipService {

    @Autowired
    private RelationshipRepository relationshipRepository;

    @Override
    public List<Relationship> listAllRelationship() {
        return relationshipRepository.findAll();
    }

    @Override
    public Relationship getRelationship(Long id) {
        return relationshipRepository.findById(id).orElse(null);
    }

    @Override
    public Relationship createRelationship(Relationship relationship) {
        relationship.setStatus("CREATED");
        relationship.setCreation_date(new Date());
        relationship.setLast_update_date(new Date());

        return relationshipRepository.save(relationship);
    }

    @Override
    public Relationship updateRelationship(Relationship relationship) {
        Relationship relationshipDB = getRelationship(relationship.getId());
        if(null == relationshipDB){
            return null;
        }

        relationshipDB.setRelationship(relationship.getRelationship());
        relationshipDB.setDescription(relationship.getDescription());

        relationshipDB.setAttribute1(relationship.getAttribute1());
        relationshipDB.setAttribute2(relationship.getAttribute2());
        relationshipDB.setAttribute3(relationship.getAttribute3());
        relationshipDB.setAttribute4(relationship.getAttribute4());
        relationshipDB.setAttribute5(relationship.getAttribute5());
        relationshipDB.setAttribute6(relationship.getAttribute6());
        relationshipDB.setAttribute7(relationship.getAttribute7());
        relationshipDB.setAttribute8(relationship.getAttribute8());
        relationshipDB.setAttribute9(relationship.getAttribute9());
        relationshipDB.setAttribute10(relationship.getAttribute10());

        relationshipDB.setStatus(relationship.getStatus());

        relationshipDB.setLast_update_by(relationship.getLast_update_by());
        relationshipDB.setLast_update_date(new Date());

        return relationshipRepository.save(relationshipDB);
    }

    @Override
    public Boolean deleteRelationship(Long id) {
        Relationship relationshipDB = getRelationship(id);
        if(null == relationshipDB){
            return false;
        }

        relationshipRepository.deleteById(id);
        return true;
    }

    @Override
    public Relationship findByRelationship(String relationship) {
        return relationshipRepository.findByRelationship(relationship);
    }
}
