package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Course;
import tn.esprit.ds.championnat.services.CourseServiceImpl;

@Tag(name="Gestion des courses")
@RestController
@AllArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private CourseServiceImpl courseservice;

    @Operation(description="ajouter une course dans la base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "coure ajoutée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PostMapping("/addecourse")
    public Course ajouterCourse(@RequestBody Course course) {
        Course c = courseservice.ajouterCourse(course);
        return c;
    }
    @PutMapping("/affectercourse-champ/{idCourse}/{idChampionnat}")
    public String affecterCourseAChampionnat(@PathVariable Long idCourse,@PathVariable Long idChampionnat) {
        return courseservice.affecterCourseAChampionnat(idCourse,idChampionnat);
    }
}
