import React, { useEffect, useState, useRef } from "react";
import './App.css';

export default function DropdownNav({name, parentRef}) {
    const [isHovered, setIsHovered] = useState(false);
    const [isToggled, setIsToggled] = useState(false); //추가
    const [hasAnimated, setAnimated] = useState(false);
    const heightref = useRef(null);
    const dropdownRef = useRef(null); // 추가
    const [downPos, setPos] = useState('0');
    const showDropdown = isHovered || isToggled; // 추가
    useEffect(() => {
        const refs = heightref.current.getBoundingClientRect().bottom;
        console.log(refs);
        setPos(refs);
    }, [])

    //추가
    useEffect(() => {
    const handleClickOutside = (e) => {
      if (
        dropdownRef.current &&
        !dropdownRef.current.contains(e.target) &&
        !heightref.current.contains(e.target)
      ) {
        setIsToggled(false);
      }
    };
        document.addEventListener("mousedown", handleClickOutside);
        return () => document.removeEventListener("mousedown", handleClickOutside);
    }, []);

    return (
        <div
        className="TopNavigatorTab items z-50"
        onMouseEnter={() => {setAnimated(true); setIsHovered(true)}}
        onMouseLeave={() => {setAnimated(false); setIsHovered(false)}}
        // onMouseOut={() => setIsToggled(true)}
        ref={heightref}
        >
        {/* 상단 고정 네비게이션 */}
        <div className="flex gap-8 cursor-pointer items-center hover:bg-gray-200">
            <div className="flex cursor-pointer font-semibold text-gray-800 gap-2">
                <span >{name}</span>
                <span className="w-2 h-4 content-center">
                    <svg viewBox="0 0 30 30">
                        <polygon points="15,17.4 4.8,7 2,9.8 15,23 28,9.8 25.2,7 "></polygon>
                    </svg>
                </span>
            </div>
        </div>
        {/* 드롭다운 hover 따라 애니메이션 1번만 수행(미구현) asd*/}
        {showDropdown && ( //변경
            name === 'Notion' ? (
                <div className="absolute left-0 w-screen py-1" 
                style={{ top: `${downPos}px`}}>
                
                <div className={`h-fit 
                    grid grid-cols-4 gap-8 top-full
                    pt-6 pb-12 px-[90px] bg-white z-50 shadow
                    transition-all duration-300 ease-in-out
                    ${hasAnimated ? "opacity-100 translate-y-0" 
                        : "opacity-0 -translate-y-[20%]"}
                `}>
                    <div className="h-[300px]">
                        <div className="flex flex-col justify-between">
                            <p className="p-2 text-gray-400">기능</p>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">Notion AI</p>
                                <span className="text-sm text-gray-500">구축, 작성, 자동화를 위한 툴</span>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">문서</p>
                                <span className="text-sm text-gray-500">간단하면서도 강력한 툴</span>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">위키</p>
                                <span className="text-sm text-gray-500">모든 지식을 한데 모은 허브</span>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">프로젝트</p>
                                <span className="text-sm text-gray-500">어떤 프로젝트든 관리할 수 있는 툴</span>
                            </div>
                        </div>
                    </div>
                    <div className="h-[300px]">
                        <div className="flex flex-col justify-between">
                            <p className="p-6"></p>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">기업 통합 검색(new)</p>
                                <span className="text-sm text-gray-500">즉시 답변을 찾을 수 있는 기능</span>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">AI 노트(new)</p>
                                <span className="text-sm text-gray-500">AI가 완벽하게 정리해 드립니다.</span>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">양식</p>
                                <span className="text-sm text-gray-500">응답과 요청을 손쉽게 확인하는 툴</span>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">프로젝트</p>
                                <span className="text-sm text-gray-500">어떤 프로젝트든 관리할 수 있는 툴</span>
                            </div>
                        </div>
                    </div>

                    <div className="h-[300px]">
                        <div className="flex flex-col justify-between">
                            <p className="p-2 text-gray-400">시작하기</p>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">마켓플레이스 둘러보기</p>
                                <span className="text-sm text-gray-500">모든 것을 위한 템플릿</span>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">AP 통합 보기</p>
                                <span className="text-sm text-gray-500">Notion에 앱 연결하기</span>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">Web Clipper 다운로드</p>
                                <span className="text-sm text-gray-500">웹에서 가져와 Notion에 저장하세요.</span>
                            </div>
                        </div>
                    </div>
                    <div className="h-[300px]">
                        <div className="">
                            <div>
                                <p className="font-bold text-xl text-balance">더 빠른 경험을 위한 Notion 데스크톱 앱다운로드</p>
                                <span className="border border-blue-500 color-white rounded-[16px] p-2 cursor-pointer">앱 다운로드</span>
                                <img className="h-fit" src="https://www.notion.com/_next/image?url=%2Ffront-static%2Fmeta%2Fstartups_background.png&w=256&q=75" />
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            ) :
            (
                <div className="absolute left-0 w-screen py-1" 
                style={{ top: `${downPos}px`}}>
                
                <div className={`h-fit 
                    grid grid-cols-4 gap-8 top-full
                    py-6 px-[90px] bg-white z-50 shadow
                    transition-all duration-500 ease-out
                    ${hasAnimated ? "opacity-100 translate-y-0 " 
                        : "opacity-0 -translate-y-[-20%]"}
                `}>
                    <div className="h-[300px]">
                        <div className="flex flex-col justify-between">
                            <p className="p-2 text-gray-400">팀</p>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">엔지니어링 및 제품</p>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">디자인</p>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">마케팅</p>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">IT</p>
                            </div>
                        </div>
                    </div>

                    <div className="h-[300px]">
                        <div className="flex flex-col justify-between">
                            <p className="p-2 text-gray-400">팀규모</p>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">스타트업</p>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">중소기업</p>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">대기업</p>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[16px]">
                                <p className="font-bold text-xl">교육</p>
                            </div>
                        </div>
                    </div>

                    <div className="h-[300px]">
                        <div className="flex flex-col justify-between">
                            <p className="p-2 text-gray-400">학습하기</p>
                            <div className="p-2 hover:bg-gray-200 rounded-[8px]">
                                <p className="font-bold text-sm">도움말 센터</p>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[8px]">
                                <p className="font-bold text-sm">고객 스토리</p>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[8px]">
                                <p className="font-bold text-sm">블로그</p>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[8px]">
                                <p className="font-bold text-sm">커뮤니티</p>
                            </div>
                        </div>
                    </div>
                    
                    <div className="h-[300px]">
                        <div className="flex flex-col justify-between">
                            <p className="p-2 text-gray-400">만들기</p>
                            <div className="p-2 hover:bg-gray-200 rounded-[8px]">
                                <p className="font-bold text-sm">API</p>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[8px]">
                                <p className="font-bold text-sm">템플릿</p>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[8px]">
                                <p className="font-bold text-sm">보안</p>
                            </div>
                            <div className="p-2 hover:bg-gray-200 rounded-[8px]">
                                <p className="font-bold text-sm">컨설턴트</p>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            )
        )}
        
        
        </div>
    );
}