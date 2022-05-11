package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.Relationship;

public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
}
