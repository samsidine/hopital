package same.code.hopital.service;

import same.code.hopital.dto.PatientDto;

import java.util.List;

public interface IpatientService {

    PatientDto save(PatientDto patientDto);

    List<PatientDto> listPatient();

    PatientDto getPatientById(long id);

    PatientDto getPatientByEmail(String email);

    void deleteById(long id);

    void delete(PatientDto patientDto);
PatientDto updatePatient(PatientDto patientDto);




}
