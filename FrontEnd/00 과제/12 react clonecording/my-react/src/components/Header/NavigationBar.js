import { useState, useEffect} from "react"
import Dropdown from './Dropdown'

export default function HeadNaviBar(){
    const [isScrolled, setIsScrolled] = useState(false);

    useEffect(() => {
      const handleScroll = () => {
        setIsScrolled(window.scrollY > 0);
      };

      window.addEventListener('scroll', handleScroll);

      // 초기 상태 반영
      handleScroll();

      return () => {
        window.removeEventListener('scroll', handleScroll);
      };
    }, []);
    return (
    <section className={`w-full my-0 mx-auto grid grid-cols-1 items-center sticky top-0 left-0 w-full bg-white 
      ${isScrolled ? 'shadow-md' : 'shadow-none'} z-50`}>
            <nav className="w-full my-0 mx-auto h-auto grid grid-cols-[1fr_auto_1fr] items-center justify-between bg-white font-sm font-[500] leading-[1.25rem] py-[15px] px-[25px]">
              <div className="justify-self-start cursor-pointer">
                <img id="profileImage" src="https://img.icons8.com/?size=100&id=nZoJhBpPfVev&format=png&color=000000" width="40" />
              </div>
    
              <div className="col-2 flex items-center gap-1">
                
                <Dropdown name='Notion'/>
    
                <a className="py-[5px] px-[10px] justify-center items-center cursor-pointer hover:bg-gray-100 rounded-[0.5rem]">
                  <span className="text-sm font-[600]">메일</span>
                </a>
    
                <a className="py-[5px] px-[10px] justify-center items-center cursor-pointer hover:bg-gray-100 rounded-[0.5rem]">
                  <span className="text-sm font-[600]">캘린더</span>
                </a>
                
                <a className="py-[5px] px-[10px] justify-center items-center cursor-pointer hover:bg-gray-100 rounded-[0.5rem]">
                  <span className="text-sm font-[600]">AI</span>
                </a>
                
                <a className="py-[5px] px-[10px] justify-center items-center cursor-pointer hover:bg-gray-100 rounded-[0.5rem]">
                  <span className="text-sm font-[600]">대기업</span>
                </a>
                
                <a className="py-[5px] px-[10px] justify-center items-center cursor-pointer hover:bg-gray-100 rounded-[0.5rem]">
                  <span className="text-sm font-[600]">가격</span>
                </a>
                
                <Dropdown name='둘러보기'/>
    
                <a className="py-[5px] px-[10px] justify-center items-center cursor-pointer hover:bg-gray-100 rounded-[0.5rem]">
                  <span className="text-sm font-[600]">영업팀 문의하기</span>
                </a>
              </div>
              <div className="w-full col-3 justify-end flex gap-[20px] items-center">
                <span className="w-fit p-2 rounded-lg cursor-pointer hover:bg-gray-200 text-sm font-[600]">로그인</span>
                <a className="min-h-[2.25rem] py-[0.25rem] px-[0.875rem] flex items-center justify-center rounded-[0.5rem] border outline-black
                text-white bg-blue-600 w-fit font-sm font-[500] leading-[1.25rem] cursor-pointer hover:bg-blue-700 text-sm font-[600]">Notion 무료로 시작하기</a>
              </div>
        </nav>
    </section>
    );
}