import React, { useEffect, useState } from "react";
import MainVideoModal from "./MainVideoModal";

const customerSounds=[
  {name:"Toyota", src:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F1fJCIIjK31CRPMPj7Bp9Mu%2Fa48f183d399e7483799401f44053e306%2Ftoyota.png&w=1920&q=75", title:"워크플로를 간소화하여 타임라인을 3분의 1로 줄였습니다. →", link:"/ko/customers/toyota"},
  {name:"ramp", src:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F4eiEZBWL5gEClwB1IHi18I%2Fb9b86479965977121ceabd01f45567a7%2Framp.png&w=1920&q=75", title:"\"Notion 덕분에 Ramp의 모든 팀원에게 AI 비서가 생겼습니다.\" →", link:"/ko/customers/ramp"},
  {name:"Vercel", src:"https://images.ctfassets.net/spoqsaf9291f/15en0a60cYTRxNO1QlHbdg/f09657a6b8287f1db0e628a048267e2c/vercel-logotype-light.svg", title:"\"Notion은 하나의 툴로 많은 문제를 해결할 수 있다는 것을 이해합니다.\" →", link:"/ko/customers/vercel"},
  {name:"MatchGroup", src:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F2Z03v7BH2brwtBG2qdA5dp%2Fd6cd228d2f7b6048edcec9f4d5bcce3c%2Fmatch.png&w=640&q=75", title:"\"Notion은 워크플로를 간소화하는 가장 강력하고 영향력 있는 툴입니다.\" →", link:"/ko/customers/match"},
  {name:"deel", src:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F5sSU1RuGiuXiLOo6BTB6JT%2F459aa7c6824c18b7faaca2b0c3606d62%2Fdeel_2025.png&w=1080&q=75", title:"\"Deel의 신규 입사자는 누군가에게 문의하지 않고도 스스로 온보딩할 수 있습니다.\" →", link:"/ko/customers/deel"},
  {name:"planful", src:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F3pCaKcH2gCNdmeLdzdL66F%2Fc6cd3b5670585d9feb298de532930d24%2FPlanful_Logo.png&w=640&q=75", title:"6개의 앱이 하나로 단일화됐습니다! 모든 팀이 Notion AI에서 더 빠르게 성장하고 있습니다. →", link:"/ko/customers/planfun"}
]

export default function CompanyReview(){
    const [isModalOpen, setIsModalOpen] = useState(false);
    useEffect(() => {
    console.log("모달 상태:", isModalOpen);
    }, [isModalOpen]);
    return(
        <section className="flex flex-col">
            <div className='flex py-4 gap-2'>
                <svg className="w-[2rem] p-1 border-none bg-gray-100 rounded-xl" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64">
                    <defs fill="currentColor"></defs>
                    <path d="m32,8c-14.81,0-24,8.43-24,22,0,6.92,2.4,12.49,6.7,16.3l-6.7,6.7,2,3c5.42,0,10.43-1.8,14.45-4.84,2.32.55,4.84.84,7.55.84,14.81,0,24-8.43,24-22s-9.19-22-24-22Zm0,8c4.94,0,8,3.06,8,8s-3.06,8-8,8-8-3.06-8-8,3.06-8,8-8Zm0,30c-5.6,0-10.03-1.41-13.09-4.03,2.72-3.81,7.24-5.97,13.09-5.97s10.37,2.16,13.09,5.97c-3.06,2.62-7.49,4.03-13.09,4.03Z" fill="currentColor"></path>
                </svg>
                <span className="font-[600] tracking-tighter self-center">고객 스토리</span>
            </div>
            <div className="flex justify-center items-center rounded-xl bg-gray-100">
                <div className="w-full p-16 grid grid-cols-3 grid-rows-3 gap-3 divide-y divide-gray-300">
                    <div className="col-span-2 row-span-2 m-2 flex flex-col justify-around">
                        <div className="">
                            <img className="w-28" src="/res/OpenAI.png" alt="openAI"></img>
                        </div>
                        <div>
                            <span className="relative before:content-['“'] before:absolute before:-left-5 before:top-0 text-[2.625rem] leading-[3rem] tracking-[-0.09375rem] font-serif">
                            Notion은 하나의 플랫폼에서 모든 업무를 가능하게 하는 강력한 도구입니다.”</span>
                            
                        </div>
                        <a className='w-fit hover:underline hover:text-blue-500 cursor-pointer font-[300]'>더 보기 →</a>
                    </div>

                    {/* 누를경우 모달로 동영상 재생하는 페이지 하나 등장해야함 */}
                    <div className="group relative row-span-2" onClick={() => setIsModalOpen(true)}>
                        <img className="w-full border rounded-xl 
                        cursor-pointer group-hover:shadow-2xl group-hover:opacity-80
                        transition-all duration-500 ease-in-out"
                        src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F28Oz1efdtQCyLG1ocTdmHK%2F0b574e8bdb1c0d5d8b41e80fdb221595%2FHomepage_25_Thumbnail.jpg&w=384&q=75"
                        alt="소개 동영상"></img>
                        <span className="absolute cursor-pointer bottom-14 right-4 border-none bg-white rounded-full p-3
                        group-hover:shadow-2xl group-hover:opacity-80
                        transition-all duration-500 ease-in-out">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64" className="w-[1.5rem] pl-[2px]">
                                <defs fill="currentColor"></defs>
                                <path d="m50,30v4l-32,16h-4V14h4l32,16Z" fill="gray"></path>
                            </svg>
                        </span>
                        {isModalOpen && (
                            <MainVideoModal
                                onClose={() => setIsModalOpen(false)}
                                videoId="HubmluaaFmc"
                            />
                        )}
                    </div>
                    {/* 고객의 소리 컴포넌트 */}
                    {customerSounds.map((customerSounds, index) => (
                        <div key={index} className="group cursor-pointer" onClick={() => document.getElementById(index).click()}>
                            <div className="my-5">
                                <img
                                src={customerSounds.src}
                                alt={`${customerSounds.name}logo`}
                                className="h-6"
                                />
                            </div>
                            <div className="pb-4">
                                <a id={index} href={customerSounds.link} className="text-base group-hover:text-blue-500">{customerSounds.title}</a>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </section>
    )
}