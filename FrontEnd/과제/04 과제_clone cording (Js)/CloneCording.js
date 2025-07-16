// 버튼을 누르면 로그인 영역의 색을 변경

var loginButton = document.getElementById("loginBtn");   // 로그인 버튼 선택
var helpButton = document.getElementById("helpBtn");   // 도움말 버튼 선택

loginButton.addEventListener("click", loginToPurple); // 로그인 버튼이 눌렸을때 이벤트

helpButton.addEventListener("mouseover", helpmessageover); // 도움말 버튼에 마우스가 올라갔을 때
helpButton.addEventListener("mouseout", helpmessageout);  // 도움말 버튼에 마우스가 내려갔을 때

function loginToPurple(){
    var ChangeColorTarget = document.getElementById("loginBtn");
    var newAttribute = document.createAttribute("style");
    
    newAttribute.value = "background-color: rgb(255, 34, 226);"
    ChangeColorTarget.setAttributeNode(newAttribute);
}

function helpmessageover(){
    helpButton.innerHTML = "무엇을 도와드릴까요?";
}

function helpmessageout(){
    helpButton.innerHTML = "도움말";
}
