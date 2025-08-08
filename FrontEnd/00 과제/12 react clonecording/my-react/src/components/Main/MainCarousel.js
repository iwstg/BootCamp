import React, { useState } from 'react';

const caroitems = [
      { name:"프로덕트", src: "https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F5FOEEkHXxB4F3hQrZLWZ8G%2Fe24c42eca70f13c0c21897233f271877%2Fproduct.ko-KR.png&w=3840&q=90"},
      { name:"엔지니어링", src: "https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F3uWfsJnlpCimdqcYJVszKt%2F344bc6d853db2e6cd5c6437c3dcc488c%2Fengineering.ko-KR.png&w=3840&q=90"},
      { name:"디자인", src: "https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F18gxMna3Gsoy0MXIciuwcm%2F99a54f6c1e49b73ccc4e0bf719efb42d%2Fdesign.ko-KR.png&w=3840&q=90"},
      { name:"IT", src: "https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2FN3cXw71SPLzvRZotzDIJK%2F3c694cb6762a1ada3e6fac70b463f016%2Fit.ko-KR.png&w=3840&q=90"},
      { name:"마케팅", src: "https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2FdWYQIU4v89fvd22zsQxV6%2F4fba9e9fff294dcf3a69289aa417c8ba%2Fmarketing.ko-KR.png&w=3840&q=90"},
      { name:"스타트업", src: "https://www.notion.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fspoqsaf9291f%2F4GoYEFFY5zHRGpaFGYkZCu%2F67af4c0a5d2769b2c4adc2347b6ce95d%2Fstartups.ko-KR.png&w=3840&q=90"}
];
              
export default function Carousel() {
  const [current, setCurrent] = useState(0);
  
  return (
    <section className="flex flex-col justify-center items-center">
      <h1 className="font-bold text-5xl m-4">팀마다 제공되는 개별 공간</h1>
      <div className="w-full mx-auto">
        <div className="flex justify-center gap-2 mb-4 items-center">
          {caroitems.map((caroitems, index) => (
            <button
            key={index}
            onClick={() => setCurrent(index)}
            className={`w-fit h-8 px-3 rounded-full ${
            current === index ? 'bg-gray-200' : ''
            } transition-colors duration-500 ease-in-out hover:bg-gray-200 text-sm text-gray-500`}
            >{caroitems.name}</button>
          ))}
        </div>

        <div className="w-full overflow-hidden rounded-lg shadow-lg bg-black">
          <img
          src={caroitems[current].src}
          alt={caroitems[current].name}
          className="w-full h-full object-cover transition-all duration-500"
          />
        </div>
      </div>
    </section>
  );
}