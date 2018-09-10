var flag = true;
function quiz(){
    document.getElementById("Modal-wrapper").style.display = "block";
}

function hideModel(){
    document.getElementById("Modal-wrapper").style.display = "none";
}

function toggle(){

    //获取当前元素下子节点
    var childs = this.children;
    var el = document.getElementById("bian");
    var timer;
    if(flag){
        for(var a in childs){
            //获取子节点className
            var className = childs[a].className;
            if(className&&className.indexOf("icon-angle-down")!=-1){
                childs[a].className = className.replace("icon-angle-down","icon-angle-up");
            }
            if(className&&className.indexOf("view")!=-1){
                childs[a].innerHTML = "收起详细资料";
            }
        }
        //改变元素高度
        timer = setInterval(function(){
            var height = el.offsetHeight;
            el.style.height = height+1+"px";
            if(height>=152){
                clearInterval(timer);
            }
        },1); 
    }else{
        for(var a in childs){
            //获取子节点className
            var className = childs[a].className;
            if(className&&className.indexOf("icon-angle-up")!=-1){
                childs[a].className = className.replace("icon-angle-up","icon-angle-down");
            }
            if(className&&className.indexOf("view")!=-1){
                childs[a].innerHTML = "查看详细资料";
            }
        }
        timer = setInterval(function(){
            var height = el.offsetHeight;
            el.style.height = height-1+"px";
            if(height<=52){
                clearInterval(timer);
            }
        },1);  
    }
    flag = !flag;
}
window.onload = function(){
    var index;
//选择列表元素
var tabs = document.getElementById("tabs").children;
for(var a=0;a<tabs.length;a++){
    //给每个li绑定点击事件
    tabs[a].onclick = function(){
        this.className = "active";
        //缓存选中的li的index
        for(var j in tabs){
            if(tabs[j]==this){
                index = j;
            }
        }
        //修改同胞元素class
        var nextsibling = this.nextElementSibling;
        var presibling = this.previousElementSibling;
        while(nextsibling){
            nextsibling.className="";
            nextsibling = nextsibling.nextElementSibling;
        }
        while(presibling){
            presibling.className="";
            presibling = presibling.previousElementSibling;
        }
        //修改对应index的div的class
        var divContain = document.getElementsByClassName("dongtai");
        console.log(index);
        for(var i in divContain){
            var divs = divContain[i].children;
            if(divs){
                for (var b=0;b<divs.length;b++) {
                    if(b!=index){
                        divs[b].className="";
                    }else{
                        divs[b].className = "selected";
                    }
                }
            } 
        }   
    }
}
}


