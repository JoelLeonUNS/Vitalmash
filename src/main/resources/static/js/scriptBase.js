document.addEventListener('DOMContentLoaded', function() {
    const menuHeight = document.querySelector('.navbar').offsetHeight;
    const links = document.querySelectorAll('a[href^="#"]');
    
    links.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            
            const targetId = this.getAttribute('href').slice(1);
            const targetElement = document.getElementById(targetId);
            
            if (targetElement) {
                const targetPosition = targetElement.offsetTop - menuHeight;
                window.scrollTo({
                    top: targetPosition,
                    behavior: 'smooth'
                });
            }
        });
    });
});
