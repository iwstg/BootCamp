import React, { useEffect, useState, useRef } from "react";


export default function DropdownNav({name, parentRef}) {
    const [isHovered, setIsHovered] = useState(false);
    const [isToggled, setIsToggled] = useState(false); //추가
    const [isOpned, setIsOpend] = useState(false);
    
    const heightref = useRef(null);
    const dropdownRef = useRef(null); // 추가
    const [downPos, setPos] = useState('0');
    const showDropdown = isHovered || isToggled; // 추가

    const Togglebtn = () => {
        setIsToggled(!isToggled);
    }

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
        className="z-50"
        onMouseEnter={() => setIsHovered(true)}
        onMouseLeave={() => setIsHovered(false)}
        onMouseUp={() => Togglebtn()}
        
        ref={heightref}
        >
        {/* 상단 고정 네비게이션 */}
        <div className={`py-[5px] px-[10px] flex gap-8 cursor-pointer items-center rounded-[0.5rem] ${isToggled ? "bg-gray-200" : ""} hover:bg-gray-200`}>
            <div className="flex cursor-pointer font-semibold text-gray-800 gap-2">
                <span className="text-sm font-[600]" >{name}</span>
                <span className="w-2 h-4 justify-items-center self-center">
                    <svg
                        className={`w-4 h-4 transition-transform duration-200 ${showDropdown ? "rotate-180" : ""}`}
                        viewBox="0 0 20 20"
                        fill="currentColor"
                    >
                    <path
                        fillRule="evenodd"
                        d="M5.23 7.21a.75.75 0 011.06.02L10 10.94l3.71-3.71a.75.75 0 111.08 1.04l-4.25 4.25a.75.75 0 01-1.08 0L5.25 8.27a.75.75 0 01-.02-1.06z"
                        clipRule="evenodd"
                    />
                    </svg>
                </span>
            </div>
        </div>
        {/* -left-9999px로 보이지 않는 영역에 미리 랜더링 -> pointer-events-none 으로 영역에 마우스 호버해도 이벤트 발생x 호버시 이벤트 발생o*/}
        <div className={`absolute ${isHovered ? "left-0 w-screen":"pointer-events-none left-0 w-screen"} py-1`}
                style={{ top: `${downPos}px`}}>
                
                <div className={`h-fit 
                    grid grid-cols-4 gap-8 pt-6 px-[90px] 
                    ${name==='Notion'? "pb-12" : ""} bg-white z-40 shadow
                    transition-all duration-500 ease-in-out
                    ${showDropdown ? "opacity-100 translate-y-0" 
                        : "opacity-0 -translate-y-[20%]"}
                `}>
        {showDropdown && ( // 드롭다운이 보여지게 되며 name의 값에따라 분기처리
            name === 'Notion' ? (
                <>
                    <div className="h-[300px] " ref={dropdownRef}>
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
                            <div className="p-2 group hover:bg-gray-200 rounded-[16px]">
                                <div className="flex gap-3">
                                    <p className="font-bold text-xl">기업 통합 검색</p>
                                    <span className="border-none rounded-[16px] px-[7px] py-[2px] leading-[14px] self-center h-[18px] text-blue-500 bg-blue-50 text-sm font-[600] content-center group-hover:bg-white">New</span>
                                </div>
                                <span className="text-sm text-gray-500">즉시 답변을 찾을 수 있는 기능</span>
                            </div>
                            <div className="p-2 group hover:bg-gray-200 rounded-[16px]">
                                <div className="flex gap-3">
                                    <p className="font-bold text-xl">AI 노트</p>
                                    <span className="border-none rounded-[16px] px-[7px] py-[2px] leading-[14px] self-center h-[18px] text-blue-500 bg-blue-50 text-sm font-[600] content-center group-hover:bg-white">New</span>
                                </div>
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
                    <div className="h-[300px] w-[280px]">
                        <div className="h-fit flex flex-col gap-4 p-4 bg-gray-100">
                            <div className="flex flex-col gap-6">
                                <p className="font-[600] lending-[1.25rem] text-[0.9rem] text-sm text-pretty">더 빠른 경험을 위한 Notion 데스크톱 앱 다운로드</p>
                                <span className="w-fit border border-blue-500 font-bold text-white rounded-[8px] py-2 px-4 cursor-pointer bg-blue-500 hover:bg-blue-600">앱 다운로드</span>
                            </div>
                            <div className="h-1/2">
                                <img className="h-fit" src="https://www.notion.com/_next/image?url=%2Ffront-static%2Fmeta%2Fstartups_background.png&w=256&q=75" />
                            </div>
                        </div>
                    </div>
                    </>
            ) :
            (
                // <div className="absolute left-0 w-screen py-1" 
                // style={{ top: `${downPos}px`}}>
                
                // <div className={`h-fit 
                //     grid grid-cols-4 gap-8 top-full
                //     py-6 px-[90px] bg-white z-50 shadow
                //     transition-all duration-500 ease-out
                //     ${hasAnimated ? "opacity-100 translate-y-0 " 
                //         : "opacity-0 -translate-y-[-20%]"}
                // `}>
                <>
                    <div className="h-fit p-7" ref={dropdownRef}>
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

                    <div className="h-fit p-7">
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

                    <div className="h-fit p-7">
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
                    
                    <div className="h-fit p-7">
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
                    </>
            //     </div>
            // </div>
            )
        )}
        </div>
        </div>
        
        </div>
    );
}