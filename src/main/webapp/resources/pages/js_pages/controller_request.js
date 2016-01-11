
Url = {
    GET_ID:  '/BookApplication/api/control/all/',
    GET_ALL: '/BookApplication/api/control/all',
    POST_CREATE: '/BookApplication/api/control/create',
    POST_SAVE:   '/BookApplication/api/control/save'
}

Req = { GET:'GET', POST:'POST' }

/* GET */
function getAllContacts(){
    var xhr = new XMLHttpRequest();
    xhr.open(Req.GET, Url.GET_ALL, false);
    xhr.send();
    if (xhr.status != 200) {
        alert( xhr.status + ': ' + xhr.statusText );
    } else {
        return JSON.parse(xhr.responseText);
    }
}

function getContact(id){
    var url = Url.GET_ID+id;
    var req = new XMLHttpRequest();
    req.open(Req.GET, url, false);
    req.send();
    if (req.status != 200) {
        alert( req.status + ': ' + req.statusText );
    } else {
        return req.responseText;
    }
}

/* POST */
function savePost(user){
    var req = new XMLHttpRequest();
    req.open(Req.POST, Url.POST_SAVE,false);
    req.setRequestHeader("Content-Type", "application/json");
    req.send(user);
}

function createPost(user){
    var req = new XMLHttpRequest();
    req.open(Req.POST, "/BookApplication/api/control/create", false);
    req.setRequestHeader("Content-Type", "application/json");
    req.send(user);
}
