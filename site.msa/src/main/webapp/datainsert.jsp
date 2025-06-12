<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/@stomp/stompjs@7.0.0/bundles/stomp.umd.min.js"></script>
<script>
var result = "${result}";
var host = window.location.host;
var sockets = new StompJs.Client({
	brokerURL:"ws://"+host+"/gs-websocket"
});
sockets.onWebSocketError = function(error){
	alert("소켓통신 서버 연결 오류:" + error);
}
if(result == "ok"){
	sockets.activate();
	sockets.onConnect = function(z){
		websocket();
	}	
}

function websocket(){
	sockets.publish({
		destination : "/app/conchat",
		body: JSON.stringify({
			'callsign':result
		})
	});
	sockets.deactivate();

	alert("정상적으로 데이터가 입력 되었습니다.");
	location.href='./data_list.html';
} 
</script>