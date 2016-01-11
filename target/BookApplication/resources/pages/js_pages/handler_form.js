
Id = {
    LASTNAME: 'last',
    FIRSTNAME: 'first',
    PATRONYMIC: 'patronymic',
    DATE: 'dateBirth',
    PHONE: 'idPhone',
    ADDRESS: 'address',
    EMAIL: 'email',
    PHFLAG: 'phflag',
    EMFLAG: 'emflag',
    CHECK1: "ph1",
    CHECK2: 'ph2',
    CHECK3: 'ph3',
    VIEW1: 'v1',
    VIEW2: 'v2'
}

Param = {
    ID : "id",
    LASTNAME : "lastname",
    FIRSTNAME : "firstname",
    PATRONYMIC : "patronymic",
    DATE : "dateBirth",
    ADDRESS : "address",
    MAIL : "mail",
    PHONE : "phone",
    VIEW : "view",
    FLAG : "flag",
    WORKING : "working",
    MOBILE : "mobile",
    HOME : "home",
    DEFAULT : "default",
    NODEFAULT : "no_default"
}

function fillForm(array){
    var line = array.replace("[","");
    line = line.replace("]","");

    user = JSON.parse(line);

    setName(Id.LASTNAME, user.lastname);
    setName(Id.FIRSTNAME, user.firstname);
    setName(Id.PATRONYMIC, user.patronymic);
    setName(Id.DATE, user.dateBirth);
    setName(Id.PHONE, user.phone);
    setName(Id.ADDRESS, user.address);
    setName(Id.EMAIL, user.mail);

    if(user.phone_view == Param.WORKING){ setCheckBox(Id.CHECK1); }
    if(user.phone_view == Param.HOME){ setCheckBox(Id.CHECK2); }
    if(user.phone_view == Param.MOBILE){ setCheckBox(Id.CHECK3); }

    if(user.mail_view == Param.WORKING){ setCheckBox(Id.VIEW1); }
    else { setCheckBox(Id.VIEW2); }

    if(user.phone_flag == Param.DEFAULT){ setCheckBox(Id.PHFLAG); }
    else { setCheckBox(Id.EMFLAG); }
}

function setName(id, name){
    document.getElementById(id).value = name;
}

function setCheckBox(id){
    document.getElementById(id).checked='true';
}
