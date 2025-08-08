export default function MainStartNotion(){
    return(
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
    )
}