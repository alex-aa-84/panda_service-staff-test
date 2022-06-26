package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.ImageConfig;

public interface ImageConfigService {
    public ImageConfig getImage(Long id);
    public ImageConfig createImage(ImageConfig imageConfig);
    public ImageConfig updateImage(ImageConfig imageConfig);
}
