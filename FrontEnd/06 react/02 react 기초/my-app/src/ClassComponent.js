import React, { Component } from "react";


/** 클래스형 컴포넌트는 extends Component와 
 * 내부에 render() 함수를 집어넣어야 함.
 * state의 값을 참조하려면 this 를 사용해야하며
 * state의 값을 수정하려면 setState 를 사용해야함.
*/

class ClassComponent extends Component {
  // 초기화
  constructor(props) {
    super(props);
    this.state = { count: 0 };
    console.log("constructor 실행");
  }

    // 컴포넌트가 생성되는 시점
    componentDidMount(){
    console.log("componentDidMount: (처음 랜더링 완료)");
  }

    //  업데이트 이후에 실행됨 
    componentDidUpdate(){
        console.log("componentDidUpdate: (업데이트 완료)" );
    }

    // 컴포넌트가 사라지는 시점 (정밀작업 위치. 타이머 등)
    componentWillUnmount(){
        console.log("componentWillUnmount: (컴포넌트가 사라짐");
    }


  render() {
    return (
      <>
        <h2>클래스형 컴포넌트</h2>
        <p>카운트: {this.state.count}</p>
        <button
          onClick={() => {
            this.setState({ count: this.state.count + 1 });
          }}
        >
          +1 증가
        </button>
      </>
    );
  }
}
export default ClassComponent;
