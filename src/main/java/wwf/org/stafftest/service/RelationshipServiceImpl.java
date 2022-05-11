package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.Relationship;
import wwf.org.stafftest.repository.RelationshipRepository;

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
    public Relationship createRelationship(Relationship relationship, Long userId) {
        relationship.setStatus("CREATED");
        relationship.setCreate_by(userId);
        relationship.setCreation_date(new Date());
        relationship.setLast_update_by(userId);
        relationship.setLast_update_date(new Date());

        return relationshipRepository.save(relationship);
    }

    @Override
    public Relationship updateRelationship(Relationship relationship, Long userId) {
        Relationship relationshipDB = getRelationship(relationship.getId());
        if(null == relationshipDB){
            return null;
        }

        relationship.setLast_update_by(userId);
        relationship.setLast_update_date(new Date());

        return relationshipRepository.save(relationship);
    }

    @Override
    public Relationship deleteRelationship(Long id, Long userId) {
        Relationship relationshipDB = getRelationship(id);
        if(null == relationshipDB){
            return null;
        }

        relationshipDB.setStatus("DELETED");
        relationshipDB.setLast_update_by(userId);
        relationshipDB.setLast_update_date(new Date());

        return relationshipRepository.save(relationshipDB);
    }
}
