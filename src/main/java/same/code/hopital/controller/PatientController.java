package same.code.hopital.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import same.code.hopital.dto.PatientDto;
import same.code.hopital.service.IpatientService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class PatientController {


    @Autowired
    IpatientService  ipatientService;

    @GetMapping("/patients")
    public List<PatientDto> getPatients(){
        return ipatientService.listPatient();
    }

    @PostMapping(path = "/patients",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public PatientDto save( PatientDto patient){

        return ipatientService.save(patient);
    }


    @GetMapping("/patients/{id}")
    public PatientDto getById(@PathVariable(name ="id" ) Long id) {
        return ipatientService.getPatientById(id);
    }

    @GetMapping("/patients/email/{email}")
    public PatientDto getByEmail(@PathVariable(name = "email") String email) {
        return ipatientService.getPatientByEmail(email);
    }
    @DeleteMapping("/patients/{id}")
    public void  deleteById(@PathVariable("id") Long id) {

        ipatientService.deleteById(id);
    }

    @PutMapping("/patients")
    public PatientDto update(@RequestBody PatientDto patient){
        return ipatientService.updatePatient(patient);

    }





}
