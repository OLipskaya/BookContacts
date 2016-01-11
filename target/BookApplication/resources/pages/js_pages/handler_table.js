
function fillTable(array){
    var i;
    for(i = 0; i < array.length; i++){
        createRow(array[i]);
    }
}

function createRow(user){
    var url = 'form_save.html?id='+user.id;
    row = document.all.contacts.insertRow();
    cell=row.insertCell(0);
    cell.innerText=user.id;
    cell=row.insertCell(1);
    cell.innerText=user.firstname;
    cell=row.insertCell(2);
    cell.innerText=user.lastname;
    cell=row.insertCell(3);
    cell.innerText=user.patronymic;
    cell=row.insertCell(4);
    cell.innerText=user.phone;
    cell=row.insertCell(5);
    cell.innerText=user.address;
    cell=row.insertCell(6);
    cell.innerText=user.mail;
    cell=row.insertCell(7);
    cell.innerHTML="<a class='btn  btn-link' href=" + url +" role='button'>Edit</a>";
}

function fillView(array){
    var i;
    for(i = 0; i < array.length; i++){
        create(array[i]);
    }
}

function create(user){
    row = document.all.contacts.insertRow();
    cell=row.insertCell(0);
    cell.innerText=user.id;
    cell=row.insertCell(1);
    cell.innerText=user.firstname;
    cell=row.insertCell(2);
    cell.innerText=user.lastname;
    cell=row.insertCell(3);
    cell.innerText=user.patronymic;
    cell=row.insertCell(4);
    cell.innerText=user.phone;
    cell=row.insertCell(5);
    cell.innerText=user.address;
    cell=row.insertCell(6);
    cell.innerText=user.mail;
}