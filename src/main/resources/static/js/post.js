$(document).ready(init);

function init(){
    $('#sidebar-picture').click(home);
    $('#sidebar-picture').hover(shakePicture);

    requestContent();
}

function home(){
    window.location.href = "/../..";
}

function shakePicture(){
    $('#sidebar-picture').effect('shake',{direction:'right',distance:5,times:3});
}


function requestContent(){
    
}
