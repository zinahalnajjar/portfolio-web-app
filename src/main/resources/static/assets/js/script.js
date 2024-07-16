document.addEventListener('DOMContentLoaded', () => {
    const modal = document.getElementById('myModal');
    const modalImage = document.getElementById('modalImage');
    const modalContent = document.querySelector('.modal-content');

    window.openModal = (imgElement) => {
        modalImage.src = imgElement.src;
        modal.style.display = 'flex';
    };

    window.closeModal = () => {
        modal.style.display = 'none';
    };

    modal.addEventListener('click', (event) => {
        // Close modal if the click is outside the modal-content
        if (!modalContent.contains(event.target)) {
            closeModal();
        }
    });
});