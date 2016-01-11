NameEnum = {
    FORM: 'registration',
    LASTNAME:   'lastName',
    FIRSTNAME:  'firstName',
    PATRONYMIC: 'patronymic',
    DATEBIRTH:  'dateBirth',
    CHECKBOX: 'checkBoxView',
    PHONENUM: 'phoneNumber',
    FLAGPHONE: 'flagPhone',
    ADDRESS: 'address',
    VIEWMAIL: 'viewMail',
    IDVIEWPHONE: 'viewPhone',
    IDVIEWMAIL: 'mview',
    IDLAST:  'lname',
    IDFIRST: 'fname',
    IDPATR:  'patr',
    IDDATE:  'date',
    IDPHONE: 'phone',
    IDADDRESS: 'addr',
    IDMAIL: 'mail',
    MAIL: 'email'
}

Messages = {
    ONE: "Must be filled",
    TWO: "Select one type"
}

function getValue(nameInput) {
    nameForm = NameEnum.FORM;
    return document.forms[nameForm][nameInput].value;
}

function printWarning(id){
    document.getElementById(id).innerHTML=Messages.ONE;
}

function validateLine(){
    var counter = false;
    var ln = getValue(NameEnum.LASTNAME);
    var fn = getValue(NameEnum.FIRSTNAME);
    var pr = getValue(NameEnum.PATRONYMIC);
    var db = getValue(NameEnum.DATEBIRTH);

    var numPhone = getValue(NameEnum.DATEBIRTH);
    var address = getValue(NameEnum.ADDRESS);
    var email = getValue(NameEnum.MAIL);

    if (ln.length==0){
        printWarning(NameEnum.IDLAST);
        counter = true;
    }
    if (fn.length==0){
        printWarning(NameEnum.IDFIRST);
        counter = true;
    }
    if (pr.length==0){
        printWarning(NameEnum.IDPATR);
        counter = true;
    }
    if (db.length==0){
        printWarning(NameEnum.IDDATE);
        counter = true;
    }
    if (numPhone.length==0){
        printWarning(NameEnum.IDPHONE);
        counter = true;
    }
    if (address.length==0){
        printWarning(NameEnum.IDADDRESS);
        counter = true;
    }
    if (email.length==0){
        printWarning(NameEnum.IDMAIL);
        counter = true;
    }
    return counter;
}

function validateCheckBox(){
    var gr = document.getElementsByName(NameEnum.CHECKBOX);
    var index = 0;
    for(var i=0; i<gr.length; i++){
        if (gr[i].checked) { index++; }
    }
    if((index > 1)||(index==0)){
        document.getElementById(NameEnum.IDVIEWPHONE).innerHTML=Messages.TWO;
        return true;
    }
    return false;
}

function validateCheckBoxMail(){
    var gr = document.getElementsByName(NameEnum.VIEWMAIL);
    var index = 0;
    for(var i=0; i<gr.length; i++){
        if (gr[i].checked) { index++; }
    }
    if((index > 1)||(index==0)){
        document.getElementById(NameEnum.IDVIEWMAIL).innerHTML=Messages.TWO;
        return true;
    }
    return false;
}

function validate(){
    var counter = true;

    if(validateLine()){ counter = false; }

    if(validateCheckBox()){ counter = false; }

    if(validateCheckBoxMail()){  counter = false; }

    return counter;
}
