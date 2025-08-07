export default function dropNoion(){
    return (
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
    )
}