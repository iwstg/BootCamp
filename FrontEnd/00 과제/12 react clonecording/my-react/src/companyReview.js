const customerSounds=[
  {name:"Toyota", src:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F1fJCIIjK31CRPMPj7Bp9Mu%2Fa48f183d399e7483799401f44053e306%2Ftoyota.png&w=1920&q=75", title:"워크플로를 간소화하여 타임라인을 3분의 1로 줄였습니다. →", link:"/ko/customers/toyota"},
  {name:"ramp", src:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F4eiEZBWL5gEClwB1IHi18I%2Fb9b86479965977121ceabd01f45567a7%2Framp.png&w=1920&q=75", title:"\"Notion 덕분에 Ramp의 모든 팀원에게 AI 비서가 생겼습니다.\" →", link:"/ko/customers/ramp"},
  {name:"Vercel", src:"https://images.ctfassets.net/spoqsaf9291f/15en0a60cYTRxNO1QlHbdg/f09657a6b8287f1db0e628a048267e2c/vercel-logotype-light.svg", title:"\"Notion은 하나의 툴로 많은 문제를 해결할 수 있다는 것을 이해합니다.\" →", link:"/ko/customers/vercel"},
  {name:"MatchGroup", src:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F2Z03v7BH2brwtBG2qdA5dp%2Fd6cd228d2f7b6048edcec9f4d5bcce3c%2Fmatch.png&w=640&q=75", title:"\"Notion은 워크플로를 간소화하는 가장 강력하고 영향력 있는 툴입니다.\" →", link:"/ko/customers/match"},
  {name:"deel", src:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F5sSU1RuGiuXiLOo6BTB6JT%2F459aa7c6824c18b7faaca2b0c3606d62%2Fdeel_2025.png&w=1080&q=75", title:"\"Deel의 신규 입사자는 누군가에게 문의하지 않고도 스스로 온보딩할 수 있습니다.\" →", link:"/ko/customers/deel"},
  {name:"planful", src:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F3pCaKcH2gCNdmeLdzdL66F%2Fc6cd3b5670585d9feb298de532930d24%2FPlanful_Logo.png&w=640&q=75", title:"6개의 앱이 하나로 단일화됐습니다! 모든 팀이 Notion AI에서 더 빠르게 성장하고 있습니다. →", link:"/ko/customers/planfun"}
]

export default function companyReview(){

    return(
        <>
        {customerSounds.map((customerSounds, index) => (
            <div key={index}>
            <div className="my-5">
                <img
                    src={customerSounds.src}
                    alt={`${customerSounds.name}logo`}
                    className="h-6"
                />
            </div>
            <div className="pb-4">
                <a href={customerSounds.link} className="text-base hover:text-blue-500">{customerSounds.title}</a>
            </div>
            </div>
        ))}
        </>
    );
}