import './App.css';
import LifecycleDemo from './LifecycleDemo';
import { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import Items from './items';

const App = () => {
  const [StatNow, UpdateStat] = useState(true);

      

  return (
    
    <div className="App">
      <h1>과제 1. 컴포넌트 라이프 사이클 콘솔로그 확인 </h1>
      <button
        onClick={() => {
          UpdateStat(!StatNow);
        }}
      > 
        { StatNow ? "컴포넌트 숨기기" : "컴포넌트 보이기"}
      </button>
        {
          StatNow && (
            <div className="myShowbox">
              <LifecycleDemo />
            </div>
          )
        }
      

      <hr />
      
      <h1>과제 2. 네이버 쇼핑투데이 카드 컴포넌트 만들기</h1>
      <div className="container">
        <div className="row mx-auto mt-3">
          <Items img_src={logo} title="지금인기~색감원피스 무더위에 한벌로딱좋아" price="65,000원" company="젬마월드" />
          <Items img_src={logo} title="여름 침대위의 작은변화~ 냉감침대패드 특가!" price="68% 31,900원" company="아이르" />
          <Items img_src={logo} title="바로발송! 여름내내 입어 1+1 예쁜핏 여름원피스" price="24% 37,000원" company="미나그램" />
          <Items img_src={logo} title="선화동 매운실비김치 신상 매콤 달콤 옛날떡볶이!" price="16,000원" company="선화동매운김치" />
        </div>
      </div>
    </div>
  );
}

export default App;
