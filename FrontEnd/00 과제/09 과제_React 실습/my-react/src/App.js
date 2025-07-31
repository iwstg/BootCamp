import React, { createContext, useState, useContext } from "react";
import Items from "./items";
import logo from './logo.svg';
import 'bootstrap/dist/css/bootstrap.min.css';

const ThemeContext = createContext();

export default function App() {
  // 과제1. 아래 useState를 한개의 state로 관리하기
  // const [score, setScore] = useState(0);
  // const [name, setName] = useState("Alice");

  const [state, setState] = useState({
    score: 0,
    name: "Alice",
  });

  const incrementScore = () => {
    setState((prevState) => ({
      ...prevState,
      score: prevState.score + 1
    }));
  };

  const changeName = () => {
    setState((prevState) => ({
      ...prevState,
      name : prevState.name === "Alice"? "Bob" : "Alice",
    }));
  };

  const [theme, setTheme] = useState("light");

  const ItemList = [
    { id:1, img_src:"", title:"지금인기~색감원피스 무더위에 한벌로딱좋아", price:"65,000원", company:"젬마월드" },
    { id:2, img_src:"", title:"여름 침대위의 작은변화~ 냉감침대패드 특가!", price:"68% 31,900원", company:"아이르" },
    { id:3, img_src:"", title:"바로발송! 여름내내 입어 1+1 예쁜핏 여름원피스", price:"24% 37,000원", company:"미나그램"},
    { id:4, img_src:"", title:"선화동 매운실비김치 신상 매콤 달콤 옛날떡볶이!", price:"16,000원", company:"선화동매운김치"}
  ]

  return (
    <>
      <h1>과제 1. useState 통합관리</h1>
      <h1>점수: {state.score}</h1>
      <button onClick={incrementScore}>Increase Score</button>
      <h2>이름: {state.name}</h2>
      <button onClick={changeName}>Change Name</button>
      <hr />
      <h1>과제 2. useContext 사용해보기</h1>
      <ThemeContext.Provider value={{ theme, setTheme }}>
        <Toolbar />
      </ThemeContext.Provider>
      <hr />
      <h1>과제 3. 네이버 쇼핑투데이 카드 컴포넌트 map 변환 과제</h1>
      <div className="container">
        <div className="row mx-auto mt-3">
          {ItemList.map((item, index) => (
            <Items key={index.id} img_src={item.img_src} title={item.title} price={item.price} company={item.company} />
          ))}
        </div>
      </div>
    </>
  );
}

function Toolbar(){
    return (
        <div>
            <ThemedButton />
        </div>
    )
}

function ThemedButton(){
    const { theme, setTheme } = useContext(ThemeContext);

    return (
        <button onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}>
            Current Theme: {theme}
        </button>
    )
}