package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.PermissionHeader;

public interface PermissionHeaderRepository extends JpaRepository<PermissionHeader, Long> {
    public PermissionHeader findByPermission(String permission);
}
