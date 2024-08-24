package same.code.hopital.mapping;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import same.code.hopital.dto.MedecinDto;
import same.code.hopital.entity.MedecinEntity;

@Service

public class MedecinMapper {
    public MedecinDto getDto (MedecinEntity medecinEntity){

        MedecinDto medecinDto = new MedecinDto();
        BeanUtils.copyProperties(medecinEntity, medecinDto);
        return medecinDto;
    }


    public MedecinEntity getEntity (MedecinDto medecinDto){
        MedecinEntity medecinEntity = new MedecinEntity();
        BeanUtils.copyProperties(medecinDto , medecinEntity);
        return medecinEntity;
    }

}
