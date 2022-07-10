package wwf.org.staff.service;

import wwf.org.staff.entity.Projects;

import java.util.List;

public interface ProjectsService {
    public List<Projects> listAllProjects();

    public Projects getProjects(Long id);

    public Projects createProjects(Projects value);
    public Projects updateProjects(Projects value);
    public Boolean deleteProjects(Long id);

    public Projects findByNumberProject(String val);
}
