package wwf.org.staff.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public void init();
    public void save(MultipartFile file);
    public Resource load(String filename);
    public String deleteFile(String filename);
    public Stream<Path> loadAll();
}
