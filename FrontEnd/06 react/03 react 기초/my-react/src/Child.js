import styles from "./Button.module.css"
import "./styles.scss";

const Child = (props) => {
    const changeHandler = (e) => {
        console.log("사용자 입력값: ", e.target.value);
        // 3단계, 부모에게 받은 콜백함수에 값을 전달한다.
        props.onData(e.target.value);
        /**
         * 아니면 디스트럭쳐링을 써서 Child = ({onData}) =>
         * onData(e.target.value)로 작성가능. (props. 안해도됨)
         */
    };

    return (
        <>
            <input type="text" onChange={changeHandler} />
            {/* 버튼 모듈로 가져옴 */}
            <button className={styles.btn}>버튼</button>
            
        </>
    );
};

export default Child;