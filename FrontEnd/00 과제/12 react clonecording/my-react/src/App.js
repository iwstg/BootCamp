import Carousels from './components/Carousel';
import CustomerSounds from './components/companyReview';
import AppsList from './components/CombineAppList';
import DropList from './components/Dropdown';
import { useRef } from "react";
import LanguageSelection from './components/LanguageSelect'

function App() {
  const parentRef = useRef(null);

  return (
        <>
        {/* HEADER 상단 네비게이션 바 */}
      <section className="w-full my-0 mx-auto grid grid-cols-1 items-center sticky top-0 left-0 w-full bg-white shadow z-50">
        <nav className="w-full my-0 mx-auto h-auto grid grid-cols-[1fr_auto_1fr] items-center justify-between bg-white font-sm font-[500] leading-[1.25rem] py-[15px] px-[25px]">
          <div className="justify-self-start cursor-pointer">
            <img id="profileImage" src="https://img.icons8.com/?size=100&id=nZoJhBpPfVev&format=png&color=000000" width="40" />
          </div>

          <div className="col-2 flex items-center gap-1">
            
            <DropList name='Notion'/>

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
            
            <DropList name='둘러보기'/>

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

      {/* BODY(MAIN) 영역 */}
      <main className="flex justify-center my-0 mx-auto w-full min-h-full h-auto py-0 px-[clamp(0.2rem,7.22223%,100%)] border-b border-b-[rgba(0,0,0,0.24)] ">
        <section className="w-full max-w-[1250px] inline-flex flex-col gap-[32px]">
            {/* 메인페이지 - 배너 */}
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

            {/* 메인페이지 - Grid 구조 */}
            <section className="grid grid-cols-2 gap-5">

                <div className="flex flex-col border-2 border-red-50 rounded-2xl bg-red-50 overflow-hidden cursor-pointer hover:border-red-300 transition-colors duration-300" title="사용해보기">
                  <div className="p-4 w-full rounded-lg bg-red-50">
                    <div className="">
                      <div className="flex gap-2 items-center p-2">
                          <img className="" src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F2RmBatRiqNZT7mu44Qoifl%2F6a834087f3d0a018fa5b14a5bae00582%2Fai-meeting-notes-icon.png&w=32&q=75" />
                          <p className="font-[600] text-sm">AI 노트</p>
                          <span className="border bg-white rounded-[8px] opacity-80 text-xs">New</span>
                      </div>
                    </div>
                    <div className="flex justify-between px-2">
                      <div className="flex-start font-bold text-2xl mb-4">늘 완벽하게 작성되는 회의록.</div>
                      <div className="flex-end">
                        <svg height="32" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64" width="32">
                          <svg viewBox="0 0 33 32" style={{ width: "100%", height: "100%", display: "block", fill: "inherit", flexshrink: "0"}}>
                            <rect width="31.2" height="31.2" x=".9" y=".4" rx="15.6" stroke="#F6F5F4" stroke-width="1" fill="white"></rect>
                            <path fill="#000" d="m23.769 16-7.2 7.2-1.272-1.272 5.028-5.028H9.297v-1.8h11.028l-5.028-5.028L16.569 8.8l7.2 7.2Z"></path>
                          </svg>
                        </svg>
                      </div>
                    </div>
                  </div>
                  
                  <div className="">
                    <img src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F4zmmc2Sts2j750iWG4cz9C%2Fed6b4c918bd5c320bbe28df3519c6fa2%2Fbento_1.ko-KR.png&w=1920&q=75" alt="노션ai노트"></img>
                  </div>
                </div>

                <div className="flex flex-col border-2 border-blue-50 rounded-2xl bg-blue-50 overflow-hidden cursor-pointer hover:border-blue-300 transition-colors duration-300" title="사용해보기">
                  <div className="p-4 w-full rounded-lg bg-blue-50">
                    <div className="">
                      <div className="flex gap-2 items-center p-2">
                        <img src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F4Jnz1LdPqjujdW77jmtWTh%2Fa055aeb5baa46435d5db493456991bff%2Ficon_bento_search.png&w=32&q=75" />
                        <p className="font-[600] text-sm">기업 전용 검색</p>
                        <span className="border bg-white rounded-[8px] opacity-80 text-xs">New</span>
                      </div>
                    </div>
                    <div className="flex justify-between">
                      <div className="flex-start font-bold text-2xl mb-4">모든 검색을 한번에.</div>
                      <div className="flex-end">
                        <svg height="32" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64" width="32">
                          <svg viewBox="0 0 33 32" style={{ width: "100%", height: "100%", display: "block", fill: "inherit", flexshrink: "0"}}>
                            <rect width="31.2" height="31.2" x=".9" y=".4" rx="15.6" stroke="#F6F5F4" stroke-width="1" fill="white"></rect>
                            <path fill="#000" d="m23.769 16-7.2 7.2-1.272-1.272 5.028-5.028H9.297v-1.8h11.028l-5.028-5.028L16.569 8.8l7.2 7.2Z"></path>
                          </svg>
                        </svg>
                      </div>
                    </div>
                  </div>
                  
                  <div className="">
                    <img src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F2ZvcfZ5FYoh5mWSzqBAoqI%2F9d840ca56eed36ff543cb5b9ba0469d2%2Fbento_2.ko-KR.png&w=1920&q=75" alt="노션기업전용검색"></img>
                  </div>
                </div>


                <div className="min-h-[260px] col-span-2 flex border-2 border-yellow-50 rounded-2xl bg-yellow-50 overflow-hidden cursor-pointer hover:border-yellow-300 transition-colors duration-300" title="시작하기">
                  <div className="p-4 flex flex-col w-full rounded-lg bg-yellow-50">
                    <div className="">
                      <div className="flex gap-2 items-center p-2">
                        <img src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F1vDd1Xq1bijUBXwf3p33RL%2F70cae92019d022cc26708127829459ae%2Ficon_bento_projects.png&w=32&q=75" />
                        <p className="font-[600] text-sm">프로젝트</p>
                      </div>
                    </div>
                    <div className="flex flex-col glow-1 items-start h-full gap-2">
                      <div className="font-bold text-2xl">모든 계획을 순조롭게.</div>
                      <div className="self-auto mt-auto">
                        <svg height="32" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64" width="32">
                          <svg viewBox="0 0 33 32" style={{ width: "100%", height: "100%", display: "block", fill: "inherit", flexshrink: "0"}}>
                            <rect width="31.2" height="31.2" x=".9" y=".4" rx="15.6" stroke="#F6F5F4" stroke-width="1" fill="white"></rect>
                            <path fill="#000" d="m23.769 16-7.2 7.2-1.272-1.272 5.028-5.028H9.297v-1.8h11.028l-5.028-5.028L16.569 8.8l7.2 7.2Z"></path>
                          </svg>
                        </svg>
                      </div>
                    </div>
                  </div>
                  
                  <div className="flex">
                    <img className="mt-auto" src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2FsBvJS45PQCJBRR1hfIZH6%2Fc19f07720c52e4aa6db37035699e74de%2Fbento_3.ko-KR.png&w=1920&q=75" alt="노션프로젝트"></img>
                  </div>
                </div>


                <div className="flex flex-col border-2 border-gray-50 rounded-2xl bg-gray-50 overflow-hidden cursor-pointer hover:border-gray-300 transition-colors duration-300" title="무료 다운로드">
                  <div className="p-4 w-full rounded-lg bg-gray-50">
                    <div className="">
                      <div className="flex gap-2 items-center p-2">
                        <img src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F3ZUI2YU0fvfX5iqzaO6vy5%2F116f6227f7a97a126cac46377c0b6ea2%2Ficon_bento_mail.png&w=32&q=75" /> 
                        <p className="font-[600] text-sm">Notion 메일</p>
                        <span className="border bg-white rounded-[8px] opacity-80 text-xs">New</span>
                      </div>
                    </div>
                    <div className="flex justify-between">
                      <div className="flex-start font-bold text-2xl mb-4">나를 이해하는 수신함.</div>
                      <div className="flex-end">
                        <svg height="32" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64" width="32">
                          <svg viewBox="0 0 33 32" style={{ width: "100%", height: "100%", display: "block", fill: "inherit", flexshrink: "0"}}>
                            <rect width="31.2" height="31.2" x=".9" y=".4" rx="15.6" stroke="#F6F5F4" stroke-width="1" fill="white"></rect>
                            <path fill="#000" d="m23.769 16-7.2 7.2-1.272-1.272 5.028-5.028H9.297v-1.8h11.028l-5.028-5.028L16.569 8.8l7.2 7.2Z"></path>
                          </svg>
                        </svg>
                      </div>
                    </div>
                  </div>
                  
                  <div className="">
                    <img src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F3WUVrdpc8WmnGJooDLXPR7%2Fc4f16af2e58912c2c5733e167e50cd83%2Fbento_4.ko-KR.png&w=3840&q=75" alt="노션메일"></img>
                  </div>
                </div> 
                <div className="flex flex-col border-2 border-green-50 rounded-2xl bg-green-50 overflow-hidden cursor-pointer hover:border-green-300 transition-colors duration-300" title="템플릿 다운로드">
                  <div className="p-4 w-full rounded-lg bg-green-50">
                    <div className="">
                      <div className="flex gap-2 items-center p-2">
                        <img src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F7x3FVMsVsqlTTYDAC8PEpD%2F3a305e02cf4577a6d7b2acf0b979bb66%2Ficon_bento_templates.png&w=32&q=75" />
                        <p className="font-[600] text-sm">비즈니스 박스</p>
                      </div>
                    </div>
                    <div className="flex justify-between">
                      <div className="flex-start font-bold text-2xl mb-4">회사 운영 전반을 원활하게.</div>
                      <div className="flex-end">
                        <svg height="32" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64" width="32">
                          <svg viewBox="0 0 33 32" style={{ width: "100%", height: "100%", display: "block", fill: "inherit", flexshrink: "0"}}>
                            <rect width="31.2" height="31.2" x=".9" y=".4" rx="15.6" stroke="#F6F5F4" stroke-width="1" fill="white"></rect>
                            <path fill="#000" d="m23.769 16-7.2 7.2-1.272-1.272 5.028-5.028H9.297v-1.8h11.028l-5.028-5.028L16.569 8.8l7.2 7.2Z"></path>
                          </svg>
                        </svg>
                      </div>
                    </div>
                  </div>
                  
                  <div className="">
                    <img src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F4m5lpqe7uGKqVeCbxJTzs8%2F7b7350617571ee4598f20a318c7c4801%2Fbento_5.ko-KR.png&w=1920&q=75" alt="노션비지니스"></img>
                  </div>
                </div>
            </section>

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
            <section className="flex flex-col justify-center items-center">
              <h1 className="font-bold text-5xl m-4">팀마다 제공되는 개별 공간</h1>
              <Carousels />
            
            </section>

            {/* 메인페이지 - 하단 소개 */}
            <section className="flex flex-col items-center h-[320px] place-content-center">
              <div>
                <p className="font-bold text-lg mt-4">더 적은 도구, 더 높은 생산성</p>
              </div>
              <div className="">
                <img className="w-2/3 justify-self-center" src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F1VJq4eDjZKJfNP8ertYCn7%2F15adb9934fa5b1c74b5b050baa0bade9%2FCrossOut-L.png&w=3840&q=75" alt="더적은도구 더높은생산성"></img>
              </div>
            </section>

            {/* 메인페이지 - 하단 고객의소리 */}
            <section className="flex flex-col">
              <div className='flex p-4 gap-5'>
                i
                <span>고객 스토리</span>
              </div>
              <div className="flex justify-center items-center rounded-xl bg-gray-100">
                  <div className="w-full p-16 grid grid-cols-3 grid-rows-3 gap-3 divide-y divide-gray-300">
                      <div className="col-span-2 row-span-2 m-2 flex flex-col justify-around">
                        <div className="">
                          <img className="w-28" src="/res/OpenAI.png" alt="openAI"></img>
                        </div>
                        <div>
                          <span className="relative before:content-['˝'] before:absolute before:-left-4 before:top-0 text-4xl font-serif">
                            Notion은 하나의 플랫폼에서 모든 업무를 가능하게 하는 강력한 도구입니다.˝</span>
                        </div>
                        <a className='w-fit hover:underline hover:text-blue-500 cursor-pointer font-[300]'>더 보기 →</a>
                      </div>

                      {/* 누를경우 모달로 동영상 재생하는 페이지 하나 등장해야함 */}
                      <div className="row-span-2">
                        <img className="w-full border rounded-xl" src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F28Oz1efdtQCyLG1ocTdmHK%2F0b574e8bdb1c0d5d8b41e80fdb221595%2FHomepage_25_Thumbnail.jpg&w=384&q=75" alt="소개 동영상"></img>
                      </div>
                      {/* 고객의 소리 컴포넌트 */}
                      <CustomerSounds />
                  </div>
              </div>
            </section>

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
            <div className="flex justify-center gap-4 mt-16 pt-14">
              <div className="flex flex-col gap-2 w-2/5">
                <h1 className="text-balance font-bold text-[2.625rem] leading-tight tracking-tight mb-1">한 번의 검색으로 무엇이든 찾기</h1>
                <p className="text-sm font-[500] mb-4">Notion 내에서 회사의 모든 지식과 앱을 검색할 수 있습니다.</p>
                <div className="flex items-center mb-8">
                  <button className="bg-blue-600 text-white font-bold py-[6px] px-[16px] mr-4 rounded-lg">무료 체험하기</button>
                  <a href="" className="text-blue-500 hover:underline">데모 요청하기 →</a>
                </div>
                <div className="flex justify-start gap-10">
                  <ul className="columns-2">
                    <AppsList />
                  </ul>
                </div>
              </div>

              <div className="w-3/5">
                <img className="w-full" src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F1WQxz3QGRQ39BXXtHbC4Hq%2Fe0ec7a9113e0e0629ab2af60fb982318%2FEnterpriseSearch_-_Landscape_-_en-US.jpg&w=3840&q=75" />
              </div>
            </div>

            {/* 메인페이지 - 하단 Notion 시작하기 */}
            <div className='py-24'>
            <div className="grid grid-cols-2 grid-rows-2 gap-8 h-[680px]">
              <div className="row-span-2 bg-gray-100 border border-gray-200 rounded-xl overflow-hidden">
                <div className="flex flex-col justify-between gap-3 h-full">
                  <div className="flex flex-col p-6 gap-2">
                    <div>
                      {/* 노션 로고 (이미지) */}
                      <img className="h-12" src="https://img.icons8.com/?size=100&id=nZoJhBpPfVev&format=png&color=000000" />
                    </div>
                    <div className="flex flex-col">
                      <span className="font-bold text-2xl">Notion 시작하기</span>
                      <span className="font-[500]">나만의 AI 워크스페이스</span>
                    </div>
                    <div className="flex flex-col">
                      <div className="w-[250px] my-4">
                        <div className="border bg-black text-white rounded-lg py-1 w-[260px] px-5 text-wrap flex justify-center items-center cursor-pointer hover:bg-gray-800 transition-colors duration-300">
                            <img className="h-8 w-8 inline" src="https://upload.wikimedia.org/wikipedia/commons/5/5f/Windows_logo_-_2012.svg" />
                              <a className="pl-2">Windows로 다운로드하기</a>
                          </div>
                      </div>
                      <div className="border bg-black text-white rounded-lg py-1 w-[260px] px-5 text-wrap flex justify-center items-center cursor-pointer hover:bg-gray-800 transition-colors duration-300">
                          <img className="h-8 w-8" src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/Microsoft_Store.svg/1030px-Microsoft_Store.svg.png" />
                        <a className="pl-2">
                          Download from the <b>Microsoft Store</b>
                        </a>
                        </div>
                    </div>
                  </div>
                  <div className=''>
                    <img className="w-fit" src="https://www.notion.com/_next/image?url=%2Ffront-static%2Fdownloads%2Fnotion%2Fen-US.png&w=1920&q=75" />
                  </div>
                </div>
              </div>
              <div className="flex border border-gray-200 rounded-xl overflow-hidden justify-between bg-gray-100 ">
                <div className="flex flex-col p-6 gap-4">
                    {/* 종이비행기 svg  */}
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64" width="3rem">
                      <svg style={{ width: "100%", height: "100%", display: "block", fill: "inherit", flexshrink: "0"}} viewBox="0 0 22 22">
                        <path d="M1.55617 8.19127C0.579346 8.44327 0.322683 9.19783 0.797222 9.6789L4.51639 13.1375C4.56 13.1758 4.58732 13.2262 4.59755 13.2843L5.74661 19.8009C5.87804 20.5463 6.83186 20.7831 7.29769 20.1855L9.19411 17.7479C9.25825 17.6676 9.37598 17.656 9.45269 17.7253L12.4303 20.3926C13.1551 20.9664 14.1015 20.6318 14.3274 20.0581L20.8045 4.1832C21.3339 2.76468 20.2979 1.31037 18.3367 2.12389" fill="currentColor"></path>
                        <path d="M6.5025 11.7319C10.1428 9.58286 12.7689 7.53232 15.9535 5.62596C16.2611 5.44184 16.5291 5.82255 16.2599 6.05928C15.5026 6.72523 14.7709 7.37237 14.5951 7.54025C14.2008 7.91697 9.79719 11.6886 9.79719 11.6886L7.61508 13.6861C8.54636 15.0129 12.1389 17.7421 13.1126 18.1146C15.6038 13.1812 17.298 8.95012 19.0422 4.23471C19.1762 3.87253 18.8246 3.52014 18.4618 3.65253L7.97959 7.47798L3.24764 9.38752L6.5025 11.7319Z" fill="white"></path>
                      </svg>
                    </svg>
                  <div className="flex flex-col">
                    <span className="font-bold text-2xl">Notion 메일</span>
                    <span className="font-[500]">나를 이해하는 수신함.</span>
                  </div>
                  <button className="border bg-white rounded-lg py-1 px-5 hover:bg-gray-100 w-fit">다운로드하기</button>
                </div>
                <div className='h-fit mt-auto'>
                  <img className="w-[300px]" src="https://www.notion.com/_next/image?url=%2Ffront-static%2Fdownloads%2Fmail%2Fen-US.png&w=384&q=75" />
                </div>
              </div>
              <div className="flex border border-gray-200 rounded-xl justify-between bg-gray-100 overflow-hidden">
                <div className="flex flex-col p-6 gap-4"> 
                  {/* 캘린더 svg */}
                  <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64" width="3em">
                    <svg style={{ width: "100%", height: "100%", display: "block", fill: "inherit", flexshrink: "0"}} viewBox="0 0 57 60">
                      <path d="M6.18613 49.1689C5.15664 49.1575 4.2418 48.8935 3.53102 48.23C3.53102 48.23 3.52873 48.23 3.52643 48.2254C3.44389 48.1451 3.36593 48.0625 3.29256 47.9798C2.73082 47.337 2.42587 46.5129 2.42587 45.6222L2.41899 8.93385C2.41899 6.81041 4.20741 4.90505 6.3237 4.77421L42.9289 2.50615C43.0091 2.50155 43.0871 2.49926 43.1673 2.49926C44.0822 2.49926 44.9351 2.82983 45.5863 3.44505C45.6757 3.52999 45.7605 3.61722 45.8385 3.70904C46.0494 3.95008 46.2237 4.21637 46.3613 4.50332C46.226 4.21867 46.0494 3.95238 45.8385 3.71134C46.3865 4.34952 46.6869 5.16216 46.6869 6.04368V6.98258C46.6869 6.98258 46.7098 7.75161 45.9486 7.80211L45.9531 7.8067L12.2851 9.91866C9.81569 10.0725 7.80946 12.2143 7.80946 14.6912C7.80946 14.6912 7.7957 48.5537 7.79341 48.6088C7.76819 49.1689 7.30733 49.1689 6.92672 49.1689H6.18613Z" fill="black"></path>
                      <path d="M54.5994 52.0086C54.5994 52.0637 54.5948 52.1188 54.5902 52.1739C54.51 53.3515 53.5722 54.3892 52.4189 54.6026C52.396 54.6026 52.3731 54.6095 52.3501 54.6095L13.3008 56.9763H13.1792C12.4157 56.9373 11.7095 56.6434 11.1592 56.1246C10.5425 55.5438 10.1963 54.7496 10.171 53.8795C10.171 53.8451 10.1664 53.8107 10.1664 53.7739V14.9277C10.1664 14.8726 10.1664 14.8198 10.171 14.7647C10.2559 13.5182 11.2968 12.4301 12.5395 12.3015C12.5716 12.3015 12.6037 12.2923 12.6358 12.29L51.7058 9.83832C51.7677 9.83373 51.8296 9.83143 51.8916 9.83143C52.5955 9.83143 53.2512 10.0862 53.7533 10.5568C54.1041 10.8851 54.3518 11.296 54.4848 11.7529C54.5421 11.948 54.5765 12.1523 54.5902 12.3612L54.5994 52.0086Z" fill="black"></path>
                      <path fill-rule="evenodd" clip-rule="evenodd" d="M48.9865 50.7782L16.2929 52.6835C14.9562 52.7776 13.7731 52.3231 13.8098 50.5693V23.2699C13.8098 22.3333 14.5802 21.7341 15.4308 21.6905L49.4199 19.6497C50.2682 19.6061 50.963 20.2213 50.963 21.073V48.4206C50.963 49.4215 50.713 50.7093 48.9934 50.7759H48.9888L48.9865 50.7782Z" fill="white"></path>
                      <path d="M23.935 29.9662C22.3369 30.0649 21.7958 31.2862 21.7981 33.164V33.4945C21.6078 33.5405 21.4473 33.5818 21.2547 33.5933C20.1037 33.6644 19.2737 32.7278 19.2714 31.0474C19.2691 28.4763 21.5665 26.0591 25.9435 25.7859C29.8414 25.5426 32.336 27.4296 32.3406 30.7582C32.3406 33.2627 30.2678 35.0418 28.2249 35.5973C32.0585 35.7856 33.6589 37.9274 33.6635 40.6637C33.6681 45.3445 30.2518 47.9959 24.9805 48.3242L24.8521 48.3311C20.8901 48.579 18.1089 47.0708 18.1066 44.4675C18.1066 42.9846 19.1888 41.7312 20.819 41.6279C20.9474 41.6187 21.0735 41.6439 21.2019 41.6371C21.5252 44.2862 23.3159 45.2618 25.1044 45.1516C26.8286 45.0437 28.0415 43.8799 28.0415 42.2316V42.165C28.0392 39.594 25.8977 39.4654 22.6694 39.3369L22.1558 36.2699C25.1594 35.719 26.6589 34.7365 26.6566 32.9574C26.6566 31.0451 25.5996 29.8583 23.9373 29.9639H23.935V29.9662Z" fill="black"></path>
                      <path d="M38.3432 28.7036C35.1492 29.6287 34.4453 28.2215 34.7938 26.75C36.7107 26.3001 41.693 24.8034 43.5777 24.1262L43.6007 43.8684L47.0835 44.3757C47.0835 45.6613 46.3498 46.4647 45.0406 46.5474C43.9537 46.6139 41.4293 46.7058 40.2164 46.7815C38.3317 46.8986 34.881 47.181 34.881 47.181C34.7847 46.9238 34.7526 46.6621 34.7526 46.4303C34.7526 45.8036 35.0071 45.1608 35.8371 44.8785L38.3592 44.0612L38.3409 28.7036H38.3432Z" fill="black"></path>
                    </svg>
                  </svg>
                  <div className="flex flex-col">
                    <span className="font-bold text-2xl">Notion 캘린더</span>
                    <span className="font-[500]">일과 시간을 함께 관리하는 곳.</span>
                  </div>
                  <button className="border bg-white rounded-lg py-1 px-5 hover:bg-gray-100 w-fit">다운로드하기</button>
                </div>
                <div className="h-fit mt-auto">
                  <img className="w-[300px]" src="https://www.notion.com/_next/image?url=%2Ffront-static%2Fdownloads%2Fcalendar%2Fen-US.png&w=384&q=75" />
                </div>
              </div>
            </div>
            <p className="text-gray-400 cursor-default text-sm">
              Notion은 사용 중인 브라우저에서 <a className="underline hover:text-blue-500 cursor-pointer">언제든지 사용할 수 있습니다.</a>.
            </p>
          </div>
        </section>
      </main>

      {/* FOOTER 하단 네비게이션 바 */}
      <div className="my-auto mx-[34.5px] py-[80px] px-[125px] flex justify-center">
        <section className="w-full max-w-[1250px] flex gap-[24px] justify-between">
            <div className="w-1/4 flex flex-col justify-stretch items-start gap-[24px]">
                <svg className="w-[10rem] h-[48px]" viewBox="0 0 105 30" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <g clip-path="url(#a)">
                        <mask id="b" width="29" height="30" x="0" y="0" maskUnits="userSpaceOnUse">
                            <path fill="#fff" d="M28.714 0H0v29.995h28.714V0Z"></path>
                        </mask>
                        <g mask="url(#b)">
                            <path fill="#fff" d="M1.805 1.29 18.403.069c2.038-.175 2.563-.057 3.844.873l5.298 3.724c.874.64 1.166.815 1.166 1.513v20.424c0 1.28-.467 2.037-2.097 2.153L7.34 29.919c-1.224.058-1.806-.116-2.447-.931L.99 23.925c-.7-.931-.99-1.628-.99-2.444V3.326c0-1.046.466-1.92 1.805-2.035Z"></path>
                            <path className="wordmark_fill__RZFeq" fill="#000" fill-rule="evenodd" d="M18.403.068 1.805 1.291C.466 1.406 0 2.28 0 3.326v18.155c0 .816.29 1.513.99 2.444l3.902 5.063c.64.815 1.223.99 2.447.93l19.275-1.163c1.63-.116 2.097-.873 2.097-2.153V6.178c0-.662-.262-.853-1.034-1.416a89.567 89.567 0 0 1-.132-.097L22.247.941C20.966.011 20.44-.107 18.403.068ZM7.776 5.843c-1.574.106-1.931.13-2.825-.596L2.678 3.443c-.232-.233-.115-.524.467-.581l15.957-1.164c1.339-.117 2.038.35 2.562.756l2.737 1.979c.116.058.407.407.058.407l-16.48.99-.203.013ZM5.94 26.427V9.087c0-.756.233-1.105.932-1.164l18.926-1.105c.642-.058.933.35.933 1.105v17.223c0 .758-.117 1.398-1.166 1.456L7.455 27.65c-1.05.058-1.515-.29-1.515-1.223Zm17.88-16.41c.116.525 0 1.049-.526 1.108l-.872.174v12.8c-.758.408-1.457.64-2.039.64-.932 0-1.165-.29-1.864-1.163l-5.707-8.96v8.67l1.806.407s0 1.047-1.458 1.047l-4.017.233c-.117-.233 0-.815.408-.931l1.048-.29V12.287l-1.456-.117c-.116-.524.174-1.28.99-1.338l4.31-.29 5.94 9.077v-8.03l-1.514-.174c-.117-.641.349-1.107.931-1.164l4.02-.234Z" clip-rule="evenodd"></path>
                        </g>
                        <path className="wordmark_fill__RZFeq" fill="#000" d="M50.995 7.02V23.23h-2.587L40.739 12.14h-.134V23.23h-2.913V7.02h2.612l7.652 11.087h.15V7.021h2.89Zm7.715 16.446c-1.187 0-2.216-.261-3.087-.784a5.269 5.269 0 0 1-2.018-2.192c-.474-.939-.712-2.036-.712-3.292 0-1.256.237-2.356.712-3.3s1.148-1.678 2.018-2.2c.87-.522 1.9-.784 3.087-.784 1.182 0 2.208.262 3.078.784.87.522 1.544 1.256 2.018 2.2.48.944.72 2.044.72 3.3 0 1.256-.24 2.353-.72 3.292a5.269 5.269 0 0 1-2.018 2.193c-.87.522-1.896.783-3.078.783Zm.008-2.28c.654 0 1.197-.176 1.63-.53.433-.358.757-.838.973-1.44.217-.607.325-1.282.325-2.026 0-.744-.108-1.419-.325-2.026-.216-.607-.54-1.09-.973-1.448-.433-.364-.976-.546-1.63-.546-.66 0-1.209.182-1.646.546-.438.359-.765.841-.982 1.448-.21.607-.316 1.282-.316 2.026 0 .744.105 1.42.316 2.026.217.602.544 1.082.982 1.44.438.354.986.53 1.646.53ZM72.33 11.074v2.2h-6.964v-2.2h6.964ZM67.09 8.16h2.842v11.42c0 .385.058.68.174.887.121.205.28.345.475.419.195.074.414.11.657.11a2.8 2.8 0 0 0 .49-.039c.148-.026.264-.05.349-.071l.474 2.224a6.49 6.49 0 0 1-.648.174c-.28.063-.623.1-1.03.11-.712.022-1.355-.086-1.93-.324a3.04 3.04
                        0 0 1-1.361-1.116c-.333-.506-.496-1.142-.491-1.907V8.16Zm6.983 15.069V11.073h2.85v12.156h-2.85Zm1.433-13.89c-.454 0-.842-.15-1.164-.45a1.456 1.456 0 0 1-.483-1.093c0-.427.161-.791.483-1.092a1.645 1.645 0 0 1 1.163-.459c.454 0 .842.153 1.164.46.327.3.49.664.49 1.091 0 .422-.163.786-.49 1.092-.322.301-.71.452-1.163.452Zm8.99 14.127c-1.187 0-2.216-.261-3.087-.784a5.268 5.268 0 0 1-2.018-2.192c-.474-.939-.712-2.036-.712-3.292 0-1.256.238-2.356.712-3.3.475-.944 1.148-1.678 2.018-2.2.871-.522 1.9-.784 3.087-.784 1.182 0 2.208.262 3.078.784.871.522 1.544 1.256 2.019 2.2.48.944.72 2.044.72 3.3 0 1.256-.24 2.353-.72 3.292a5.267 5.267 0 0 1-2.019 2.193c-.87.522-1.896.783-3.078.783Zm.008-2.28c.654 0 1.197-.176 1.63-.53.433-.358.757-.838.974-1.44.216-.607.324-1.282.324-2.026 0-.744-.108-1.419-.324-2.026-.217-.607-.541-1.09-.974-1.448-.433-.364-.976-.546-1.63-.546-.66 0-1.208.182-1.646.546-.438.359-.765.841-.982 1.448-.21.607-.316 1.282-.316 2.026 0 .744.105 1.42.316 2.026.217.602.544 1.082.982 1.44.438.354.986.53 1.646.53Zm10.406-5.088v7.13h-2.848V11.074h2.722v2.057h.143a3.48 3.48 0 0 1 1.337-1.614c.617-.401 1.38-.602 2.288-.602.833 0 1.561.18 2.184.539a3.63 3.63 0 0 1 1.456 1.559c.348.68.522 1.506.522 2.477v7.74h-2.84v-7.305c0-.813-.212-1.448-.634-1.907-.423-.464-1.006-.697-1.75-.697-.5 0-.946.111-1.337.333-.39.216-.696.532-.918.95-.216.41-.325.91-.325 1.495Z"></path>
                    </g>
                </svg>

                <div className="w-full">
                    <ul aria-label="Social media" role="list" className="flex gap-1">
                        <li className="h-8 w-8 roundred-sm hover:bg-gray-200 content-center justify-items-center cursor-pointer">
                            <svg className="shareInstagram" viewBox="0 0 18 18" style={{width:"18px", height:"18px", display:"block", fill:"currentColor", flexshrink:"0" }}>
                                <path fill-rule="evenodd" clip-rule="evenodd" d="M9 1.621c2.405 0 2.689.011 3.635.053.879.039 1.354.186 1.67.309.418.162.721.359 1.034.671.316.316.51.615.675 1.034.123.316.271.795.309 1.67.042.949.053 1.234.053 3.635s-.011 2.689-.053 3.635c-.039.879-.186 1.354-.309 1.67a2.802 2.802 0 01-.671 1.034c-.316.316-.615.51-1.034.675-.316.123-.795.271-1.67.309-.949.042-1.234.053-3.635.053s-2.689-.011-3.635-.053c-.879-.039-1.354-.186-1.67-.309a2.802 2.802 0 01-1.034-.671 2.815 2.815 0 01-.675-1.034c-.123-.316-.271-.795-.309-1.67-.042-.949-.053-1.234-.053-3.635s.011-2.689.053-3.635c.039-.879.186-1.354.309-1.67.162-.418.359-.721.671-1.034.316-.316.615-.51 1.034-.675.316-.123.795-.271 1.67-.309.946-.042 1.23-.053 3.635-.053zM9 0C6.557 0 6.251.011 5.291.053 4.335.095 3.677.25 3.108.471a4.389 4.389 0 00-1.596 1.041A4.404 4.404 0 00.471 3.105C.25 3.678.095 4.332.053 5.288.011 6.251 0 6.557 0 9c0 2.443.011 2.749.053 3.709.042.956.197 1.614.418 2.183a4.389 4.389 0 001.041 1.596 4.392 4.392 0 001.593 1.037c.573.221 1.227.376 2.183.418.96.042 1.266.053 3.709.053s2.749-.011 3.709-.053c.956-.042 1.614-.197 2.183-.418a4.413 4.413 0 001.593-1.037c.5-.499.809-1.002 1.037-1.593.221-.573.376-1.227.418-2.183.042-.96.053-1.266.053-3.709s-.011-2.749-.053-3.709c-.042-.956-.197-1.614-.418-2.183a4.21 4.21 0 00-1.03-1.6A4.392 4.392 0 0014.896.474c-.573-.221-1.227-.376-2.183-.418C11.75.01 11.444 0 9 0zm0 4.377A4.625 4.625 0 004.377 9 4.625 4.625 0 009 13.623 4.625 4.625 0 0013.623 9 4.625 4.625 0 009 4.377zm0 7.622A3 3 0 119 6 3 3 0 019 12zm4.806-6.726a1.079 1.079 0 100-2.158 1.079 1.079 0 000 2.158z"></path>
                            </svg>
                        </li>
                        <li className="h-8 w-8 roundred-sm hover:bg-gray-200 content-center justify-items-center cursor-pointer">
                            <svg className="shareX" viewBox="0 0 15 13" style={{width:"20px",height:"16px",display:"block",fill:"currentColor",flexshrink:"0"}}><path d="M11.787.523h2.109L9.289 5.788l5.42 7.164h-4.244L7.142 8.607 3.34 12.952H1.23l4.927-5.631L.958.523H5.31l3.004 3.972L11.787.523Zm-.74 11.167h1.169L4.674 1.719H3.421l7.626 9.971Z"></path>
                            </svg>
                        </li>
                        <li className="h-8 w-8 roundred-sm hover:bg-gray-200 content-center justify-items-center cursor-pointer">
                            <svg className="shareLinkedIn" viewBox="0 0 16 16" style={{width:"20px",height:"16px",display:"block",fill:"currentColor",flexshrink:"0"}}>
                                <defs>
                                    <clipPath id="linkedin-clip-1">
                                        <path d="M0 0h16v16H0z"></path>
                                    </clipPath>
                                </defs>
                                <path d="M14.81 0H1.18C.53 0 0 .52 0 1.15v13.69C0 15.48.53 16 1.18 16h13.63c.65 0 1.18-.52 1.18-1.15V1.15c0-.64-.53-1.15-1.18-1.15ZM4.75 13.63H2.38V5.99h2.37v7.64ZM3.56 4.96c-.76 0-1.38-.62-1.38-1.37s.62-1.37 1.38-1.37 1.37.62 1.37 1.37-.62 1.37-1.37 1.37Zm10.07 8.67h-2.37V9.92c0-.88-.02-2.02-1.23-2.02s-1.42.97-1.42 1.96v3.77H6.24V5.99h2.27v1.04h.03c.32-.6 1.09-1.23 2.24-1.23 2.4 0 2.85 1.58 2.85 3.64v4.19Z" style={{clippath:"url(#linkedin-clip-1)"}}></path>
                            </svg>
                        </li>
                        <li className="h-8 w-8 roundred-sm hover:bg-gray-200 content-center justify-items-center cursor-pointer">
                          <svg className="shareFacebook" viewBox="0 0 18 18" style={{width:"20px",height:"16px",display:"block",fill:"currentColor",flexshrink:"0"}}>
                              <path d="M17.999 8.999c0-4.97-4.029-8.999-8.999-8.999s-8.999 4.029-8.999 8.999c0 4.492 3.291 8.215 7.593 8.89v-6.289h-2.285v-2.601h2.285v-1.983c0-2.255 1.344-3.501 3.399-3.501 0.985 0 2.015 0.176 2.015 0.176v2.215h-1.135c-1.118 0-1.467 0.694-1.467 1.405v1.688h2.496l-0.399 2.601h-2.097v6.289c4.302-0.675 7.593-4.398 7.593-8.89z"></path>
                          </svg>
                        </li>
                        <li className="h-8 w-8 roundred-sm hover:bg-gray-200 content-center justify-items-center cursor-pointer">
                          <svg className="shareYouTube" viewBox="0 0 18 18" style={{width:"20px",height:"16px",display:"block",fill:"currentColor",flexshrink:"0"}}>
                              <path d="M9 2.070c-8.845 0-9 0.787-9 6.93s0.155 6.93 9 6.93 9-0.787 9-6.93-0.155-6.93-9-6.93zM11.884 9.301l-4.041 1.886c-0.354 0.164-0.644-0.020-0.644-0.41v-3.553c0-0.39 0.29-0.574 0.644-0.41l4.041 1.886c0.354 0.166 0.354 0.436 0 0.601z"></path>
                          </svg>
                        </li>
                    </ul>    
                </div>
                <div className="mt-auto flex flex-col gap-3">
                    <LanguageSelection />
                    
                    {/* <select className="border h-3 w-8">언어설정
                      <option value="한국어"></option>
                      <option value="영어"></option>
                      <option value="일본어"></option>
                      <option value="중국어"></option>

                    </select> */}
                    <span className="text-sm text-gray-400">쿠키 설정</span>
                    <span className="text-sm font-[500] text-gray-400">© 2025 Notion Labs, Inc.</span>
                </div>
                
            </div>

            
            <nav className="w-3/4">
                <div className="grid grid-cols-[repeat(4,_minmax(10px,_1fr))] text-sm">
                    <ul className='m-0 mb-[36px] p-0 list-none break-inside-avoid flex flex-col items-start'>
                        <li className="block cursor-default mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word font-bold">회사 소개</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">Notion 소개</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">채용</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">보안</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">서비스 상태</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">이용약관 및 개인정보 보호정책</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">개인정보 보호 권한</li>
                    </ul>
                    <ul className='m-0 mb-[36px] p-0 list-none break-inside-avoid flex flex-col items-start'>
                        <li className="block cursor-default mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word font-bold">다운로드</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">iOS & Android</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">Mac & Windows</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">캘린더</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">Web Clipper</li>
                    </ul>
                    <ul className='m-0 mb-[36px] p-0 list-none break-inside-avoid flex flex-col items-start'>
                        <li className="block cursor-default mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word font-bold">자료</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">도움말 센터</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">요금제</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">블로그</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">커뮤니티</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">API 통합</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">템플릿</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">추천인</li>
                    </ul>
                    <ul className="m-0 mb-[36px] p-0 list-none break-inside-avoid flex flex-col items-start justify-start">
                        <li className="block cursor-default mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word font-bold">용도별</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">회사</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">팀</li>
                        <li className="block cursor-pointer mt-[0.4rem] leading-[1.35rem] text-left wrap-break-word hover:underline decoration-blue-400">개인</li>
                        <span className="mt-auto font-bold hover:underline hover:text-blue-500 cursor-pointer">더 살펴보기 →</span>
                    </ul>
                </div>
            </nav>
        </section>
    </div>
    </>
  );
}

export default App;
