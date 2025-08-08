export default function MainBanner(){
    return(
        <section className="max-w-full min-h-[400px] max-h-[720px] flex justify-between items-center py-[65px] px-0 my-[50px] mx-0 gap-[24px]">
                <div className="flex flex-col items-start min-w-[450px] w-full justify-between m-0 p-0 text-balance gap-[16px]">
                    <h1 className="w-full text-[4rem] font-[600] leading-[4rem] tracking-[-0.1328125rem] ">나만을 위한 AI 워크스페이스</h1>

                    <h2 className="w-full text-[1.375rem] font-[500] leading-[1.75rem] tracking-[-0.015625rem]">팀이 모든 답을 찾고, 반복 업무를 자동화하며, 프로젝트를 완료할 수 있는 하나의 공간.</h2>

                    <nav className="flex gap-[15px] w-full">
                        <a className="min-h-[2.25rem] py-[0.25rem] px-[0.875rem] flex items-center justify-center rounded-[0.5rem] border outline-black
                            text-white bg-blue-600 w-fit font-sm font-[500] leading-[1.25rem] cursor-pointer hover:bg-blue-700 hover:bg-blue-700">Notion 무료로 시작하기</a>
                        <button className="py-[.6875rem] px-[1.25rem] w-fit border rounded-lg bg-blue-50 text-blue-700 outline-blue-50 font-[500] hover:bg-blue-100">데모 요청하기</button>
                    </nav>
                </div>
                <div className="w-full h-auto rounded-[8px]">
                    
                    <img className="w-full" src="/res/noseyHeroV2.png" alt="노션얼굴3개이미지"/>
                </div>
        </section>
    );
}