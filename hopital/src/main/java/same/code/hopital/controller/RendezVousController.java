package same.code.hopital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import same.code.hopital.dto.MedecinDto;
import same.code.hopital.dto.NewRendezVousDto;
import same.code.hopital.dto.PatientDto;
import same.code.hopital.dto.RendezVousDto;
import same.code.hopital.entity.MedecinEntity;
import same.code.hopital.entity.UserEntity;
import same.code.hopital.repository.UserRepository;
import same.code.hopital.service.ImedecinService;
import same.code.hopital.service.IpatientService;
import same.code.hopital.service.IrendezVousService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RendezVousController {

    @Autowired
    IrendezVousService irendezVousService;

    @Autowired
    IpatientService patientService;

    @Autowired
    ImedecinService medecinService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/rendezVous")
    public List<RendezVousDto> getRendezVous(){
        return irendezVousService.listRendezVous();
    }


    @PostMapping(path = "/rendezVous",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //@ResponseStatus(HttpStatus.CREATED)
    public RendezVousDto save(NewRendezVousDto rendezVousDto){
        RendezVousDto savaRV = getDataRendezVous(rendezVousDto);
         return  irendezVousService.save(savaRV);

    }

    @PutMapping("/rendezVous")
    public RendezVousDto update(RendezVousDto rendezVousDto){
        return irendezVousService.updateRendezVous(rendezVousDto);

    }
    @DeleteMapping("/rendezVous/{id}")
    public void  deleteById(@PathVariable(name ="id" ) Long id) {
        irendezVousService.deleteById(id);
    }

    @GetMapping("/rendezVous/{idUser}")
    public List<RendezVousDto>  getRendezVousByUser(@PathVariable(name ="idUser" ) Long idUser) {
        //Long idUs = Long.parseLong(idUser);
        UserEntity user = userRepository.findById(idUser).get();
        if (user.getMedecin()!=null){
            MedecinDto medecin = medecinService.getMedecinById(user.getMedecin().getId());
            return  irendezVousService.findAllByMedecin(medecin);
        }else {
            PatientDto patient = patientService.getPatientById(user.getPatient().getId());
            return  irendezVousService.findAllByPatient(patient);
        }

    }
    private RendezVousDto getDataRendezVous(NewRendezVousDto newRV){

        RendezVousDto rendezVousDto = new RendezVousDto();
        PatientDto patient = patientService.getPatientById(newRV.getPatient());
        MedecinDto medecin = medecinService.getMedecinById(newRV.getMedecin());
        rendezVousDto.setDateRendezVous(newRV.getDateRendezVous());
        rendezVousDto.setDescription(newRV.getDescription());
        rendezVousDto.setPatient(patient);
        rendezVousDto.setMedecin(medecin);
        return  rendezVousDto;

    }

}
