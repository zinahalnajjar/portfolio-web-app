document.querySelectorAll('.nav a').forEach(link => {
    link.addEventListener('click', event => {
        if (link.getAttribute('href') === 'upload.html') {
            // Make sure the default behavior is not prevented
            // event.preventDefault(); // Don't prevent default action if not necessary
            window.location.href = 'upload.html';
        }
    });
});