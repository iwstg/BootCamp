import HeadNaviBar from './components/Header/NavigationBar';
import MainContentsArea from './components/Main/MainContentsArea';
import FooterNaviBar from './components/Footer/FooterNavigation';

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
