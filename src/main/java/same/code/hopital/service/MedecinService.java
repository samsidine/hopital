package same.code.hopital.service;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import same.code.hopital.dto.MedecinDto;
import same.code.hopital.entity.MedecinEntity;
import same.code.hopital.entity.PatientEntity;
import same.code.hopital.mapping.MedecinMapper;
import same.code.hopital.repository.ImedecinRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackOn = {Throwable.class})
public class MedecinService implements ImedecinService{

    @Autowired
    ImedecinRepository imedecinRepository;
    @Autowired
    MedecinMapper medecinMapper;
    @Override
    public MedecinDto save(MedecinDto medecinDto) {
        MedecinEntity medecinEntity= imedecinRepository.findByEmail(medecinDto.getEmail());
                if(medecinEntity!=null){
                    throw  new RuntimeException("Medecin existe deja");
                }
         MedecinEntity medecinEntity1 = medecinMapper.getEntity(medecinDto);
         MedecinEntity medecin = imedecinRepository.save(medecinEntity1) ;
         MedecinDto dto = medecinMapper.getDto(medecin);
         return dto;
    }
    @Override
    public List<MedecinDto> listMedecin() {
       List<MedecinEntity> medecins = imedecinRepository.findAll();
       List<MedecinDto> medecinDtos = medecins.stream().map(medecinEntity -> medecinMapper.getDto(medecinEntity)).collect(Collectors.toList());
       return medecinDtos;
    }
    @Override
    public MedecinDto getMedecinById(Long id) {
        MedecinEntity medecinEntity = imedecinRepository.getById(id);
        return medecinMapper.getDto(medecinEntity);
    }

    @Override
    public MedecinDto getMedecinByEmail(String email) {
        MedecinEntity medecinEntity= imedecinRepository.findByEmail(email);
        return medecinMapper.getDto(medecinEntity);
    }
    @Override
    public void deleteById(Long id) {

        imedecinRepository.deleteById(id);
    }

    @Override
    public MedecinDto updateMedecin(MedecinDto medecinDto) {
        MedecinEntity medecinSave =null;
        if (medecinDto!=null){
            MedecinEntity medecin = medecinMapper.getEntity(medecinDto);
            medecinSave= imedecinRepository.save(medecin);
        }
        return medecinMapper.getDto(medecinSave);

    }
}
