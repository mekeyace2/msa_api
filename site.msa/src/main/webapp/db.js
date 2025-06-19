//해당 node서버에서 라이브러리를 호출
const express = require('express');		//express 가상 API 서버
const cors = require('cors');			//CORS를 해결하는 라이브러리 (Ajax)
const { MongoClient } = require('mongodb');

//express 서버를 셋팅
var ex = express();
var port = 9800;
ex.use(cors());			//CORS를 통과시키는 함수를 즉시실행 설정
ex.use(express.json());		//json 배열로 return 시키기 위한 함수

//해당 express 서버를 실행하는 함수 listen : 대기
ex.listen(port, ()=> {
	console.log("express서버 체크 실행중!!!!");
});


//사용자 접속 정보
var userid = encodeURIComponent('cms');	//아이디
var userpw = encodeURIComponent('cms402');	//패스워드
var host = "notice.kbsn.or.kr:27017";	//접속경로
var dbnm = "cms";		//db명

//mongodb 접속 경로 및 데이터베이스명
//authSource : Authentication의 정보를 확인하는 작업 (admin DB에서)
//*** Authentication보안 사용시 필수 admin Database에 db.createUser를 꼭 생성 후 적용 */
const uri = `mongodb://${userid}:${userpw}@${host}/${dbnm}?authSource=admin`;

var client = new MongoClient(uri);		//접속체크
var db = null;

//Front-end가 Ajax로 호출하는 가상의 경로
ex.get('/api/data',async(req,res)=>{
	try{
		await client.connect();	//연결 응답 대기 상황
		console.log('express서버에 연결확인!!');
		db = client.db(dbnm);	//DB연결 정보 및 collection 연결 준비 작업
		var collection = db.collection('members');	//table명
		var query = await collection.find({}).toArray();
		res.json(query);
	}
	catch(error){
		console.log(error);
		res.json({"error":"정상적인 접속 방식이 아닙니다."})
	}
	finally{
		await client.close();
	}
});








async function abc(){
	try{
		await client.connect();	//연결 응답 대기 상황
		console.log("success mongodb!!");
		db = client.db(dbnm);	//DB연결 정보 및 collection 연결 준비 작업
		var collection = db.collection('members');	//table명
		//query문을 작성
		var query = await collection.find({}).toArray();
		console.log("공지사항 리스트 출력 : ",query);
				
	}catch(error){
		console.log(error);
	}finally{
		await client.close();		//모든 작업이 끝난 후 DB 연결해제
	}
}
//abc();	//해당 Database를 연결하는 함수를 호출하여 적용
