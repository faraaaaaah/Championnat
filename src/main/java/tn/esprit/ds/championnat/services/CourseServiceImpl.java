package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Championnat;
import tn.esprit.ds.championnat.entities.Course;
import tn.esprit.ds.championnat.repositories.ChampionnatRepository;
import tn.esprit.ds.championnat.repositories.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements ICourseService{
    private CourseRepository courseRepository;
    private ChampionnatRepository championnatRepository;
    @Override
    public Course ajouterCourse(Course course)
    {
        return courseRepository.save(course);
    }

    @Override
    public String affecterCourseAChampionnat(Long idCourse,Long idChampionnat){
        Course c=courseRepository.findById(idCourse).get();
        Championnat ch =championnatRepository.findById(idChampionnat).get();
        List<Course> courses=new ArrayList<>();
        if (ch.getCourses()!=null){
            courses=ch.getCourses();
        }
        courses.add(c);
        ch.setCourses(courses);
        championnatRepository.save(ch);
        return "course affectée";
    }
}
