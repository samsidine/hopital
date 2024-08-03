package same.code.hopital.mapping;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import same.code.hopital.dto.PatientDto;
import same.code.hopital.entity.PatientEntity;


@Service

public class PatientMapper {

    public PatientDto getDto(PatientEntity patient){
        PatientDto patientDto = new PatientDto();
        BeanUtils.copyProperties(patient, patientDto);
        return patientDto;

    }

    public PatientEntity getEntity(PatientDto  patientDto){
        PatientEntity patient = new PatientEntity();
        BeanUtils.copyProperties( patientDto, patient);
        return  patient;

    }



}
