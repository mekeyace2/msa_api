$(function(){
	//입고처리 버튼 클릭시
	$("#insert_btn").click(function(){
		$("#frm").submit();	
	});
	
	//메세지 닫기 버튼 클릭시
	$("#closebtn").click(function(){
			$("#message").animate({
				opacity:0	
			},1000);
	});
});

var host = window.location.host;
var sockets = new StompJs.Client({
	brokerURL:"ws://"+host+"/gs-websocket"
});
sockets.onWebSocketError = function(error){
	alert("소켓통신 서버 연결 오류:" + error);
}
sockets.activate();

sockets.onConnect = function(z){
	console.log(z);
	sockets.subscribe('/room/geetings',function(z){
			pop_message(JSON.parse(z.body).content);
	});
}

function pop_message(msg){
	$("#msg").html(msg);
	
	$("#message").animate({
		opacity:1,
		bottom:"50px"	
	},1500);	
	sockets.deactivate();
}

