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
### 3.3.1. Thêm học viên
<img width="297" height="385" alt="Create" src="https://github.com/user-attachments/assets/b2506286-6e55-4797-8fb2-298c646311f5" />

### 3.3.2. Đọc học viên
<img width="433" height="253" alt="SoWkIImgAStDuUK2itYvh4AAIYiLAaeVxbfQef2Ic9UXK7nuONA6GiR3tRt92cMPXrVbMVDoPQOfQBWW98iUxfwUbswlgL2IaPgdeE5yUBCcBvU2WfL7viFTpNb0qOUxknMKa3IK07LCp4jN0XgLcbESgg3XdN5uIruw5bqbO0c5aaoWmCFTgu5CL9UavgLafe5Sdr_0o-K0v84z0m00" src="https://github.com/user-attachments/assets/5fd10966-87ad-4e56-bb6b-29e78ee3ec01" />

### 3.3.3. Sửa học viên
<img width="445" height="469" alt="RP2n2i8m48RtGjxXS6fVGGSBTL0ABle29Mrjm9vYKy7PKHoTN7GGGNJIoOnvaho9bwXGmUro_t_V_Rcmaib2rkMKUQvYNdjOcETj3eCU54PjEIo5lY1mypmZL4RTaWwPOc7KkWIvI21Di81A7tb1WiZ17-ihAKGvhOZI3QZE4Fn8tmFc0NmNI8ijZTgBpa-xDcedcaBa-cXbIIpzm0b8WM-" src="https://github.com/user-attachments/assets/21c0def4-c361-4803-8856-d3463f58c43e" />

### 3.3.4. Xóa học viên
<img width="461" height="361" alt="SoWkIImgAStDuUK2itYvhFmo7kvQMw3WwQAGyN1tRx92MURXLNaAoGztBSzJg3YyET4QgCOxy-7kvbo5ag94XPJ4l0o5uiCBapE04fbf2XeXXzS0PO26BAq46cAl2MIdvYbeE1_UhCdBfQ1W5G4q0yNeR22dFnFL8A0w3v0TUI2JTdShA85rbMGSNW1Kb7nuIrww4b1LQavngeA6TmQ8hub" src="https://github.com/user-attachments/assets/dd8009d1-1536-4b9e-835c-f1f65886bf3c" />
