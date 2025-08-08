import React, { useRef, useEffect } from "react";

export default function MainVideoModal({onClose, videoId}){

    return (
        <div className="fixed inset-0 z-50 bg-gray-300 bg-opacity-50 flex items-center justify-center" onClick={onClose}>
            <div className="w-[800px] h-[600px] border bg-white rounded-[16px] flex flex-col" onClick={(e) => e.stopPropagation()}> {/* 이벤트 버블링을 막음. */}
                <div className="flex flex-row-reverse">
                    <button className="p-3" onClick={onClose}>
                        <svg className="w-[1rem] cursor-pointer"
                        xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64">
                            <defs fill="currentColor"></defs>
                            <path d="m36.24,32l15.76,15.76-4.24,4.24-15.76-15.76-15.76,15.76-4.24-4.24,15.76-15.76-15.76-15.76,4.24-4.24,15.76,15.76,15.76-15.76,4.24,4.24-15.76,15.76Z" fill="currentColor"></path>
                        </svg>
                    </button>
                </div>
                <div className="relative w-full h-full">
                    <iframe
                    className="absolute p-6 top-0 left-0 w-full h-full"
                    src={`https://www.youtube.com/embed/${videoId}?autoplay=0`}
                    title="YouTube video"
                    allow="accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                    allowFullScreen
                    ></iframe>
                </div>
                <div className="p-6 text-start">
                    <span className="hover:underline hover:text-blue-400 text-gray-600 cursor-pointer">더 보기 →</span>
                </div>
            </div>
        </div>
    );
};