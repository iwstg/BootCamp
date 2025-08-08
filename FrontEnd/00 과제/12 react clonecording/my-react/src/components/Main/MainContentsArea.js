import MainBanner from "./MainBanner"
import MainCareComponents from './MainCardComponents'
import MainCarousel from './MainCarousel'
import MainCompanyReview from './MainCompanyReview'
import MainCombineAppList from './MainCombineAppList'
import MainStartNotion from './MainStartNotion'

export default function MainContentsArea(){
    return (
    <main className="flex justify-center my-0 mx-auto w-full min-h-full h-auto py-0 px-[clamp(0.2rem,7.22223%,100%)] border-b border-b-[rgba(0,0,0,0.24)] ">
        <section className="w-full max-w-[1250px] inline-flex flex-col gap-[32px]">
            {/* 메인페이지 - 배너 */}
            <MainBanner />

            {/* 메인페이지 - 사용 회사목록 */}
            <section className="flex items-center justify-between gap-4">
                <span className="text-sm font-normal text-customColor">Notion을 믿고 쓰는 고객</span>
                <img className="h-8 object-contain" src="/res/Daangn_Logo.png" alt="당근로고"></img>
                <img className="h-8 object-contain" src="/res/KakaoStyle_Logo.png" alt="카카오스타일로고"></img>
                <img className="h-8 object-contain" src="/res/LGAI_Logo.png" alt="LGAI로고"></img>
                <img className="h-8 object-contain" src="/res/OpenAI.png" alt="openAI로고"></img>
                <img className="h-8 object-contain" src="/res/socar_Logo.png" alt="쏘카로고"></img>
                <img className="h-8 object-contain" src="/logo192.png" alt="리액트로고"></img>
            </section>

            {/* 메인페이지 - 카드컴포넌트 */}
            <MainCareComponents />

            {/* 메인페이지 - 중간 소개 */}
            <section className="flex flex-col items-center h-[280px] place-content-center">
              <div>
                <p className="font-serif font-bold text-4xl m-4">"Ai의 모든 것을 담은 앱."</p>
              </div>
              <div className="">
                <img className="h-5" src="https://images.ctfassets.net/spoqsaf9291f/3FH43ruDfwZILGSgjnJ2sn/82bb2e9bfd3521c58e53a395bd72c6f6/forbes.png" alt="Forbes"></img>
              </div>
            </section>

            {/* 메인페이지 - 중간 캐러셀 */}
            <MainCarousel />

            {/* 메인페이지 - 하단 중간 소개 */}
            <section className="flex flex-col items-center h-[320px] place-content-center">
              <div>
                <p className="font-bold text-lg mt-4">더 적은 도구, 더 높은 생산성</p>
              </div>
              <div className="">
                <img className="w-2/3 justify-self-center" src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F1VJq4eDjZKJfNP8ertYCn7%2F15adb9934fa5b1c74b5b050baa0bade9%2FCrossOut-L.png&w=3840&q=75" alt="더적은도구 더높은생산성"></img>
              </div>
            </section>

            {/* 메인페이지 - 하단 고객 스토리 기업들리뷰 */}
            <MainCompanyReview />

            {/* 마퀴 에니메이션 구현 (자연스럽지않음..) */}
            <div className="relative overflow-hidden whitespace-nowrap w-full">
                <div className="flex animate-marquee hover:[animation-play-state:paused]">
                  <div className="flex gap-8 shrink-0">
                    <p className="w-fit flex gap-4 items-center">
                      <p><img className="h-4" src="logo192.png"/></p>
                      Fortune 100 기업의 62%가 Notion 사용
                    </p>
                    <p className="w-fit flex gap-4 items-center">
                      <p><img className="h-4" src="logo192.png"/></p>#AI 글쓰기 1위 (G2)</p>
                    <p className="w-fit flex gap-4 items-center">
                      <p><img className="h-4" src="logo192.png"/></p>YC 기업의 50% 이상</p>
                    <p className="w-fit flex gap-4 items-center">
                      <p><img className="h-4" src="logo192.png"/></p>140만 명이 넘는 커뮤니티 멤버</p>
                    <p className="w-fit flex gap-4 items-center">
                      <p><img className="h-4" src="logo192.png"/></p>1억 명 이상의 전세계 사용자</p>
                    <p className="w-fit flex gap-4 items-center">
                      <p><img className="h-4" src="logo192.png"/></p>#3년 연속 지식 베이스 1위 (G2)</p>      
                    
                    <p className="w-fit flex gap-4 items-center" aria-hidden="true" tabindex="-1">
                      <p><img className="h-4" src="logo192.png"/></p>Fortune 100 기업의 62%가 Notion 사용</p>
                    <p aria-hidden="true" tabindex="-1" className="w-fit flex gap-4 items-center">
                      <p><img className="h-4" src="logo192.png"/></p>#AI 글쓰기 1위 (G2)</p>
                    <p aria-hidden="true" tabindex="-1" className="w-fit flex gap-4 items-center">
                      <p><img className="h-4" src="logo192.png"/></p>YC 기업의 50% 이상</p>
                    <p aria-hidden="true" tabindex="-1" className="w-fit flex gap-4 items-center">
                      <p><img className="h-4" src="logo192.png"/></p>140만 명이 넘는 커뮤니티 멤버</p>
                    <p aria-hidden="true" tabindex="-1" className="w-fit flex gap-4 items-center">
                      <p><img className="h-4" src="logo192.png"/></p>1억 명 이상의 전세계 사용자</p>
                    <p aria-hidden="true" tabindex="-1" className="w-fit flex gap-4 items-center">
                      <p><img className="h-4" src="logo192.png"/></p>#3년 연속 지식 베이스 1위 (G2)</p>                    
                  </div>
                </div>
            </div>

            {/* 메인페이지 - 하단 한번의 검색으로 무엇이든 찾기 */}
            <MainCombineAppList />

            {/* 메인페이지 - 하단 Notion 시작하기 */}
            <MainStartNotion />
        </section>
    </main>
    );
}