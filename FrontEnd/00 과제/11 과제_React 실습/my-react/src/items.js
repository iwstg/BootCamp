import { useState } from "react";
import Modal from "./Modal";

export default function({ img_src, title, discount, price, company }){
    const [modalOpen, setModalOpen] = useState(false);

    return (
    <>
        <div className="w-full sm:w-1/3 mb-1 flex items-start justify-start border m-3 cursor-pointer" onClick={() => setModalOpen(!modalOpen)}>
            <div className="card mb-3 w-full">
                <div className="flex flex-row gap-0">
                    <div className="w-5/12">
                        <img src={img_src} alt="내이미지" className="w-full h-full object-cover border" />
                    </div>
                    <div className="w-7/12">
                        <div className="p-1 flex flex-col justify-between text-left h-full">
                            <p className="mb-1 text-sm">{title}</p>
                            <p className="my-1 text-base font-bold">{price} <del className="text-gray-400">{discount && `${discount}`}</del></p>
                            <p className="mt-auto mb-0 text-xs text-gray-500">{company}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        {modalOpen && (
            <Modal onClose={() => setModalOpen(false)}>
                {img_src && <img src={img_src} alt={title} style={{ width: "100%" }} />}
                <h2>{title}</h2>
                <p>{price} <del style={{ color: "gray" }}>{discount && `(${discount})`}</del></p>
            </Modal>
        )}
    </>
    );
}