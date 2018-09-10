var count=0;

function quiz(){
    document.getElementById("Modal-wrapper").style.display = "block";
}

function hideModel(){
    document.getElementById("Modal-wrapper").style.display = "none";
}

var upSpans = document.getElementsByClassName("icon-sort-up");
for(var a in upSpans){
	if(upSpans[a]){
		//赞同按钮绑定点击事件
		upSpans[a].onclick = function(){
			if(count<1){
				//获取当前元素父节点
				var parent = this.parentNode;
				//当前元素文本内容转数字
				var innerText = this.innerHTML-0;
				this.innerHTML = innerText+1;
				//当前元素父节点上级同胞元素下所有子节点
				var childNodes = parent.previousElementSibling.childNodes;
				for(var a in childNodes){
					var _this = childNodes[a];
					if(_this.className=="shuoming"){
						//改变文本内容
						_this.children[0].innerHTML = innerText+1;
					}
				}
				count++;
			}
		}
	}
}
var downSpans = document.getElementsByClassName("icon-sort-down");
for(var a in downSpans){
	if(downSpans[a]){
		//取消赞同按钮绑定点击事件
		downSpans[a].onclick = function(){
			if(count>0){
				//获取当前元素父节点
				var parent = this.parentNode;
				//当前元素上级同胞元素
				var sibling = this.previousElementSibling;
				//同胞元素文本内容
				var innerText = sibling.innerHTML;
				sibling.innerHTML = innerText-1;
				//当前元素父节点上级同胞元素下所有子节点
				var childNodes = parent.previousElementSibling.childNodes;
				for(var a in childNodes){
					var _this = childNodes[a];
					if(_this.className=="shuoming"){
						//改变文本内容
						_this.children[0].innerHTML = innerText-1;
					}
				}
				count--;
			}
		}
	}
}
