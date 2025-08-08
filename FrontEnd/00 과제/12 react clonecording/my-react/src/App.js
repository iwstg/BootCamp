import HeadNaviBar from './components/header/NavigationBar';
import MainContentsArea from './components/main/MainContentsArea';
import FooterNaviBar from './components/footers/FooterNavigation';

function App() {

  return (
        <>
        {/* HEADER 상단 네비게이션 바 */}
        <HeadNaviBar />

        {/* BODY(MAIN) 영역 */}
        <MainContentsArea />

        {/* FOOTER 하단 네비게이션 바 */}
        <FooterNaviBar />
    </>
  );
}

export default App;
