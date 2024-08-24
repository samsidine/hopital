package same.code.hopital.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import same.code.hopital.dto.MedecinDto;
import same.code.hopital.service.ImedecinService;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin("*")
public class MedecinController {

    @Autowired
    ImedecinService imedecinService;


    @PostMapping(path = "/medecins",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MedecinDto save ( MedecinDto medecinDto){
    return imedecinService.save(medecinDto); }


@GetMapping("/medecins")
public List<MedecinDto> getMedecins(){
    return imedecinService.listMedecin();
}

@GetMapping("/medecins/{id}")
public MedecinDto getById(@PathVariable (name= "id") Long id){
        return imedecinService.getMedecinById(id);
}

@GetMapping("/medecins/email/{email}")
    public MedecinDto getByEmail(@PathVariable (name= "email") String email) {
        return imedecinService.getMedecinByEmail(email);
}

@DeleteMapping("/medecins/{id}")
    public void delete(@PathVariable (name = "id") Long id){
        imedecinService.deleteById(id);
}


@PutMapping("/medecins")
public MedecinDto update(@RequestBody MedecinDto medecin){
    return imedecinService.updateMedecin(medecin);

}
}

