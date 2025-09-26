package Repository;

import java.util.ArrayList;
import java.util.List;

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
            if (lesson.getId() == id) {
                return lesson;
            }
        }
        return null;
    }

    // Update
    public void updateLesson(Lesson updatedLesson) {
        for (int i = 0; i < lessonList.size(); i++) {
            if (lessonList.get(i).getId() == updatedLesson.getId()) {
                lessonList.set(i, updatedLesson);
                return;
            }
        }
    }

    // Delete
    public void deleteLesson(int id) {
        lessonList.removeIf(lesson -> lesson.getId() == id);
    }

    // Get all Lessons
    public List<Lesson> getAllLessons() {
        return new ArrayList<>(lessonList);
    }
}

class Lesson {
    private int id;
    // other fields, constructors, and methods

    public int getId() {
        return id;
    }

    // Optionally, add a setter if needed
    public void setId(int id) {
        this.id = id;
    }
}
