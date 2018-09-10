window.onload = function(){
    function quiz(){
        document.getElementById("Modal-wrapper").style.display = "block";
    }

    function hideModel(){
        document.getElementById("Modal-wrapper").style.display = "none";
    }

    var flag = true;
    var toggle = document.getElementsByClassName("toggle-expand");
    for(var a in toggle){
        if(toggle[a]){
            toggle[a].onclick = function(e){
                e.preventDefault();
                if(flag){
                    this.innerHTML = "收起全部";
                    this.previousElementSibling.style.height = "auto";
                }else{
                    this.innerHTML = "显示全部";
                    this.previousElementSibling.style.height = "80px";
                }
                flag = !flag;
            }
        }
    }

    var topicList = document.getElementById("topic").children;
    for(var a = 0;a<topicList.length;a++){
        topicList[a].firstChild.onclick = function(e){

            //禁用a标签默认行为
            e.preventDefault();
            //修改当前a标签class
            this.className = "actived";
            //当前元素父节点
            var parent = this.parentNode;
            //对应div显示
            var id = this.getAttribute("href");
            document.getElementById(id).removeAttribute("hidden");
            //修改同胞元素下a标签class
            var nextsibling = parent.nextElementSibling;
            var presibling = parent.previousElementSibling;
            while(nextsibling){
                nextsibling.firstChild.className="";
                //隐藏非对应div
                document.getElementById(nextsibling.firstChild.getAttribute("href")).setAttribute("hidden","hidden");
                nextsibling = nextsibling.nextElementSibling;
            }
            while(presibling){
                //隐藏非对应div
                presibling.firstChild.className="";
                document.getElementById(presibling.firstChild.getAttribute("href")).setAttribute("hidden","hidden");
                presibling = presibling.previousElementSibling;
            }
        }
    }
}