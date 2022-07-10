package wwf.org.staff.service;

import wwf.org.staff.entity.ImageConfig;

public interface ImageConfigService {
    public ImageConfig getImage(Long id);
    public ImageConfig createImage(ImageConfig imageConfig);
    public ImageConfig updateImage(ImageConfig imageConfig);
}
