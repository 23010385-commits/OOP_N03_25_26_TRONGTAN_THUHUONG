// Minimal helpers used by login page
document.addEventListener('DOMContentLoaded', function () {
  window.togglePassword = function (id) {
    const el = document.getElementById(id);
    if (!el) return;
    el.type = el.type === 'password' ? 'text' : 'password';
  };

  const form = document.getElementById('loginForm');
  const err = document.getElementById('login-error');
  if (form) {
    form.addEventListener('submit', function (e) {
      // client-side basic validation
      const u = document.getElementById('username').value.trim();
      const p = document.getElementById('password').value.trim();
      if (!u || !p) {
        e.preventDefault();
        if (err) { err.textContent = 'Vui lòng nhập tên đăng nhập và mật khẩu.'; err.classList.add('show'); err.style.display = 'block'; }
      }
    });
  }
});