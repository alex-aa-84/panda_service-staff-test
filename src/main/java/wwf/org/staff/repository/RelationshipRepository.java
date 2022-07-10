package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Relationship;

public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
    public Relationship findByRelationship(String relationship);
}
