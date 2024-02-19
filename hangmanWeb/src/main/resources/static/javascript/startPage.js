function toggleSidebar() {
    var sidebar = document.getElementById('sidebar');
    sidebar.style.width = sidebar.style.width === '30%' ? '0' : '30%';
}

function closeSidebar() {
    document.getElementById('sidebar').style.width = '0';
}