package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.Relationship;

import java.util.List;

public interface RelationshipService {
    public List<Relationship> listAllRelationship();
    public Relationship getRelationship(Long id);

    public Relationship createRelationship(Relationship relationship);
    public Relationship updateRelationship(Relationship relationship);
    public Boolean deleteRelationship(Long id);
    public Relationship findByRelationship(String relationship);
}
