import { useState } from "react";
import Modal from "./Modal";

export default function CardComponent({ img_src, title, discount, price, company }) {
  const [modalOpen, setModalOpen] = useState(false);

  return (
    <>
      <div className="col-sm-6 align-items-start justify-content-start mb-1"  onClick={() => setModalOpen(!modalOpen)}>
        <div className="card mb-3">
          <div className="row g-0">
            <div className="col-md-5">
                <img src={img_src} alt={title} />
            </div>
            <div className="col-md-7">
                <div className="card-body p-1 d-flex flex-column justify-content-between text-start h-100">
                    <p className="card-text mb-1" style= {{ fontSize: '0.875rem' }}>{title}</p>
                    <p className="card-title my-1"><b>{price}</b> <del style={{ color: "gray" }}>{discount && `${discount}`}</del></p>
                    <p className="text-body-secondary mt-auto mb-0" style= {{ fontSize: '0.75rem' }}>{company}</p>
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