import logo from './logo.svg';
import './App.css';
// npm i styled-components
import styled from "styled-components"

import React, { useState } from "react";

// Redux를 사용하기위한 임포트
import { useSelector, useDispatch } from "react-redux";
import { increment, decrement, toggleCounter } from "./actions/counterActions";

/** npm install -D tailwindcss postcss autoprefixer 으로 작성시
 *  tailwindcss 명령어가 CLI에서 동작하지 않는 이슈 생김. 아래의 코드로 진행
 * 
 *  npm install -D tailwindcss@3 postcss autoprefixer
 *  npx tailwindcss init
 *  tailwind.config.js 파일 내용을 동일하게 설정
 * 
 * 이후 index.js에서 3줄 추가
    @tailwind base;
    @tailwind components;
    @tailwind utilities;
 * 
 * npm install redux react-redux // 리듀서 설치
 * npm install @reduxjs/toolkit // 리듀서 툴킷 설치(reduce devtool 구글 확장프로그램 사용)
 */


const Container = styled.div`
    background: #fff;
    ul{
      li{
        background:pink;
        margin-bottom: 10px;
        list-style: none;
      }
    }
`;

const Title = styled.h1`
    font-size: 3rem;
    font-weight: 800;
    color: black;
`;

const Input = styled.input`
    color: red;
`;

const Button = styled.button`
    background: ${props => props.add ? "blue":"gray"};
    border: none;
    margin-right: 10px;
    color: ${(props) => (props.add ? "#fff": "black")};
    width: 4rem;
    height: fit-content;
    padding: 10px;
    border-radius: 5px;
`;

const AddButton = styled(Button)`
  border: 2px solid red;
`;

const DelButton = styled(Button)`
  border: 2px solid pink;
`;

function App() {
  // 리덕스 필요요소
  const counter = useSelector((state) => state.stores.counter);
  const showCounter = useSelector((state) => state.stores.showCounter);
  const dispatch = useDispatch();

  // 투두리스트 state
  const [todos, setTodos] = useState([]);
  const [input, setInput] = useState("");

  const addTodo = () => {
    if (input.trim() === "") return;
    setTodos([...todos, input.trim()]);
    setInput("");
  };

  const deleteTodo = (index) => {
    const newTodos = todos.filter((_, i) => i !== index);
    setTodos(newTodos);
  };

  return (
    
    <Container>
      <h1>할 일 목록</h1>
      
      <Title>할 일 목록</Title>

      <div>
        <Input
          type="text"
          placeholder="할 일을 입력하세요"
          value={input}
          onChange={(e) => setInput(e.target.value)}
        />
        <Button add onClick={addTodo}>추가</Button>
        <Button >삭제</Button>
        <AddButton add>상속추가</AddButton>
        <DelButton>상속삭제</DelButton>
      <ul>
        {todos.map((todo, index) => (
          <li key={index} className="px-4">
            <span>{todo}</span>
            <Button className="mx-4" onClick={() => deleteTodo(index)}>삭제</Button>
          </li>
        ))}
      </ul>
        {/* tailwindcss 사용 */}
        <h1 className="bg-blue-500 text-white p-4 text-center">안녕하세요</h1>
        <h1 className="bg-orange-400 text-white p-4 text-center md:text-left">안녕하세요</h1>
        <h1 className="bg-green-400 text-white p-4 text-center lg:text-right">안녕하세요</h1>

        <button className="bg-blue-500 hover:bg-red-400 text-white font-bold p-4">Hover me</button>
        {/* tailwind.config.js에 extends 부분 customPurple을 커스텀으로 집어넣음. 이후 적용 */}
        <button className="bg-customPurple hover:bg-gray-400 text-white font-bold p-4">Hover me</button>
      </div>
      <hr />
    
      <div className="flex flex-col items-center">
        <h1>리덕스 카운터</h1>
        <div className="box-border h-24 w-48 border-2 p-6 shadow-xl/30 content-center text-center">
          {showCounter && <p>카운터 값: {counter}</p>}  
        </div>
        <div className="m-3">
          <button className="bg-blue-500 text-white font-bold p-4 mr-2 rounded-md" onClick={() => dispatch(increment(5))}>카운터 +5</button>
          <button className="bg-red-400 text-white font-bold p-4 rounded-md" onClick={() => dispatch(decrement(3))}>카운터 -3</button>
        </div>
        <button className="bg-customPurple text-white font-bold p-3 rounded-full" onClick={() => dispatch(toggleCounter())}>
          {showCounter ? "카운터 숨기기" : "카운터 보이기"}
        </button>
      </div>
   </Container>
  );
}

export default App;