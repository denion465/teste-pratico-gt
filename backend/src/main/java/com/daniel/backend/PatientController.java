//package com.daniel.backend;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//@CrossOrigin
//public class PatientController {
//
//  @Autowired
//  private PatientRepository patientRepository;
//
//  // Rota para buscar todos os Pacientes
//  @GetMapping("/patients")
//  public List<Patient> GetPatient() {
//
//    return patientRepository.findAll();
//  }
//
//  @GetMapping("/patients/{id}")
//  public Patient GetPatient(@PathVariable Long id) {
//
//    return patientRepository.findById(id).orElse(null);
//  }
//
//  // Rota para salvar formulário do paciente
//  @PostMapping("/patients")
//  public Patient PostPatient(@RequestBody Patient patient) {
//    patient.setCpf(Encrypt.encrypt(patient.getCpf()));
//
//    return patientRepository.save(patient);
//  }
//
//  // Rota para atulizar
//  @PutMapping("/patients")
//  public Patient PutPatient(@RequestBody Patient patient) {
//    Patient oldPatient = patientRepository.findById(patient.getId())
//    .orElse(null);
//
//    oldPatient.setName(patient.getName());
//    oldPatient.setCpf(patient.getCpf());
//    oldPatient.setBirth(patient.getBirth());
//    oldPatient.setWeight(patient.getWeight());
//    oldPatient.setHeight(patient.getHeight());
//    oldPatient.setUf(patient.getCpf());
//
//    return patientRepository.save(oldPatient);
//  }
//
//  //Rota para deletar
//  @DeleteMapping("/patients/{id}")
//  public Long DeletePatient(@PathVariable Long id) {
//    patientRepository.deleteById(id);
//
//    return id;
//  }
//}
