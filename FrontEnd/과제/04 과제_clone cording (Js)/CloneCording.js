// 버튼을 누르면 로그인 영역의 색을 변경

var loginButton = document.getElementById("loginBtn");   // 로그인 버튼 선택
var helpButton = document.getElementById("helpBtn");   // 도움말 버튼 선택
var termsButton = document.getElementById("termsBtn");   // 약관 버튼 선택

loginButton.addEventListener("click", loginToPurple); // 로그인 버튼이 눌렸을때 이벤트

helpButton.addEventListener("mouseover", helpmessageover); // 도움말 버튼에 마우스가 올라갔을 때
helpButton.addEventListener("mouseout", helpmessageout);  // 도움말 버튼에 마우스가 내려갔을 때

termsButton.addEventListener("mouseover", MakeTermsStyleButton);
termsButton.addEventListener("mouseout", DeleteTermsStyleButton);


function loginToPurple(){
    var ChangeColorTarget = document.getElementById("loginBtn");
    var newAttribute = document.createAttribute("style");
    
    newAttribute.value = "background-color: rgb(255, 34, 226);"
    ChangeColorTarget.setAttributeNode(newAttribute);
}

function helpmessageover(){ // 도움말버튼에 마우스를 올릴때
    helpButton.innerHTML = `무엇을 도와드릴까요?`;
}

function helpmessageout(){ // 도움말버튼에서 마우스가 벗어날때
    helpButton.innerHTML = "도움말";
}

function MakeTermsStyleButton(){ // 약관버튼에 마우스를 올릴때
    var newAttribute = document.createAttribute("style"); // 새로운 style 속성 노드를 생성
    newAttribute.value = `border: 2px dashed black`; // 테두리에 검정색 대쉬를 생성
    termsButton.setAttributeNode(newAttribute); // 약관페이지에 적용
}

function DeleteTermsStyleButton(){ // 약관버튼서 마우스가 벗어날때
    termsButton.removeAttribute("style"); // 삭제
}