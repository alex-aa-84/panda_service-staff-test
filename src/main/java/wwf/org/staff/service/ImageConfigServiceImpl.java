package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.repository.ImageConfigRepository;
import wwf.org.staff.serviceApi.MD5Util;
import wwf.org.staff.entity.ImageConfig;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ImageConfigServiceImpl implements ImageConfigService {

    @Autowired
    private ImageConfigRepository imageConfigRepository;

    @Override
    public ImageConfig getImage(Long id) {
        return imageConfigRepository.findById(id).orElse(null);
    }

    @Override
    public ImageConfig createImage(ImageConfig imageConfig) {
        imageConfig.setCreation_date(new Date());
        imageConfig.setLast_update_date(new Date());
        String md5 = MD5Util.string2MD5(imageConfig.toString());
        imageConfig.setCtrlMd5(md5);
        return imageConfigRepository.save(imageConfig);
    }

    @Override
    public ImageConfig updateImage(ImageConfig imageConfig) {
        ImageConfig imageConfigBD = getImage(imageConfig.getId());

        if(null == imageConfigBD){
            return null;
        }

        imageConfigBD.setImage(imageConfig.getImage());
        imageConfigBD.setName(imageConfig.getName());
        imageConfigBD.setType(imageConfig.getType());
        imageConfig.setLast_update_date(new Date());
        imageConfigBD.setLast_update_by(imageConfig.getLast_update_by());

        return imageConfigRepository.save(imageConfigBD);
    }

}