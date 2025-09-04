

public class Lesson {

    private String lessonID;
    private String lessonName;

    Lesson(String id, String name){
        lessonID = id;
        lessonName = name;
    }

    public void setLessonName(String name){
        lessonName = name;
    }

    public String getLessonname(){
        return lessonName;
    }

    public String getID(){
        return lessonID;
    } 

    
}
