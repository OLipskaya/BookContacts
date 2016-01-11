Id = {
    LASTNAME: 'last', FIRSTNAME: 'first', PATRONYMIC: 'patronymic',
    DATE: 'dateBirth', PHONE: 'idPhone', ADDRESS: 'address', EMAIL: 'email',
    PHFLAG: 'phflag', EMFLAG: 'emflag',
    CHECK1: 'ch1', CHECK2: 'ch2', CHECK3: 'ch3',
    PHONE1: 'ph1', PHONE2: 'ph2', PHONE3: 'ph3',
    VIEW1: 'v1', VIEW2: 'v2'
}

Param = {
    ID: 'id', NAME: 'name', SURNAME: 'surname',
    DATE: 'data', PATR: 'patr',
    PHONE: 'phone', ADDR: 'addr', MAIL: 'mail',
    VIEWPHONE: 'view_phone', FLAGPHONE: 'flag_phone',
    VIEWMAIL: 'view_mail', FLAGMAIL: 'flag_mail'
}

Values = {
    WORKING: 'working', HOME: 'home', MOBILE: 'mobile',
    DEFAULT: 'default', NODEFAULT: 'no_default'
}

function createContact(id){
    var name = document.getElementById(Id.LASTNAME).value;
    var surname = document.getElementById(Id.FIRSTNAME).value;
    var patr = document.getElementById(Id.PATRONYMIC).value;
    var data = document.getElementById(Id.DATE).value;
    var addr = document.getElementById(Id.ADDRESS).value;

    //list Phone
    var phone = document.getElementById(Id.PHONE).value;
    var view_phone = checkPhoneView();
    var flag_phone = checkPhoneFlag();

    //list Mail
    var mail = document.getElementById(Id.EMAIL).value;
    var mail_view = checkViewMail();
    var mail_flag = checkFlagMail();

    //id!!
    var CONTACT = {
        id: id,
        lastname: name,
        firstname: surname,
        patronymic: patr,
        dateBirth: data,
        address: addr,
        phones: {
            phone: phone,
            view: view_phone,
            flag: flag_phone
        },
        mailes: {
            mail: mail,
            view: mail_view,
            flag: mail_flag
        }
    }

    var contact = JSON.stringify(CONTACT);
    return contact;
}

function checkPhoneView(){
    var view = Values.WORKING;
    if(document.getElementById(Id.PHONE1).checked){ view = Values.WORKING; }
    if(document.getElementById(Id.PHONE2).checked){ view = Values.HOME; }
    if(document.getElementById(Id.PHONE3).checked){ view = Values.MOBILE; }
    return view;
}

function checkPhoneFlag(){
    var value = Values.NODEFAULT;
    if(document.getElementById(Id.PHFLAG).checked){
        value = Values.DEFAULT;
    }
    return value;
}

function checkViewMail(){
    var view = Values.WORKING;
    if(document.getElementById(Id.VIEW2).checked){
        view = Values.HOME;
    }
    return view;
}

function checkFlagMail(){
    var value = Values.NODEFAULT;
    if(document.getElementById(Id.EMFLAG).checked){
        value = Values.DEFAULT;
    }
    return value;
}