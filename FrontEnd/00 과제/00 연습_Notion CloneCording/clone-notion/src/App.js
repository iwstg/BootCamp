import logo from './logo.svg';
import './App.css';
import './CloneCording.css';

function App() {
  return (
    <>
      <section className="TopContainer">
        <nav className="TopNavigator">
          <div className="TopLogoImage">
            <img id="profileImage" src="https://img.icons8.com/?size=100&id=nZoJhBpPfVev&format=png&color=000000" width="40" />
          </div>

          <div className="TopNavigatorTab">
            <button className="TopNavList items">
              <span>Notion</span>
              <span className="TopNavListNotionImg">
                  <svg viewBox="0 0 30 30">
                      <polygon points="15,17.4 4.8,7 2,9.8 15,23 28,9.8 25.2,7 "></polygon>
                  </svg>
              </span>
            </button>
            <a className="items">
              <span>메일</span>
            </a>
            <span>
              <a className="items">캘린더</a>
            </span>
            
            <a className="items">
              <span>AI</span>
            </a>
            
            <a className="items">
              <span>대기업</span>
            </a>
            
            <a className="items">
              <span>가격</span>
            </a>
            
            <button className="TopNavList items">
              <span >둘러보기</span>
              <span className="TopNavListNotionImg">
                <svg viewBox="0 0 30 30">
                  <polygon points="15,17.4 4.8,7 2,9.8 15,23 28,9.8 25.2,7 "></polygon>
                </svg>
              </span>
            </button>

            <a className="items">
              <span>영업팀 문의하기</span>
            </a>
          </div>
          <div className="TopNavigatorTab2">
            <span className="Btn NotionLoginBtn">
              <a style={{ width: "max-content" }}>로그인</a>
            </span>
            <a className="Btn TopNotionStartForFree">Notion 무료로 시작하기</a>
          </div>
        </nav>
      </section>
      <main className="MainLayoutArea">

        <section className="MainPageArea">
            <section className="MainPageBanner">
                <header className="MainPageBannerText">
                    <h1>나만을 위한 AI 워크스페이스</h1>

                    <h2>팀이 모든 답을 찾고, 반복 업무를 자동화하며, 프로젝트를 완료할 수 있는 하나의 공간.</h2>

                    <nav className="MainPageBannerNav">
                        <a className="Btn NotionStartForFree">Notion 무료로 시작하기</a>
                        <button>데모 요청하기</button>
                    </nav>
                </header>
                <div className="MainPageBannerImg">
                    
                    <img width="100%" height="auto" src="./res/noseyHeroV2.png" />
                </div>
            </section>

            <section>
                후원자들 와글와글
            </section>

            <section>
                그리드로 된 정보들을 넣을곳임
            </section>


        </section>
      </main>

      <div className="Footer">
        <section className="FooterBanner">
            <div className="FooterTop">
                <svg className="FooterLogo" viewBox="0 0 105 30" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <g clip-path="url(#a)">
                        <mask id="b" width="29" height="30" x="0" y="0" maskUnits="userSpaceOnUse">
                            <path fill="#fff" d="M28.714 0H0v29.995h28.714V0Z"></path>
                        </mask>
                        <g mask="url(#b)">
                            <path fill="#fff" d="M1.805 1.29 18.403.069c2.038-.175 2.563-.057 3.844.873l5.298 3.724c.874.64 1.166.815 1.166 1.513v20.424c0 1.28-.467 2.037-2.097 2.153L7.34 29.919c-1.224.058-1.806-.116-2.447-.931L.99 23.925c-.7-.931-.99-1.628-.99-2.444V3.326c0-1.046.466-1.92 1.805-2.035Z"></path>
                            <path className="wordmark_fill__RZFeq" fill="#000" fill-rule="evenodd" d="M18.403.068 1.805 1.291C.466 1.406 0 2.28 0 3.326v18.155c0 .816.29 1.513.99 2.444l3.902 5.063c.64.815 1.223.99 2.447.93l19.275-1.163c1.63-.116 2.097-.873 2.097-2.153V6.178c0-.662-.262-.853-1.034-1.416a89.567 89.567 0 0 1-.132-.097L22.247.941C20.966.011 20.44-.107 18.403.068ZM7.776 5.843c-1.574.106-1.931.13-2.825-.596L2.678 3.443c-.232-.233-.115-.524.467-.581l15.957-1.164c1.339-.117 2.038.35 2.562.756l2.737 1.979c.116.058.407.407.058.407l-16.48.99-.203.013ZM5.94 26.427V9.087c0-.756.233-1.105.932-1.164l18.926-1.105c.642-.058.933.35.933 1.105v17.223c0 .758-.117 1.398-1.166 1.456L7.455 27.65c-1.05.058-1.515-.29-1.515-1.223Zm17.88-16.41c.116.525 0 1.049-.526 1.108l-.872.174v12.8c-.758.408-1.457.64-2.039.64-.932 0-1.165-.29-1.864-1.163l-5.707-8.96v8.67l1.806.407s0 1.047-1.458 1.047l-4.017.233c-.117-.233 0-.815.408-.931l1.048-.29V12.287l-1.456-.117c-.116-.524.174-1.28.99-1.338l4.31-.29 5.94 9.077v-8.03l-1.514-.174c-.117-.641.349-1.107.931-1.164l4.02-.234Z" clip-rule="evenodd"></path>
                        </g>
                        <path className="wordmark_fill__RZFeq" fill="#000" d="M50.995 7.02V23.23h-2.587L40.739 12.14h-.134V23.23h-2.913V7.02h2.612l7.652 11.087h.15V7.021h2.89Zm7.715 16.446c-1.187 0-2.216-.261-3.087-.784a5.269 5.269 0 0 1-2.018-2.192c-.474-.939-.712-2.036-.712-3.292 0-1.256.237-2.356.712-3.3s1.148-1.678 2.018-2.2c.87-.522 1.9-.784 3.087-.784 1.182 0 2.208.262 3.078.784.87.522 1.544 1.256 2.018 2.2.48.944.72 2.044.72 3.3 0 1.256-.24 2.353-.72 3.292a5.269 5.269 0 0 1-2.018 2.193c-.87.522-1.896.783-3.078.783Zm.008-2.28c.654 0 1.197-.176 1.63-.53.433-.358.757-.838.973-1.44.217-.607.325-1.282.325-2.026 0-.744-.108-1.419-.325-2.026-.216-.607-.54-1.09-.973-1.448-.433-.364-.976-.546-1.63-.546-.66 0-1.209.182-1.646.546-.438.359-.765.841-.982 1.448-.21.607-.316 1.282-.316 2.026 0 .744.105 1.42.316 2.026.217.602.544 1.082.982 1.44.438.354.986.53 1.646.53ZM72.33 11.074v2.2h-6.964v-2.2h6.964ZM67.09 8.16h2.842v11.42c0 .385.058.68.174.887.121.205.28.345.475.419.195.074.414.11.657.11a2.8 2.8 0 0 0 .49-.039c.148-.026.264-.05.349-.071l.474 2.224a6.49 6.49 0 0 1-.648.174c-.28.063-.623.1-1.03.11-.712.022-1.355-.086-1.93-.324a3.04 3.04 0 0 1-1.361-1.116c-.333-.506-.496-1.142-.491-1.907V8.16Zm6.983 15.069V11.073h2.85v12.156h-2.85Zm1.433-13.89c-.454 0-.842-.15-1.164-.45a1.456 1.456 0 0 1-.483-1.093c0-.427.161-.791.483-1.092a1.645 1.645 0 0 1 1.163-.459c.454 0 .842.153 1.164.46.327.3.49.664.49 1.091 0 .422-.163.786-.49 1.092-.322.301-.71.452-1.163.452Zm8.99 14.127c-1.187 0-2.216-.261-3.087-.784a5.268 5.268 0 0 1-2.018-2.192c-.474-.939-.712-2.036-.712-3.292 0-1.256.238-2.356.712-3.3.475-.944 1.148-1.678 2.018-2.2.871-.522 1.9-.784 3.087-.784 1.182 0 2.208.262 3.078.784.871.522 1.544 1.256 2.019 2.2.48.944.72 2.044.72 3.3 0 1.256-.24 2.353-.72 3.292a5.267 5.267 0 0 1-2.019 2.193c-.87.522-1.896.783-3.078.783Zm.008-2.28c.654 0 1.197-.176 1.63-.53.433-.358.757-.838.974-1.44.216-.607.324-1.282.324-2.026 0-.744-.108-1.419-.324-2.026-.217-.607-.541-1.09-.974-1.448-.433-.364-.976-.546-1.63-.546-.66 0-1.208.182-1.646.546-.438.359-.765.841-.982 1.448-.21.607-.316 1.282-.316 2.026 0 .744.105 1.42.316 2.026.217.602.544 1.082.982 1.44.438.354.986.53 1.646.53Zm10.406-5.088v7.13h-2.848V11.074h2.722v2.057h.143a3.48 3.48 0 0 1 1.337-1.614c.617-.401 1.38-.602 2.288-.602.833 0 1.561.18 2.184.539a3.63 3.63 0 0 1 1.456 1.559c.348.68.522 1.506.522 2.477v7.74h-2.84v-7.305c0-.813-.212-1.448-.634-1.907-.423-.464-1.006-.697-1.75-.697-.5 0-.946.111-1.337.333-.39.216-.696.532-.918.95-.216.41-.325.91-.325 1.495Z"></path>
                    </g>
                </svg>

                <div className="FooterOtherLink">
                    <ul aria-label="Social media" role="list" className="FooterOtherLink">
                        <li className="linkbtn">
                            <a className="" aria-label="Instagram" href="https://www.instagram.com/notionhq/" rel="noopener" target="_blank">
                                <svg className="shareInstagram" viewBox="0 0 18 18" style={{width:"18px", height:"18px", display:"block", fill:"currentColor", flexshrink:"0" }}>
                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M9 1.621c2.405 0 2.689.011 3.635.053.879.039 1.354.186 1.67.309.418.162.721.359 1.034.671.316.316.51.615.675 1.034.123.316.271.795.309 1.67.042.949.053 1.234.053 3.635s-.011 2.689-.053 3.635c-.039.879-.186 1.354-.309 1.67a2.802 2.802 0 01-.671 1.034c-.316.316-.615.51-1.034.675-.316.123-.795.271-1.67.309-.949.042-1.234.053-3.635.053s-2.689-.011-3.635-.053c-.879-.039-1.354-.186-1.67-.309a2.802 2.802 0 01-1.034-.671 2.815 2.815 0 01-.675-1.034c-.123-.316-.271-.795-.309-1.67-.042-.949-.053-1.234-.053-3.635s.011-2.689.053-3.635c.039-.879.186-1.354.309-1.67.162-.418.359-.721.671-1.034.316-.316.615-.51 1.034-.675.316-.123.795-.271 1.67-.309.946-.042 1.23-.053 3.635-.053zM9 0C6.557 0 6.251.011 5.291.053 4.335.095 3.677.25 3.108.471a4.389 4.389 0 00-1.596 1.041A4.404 4.404 0 00.471 3.105C.25 3.678.095 4.332.053 5.288.011 6.251 0 6.557 0 9c0 2.443.011 2.749.053 3.709.042.956.197 1.614.418 2.183a4.389 4.389 0 001.041 1.596 4.392 4.392 0 001.593 1.037c.573.221 1.227.376 2.183.418.96.042 1.266.053 3.709.053s2.749-.011 3.709-.053c.956-.042 1.614-.197 2.183-.418a4.413 4.413 0 001.593-1.037c.5-.499.809-1.002 1.037-1.593.221-.573.376-1.227.418-2.183.042-.96.053-1.266.053-3.709s-.011-2.749-.053-3.709c-.042-.956-.197-1.614-.418-2.183a4.21 4.21 0 00-1.03-1.6A4.392 4.392 0 0014.896.474c-.573-.221-1.227-.376-2.183-.418C11.75.01 11.444 0 9 0zm0 4.377A4.625 4.625 0 004.377 9 4.625 4.625 0 009 13.623 4.625 4.625 0 0013.623 9 4.625 4.625 0 009 4.377zm0 7.622A3 3 0 119 6 3 3 0 019 12zm4.806-6.726a1.079 1.079 0 100-2.158 1.079 1.079 0 000 2.158z"></path>
                                </svg>
                            </a>
                        </li>
                        <li className="linkbtn">
                            <a className="" aria-label="X" href="https://twitter.com/NotionHQ" rel="noopener" target="_blank">
                                <svg className="shareX" viewBox="0 0 15 13" style={{width:"20px",height:"16px",display:"block",fill:"currentColor",flexshrink:"0"}}><path d="M11.787.523h2.109L9.289 5.788l5.42 7.164h-4.244L7.142 8.607 3.34 12.952H1.23l4.927-5.631L.958.523H5.31l3.004 3.972L11.787.523Zm-.74 11.167h1.169L4.674 1.719H3.421l7.626 9.971Z"></path>
                                </svg>
                            </a>
                        </li>
                        <li className="linkbtn">
                            <a className="" aria-label="LinkedIn" href="https://www.linkedin.com/company/notionhq/" rel="noopener" target="_blank">
                                <svg className="shareLinkedIn" viewBox="0 0 16 16" style={{width:"20px",height:"16px",display:"block",fill:"currentColor",flexshrink:"0"}}>
                                    <defs>
                                        <clipPath id="linkedin-clip-1">
                                            <path d="M0 0h16v16H0z"></path>
                                        </clipPath>
                                    </defs>
                                    <path d="M14.81 0H1.18C.53 0 0 .52 0 1.15v13.69C0 15.48.53 16 1.18 16h13.63c.65 0 1.18-.52 1.18-1.15V1.15c0-.64-.53-1.15-1.18-1.15ZM4.75 13.63H2.38V5.99h2.37v7.64ZM3.56 4.96c-.76 0-1.38-.62-1.38-1.37s.62-1.37 1.38-1.37 1.37.62 1.37 1.37-.62 1.37-1.37 1.37Zm10.07 8.67h-2.37V9.92c0-.88-.02-2.02-1.23-2.02s-1.42.97-1.42 1.96v3.77H6.24V5.99h2.27v1.04h.03c.32-.6 1.09-1.23 2.24-1.23 2.4 0 2.85 1.58 2.85 3.64v4.19Z" style={{clippath:"url(#linkedin-clip-1)"}}></path>
                                </svg>
                            </a>
                        </li>
                        <li className="linkbtn">
                            <a className="" aria-label="Facebook" href="https://www.facebook.com/NotionHQ/" rel="noopener" target="_blank">
                                <svg className="shareFacebook" viewBox="0 0 18 18" style={{width:"20px",height:"16px",display:"block",fill:"currentColor",flexshrink:"0"}}>
                                    <path d="M17.999 8.999c0-4.97-4.029-8.999-8.999-8.999s-8.999 4.029-8.999 8.999c0 4.492 3.291 8.215 7.593 8.89v-6.289h-2.285v-2.601h2.285v-1.983c0-2.255 1.344-3.501 3.399-3.501 0.985 0 2.015 0.176 2.015 0.176v2.215h-1.135c-1.118 0-1.467 0.694-1.467 1.405v1.688h2.496l-0.399 2.601h-2.097v6.289c4.302-0.675 7.593-4.398 7.593-8.89z"></path>
                                </svg>
                            </a>
                        </li>
                        <li className="linkbtn">
                            <a className="" aria-label="YouTube" href="https://www.youtube.com/channel/UCoSvlWS5XcwaSzIcbuJ-Ysg" rel="noopener" target="_blank">
                                <svg className="shareYouTube" viewBox="0 0 18 18" style={{width:"20px",height:"16px",display:"block",fill:"currentColor",flexshrink:"0"}}>
                                    <path d="M9 2.070c-8.845 0-9 0.787-9 6.93s0.155 6.93 9 6.93 9-0.787 9-6.93-0.155-6.93-9-6.93zM11.884 9.301l-4.041 1.886c-0.354 0.164-0.644-0.020-0.644-0.41v-3.553c0-0.39 0.29-0.574 0.644-0.41l4.041 1.886c0.354 0.166 0.354 0.436 0 0.601z"></path>
                                </svg>
                            </a>
                        </li>
                    </ul>    
                </div>
                <div>
                    한국어설정<br />
                    쿠키 설정<br />
                    카피라이트<br />
                </div>
                
            </div>

            
            <nav className="FooterBottom">
                <div className="FooterPanel">
                    <ul>
                        <li><b>회사 소개</b></li>
                        <li>Notion 소개</li>
                        <li>채용</li>
                        <li>보안</li>
                        <li>서비스 상태</li>
                        <li>이용약관 및 개인정보 보호정책</li>
                        <li>개인정보 보호 권한</li>
                    </ul>
                    <ul>
                        <li><b>다운로드</b></li>
                        <li>iOS & Android</li>
                        <li>Mac & Windows</li>
                        <li>캘린더</li>
                        <li>Web Clipper</li>
                    </ul>
                    <ul>
                        <li><b>자료</b></li>
                        <li>도움말 센터</li>
                        <li>요금제</li>
                        <li>블로그</li>
                        <li>커뮤니티</li>
                        <li>API 통합</li>
                        <li>템플릿</li>
                        <li>추천인</li>
                    </ul>
                    <ul>
                        <li><b>용도별</b></li>
                        <li>회사</li>
                        <li>팀</li>
                        <li>개인</li>
                        <span>더 살펴보기 →</span>
                    </ul>
                </div>
            </nav>
        </section>
    </div>
    </>
  );
}

export default App;
