import React from 'react';

const AppList = [
    { name:"Slack", url:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2FCQcBQyH4Arrg3L89LGtJJ%2Fbe4d88d7b99690a8e32cec52ec9322dc%2Fslack-logo.png&w=32&q=75"},
    { name:"Google Drive", url:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F2Kp35zgUoc6qKprOsvC0rm%2F5bb1391716e9f3549bab489646c0fff4%2Fgoogle-workspace-logo.png&w=32&q=75"},
    { name:"GitHub", url:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F4c6UQCtqP2VcaQ54geVmhE%2Fecb8a17172049803d0687a331738eb64%2Fgithub-logo.png&w=32&q=75"},
    { name:"Jira", url:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F2QeSvVRbbTcryv22yuxJ4O%2F7a2f80d7e0c777b7d98f35e76bb241cf%2Fjira-logo.png&w=32&q=75"},
    { name:"Ms Teams", url:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F4Peb2KsEz9ZP28FP5TQMhw%2F4b1eb7bf064929333034da4e2acaadb7%2Fms-teams-logo.png&w=32&q=75"},
    { name:"SharePoint", url:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F1Y9wMruARnjBVnkdEPmoJd%2Fb98ddb2a235344031a05c3b6579fec40%2Fsharepoint-logo.png&w=32&q=75"},
    { name:"OneDrive", url:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F3qLse95jc5JIgvNUbsyQq7%2F68eaf72b8bc66c93577a37cd5cdddd60%2Fonedrive-logo.png&w=32&q=75"},
    { name:"Gmail", url:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F7uxYhi4B135cc5qjskpew1%2F85dd5b390939ec5d9f481b334dfaa433%2Fgmail-logo.png&w=32&q=75"},
    { name:"Linear", url:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F6sXzNcTANYabBBQaiCZMXR%2F678d3ad8374d4276da3fd8e95ae88234%2Flinear-logo.png&w=32&q=75"},
    { name:"Zendesk", url:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F4QFYcbryJVxPpMyp1lypRD%2Fb78f20fcf39037dd5792bae510a9b740%2Fzendesk-logo.png&w=32&q=75"},
    { name:"Salesforce", url:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F6Kt86waxJxRwpIxAPorGyn%2F4ddbf37fecde60a2faf7ff9788ba00ac%2Fsalesforce-logo.png&w=32&q=75"},
    { name:"Box", url:"https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F6J63Bc8LtN8uIO1giCEyZN%2F4364add25c89df7f0912c64249a22ce4%2Fbox-logo.png&w=32&q=75"}
]

export default function CombineAppList(){
    return(
        <div className="flex justify-center gap-4 mt-16 pt-14">
            <div className="flex flex-col gap-2 w-2/5">
                <h1 className="text-balance font-bold text-[2.625rem] leading-tight mb-1 tracking-[-0.3rem]">한 번의 검색으로 무엇이든 찾기</h1>
                <p className="text-sm font-[600] mb-4">Notion 내에서 회사의 모든 지식과 앱을 검색할 수 있습니다.</p>
                <div className="flex items-center mb-8">
                <button className="bg-blue-600 text-white font-bold py-[6px] px-[16px] mr-4 rounded-lg">무료 체험하기</button>
                <a href="" className="text-blue-500 hover:underline">데모 요청하기 →</a>
                </div>
                <div className="flex justify-start gap-10">
                <ul className="columns-2">
                    {AppList.map((app, index) => (
                        index <= 5 ? (
                            <React.Fragment key={index}>
                            {index === 0 && <li className="font-bold mb-2 text-[0.875rem] cursor-default">통합 가능 앱</li>}
                            <li className="flex gap-2 items-center mb-2 justify-start w-64 text-[0.875rem] cursor-default">
                                <img className="w-3" src={app.url} alt={app.name} />
                                <span>{app.name}</span>
                            </li>
                            </React.Fragment>
                        ) : (
                            <React.Fragment key={index}>
                            {index === 9 && <li className="font-bold mb-2 text-[0.875rem] cursor-default">출시 예정</li>}
                            <li className="flex gap-2 items-center mb-2 justify-start w-64 text-[0.875rem] cursor-default">
                                <img className="w-3" src={app.url} alt={app.name} />
                                <span>{app.name}</span>
                            </li>
                            </React.Fragment>
                        )
                    ))}
                </ul>
                </div>
            </div>
            <div className="w-3/5">
                <img className="w-full" src="https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F1WQxz3QGRQ39BXXtHbC4Hq%2Fe0ec7a9113e0e0629ab2af60fb982318%2FEnterpriseSearch_-_Landscape_-_en-US.jpg&w=3840&q=75" />
            </div>
        </div>
    )
}