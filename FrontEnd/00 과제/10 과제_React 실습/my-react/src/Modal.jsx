import styles from "./Modal.module.css";

export default function Modal({ onClose, children }) {
  return (
    <div className={styles.overlay} onClick={onClose}>
      <div className={styles.modal} onClick={(e) => e.stopPropagation()}>
        {children}
        <button className={styles.closebtn} onClick={onClose}>X</button>        
      </div>
    </div>
  );
}