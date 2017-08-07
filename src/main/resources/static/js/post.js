$(document).ready(init);

function init(){
    $('#sidebar-picture').click(home);
    $('#sidebar-picture').hover(shakePicture);

    let pathname = window.location.pathname;
    let content = pathname.split('/');
    var lastContent = content[2];

    requestContent(lastContent);
}

function home(){
    window.location.href = "/";
}

function shakePicture(){
    $('#sidebar-picture').effect('shake',{direction:'right',distance:5,times:3});
}


function requestContent(lastContent){
    let response;
    $.ajax({
        method: 'POST',
        url: '/post-info',
        data: {idString: lastContent}
    }).done(function(data){
        response = data;
        setContent(response);
    })
}

function setContent(content){
    let container = $('#content-margin');
    container.html(function(){
        let monthNames = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
        let postDate = new Date(content.lastMntDate);
        let dateString = postDate.getDate() + ' ' + monthNames[postDate.getMonth()] + ' ' + (postDate.getYear() + 1900);
        return '<div id="date">' + dateString + '</div><div id="title">' + content.title + '</div><div id="post">' + content.content + '</div>';
    })
}
