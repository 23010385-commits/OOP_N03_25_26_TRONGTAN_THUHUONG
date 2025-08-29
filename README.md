Project – Ứng dụng Quản lý Học Guitar 🎸

Yêu cầu chính

Giao diện: Java Spring Boot (REST API hoặc Web).

Chức năng: Quản lý học viên, khóa học guitar, bài học.

Dữ liệu: Quản lý trong bộ nhớ bằng Collection (ArrayList, Map, …).

Lưu trữ: Ghi & đọc từ file nhị phân (ObjectOutputStream / ObjectInputStream).
Bạn đã gửi
Chức năng chi tiết
1. Quản lý Học viên

Thêm, sửa, xóa học viên.

Liệt kê danh sách học viên.

Lọc học viên theo level (Beginner, Intermediate, Advanced).

Xem tiến độ học tập (các bài học đã hoàn thành).

2. Quản lý Khóa học Guitar

Thêm, sửa, xóa khóa học.

Mỗi khóa học có danh sách bài học (Lesson).

Xem nội dung khóa học.

3. Quản lý Bài học (Lesson)

Thêm, sửa, xóa bài học.

Bài học có: lessonId, title, duration, levelRequired.

Có thể lọc bài học theo độ khó hoặc thời lượng.

4. Gán học viên vào khóa học

Mỗi học viên có thể tham gia nhiều khóa học.

Mỗi khóa học có nhiều học viên.

Học viên được gán vào khóa học phù hợp với level.

5. Quản lý Giáo viên (tùy chọn thêm)

Thêm, sửa, xóa giáo viên.

Gán giáo viên vào khóa học.

6. Lưu trữ dữ liệu

Toàn bộ dữ liệu (học viên, khóa học, bài học, giáo viên) được lưu xuống file nhị phân.

Có chức năng backup và restore dữ liệu.

1.1 UML Class Diagram

<img width="1321" height="444" alt="Hoc_guitar-Trang-2 drawio" src="https://github.com/user-attachments/assets/978ac908-2930-475b-9ddd-966c1321e6a8" />

1.2 UML Sequence Diagram

![0c1bc6a7-45ed-4a82-b1bb-fae5ae85b6ad](https://github.com/user-attachments/assets/bb52c924-c9e0-41f9-ae7b-99e6de1f1b4f)

1.3 UML Sequence Diagram

![c380c7c8-989a-4a9b-b3fa-cc0032a6460b](https://github.com/user-attachments/assets/c9175f59-66cb-4a36-8c28-c330d14e82ac)

1.4 UML Sequence Diagram

![5d0403f4-7a53-4126-91e6-95619befe0c9](https://github.com/user-attachments/assets/636f2570-be09-4999-a862-ab07563cc833)

1.5 UML Sequence Diagram

![a4fc2910-f900-411f-952e-8234c6b73b63](https://github.com/user-attachments/assets/f0b7ac22-cc76-4148-bfa9-ca2cfcc93c2c)

