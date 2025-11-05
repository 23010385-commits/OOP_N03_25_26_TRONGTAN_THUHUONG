document.addEventListener('DOMContentLoaded', function () {
  let currentStep = 1;
  const totalSteps = 3;
  const form = document.getElementById('registerForm');
  const errorAlert = document.getElementById('error-alert');
  const successMessage = document.getElementById('success-message');

  // navigation
  window.nextStep = function () {
    if (validateStep(currentStep)) {
      if (currentStep < totalSteps) {
        updateSummary();
        currentStep++;
        updateUI();
      }
    }
  };

  window.prevStep = function () {
    if (currentStep > 1) {
      currentStep--;
      updateUI();
    }
  };

  function updateUI() {
    for (let i = 1; i <= totalSteps; i++) {
      const sec = document.getElementById(`section-${i}`);
      const stepEl = document.getElementById(`step-${i}`);
      if (sec) sec.classList.remove('active');
      if (stepEl) stepEl.classList.remove('active', 'completed');
    }
    const currentSec = document.getElementById(`section-${currentStep}`);
    const currentStepEl = document.getElementById(`step-${currentStep}`);
    if (currentSec) currentSec.classList.add('active');
    if (currentStepEl) currentStepEl.classList.add('active');
    // mark completed
    for (let i = 1; i < currentStep; i++) {
      const s = document.getElementById(`step-${i}`);
      if (s) s.classList.add('completed');
    }
    // progress
    const progress = (currentStep / totalSteps) * 100;
    const fill = document.getElementById('progress-fill');
    if (fill) fill.style.width = progress + '%';
    const currentStepLabel = document.getElementById('current-step');
    if (currentStepLabel) currentStepLabel.textContent = currentStep;
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }

  function validateStep(step) {
    clearErrors();
    let valid = true;
    if (step === 1) {
      const fullname = getVal('fullname');
      const email = getVal('email');
      const phone = getVal('phone');
      const dob = getVal('dob');
      const gender = getVal('gender');

      if (!fullname || fullname.length < 2) { showError('fullname', 'Họ tên phải ít nhất 2 ký tự'); valid = false; }
      const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      if (!emailRegex.test(email)) { showError('email', 'Email không hợp lệ'); valid = false; }
      const phoneRegex = /^0\d{9}$/;
      if (!phoneRegex.test(phone)) { showError('phone', 'Số điện thoại phải là 10 chữ số bắt đầu bằng 0'); valid = false; }
      if (!dob) { showError('dob', 'Vui lòng chọn ngày sinh'); valid = false; }
      else {
        const age = new Date().getFullYear() - new Date(dob).getFullYear();
        if (age < 13) { showError('dob', 'Bạn phải ít nhất 13 tuổi'); valid = false; }
      }
      if (!gender) { showError('gender', 'Vui lòng chọn giới tính'); valid = false; }
    } else if (step === 2) {
      const password = getVal('password');
      const confirm = getVal('confirm-password');
      if (!password || password.length < 8) { showError('password', 'Mật khẩu phải ít nhất 8 ký tự'); valid = false; }
      if (!isPasswordStrong(password)) { showError('password', 'Mật khẩu phải chứa chữ hoa, chữ thường, số và ký tự đặc biệt'); valid = false; }
      if (password !== confirm) { showError('confirm-password', 'Mật khẩu không khớp'); valid = false; }
    } else if (step === 3) {
      const terms = document.getElementById('terms');
      if (!terms || !terms.checked) { showAlert('Vui lòng đồng ý với Điều khoản sử dụng và Chính sách bảo mật'); valid = false; }
    }
    return valid;
  }

  function getVal(id) {
    const el = document.getElementById(id);
    return el ? el.value.trim() : '';
  }

  function showError(fieldId, message) {
    const input = document.getElementById(fieldId);
    if (input) input.classList.add('input-error');
    const err = document.getElementById(`${fieldId}-error`);
    if (err) { err.textContent = message; err.classList.add('show'); }
  }

  function clearErrors() {
    document.querySelectorAll('.error-message').forEach(e => { e.textContent = ''; e.classList.remove('show'); });
    document.querySelectorAll('.input-error').forEach(i => i.classList.remove('input-error'));
    if (errorAlert) { errorAlert.textContent = ''; errorAlert.classList.remove('show'); }
  }

  function showAlert(msg) {
    if (errorAlert) { errorAlert.textContent = msg; errorAlert.classList.add('show'); }
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }

  function updateSummary() {
    const fmtDate = (d) => { if (!d) return '-'; const dt = new Date(d); return dt.toLocaleDateString(); };
    const name = getVal('fullname') || '-';
    document.getElementById('summary-name').textContent = name;
    document.getElementById('summary-email').textContent = getVal('email') || '-';
    document.getElementById('summary-phone').textContent = getVal('phone') || '-';
    document.getElementById('summary-dob').textContent = fmtDate(getVal('dob'));
    const genderSelect = document.getElementById('gender');
    if (genderSelect) {
      const genderText = genderSelect.options[genderSelect.selectedIndex]?.text || '-';
      document.getElementById('summary-gender').textContent = genderText;
    }
  }

  // password helpers
  window.togglePassword = function (id) {
    const el = document.getElementById(id);
    if (!el) return;
    el.type = el.type === 'password' ? 'text' : 'password';
  };

  function isPasswordStrong(pw) {
    const hasUpper = /[A-Z]/.test(pw);
    const hasLower = /[a-z]/.test(pw);
    const hasNum = /[0-9]/.test(pw);
    const hasSpec = /[!@#\$%\^&\*\(\)\-_=\+\[\]\{\};:'",.<>\/\?\\|`~]/.test(pw);
    return pw.length >= 8 && hasUpper && hasLower && hasNum && hasSpec;
  }

  function calculatePasswordStrength(pw) {
    let score = 0;
    if (pw.length >= 8) score++;
    if (/[A-Z]/.test(pw)) score++;
    if (/[0-9]/.test(pw)) score++;
    if (/[^A-Za-z0-9]/.test(pw)) score++;
    return score; // 0..4
  }

  window.checkPasswordStrength = function () {
    const pw = getVal('password');
    const bar = document.getElementById('strength-bar');
    const text = document.getElementById('strength-text');
    if (!bar || !text) return;
    if (!pw) {
      bar.className = 'password-strength-bar';
      text.textContent = '';
      return;
    }
    const score = calculatePasswordStrength(pw);
    if (score <= 1) { bar.className = 'password-strength-bar weak'; text.textContent = 'Yếu'; }
    else if (score === 2 || score === 3) { bar.className = 'password-strength-bar medium'; text.textContent = 'Trung bình'; }
    else { bar.className = 'password-strength-bar strong'; text.textContent = 'Mạnh'; }
  };

  // form submit
  if (form) {
    form.addEventListener('submit', function (ev) {
      ev.preventDefault();
      clearErrors();
      if (!validateStep(1) || !validateStep(2) || !validateStep(3)) {
        showAlert('Vui lòng sửa các lỗi trước khi gửi.');
        return;
      }
      // simulate submit (replace with actual fetch to server endpoint)
      successMessage.textContent = 'Đăng ký thành công! Vui lòng kiểm tra email để xác nhận.';
      successMessage.classList.add('show');
      form.reset();
      // go to first step
      currentStep = 1;
      updateUI();
    });
  }

  // init
  updateUI();
});