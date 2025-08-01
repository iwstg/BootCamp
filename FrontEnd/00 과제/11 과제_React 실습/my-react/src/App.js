import logo from './logo.svg';
import './App.css';
import Items from './items';

// redux사용하기 위한 import
import { useSelector, useDispatch } from "react-redux";
/**
 * counterActions은 Redux Toolkit 을 사용하지 않을 때 사용함.
 * counterSlice는 Redux Toolkit을 적용한것으로, Action과 Reducer 모두 포함됨.
 * store.js에서는 
 * const store = configureStore({
    reducer: {
        stores: counterReducer, 
    },
});
 * 이처럼 객체형태로 만들어 줘야함.
 * 그리고 useSelector에 state.'stores'.counter 로 입력
 */
// import { increment, decrement, toggleCounter } from "./actions/counterActions";
import { increment, decrement, toggleCounter } from "./reducers/counterSlice";

/** npm install -D tailwindcss postcss autoprefixer 으로 작성시
 *  tailwindcss 명령어가 CLI에서 동작하지 않는 이슈 생김. 아래의 코드로 진행
 * 
 *  npm install -D tailwindcss@3 postcss autoprefixer
 *  npx tailwindcss init
 *  tailwind.config.js 파일 내용을 동일하게 설정
 * 
 * 이후 index.css에서 3줄 추가
    @tailwind base;
    @tailwind components;
    @tailwind utilities;
 * 
 * npm install redux react-redux // 리듀서 설치
 * npm install @reduxjs/toolkit // 리듀서 툴킷 설치(reduce devtool 구글 확장프로그램 사용)
 */

function App() {
  // 과제 1. 네이버 쇼핑 카드 컴포넌트 테일윈드로 스타일링
  const ItemList = [
    { id:1, img_src:logo, title:"지금인기~색감원피스 무더위에 한벌로딱좋아", price:"65,000원", company:"젬마월드" },
    { id:2, img_src:logo, title:"여름 침대위의 작은변화~ 냉감침대패드 특가!", discount:"99,800원", price:"68% 31,900원", company:"아이르" },
    { id:3, img_src:logo, title:"바로발송! 여름내내 입어 1+1 예쁜핏 여름원피스", discount:"49,000원", price:"24% 37,000원", company:"미나그램"},
    { id:4, img_src:logo, title:"선화동 매운실비김치 신상 매콤 달콤 옛날떡볶이!", price:"16,000원", company:"선화동매운김치"}
  ]
  
  // 과제 2. 리덕스 실습 
  const counter = useSelector((state) => state.stores.counter);
  const showCounter = useSelector((state) => state.stores.showCounter);
  const dispatch = useDispatch();
  
  return (
  <>
    <div className="container mx-auto text-center">
      <h1 className="mt-3 font-bold text-2xl">과제 1. 네이버 쇼핑 카드 컴포넌트 테일윈드로 스타일링</h1>
      <div className="flex flex-wrap justify-center m-3">
        {ItemList.map((item, index) => (
          <Items key={index.id} img_src={item.img_src} title={item.title} discount={item.discount} price={item.price} company={item.company} />
        ))}
      </div>
      <hr />
      <h1 className="mt-3 font-bold text-2xl">과제2. 리덕스 실습 </h1> 
      <div className="flex flex-col items-center">
        <h1 className="my-3">리덕스 카운터</h1>
        <div className="box-border h-24 w-48 border-2 p-6 shadow-xl/30 content-center text-center">
          {showCounter && <p>카운터 값: {counter}</p>}  
        </div>
        <div className="m-3">
          
          <button className="bg-blue-500 text-white font-bold p-4 mr-2 rounded-md" onClick={() => dispatch(increment(5))}>카운터 +5</button>
          <button className="bg-red-400 text-white font-bold p-4 rounded-md" onClick={() => dispatch(decrement(3))}>카운터 -3</button>
        </div>
        <button className="bg-orange-400 text-white font-bold p-3 rounded-full" onClick={() => dispatch(toggleCounter())}>
          {showCounter ? "카운터 숨기기" : "카운터 보이기"}
        </button>
      </div>
    </div>
  </>
  );
}

export default App;
