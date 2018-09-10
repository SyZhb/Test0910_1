function quiz(){
    document.getElementById("Modal-wrapper").style.display = "block";
}

function hideModel(){
    document.getElementById("Modal-wrapper").style.display = "none";
}
function logout(){
    window.location.href="login.html"
}
function modify(){
    //去除元素readonly和disabled 属性
    var fildtext = document.getElementsByClassName("fildtext");
    for(var i=0;i<fildtext.length;i++){
        fildtext[i].removeAttribute("readonly");
        fildtext[i].removeAttribute("disabled");
        fildtext[i].className +=" add-border";
    }

    var radios = document.getElementsByTagName("input");
    for(var a=0;a<radios.length;a++){
        radios[a].removeAttribute("disabled");
    }
    //显示保存按钮
    document.getElementById("save").removeAttribute("hidden");
}

function save(){
    var city = document.getElementById("city");
    var birthday = document.getElementById("birthday");
    var job = document.getElementById("job");
    var email = document.getElementById("email");
    var phone = document.getElementById("phone");
    var education = document.getElementById("education");
    var introduce = document.getElementById("introduce");

    //邮箱验证正则
    var emailReg = new RegExp("([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})");
    //手机号验证正则
    var phoneReg = /^1[34578]\d{9}$/;

    if(!city.value){
        alert("请选择居住地");
        city.focus();
        return;
    }
    if(!birthday.value){
        alert("请输入出生日期");
        birthday.focus();
        return;
    }
    if(!job.value){
        alert("请输入所在行业");
        birthday.focus();
        return;
    }
    if(!email.value){
        alert("请输入邮箱");
        email.focus();
        return;
    }
    if(!phone.value){
        alert("请输入电话");
        phone.focus();
        return;
    }
    if(!education.value){
        alert("请输入教育经历");
        education.focus();
        return;
    }
    if(!introduce.value){
        alert("请输入个人简介");
        introduce.focus();
        return;
    }
    if(!emailReg.test(email.value)){
        alert("邮箱格式不正确");
        return;
    }
    if(!phoneReg.test(phone.value)){
        alert("手机格式不正确");
        return;
    }

    //输入域只读
    var fildtext = document.getElementsByClassName("fildtext");
    for(var i=0;i<fildtext.length;i++){
        fildtext[i].setAttribute("readonly","readonly");
        fildtext[i].className =fildtext[i].className.replace(" add-border","");
    }

    //禁用下拉列表
    var select = document.getElementsByClassName("select");
    for(var b=0;b<select.length;b++){
        select[b].setAttribute("disabled","disabled");
    }
    //禁用单选按钮
    var radios = document.getElementsByTagName("input");
    for(var a=0;a<radios.length;a++){
        if(radios[a].type=="radio"){
            radios[a].setAttribute("disabled","disabled");
        }
    }

    //隐藏保存按钮
    document.getElementById("save").setAttribute("hidden","hidden");
}
