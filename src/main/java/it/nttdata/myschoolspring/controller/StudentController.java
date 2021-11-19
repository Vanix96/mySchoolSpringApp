package it.nttdata.myschoolspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.nttdata.myschoolspring.repository.StudentRepository;

@Controller
public class StudentController {
    
    private StudentRepository studentRepository;
    public StudentController (StudentRepository studentRepository) {
        this.studentRepository=studentRepository;
    }

    @GetMapping("/students")
    public String getStudents (Model model) {
        //Ci restituisce la lista degli studenti e la passa co model
        model.addAttribute("students", studentRepository.findAll()); //NB stduents sarebbe la chiave e ci possiamo mettere quello che vogliamo
         model.addAttribute("title", "List Student MySchool");
        //Ritorno il nome del fil html in Templates
        return "studentslist";
    }

        //Se vogliamo cliccare sulla classe nella lista
    @GetMapping("/students/{section}")
    public String getStudentByClass(Model model, @PathVariable String section) {
       model.addAttribute("title", "Lista studenti" + section);
        //Cosi mi ritorna una lista di una certa sezione
        model.addAttribute("students",studentRepository.findStudentByClass(section) );
        return "studentslist";
    }
}
