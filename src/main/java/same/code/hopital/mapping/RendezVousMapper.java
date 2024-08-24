package same.code.hopital.mapping;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;
import same.code.hopital.dto.MedecinDto;
import same.code.hopital.dto.PatientDto;
import same.code.hopital.dto.RendezVousDto;

import same.code.hopital.entity.MedecinEntity;
import same.code.hopital.entity.PatientEntity;
import same.code.hopital.entity.RendezVousEntity;

@Service
public class RendezVousMapper {
    public RendezVousDto getDto(RendezVousEntity entite){
        RendezVousDto dto = new RendezVousDto();
        //BeanUtils.copyProperties(rendezVous, rendezVousDto);
        dto.setDateRendezVous(entite.getDateRendezVous());
        dto.setId(entite.getId());
        dto.setPatient(getDto(entite.getPatient()) );
        dto.setMedecin(getDto(entite.getMedecin()));
        dto.setDescription(entite.getDescription());
        return dto;

    }

    public RendezVousEntity getEntity(RendezVousDto  dto){
        RendezVousEntity entite = new RendezVousEntity();
        //BeanUtils.copyProperties( rendezVousDto, rendezVous);
        entite.setDateRendezVous(dto.getDateRendezVous());
        entite.setId(dto.getId());
        entite.setPatient(getEntity(dto.getPatient()) );
        entite.setMedecin(getEntity(dto.getMedecin()));
        entite.setDescription(dto.getDescription());
        return  entite;

    }

    public PatientEntity getEntity(PatientDto patientDto){
        PatientEntity patient = new PatientEntity();
        BeanUtils.copyProperties( patientDto, patient);
        return  patient;

    }
    public MedecinEntity getEntity (MedecinDto medecinDto){
        MedecinEntity medecinEntity = new MedecinEntity();
        BeanUtils.copyProperties(medecinDto , medecinEntity);
        return medecinEntity;
    }

    public PatientDto getDto(PatientEntity patient){
        PatientDto patientDto = new PatientDto();
        BeanUtils.copyProperties(patient, patientDto);
        return patientDto;

    }
    public MedecinDto getDto (MedecinEntity medecinEntity){
        MedecinDto medecinDto = new MedecinDto();
        BeanUtils.copyProperties(medecinEntity, medecinDto);
        return medecinDto;
    }

}
