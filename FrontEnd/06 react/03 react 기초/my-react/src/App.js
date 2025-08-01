import Child from "./Child";
import {useState} from "react";
import Button from "./Button";

export default function App() {
  const [data, setData] = useState("초기값")

  // 1단계, 부모에서 콜백함수를 만들어준다.
  const 콜백함수 = (자식에서받아온데이터) => {
    console.log("받아온 데이터: ", 자식에서받아온데이터);

    // 4단계, 자식에서 받아온 데이터로 state값을 변경한다.
    setData(자식에서받아온데이터);
  }

  return (
    <>
      <h1>부모상태: {data}</h1>
      {/* 2단계. 자식에게 콜백함수를 넘겨준다 . */}
      <Child onData={콜백함수}/>
      <hr />
      {/* css module 사용. 설치 불필요 */}
      <Button color="blue"/>
      <hr />
    </> 
  );
}