import logo from './logo.svg';
import './App.css';
import CardComponent from './CardComponent';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const ItemList = [
    { id:1, img_src:logo, title:"지금인기~색감원피스 무더위에 한벌로딱좋아", price:"65,000원", company:"젬마월드" },
    { id:2, img_src:logo, title:"여름 침대위의 작은변화~ 냉감침대패드 특가!", discount:"99,800원", price:"68% 31,900원", company:"아이르" },
    { id:3, img_src:logo, title:"바로발송! 여름내내 입어 1+1 예쁜핏 여름원피스", discount:"49,000원", price:"24% 37,000원", company:"미나그램"},
    { id:4, img_src:logo, title:"선화동 매운실비김치 신상 매콤 달콤 옛날떡볶이!", price:"16,000원", company:"선화동매운김치"}
  ]

  return (
    <>
    <h1>과제 - 네이버 쇼핑투데이 카드 누르면 상세모달 뜨게 구현해보기</h1>
    <hr />
     <div className="container">
      <div className="row mx-auto mt-3">
          {ItemList.map((item, index) => (
            <CardComponent key={index.id} img_src={item.img_src} title={item.title} discount={item.discount} price={item.price} company={item.company} />
          ))}
      </div>
    </div>
    </>
  );
}

export default App;
