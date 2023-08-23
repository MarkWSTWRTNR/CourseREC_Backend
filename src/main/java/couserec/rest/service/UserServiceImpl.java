package couserec.rest.service;

import couserec.rest.entity.FinishedGroupCourse;
import couserec.rest.entity.User;
import couserec.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FinishedGroupCourseService finishedGroupCourseService;
    @Override
    public List<FinishedGroupCourse> getCompletedCoursesByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            return user.getFinishedGroupCourses();
        }
        return null;
    }
    @Override
    public FinishedGroupCourse saveCompletedCourse(String username, FinishedGroupCourse finishedGroupCourse) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            FinishedGroupCourse savedCourse = finishedGroupCourseService.saveFinishedGroupCourse(finishedGroupCourse);
            if (!savedCourse.getUsers().contains(user)) {
                user.getFinishedGroupCourses().add(savedCourse);
                savedCourse.getUsers().add(user);
                userRepository.save(user);
            }
            return savedCourse;
        }
        return null;
    }


    @Override
    public FinishedGroupCourse updateCompletedCourse(String username, int groupId, FinishedGroupCourse finishedGroupCourse) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            FinishedGroupCourse updatedCourse = finishedGroupCourseService.updateFinishedGroupCourse(finishedGroupCourse);
            if (!updatedCourse.getUsers().contains(user)) {
                user.getFinishedGroupCourses().removeIf(course -> course.getId() == groupId);
                user.getFinishedGroupCourses().add(updatedCourse);
                updatedCourse.getUsers().add(user);
                userRepository.save(user);
            }
            return updatedCourse;
        }
        return null;
    }

    @Override
    public String deleteCompletedCourse(String username, int groupId) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            FinishedGroupCourse existingCourse = user.getFinishedGroupCourses().stream()
                    .filter(course -> course.getId() == groupId)
                    .findFirst()
                    .orElse(null);
            if (existingCourse != null) {
                user.getFinishedGroupCourses().remove(existingCourse);
                existingCourse.getUsers().remove(user);
                userRepository.save(user);
                return finishedGroupCourseService.deleteFinishedGroupCourse(groupId);
            }
        }
        return null;
    }
}
