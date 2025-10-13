package ourProject.src.main.java.com.guitar.management.repository;

import java.util.ArrayList;
import java.util.List;
import ourProject.src.main.java.com.guitar.management.model.Lesson;

public class LessonRepository {
    private List<Lesson> lessonList;

    public LessonRepository() {
        this.lessonList = new ArrayList<>();
    }

    // Create
    public void addLesson(Lesson lesson) {
        lessonList.add(lesson);
    }

    // Read
    public Lesson getLessonById(int id) {
        for (Lesson lesson : lessonList) {
            if (lesson.getLessonID() == id) {
                return lesson;
            }
        }
        return null;
    }

    // Update
    public boolean updateLesson(int id, Lesson updatedLesson) {
        for (int i = 0; i < lessonList.size(); i++) {
            if (lessonList.get(i).getLessonID() == id) {
                lessonList.set(i, updatedLesson);
                return true;
            }
        }
        return false;
    }

    // Delete
    public boolean deleteLesson(int id) {
        return lessonList.removeIf(lesson -> lesson.getLessonID() == id);
    }

    // Get all Lessons
    public List<Lesson> getAllLessons() {
        return new ArrayList<>(lessonList);
    }
}
