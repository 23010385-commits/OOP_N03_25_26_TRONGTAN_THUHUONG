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

<img width="2852" height="3176" alt="image" src="https://github.com/user-attachments/assets/1fc46cca-87ae-4f92-b1ae-2c889a9680ca" />


## 3.2 UML Sequence Diagram
### 3.2.1. Học viên đăng ký khóa

<img width="784" height="462" alt="hocvien_dangky_khoahoc" src="https://github.com/user-attachments/assets/1585dfc8-f5f4-437a-911e-d6c76b1a64ee" />

### 3.2.2. Học viên học bài

<img width="620" height="420" alt="hocvien_hocbai" src="https://github.com/user-attachments/assets/ecef2cd0-acbf-4f18-8c66-077bbaa1f4a2" />

### 3.2.3. Học viên hoàn thành bài học

<img width="650" height="382" alt="hocvien_hoanthanh_baihoc" src="https://github.com/user-attachments/assets/c650650a-b612-4649-84fc-bd42d9fd658c" />

### 3.2.4. Giáo viên đánh giá học viên

<img width="678" height="369" alt="giaovien_danhgia_hocvien" src="https://github.com/user-attachments/assets/e7270a08-9af6-4d98-b532-ff789691e1fb" />

## 3.3 UML Activity Diagram
### 3.3.1. Khóa học
<img width="464" height="1728" alt="nPJ1Qi9048RlWRp3u4d1qhiUgasa0KNQgk1rkwxkq2GRT5OgfU_UcTZ4LepqKEXjTtR-VsU-dMIm8xKbdwLXG4YfWQ4ct2CT84QrsQeCRY1wNiGmjav1udGOX4714YHqEH-DXlCHl8S1GEaaYzu3AWTxD3beoqcjEMyhVQjVfaojAe1CteNC0QakR6fDOJtGLcbRPk8QsdDssG1X3jOLa9g" src="https://github.com/user-attachments/assets/24a5b110-d6bf-4516-b31e-9cdf95fa92a6" />


### 3.3.2. Giáo viên
<img width="477" height="1620" alt="giao vien" src="https://github.com/user-attachments/assets/fc812fc2-844a-4858-a85a-d2218cd6fa41" />


### 3.3.3. Học viên
<img width="466" height="1620" alt="hoc vien" src="https://github.com/user-attachments/assets/63136c2b-bdfd-43eb-bcb3-6d2018133f76" />


### 3.3.4. Bài học
<img width="489" height="1620" alt="bai hoc" src="https://github.com/user-attachments/assets/4d0dc1c3-b013-4460-9e5d-056345dc7ba5" />

