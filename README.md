# Project – Ứng dụng Quản lý khóa học Guitar 🎸

# 1. Thành viên dự án
1. Trần Thị Thu Hường - 23010344
2. Nguyễn Trọng Tấn - 23010385
---

# 1.1. Yêu cầu chính
- Giao diện: Java Spring Boot.
- Chức năng quản lý: Quản lý học viên, giáo viên, bài học, khóa học, tiến trình học tập.

# 1.2. Chức năng chính của hệ thống
## Quản lý học viên
- Thêm, sửa, xóa học viên.
- Liệt kê danh sách học viên, tìm kiếm học viên theo tên, level, hoặc khóa học.

## Quản lý giáo viên
- Thêm, sửa, xóa giáo viên.
- Liệt kê, tìm kiếm giáo viên theo chuyên môn.

## Quản lý bài học (Lesson)
- Thêm, sửa, xóa bài học.
- Liệt kê các bài học, lọc theo cấp độ (Basic, Advanced).

## Quản lý khóa học (Course)
- Thêm, sửa, xóa khóa học.
- Gán học viên vào khóa học.
- Gán giáo viên vào khóa học.
- Thêm bài học vào khóa học.
- Liệt kê khóa học và chi tiết liên quan.

## Quản lý tiến trình học tập
- Theo dõi trạng thái học của học viên (đã học, đang học).
- Đánh giá và nhận xét kết quả học tập.
- Thống kê báo cáo tiến trình theo học viên hoặc theo khóa học.

## Lưu trữ dữ liệu
- Dữ liệu được lưu trữ dưới dạng file nhị phân để đảm bảo tính bền vững và khôi phục khi khởi động lại hệ thống.
+ Sau mỗi thao tác thêm, sửa, xóa, dữ liệu được ghi xuống file nhị phân.
+ Khi ứng dụng khởi động, dữ liệu được đọc từ file và nạp vào bộ nhớ.
+ Trong bộ nhớ, dữ liệu được quản lý bằng các Collection như ArrayList, LinkedList, HashMap.
+ Đảm bảo tránh trùng lặp và mất mát dữ liệu khi ghi/đọc file.
# 2. Objects (Đối tượng)
## 2.1. Học viên
## 2.2. Giáo viên
## 2.3. Khóa học
## 2.4. Bài học

# 3. Sơ đồ khối
## 3.1 UML Class Diagram

<img width="1321" height="444" alt="Hoc_guitar-Trang-2 drawio" src="https://github.com/user-attachments/assets/978ac908-2930-475b-9ddd-966c1321e6a8" />

## 3.2 UML Sequence Diagram
### 3.2.1. Học viên học bài học (Student learns a Lesson)
![0c1bc6a7-45ed-4a82-b1bb-fae5ae85b6ad](https://github.com/user-attachments/assets/bb52c924-c9e0-41f9-ae7b-99e6de1f1b4f)

### 3.2.2. Giáo viên dạy học viên (Teacher teaches Student)

![c380c7c8-989a-4a9b-b3fa-cc0032a6460b](https://github.com/user-attachments/assets/c9175f59-66cb-4a36-8c28-c330d14e82ac)

### 3.2.3. Giáo viên đánh giá học viên (Teacher evaluates Student)

![5d0403f4-7a53-4126-91e6-95619befe0c9](https://github.com/user-attachments/assets/636f2570-be09-4999-a862-ab07563cc833)

### 3.2.4. Học viên tham gia khóa học (Student enrolls in Course)

![a4fc2910-f900-411f-952e-8234c6b73b63](https://github.com/user-attachments/assets/f0b7ac22-cc76-4148-bfa9-ca2cfcc93c2c)

## 3.3 UML Activity Diagram
### 3.3.1. Khóa học
<img width="464" height="1728" alt="nPJ1Qi9048RlWRp3u4d1qhiUgasa0KNQgk1rkwxkq2GRT5OgfU_UcTZ4LepqKEXjTtR-VsU-dMIm8xKbdwLXG4YfWQ4ct2CT84QrsQeCRY1wNiGmjav1udGOX4714YHqEH-DXlCHl8S1GEaaYzu3AWTxD3beoqcjEMyhVQjVfaojAe1CteNC0QakR6fDOJtGLcbRPk8QsdDssG1X3jOLa9g" src="https://github.com/user-attachments/assets/24a5b110-d6bf-4516-b31e-9cdf95fa92a6" />


### 3.3.2. Giáo viên
<img width="477" height="1620" alt="giao vien" src="https://github.com/user-attachments/assets/fc812fc2-844a-4858-a85a-d2218cd6fa41" />


### 3.3.3. Học viên
<img width="466" height="1620" alt="hoc vien" src="https://github.com/user-attachments/assets/63136c2b-bdfd-43eb-bcb3-6d2018133f76" />


### 3.3.4. Bài học
<img width="489" height="1620" alt="bai hoc" src="https://github.com/user-attachments/assets/4d0dc1c3-b013-4460-9e5d-056345dc7ba5" />

