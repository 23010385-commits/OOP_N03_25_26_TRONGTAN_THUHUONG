# 🎸 Ứng Dụng Quản Lý Khóa Học Guitar 🎶
## 1. Giới Thiệu Chung

   Dự án Ứng dụng Quản lý Khóa học Guitar là một hệ thống được xây dựng nhằm mục đích tối ưu hóa quy trình quản lý các hoạt động đào tạo tại các trung tâm/lớp học Guitar. Hệ thống giúp quản lý học viên, giáo viên, bài học và khóa học một cách hiệu quả, đồng thời theo dõi tiến trình học tập chi tiết của từng học viên.

  -Mục tiêu chính: Cung cấp một giao diện trực quan và các chức năng quản lý toàn diện để đảm bảo chất lượng giảng dạy và học tập.

  -Công nghệ cốt lõi: Java Spring Boot (cho giao diện) và Kỹ thuật Lập trình Hướng đối tượng (OOP) cho logic nghiệp vụ và quản lý dữ liệu.

## 2. Thành Viên Dự Án
   
   Trần Thị Thu Hường - Mã số: 23010344
   
   Nguyễn Trọng Tấn - Mã số: 23010385

## 3. Thông tin
Link Repo:https://github.com/23010385-commits/OOP_N03_25_26_TRONGTAN_THUHUONG.git

Link Demo:https://youtu.be/eHRudUVIoPw

Link Deploy:**********

## 4. Yêu Cầu và Công Nghệ
Dự án được xây dựng dựa trên nền tảng Java với trọng tâm là Lập trình Hướng đối tượng (OOP) để quản lý logic nghiệp vụ và dữ liệu. Giao diện người dùng sẽ được phát triển bằng Java Spring Boot, cung cấp một môi trường mạnh mẽ để xây dựng các ứng dụng doanh nghiệp. Về mặt quản lý dữ liệu, hệ thống sử dụng Java Collections (như ArrayList, LinkedList, HashMap) để thao tác dữ liệu trong bộ nhớ một cách hiệu quả. Điểm đặc biệt của dự án là cơ chế lưu trữ bền vững: dữ liệu được ghi và đọc thông qua File nhị phân (Binary File). Việc này đảm bảo dữ liệu không bị mất khi ứng dụng tắt và có thể được khôi phục nguyên vẹn khi khởi động lại, duy trì tính bền vững và toàn vẹn của hệ thống.

## 5. Chức Năng Chính Của Hệ Thống
### 5.1. Quản lý Học viên 🧑‍🎓
  CRUD: Thêm, Sửa, Xóa thông tin học viên.

  Tìm kiếm & Lọc: Liệt kê danh sách, tìm kiếm theo tên, cấp độ (level), hoặc khóa học đang tham gia.

### 5.2. Quản lý Giáo viên 👨‍🏫
  CRUD: Thêm, Sửa, Xóa thông tin giáo viên.

  Tìm kiếm & Lọc: Liệt kê và tìm kiếm giáo viên theo chuyên môn giảng dạy.

### 5.3. Quản lý Bài học (Lesson) 📖
  CRUD: Thêm, Sửa, Xóa bài học.

  Lọc: Liệt kê các bài học, lọc theo cấp độ (ví dụ: Basic, Advanced).

### 5.4. Quản lý Khóa học (Course) 📚
  CRUD: Thêm, Sửa, Xóa khóa học.

  Phân bổ:

  Gán học viên vào khóa học.

  Gán giáo viên vào khóa học.

  Thêm bài học vào khóa học (xây dựng giáo trình).

  Chi tiết: Liệt kê khóa học và xem chi tiết các thông tin liên quan (giáo viên, học viên, bài học).

### 5.5. Quản lý Tiến trình Học tập 📈
  Theo dõi: Cập nhật trạng thái học của học viên (ví dụ: Đã học, Đang học, Hoàn thành).

  Đánh giá: Ghi nhận đánh giá và nhận xét kết quả học tập từ giáo viên.

Báo cáo: Thống kê báo cáo tiến trình theo từng học viên hoặc theo khóa học (ví dụ: tỉ lệ hoàn thành, điểm trung bình).
## 6. Cơ Chế Lưu Trữ Dữ Liệu (OOP & I/O)
  Hệ thống được thiết kế để đảm bảo tính bền vững (Persistence) và toàn vẹn (Integrity) của dữ liệu thông qua cơ chế ghi/đọc File nhị phân kết hợp với quản lý dữ liệu trong bộ nhớ:

  In-memory Management: Dữ liệu của các đối tượng (Học viên, Giáo viên, Khóa học,...) được quản lý bằng các Collection của Java như ArrayList, LinkedList, và HashMap.

  Ghi Dữ liệu: Sau mỗi thao tác thêm, sửa, hoặc xóa, dữ liệu sẽ được ghi xuống File nhị phân.

  Khôi phục Dữ liệu: Khi ứng dụng khởi động, dữ liệu sẽ được đọc từ File nhị phân và nạp lại vào các Collection trong bộ nhớ.

  Bảo toàn: Đảm bảo sử dụng kỹ thuật Serializer/Deserializer phù hợp để tránh trùng lặp và mất mát dữ liệu trong quá trình ghi/đọc.

## 7. Hướng Dẫn Cài Đặt và Chạy 🚀
  Clone Repository:

  git clone https://github.com/23010385-commits/OOP_N03_25_26_TRONGTAN_THUHUONG.git
  Yêu cầu: Đảm bảo đã cài đặt JDK (Java Development Kit) phiên bản phù hợp (ví dụ: Java 17+).

  Mở Project: Mở dự án bằng IDE (ví dụ: IntelliJ IDEA hoặc Eclipse).

  Chạy Ứng dụng: Chạy class chính chứa phương thức main() hoặc sử dụng cấu hình Spring Boot để khởi động.

## 8. Hướng Dẫn Sử Dụng (TBD - Chi tiết hơn sau khi hoàn thiện)
  Truy cập: Mở giao diện thông qua Spring Boot (thường là http://localhost:[8080]/ - nếu dùng giao diện web) hoặc cửa sổ ứng dụng Desktop.

  Đăng nhập: (Nếu có) Sử dụng tài khoản mặc định (ví dụ: admin/admin).

  Thao tác: Điều hướng qua các Menu Quản lý Học viên, Quản lý Khóa học,... để thực hiện các chức năng CRUD và theo dõi tiến trình.

# 9. Sơ đồ khối
## 9.1 UML Class Diagram

<img width="921" height="481" alt="diagram_tong" src="https://github.com/user-attachments/assets/fcb371e3-9f6c-4961-b35a-8642e752be27" />



## 9.2 UML Sequence Diagram
### 9.2.1. Người dùng xem khóa học

<img width="712" height="339" alt="user_khoahoc" src="https://github.com/user-attachments/assets/b7d182ea-6847-42bb-b169-ba6de799d991" />


### 9.2.2. Học viên đăng ký khóa học

<img width="1365" height="432" alt="hocvien_dangky" src="https://github.com/user-attachments/assets/f40b5f21-75f8-4d67-944f-10b1cdbabfff" />


### 9.2.3. Giáo viên,Admin xóa khóa học

<img width="1118" height="374" alt="giaovien_khoahoc" src="https://github.com/user-attachments/assets/da1b28f3-f137-41ae-9029-1291886a86d6" />


### 9.2.4. Giáo viên xem chi tiết khóa học

<img width="1256" height="397" alt="giaovien_detail_khoahoc" src="https://github.com/user-attachments/assets/8332cf9b-7328-4aac-8b2b-95faede31447" />

## 9.3 UML Activity Diagram
### 9.3.1. Khóa học
<img width="1036" height="453" alt="CRUD_khoahoc" src="https://github.com/user-attachments/assets/4125071c-a4ac-4bc7-9709-02d5d4e6dbd7" />


### 9.3.2. Giáo viên
<img width="1038" height="453" alt="CRUD_giaovien" src="https://github.com/user-attachments/assets/5a41e8ac-2fdc-4ddd-b50f-ec9256293e6b" />


### 9.3.3. Học viên
<img width="1029" height="453" alt="CRUD_hocvien" src="https://github.com/user-attachments/assets/47b67623-510b-4484-b13e-3d29398af77e" />


### 9.3.4. Bài học
<img width="1013" height="453" alt="CRUD_lesson" src="https://github.com/user-attachments/assets/fe337b40-38a1-4a95-8c0a-05c6e9271a50" />

