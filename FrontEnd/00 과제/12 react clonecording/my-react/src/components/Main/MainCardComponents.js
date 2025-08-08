export default function CardComponents(){
    return(
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
    );
}