import React, { useState, useRef, useEffect } from "react";

const languages = [
    {lang:"English (US)", kor:"영어(미국)"},
    {lang:"English (UK)", kor:"영어(영국)"},
    {lang:"한국어", kor:"한국어"},
    {lang:"Deutsh", kor:"독일어"},
    {lang:"Tiếng Việt", kor:"베트남어"},
    {lang:"Español (Latinoamérica)", kor:"스페인어(라틴 아메리카)"},
    {lang:"Español (España)", kor:"스페인어(스페인)"},
    {lang:"Bahasa Indonesia", kor:"인도네시아어"},
    {lang:"日本語", kor:"일본어"},
    {lang:"简体中文", kor:"중국어 간체"},
    {lang:"繁體中文", kor:"중국어 번체"},
    {lang:"ภาษาไทย", kor:"태국어"},
    {lang:"Português (Brasil)", kor:"포르투갈어(브라질)"},
    {lang:"Français (France)", kor:"프랑스어(프랑스)"},
];
    

export default function LanguageDropdown() {
  const [selected, setSelected] = useState("한국어");
  const [isOpen, setIsOpen] = useState(false);
  const dropdownRef = useRef(null);

  // 외부 클릭 시 드롭다운 닫기
  useEffect(() => {
    const handleClickOutside = (e) => {
      if (dropdownRef.current && !dropdownRef.current.contains(e.target)) {
        setIsOpen(false);
      }
    };
    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, []);

  return (
    <div className="relative inline-block text-left" ref={dropdownRef}>
      {/* 선택된 언어 버튼 */}
      <button
        onClick={() => setIsOpen((prev) => !prev)}
        className="inline-flex justify-between items-center w-fit px-4 py-2 text-sm font-medium text-gray-700 bg-white border border-gray-300 rounded-md shadow-sm hover:bg-gray-50"
      >
        {selected}
        <svg
          className={`w-4 h-4 ml-2 transition-transform duration-200 ${isOpen ? "rotate-180" : ""}`}
          viewBox="0 0 20 20"
          fill="currentColor"
        >
          <path
            fillRule="evenodd"
            d="M5.23 7.21a.75.75 0 011.06.02L10 10.94l3.71-3.71a.75.75 0 111.08 1.04l-4.25 4.25a.75.75 0 01-1.08 0L5.25 8.27a.75.75 0 01-.02-1.06z"
            clipRule="evenodd"
          />
        </svg>
      </button>

      {/* 드롭다운 목록 */}
      <div
        className={`
          absolute z-10 w-fit bg-white border border-gray-200 rounded-md 
          shadow-lg transition-all duration-200 origin-bottom bottom-full
          overflow-y-auto max-h-[18rem] whitespace-nowrap
          ${isOpen ? "opacity-100 scale-100" : "opacity-0 scale-95 pointer-events-none"}
        `}
      >
        <ul className="py-1 ">
          {languages.map((lang, index) => (
            <li
              key={index}
              onClick={() => {
                setSelected(lang);
                setIsOpen(false);
              }}
              className="px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 cursor-pointer"
            >
              <p className="text-xl">{lang.lang}</p>
              <span className="text-sm text-gray-400">{lang.kor}</span>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}