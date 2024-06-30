function openModal(element) {
    var modal = document.getElementById("myModal");
    var modalImg = document.getElementById("modalImage");
    modal.style.display = "block";
    modalImg.src = element.src;
}

function closeModal() {
    var modal = document.getElementById("myModal");
    modal.style.display = "none";
}