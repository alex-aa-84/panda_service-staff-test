package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.PermissionHeader;

public interface PermissionHeaderRepository extends JpaRepository<PermissionHeader, Long> {
    public PermissionHeader findByPermission(String permission);
}
