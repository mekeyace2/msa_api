var host = window.location.host;	//접속 도메인, IP 정보 출력

//가상의 TCP 소켓을 오픈 및 연결하는 라이브러리
var chat = new StompJs.Client({
	brokerURL:"ws://"+host+"/gs-websocket"
});

//소켓서버 연결 에러
chat.onWebSocketError = function(error){
	alert("소켓통신 서버 연결 오류:" + error);
}

//메세지를 주고 받는 송수신 에러
chat.onStrompError = function(error){
	alert("메세지 전송 오류 발생!!" + error);
}

chat.onConnect = function(z){
	setConnect(true);
	console.log("소켓연결 서버" + z);
	//채팅 방을 생성하여 연결시키는 함수
	chat.subscribe('/room/geetings',function(z){
		showmsg(JSON.parse(z.body).content);
	});
}

//웹에 메세지 출력
function showmsg(msg){
	$("#greetings").append("<tr><td>"+msg+"</td></tr>");
}

//연결 버튼 클릭시 작동
function connect(){
	chat.activate();  //StompJs 함수
}

//연결 종료 클릭시 작동
function disconnect(){
	chat.deactivate();	//StompJs 함수
	setConnect(false);	//ws에 완전히 종료	
	alert("소켓 통신 종료!!");
}

$(function(){
	$("form").on("submit",(e)=>e.preventDefault());
	$("#connect").click(()=>connect());
	$("#disconnect").click(()=>disconnect());
	$("#send").click(function(){
			sends();
	});
});

function sends(){
	//ajax 형태로 해당 경로에 메세지 전송 (StompJs 함수)
	chat.publish({
			destination : "/app/conchat",
			body: JSON.stringify({
				'name':$("#name").val(),
				'msg':$("#msg").val()
			})
	});
}

function setConnect(c){
	$("#connect").prop("disabled",c);
	$("#disconnect").prop("disabled",!c);
	if(c==true){
		$("#conversation").show();
	}
	else{
		$("#conversation").hide();
	}
	$("#greetings").html("");	
}




