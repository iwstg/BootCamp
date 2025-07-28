import logo from './logo.svg';
import './App.css';
import Nav from "./Nav";
import Footer from "./Footer"

function App() {
  const imgSrc = "이미지 경로"
  const 로그인여부 = false;
  const 과일들 = ["🍊", "🍇", "🍎"]

  const users = [
    { id: 1, name: "Alice", age: 24 },
    { id: 2, name: "Bob", age: 30 },
    { id: 3, name: "John", age: 28 }
  ];

  return (
    // class가 아닌 className
    <div className="App">
      {/* 네비게이션 영역 */}
      <Nav />
      {로그인여부 && <Nav />}
      {/* 본문영역 */}
      <ul>
        {과일들.map((item, index) => (
          <li key={index}>{item}</li>
        ))}

        {/* 객체 쓰는법 */}
        {users.map((item, index) => (
          <li key={item.id}>{item.name}</li>
        ))}
      </ul>
      {/* 푸터 */}
      <Footer />
    </div>
  );
}

export default App;
