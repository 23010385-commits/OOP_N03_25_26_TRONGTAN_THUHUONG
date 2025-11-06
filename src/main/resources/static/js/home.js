document.addEventListener('DOMContentLoaded', function () {
  // Mobile menu
  const menuButton = document.getElementById('mobile-menu-button');
  const mobileMenu = document.getElementById('mobile-menu');
  if (menuButton && mobileMenu) {
    menuButton.addEventListener('click', () => mobileMenu.classList.toggle('hidden'));
  }

  // Carousel
  const slides = document.querySelectorAll('.carousel-slide');
  const dots = document.querySelectorAll('.carousel-dot');
  const prevButton = document.getElementById('prev-slide');
  const nextButton = document.getElementById('next-slide');
  if (!slides.length) return;

  let currentSlide = 0;
  const slideInterval = 5000;
  let autoSlideTimer;

  function goToSlide(n) {
    slides[currentSlide].classList.remove('opacity-100'); slides[currentSlide].classList.add('opacity-0');
    dots[currentSlide].classList.remove('bg-white'); dots[currentSlide].classList.add('bg-white/50');
    currentSlide = (n + slides.length) % slides.length;
    slides[currentSlide].classList.remove('opacity-0'); slides[currentSlide].classList.add('opacity-100');
    dots[currentSlide].classList.remove('bg-white/50'); dots[currentSlide].classList.add('bg-white');
  }
  function nextSlide(){ goToSlide(currentSlide + 1) }
  function prevSlide(){ goToSlide(currentSlide - 1) }
  function startAutoSlide(){ autoSlideTimer = setInterval(nextSlide, slideInterval) }
  function stopAutoSlide(){ clearInterval(autoSlideTimer) }

  if (nextButton) nextButton.addEventListener('click', ()=>{ nextSlide(); stopAutoSlide(); startAutoSlide(); });
  if (prevButton) prevButton.addEventListener('click', ()=>{ prevSlide(); stopAutoSlide(); startAutoSlide(); });
  dots.forEach((dot, index)=> dot.addEventListener('click', ()=>{ goToSlide(index); stopAutoSlide(); startAutoSlide(); }));

  goToSlide(0);
  startAutoSlide();
});