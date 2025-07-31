import styles from "./Button.module.css"

export default function Button({color}) {

    return <button className={`${styles.btn} ${color === "blue"? styles.blue : ''}`}>버튼</button>;
}