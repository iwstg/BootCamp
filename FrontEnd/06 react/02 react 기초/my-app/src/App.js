import logo from "./logo.svg";
import "./App.css";
import Child from "./child";
import ClassComponent from "./ClassComponent";
import FunctionComponents from "./FunctionComponents";
import { useState } from "react";

const App = () => {
  const [상태, 상태업데이트함수] = useState(true);
  let age = 30;
  age = 25;
  return (
    <>
      <Child name="홍길동" />
      <Child age={age} name="홍길동" />
      <Child age="20" name="홍길동" />
      <button
        onClick={() => {
          상태업데이트함수(!상태);
        }}
     > 
        { 상태 ? "컴포넌트 숨기기" : "컴포넌트 보이기"}
      </button>
      <hr />
      {
        상태 && (
          <>
            <ClassComponent />
            <FunctionComponents />
          </>
        )
      }
    </>
  );
};

export default App;
