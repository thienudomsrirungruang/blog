$(document).ready(init);

function init(){

	$('#sidebar-picture').click( change )
	$('#sidebar-picture').hover( shakePicture )

	let pathname = window.location.pathname;
    let content = pathname.split('/');
    var page = content[2];

    requestContent(page);
}


function change() {
   let sidebar = $('#sidebar');

   if (sidebar.width() !== $('body').width())
       sidebar.width('100%');
   else
       sidebar.width('25%');
}

function shakePicture() {
	$( '#sidebar-picture' ).effect('shake',{direction:'right',distance:5,times:3})
}

function requestContent(page){
    let response = '';
    $.ajax({
        method:'POST',
        url:'/content-preview',
        data: {page: page}
    }).done(function(data){
        response = data;
        setContent(response);
    })
}

function setContent( content ){
	let data = $('#content-margin');
	data.html(function(){
		let finalHTML = '';
		let monthNames = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
		for (let i = 0; i < content.length; i++){
			let postDate = new Date(content[i].lastMntDate);
			let dateString = postDate.getDate() + ' ' + monthNames[postDate.getMonth()] + ' ' + (postDate.getYear() + 1900);
			finalHTML += ('<div class="article-container"><div class="title-preview">' + content[i].title + '</div><div class="content-preview">' + content[i].content + '</div><div class="date-preview">' + dateString + '</div></div><div class=horizontal-line></div>')

		}
		return finalHTML;
	})
}
