class Web extends React.Component{
	pd = alldata;	//Backend가 보내준 json 배열값을 React 가상 변수로 이관
	htmls = [];	//반복문을 작동시킨 html 코드를 담는 배열
	render(){
		//return 함수에 익명함수를 적용하여 결과를 출력함
		return(
			<>
			<div>
			<ol>
			{this.aaa()}
			</ol>
			</div>
			</>
		);
	}
	//익명함수 생성 반복문으로 데이터를 생성
	aaa = function(){
		/* 일반 반복문으로 핸들링 이벤트를 발생 시키기 어려움 */
		/*
		for(var a=0; a<this.pd.length; a++){
			this.htmls.push(<li key={a}>{this.pd[a]}</li>);
		}
		return this.htmls;	//결과값을 return	
		*/
		
		/*
		CDN에서 html배열에 push를 사용하여 적용하는 것이 아니라 함수에서 foreach, map을 이용하여
		즉각 핸들링 이벤트를 적용해야만 핸들링을 할 수 있음
		*/
		/*
		return this.pd.map((a, b) => (
			<li key={b} onClick={()=>this.getdata(a)}>{a}</li>
		));
		*/
		this.pd.forEach((a,b,c) => {
			this.htmls.push(<li key={a} onClick={()=>this.getdata(a)}>{a}</li>)
		});
		return this.htmls;
	}
	
	getdata = function(pnm){
		//console.log(pnm);
		location.href='./product_list.do?pnm='+pnm;
	}
	
}
ReactDOM.render(<Web/>,document.querySelector("#box"));