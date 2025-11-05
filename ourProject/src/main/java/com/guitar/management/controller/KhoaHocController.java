package com.guitar.management.controller;

import com.guitar.management.model.KhoaHoc;
import com.guitar.management.service.GiaoVienService;
import com.guitar.management.service.KhoaHocService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/khoahoc")
public class KhoaHocController {

    private final KhoaHocService khoaHocService;
    private final GiaoVienService giaoVienService;

    public KhoaHocController(KhoaHocService khoaHocService, GiaoVienService giaoVienService) {
        this.khoaHocService = khoaHocService;
        this.giaoVienService = giaoVienService;
    }

    @GetMapping("")
    public String listKhoaHoc(@RequestParam(name = "level", required = false) String level, Model model) {
        List<KhoaHoc> listKhoaHoc;
        if (level != null && !level.trim().isEmpty()) {
            listKhoaHoc = khoaHocService.findAllByLevel(level);
        } else {
            listKhoaHoc = khoaHocService.findAll();
        }
        model.addAttribute("listKhoaHoc", listKhoaHoc);
        try {
            Set<Long> enrolled = khoaHocService.getEnrolledCourseIdsForCurrentUser();
            model.addAttribute("enrolledCourseIds", enrolled);
        } catch (Exception ex) {
            // ignore when user not authenticated
        }
        return "khoahoc/list";
    }

    // Pretty URLs for basic/advanced courses
    @GetMapping("/co-ban")
    public String listCoBan(Model model) {
        // reuse the list handler with level=basic
        return listKhoaHoc("basic", model);
    }

    @GetMapping("/nang-cao")
    public String listNangCao(Model model) {
        // reuse the list handler with level=advanced
        return listKhoaHoc("advanced", model);
    }

    @GetMapping("/add")
    @PreAuthorize("hasAnyRole('GIAOVIEN','ADMIN')")
    public String showAddForm(Model model) {
        model.addAttribute("khoaHoc", new KhoaHoc());
        model.addAttribute("listGiaoVien", giaoVienService.findAll());
        model.addAttribute("giaoVienList", giaoVienService.findAll());
        return "khoahoc/add";
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('GIAOVIEN','ADMIN')")
    public String saveKhoaHoc(@ModelAttribute KhoaHoc khoaHoc,
            @RequestParam(name = "giaoVienId", required = false) Long giaoVienId) {
        if (giaoVienId != null) {
            khoaHocService.save(khoaHoc, giaoVienId);
        } else {
            khoaHocService.save(khoaHoc);
        }
        return "redirect:/khoahoc";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAnyRole('GIAOVIEN','ADMIN')")
    public String showEditForm(@PathVariable Long id, Model model) {
        KhoaHoc khoaHoc = khoaHocService.findById(id);
        model.addAttribute("khoaHoc", khoaHoc);
        model.addAttribute("listGiaoVien", giaoVienService.findAll());
        model.addAttribute("giaoVienList", giaoVienService.findAll());
        return "khoahoc/edit";
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('GIAOVIEN','ADMIN')")
    public String updateKhoaHoc(@PathVariable Long id, @ModelAttribute KhoaHoc khoaHoc,
            @RequestParam(name = "giaoVienId", required = false) Long giaoVienId) {
        khoaHoc.setId(id);
        if (giaoVienId != null) {
            khoaHocService.save(khoaHoc, giaoVienId);
        } else {
            khoaHocService.save(khoaHoc);
        }
        return "redirect:/khoahoc";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('GIAOVIEN','ADMIN')")
    public String deleteKhoaHoc(@PathVariable Long id) {
        khoaHocService.deleteById(id);
        return "redirect:/khoahoc";
    }

    @GetMapping("/detail/{id}")
    public String detailKhoaHoc(@PathVariable Long id, Model model) {
        KhoaHoc khoaHoc = khoaHocService.findById(id);
        model.addAttribute("khoaHoc", khoaHoc);
        try {
            Set<Long> enrolled = khoaHocService.getEnrolledCourseIdsForCurrentUser();
            model.addAttribute("isEnrolled", enrolled.contains(id));
        } catch (Exception ex) {
            model.addAttribute("isEnrolled", false);
        }
        return "khoahoc/detail";
    }

    @PostMapping("/{id}/lessons")
    @PreAuthorize("hasAnyRole('GIAOVIEN','ADMIN')")
    public String addLessonToCourse(@PathVariable("id") Long khoaHocId,
            @RequestParam String title,
            @RequestParam(required = false) String noiDung,
            @RequestParam(defaultValue = "1") int thoiLuong,
            RedirectAttributes redirect) {
        try {
            khoaHocService.addLessonToCourse(khoaHocId, title, noiDung, thoiLuong);
            redirect.addFlashAttribute("successMessage", "Thêm bài học thành công");
        } catch (RuntimeException ex) {
            redirect.addFlashAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/khoahoc/detail/" + khoaHocId;
    }

    @PostMapping("/{id}/enroll")
    @PreAuthorize("hasRole('HOCVIEN')")
    public String enrollCurrentStudent(@PathVariable("id") Long khoaHocId, RedirectAttributes redirect) {
        try {
            khoaHocService.enrollCurrentStudentToCourse(khoaHocId);
            redirect.addFlashAttribute("successMessage", "Đăng ký khóa học thành công");
        } catch (RuntimeException ex) {
            redirect.addFlashAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/khoahoc/detail/" + khoaHocId;
    }

    @PostMapping("/{id}/unenroll")
    @PreAuthorize("hasRole('HOCVIEN')")
    public String unenrollCurrentStudent(@PathVariable("id") Long khoaHocId, RedirectAttributes redirect) {
        try {
            khoaHocService.unenrollCurrentStudentFromCourse(khoaHocId);
            redirect.addFlashAttribute("successMessage", "Hủy đăng ký khóa học thành công");
        } catch (RuntimeException ex) {
            redirect.addFlashAttribute("errorMessage", ex.getMessage());
        }
        // After unenrolling we return to the course list per request
        return "redirect:/khoahoc";
    }

}