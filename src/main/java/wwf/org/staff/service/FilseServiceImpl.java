package wwf.org.staff.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FilseServiceImpl implements FileService{
        
    //private final Path root = Paths.get("uploadsTs");
    private Path path = Paths.get("/home/uploadsTs");

    @Override
    public void init() {
        if(!Files.exists(this.path)){
            try {
                Files.createDirectory(this.path);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage()+"::"+this.path.toAbsolutePath().toString());
            }
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {

            StringBuilder builder = new StringBuilder();
            //builder.append(System.getProperty("user.home")); /var/lib/tomcat
            builder.append("/home/uploadsTs");
            builder.append(File.separator);
            builder.append(file.getOriginalFilename());

            byte[] fileBytes = file.getBytes();
            Path path2 = Paths.get(builder.toString());
            Files.write(path2, fileBytes);

            //File fil = new File(path2.toString());
            //File filR = new File("prueba");
            //fil.renameTo(filR);

            //Files.copy(file.getInputStream(), this.path);

            /*Files.copy(file.getInputStream(),
                    this.path.resolve(file.getOriginalFilename()));*/
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = this.path.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new RuntimeException("Can't read file");
            }
        }catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String deleteFile(String filename) {
        try {
            Boolean delete = Files.deleteIfExists(this.path.resolve(filename));
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "nop";
        }
    }
}
