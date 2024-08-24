package same.code.hopital.service;



import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import same.code.hopital.dto.PatientDto;
import same.code.hopital.entity.PatientEntity;
import same.code.hopital.mapping.PatientMapper;
import same.code.hopital.repository.IpatientRepository;

import java.util.List;

import java.util.stream.Collectors;

@Service
@Transactional(rollbackOn = {Throwable.class})
public class PatientService implements IpatientService{


    @Autowired
    IpatientRepository  ipatientRepository;


    @Autowired
     PatientMapper   patientMapper;
    @Override
    public PatientDto save(PatientDto patientDto) {
        PatientEntity existePatient = ipatientRepository.findByEmail(patientDto.getEmail());
        if(existePatient!=null) {
            throw new RuntimeException("Patient existe deja ");
        }
        PatientEntity patientEntity = patientMapper.getEntity(patientDto);
        PatientEntity patient = ipatientRepository.save(patientEntity);
        PatientDto dto = patientMapper.getDto(patient);
        return dto;
    }

    @Override
    public List<PatientDto> listPatient() {
        List<PatientEntity> patients  = ipatientRepository.findAll();
        List<PatientDto> patientDtos = patients.stream().map(patient -> patientMapper.getDto(patient)).collect(Collectors.toList());

        return patientDtos;
    }

    @Override
    public PatientDto getPatientById(long id) {
        PatientEntity patient = ipatientRepository.getById(id);
        PatientDto patientDto = patientMapper.getDto(patient);
        return patientDto ;
    }

    @Override
    public PatientDto getPatientByEmail(String email) {

        PatientEntity patient = ipatientRepository.findByEmail(email);
        return patientMapper.getDto(patient);
    }
    @Override
    public void deleteById(long id) {
        ipatientRepository.deleteById(id);
    }

//    @Override
//    public PatientDto deleteById(long id) {
//        ipatientRepository.deleteById(id);
//    }
    @Override
    public void delete(PatientDto patientDto) {
        ipatientRepository.delete(patientMapper.getEntity(patientDto));

    }
    @Override
    public PatientDto updatePatient(PatientDto patientDto) {
        PatientEntity patientSave =null;
        if (patientDto!=null){
            PatientEntity patient = patientMapper.getEntity(patientDto);
            patientSave= ipatientRepository.save(patient);
        }
    return patientMapper.getDto(patientSave);


    }


    }
