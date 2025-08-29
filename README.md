1. Student đăng ký khóa học (Enroll Course)

Mục tiêu: Sinh viên chọn 1 khóa học và hệ thống ghi nhận đăng ký.

Các bước:

Student chọn khóa học muốn học → gửi yêu cầu enrollCourse(courseId).

CourseService nhận yêu cầu → kiểm tra khóa học có tồn tại không.

CourseService gọi đến Course để lấy thông tin khóa học.

Nếu hợp lệ, CourseService tạo mới Enrollment (ghi nhận sinh viên đã đăng ký).

CourseService trả kết quả cho Student: “Đăng ký thành công”.

2. Teacher thêm bài học vào khóa học (Add Lesson)

Mục tiêu: Giáo viên thêm bài học mới (Lesson) vào 1 Course.

Các bước:

Teacher chọn khóa học cần thêm bài học → gửi yêu cầu addLesson(courseId, lesson).

CourseService kiểm tra giáo viên có quyền dạy khóa học này không.

Nếu hợp lệ, CourseService gọi đến Course để thêm bài học mới.

Course khởi tạo Lesson và lưu vào danh sách bài học.

CourseService trả kết quả cho Teacher: “Thêm bài học thành công”.

3. Student xem tiến trình học (Show Progress)

Mục tiêu: Sinh viên muốn xem mình đã học đến đâu.

Các bước:

Student gửi yêu cầu showProgress(courseId).

CourseService nhận yêu cầu → tìm Enrollment của Student trong Course.

CourseService lấy danh sách Lesson của Course.

Dựa trên thông tin Enrollment (các lesson đã hoàn thành), CourseService tính % tiến trình.

CourseService trả kết quả tiến trình cho Student (ví dụ: “3/5 lessons completed”).

4. Student hoàn thành 1 bài học (Complete Lesson) (tùy chọn thêm cho đẹp báo cáo)

Mục tiêu: Ghi nhận khi Student học xong 1 Lesson.

Các bước:

Student gửi yêu cầu completeLesson(courseId, lessonId).

CourseService nhận yêu cầu → tìm Enrollment tương ứng.

CourseService đánh dấu lesson đó là “completed” trong Enrollment.

Cập nhật tiến trình học.

CourseService trả về thông báo “Bài học đã hoàn thành”.

1.1 UML Class Diagram

<img width="1321" height="444" alt="Hoc_guitar-Trang-2 drawio" src="https://github.com/user-attachments/assets/978ac908-2930-475b-9ddd-966c1321e6a8" />

1.2 UML Sequence Diagram


