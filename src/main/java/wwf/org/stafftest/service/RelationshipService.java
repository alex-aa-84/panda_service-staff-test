package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.Relationship;

import java.util.List;

public interface RelationshipService {
    public List<Relationship> listAllRelationship();
    public Relationship getRelationship(Long id);

    public Relationship createRelationship(Relationship relationship, Long userId);
    public Relationship updateRelationship(Relationship relationship, Long userId);
    public Relationship deleteRelationship(Long id, Long userId);
}
