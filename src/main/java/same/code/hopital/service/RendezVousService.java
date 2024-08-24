package same.code.hopital.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import same.code.hopital.dto.MedecinDto;
import same.code.hopital.dto.NewRendezVousDto;
import same.code.hopital.dto.PatientDto;
import same.code.hopital.dto.RendezVousDto;
import same.code.hopital.entity.PatientEntity;
import same.code.hopital.entity.RendezVousEntity;
import same.code.hopital.mapping.MedecinMapper;
import same.code.hopital.mapping.PatientMapper;
import same.code.hopital.mapping.RendezVousMapper;
import same.code.hopital.repository.IrendezVousRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackOn = {Throwable.class})

public class RendezVousService implements IrendezVousService {

    @Autowired
    IrendezVousRepository irendezVousRepository;

    @Autowired
    RendezVousMapper rendezVousMapper;

    @Autowired
    PatientMapper patientMapper;

    @Autowired
    MedecinMapper medecinMapper;

    @Override
    public RendezVousDto save(RendezVousDto rendezVousDto) {
//        RendezVousEntity existeRendezVous = irendezVousRepository.findById(rendezVousDto.getId()).get();
//        if(existeRendezVous!=null) {
//            throw new RuntimeException("Rendez-Vous existe deja ");
//        }
        RendezVousEntity rendezVousEntity = rendezVousMapper.getEntity(rendezVousDto);
        RendezVousEntity rendezVous = irendezVousRepository.save(rendezVousEntity);
        RendezVousDto dto = rendezVousMapper.getDto(rendezVous);
        return dto;

    }

    @Override
    public NewRendezVousDto getDataRendezVous(NewRendezVousDto rendezVousDto) {
        return null;
    }

    @Override
    public List<RendezVousDto> listRendezVous() {
        List<RendezVousEntity> rendezVousEntities  = irendezVousRepository.findAll();
        List<RendezVousDto> rendezVousDtos = rendezVousEntities.stream().map(rendezVous -> rendezVousMapper.getDto(rendezVous)).collect(Collectors.toList());

        return rendezVousDtos;
    }

    @Override
    public void delete(RendezVousDto rendezVousDto) {
        irendezVousRepository.delete(rendezVousMapper.getEntity(rendezVousDto));

    }

    @Override
    public RendezVousDto updateRendezVous(RendezVousDto rendezVousDto) {
        RendezVousEntity rendezVousSave =null;
        if (rendezVousDto!=null){
            RendezVousEntity rendezVous = rendezVousMapper.getEntity(rendezVousDto);
            rendezVousSave= irendezVousRepository.save(rendezVous);
        }
        return rendezVousMapper.getDto(rendezVousSave);

    }

    @Override
    public void deleteById(long id) {
        irendezVousRepository.deleteById(id);
    }

    @Override
    public List<RendezVousDto> findAllByPatient(PatientDto patient) {
        List<RendezVousEntity> rendezVousEntities  = irendezVousRepository.findAllByPatient(patientMapper.getEntity(patient) );
        List<RendezVousDto> rendezVousDtos = rendezVousEntities.stream().map(rendezVous -> rendezVousMapper.getDto(rendezVous)).collect(Collectors.toList());

        return rendezVousDtos;
    }

    @Override
    public List<RendezVousDto> findAllByMedecin(MedecinDto medecin) {
        List<RendezVousEntity> rendezVousEntities  = irendezVousRepository.findAllByMedecin(medecinMapper.getEntity(medecin));
        List<RendezVousDto> rendezVousDtos = rendezVousEntities.stream().map(rendezVous -> rendezVousMapper.getDto(rendezVous)).collect(Collectors.toList());

        return rendezVousDtos;
    }
}
