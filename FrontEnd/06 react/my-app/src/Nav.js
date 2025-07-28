export default function Nav() {
    const name = "홍길동";
    const myStyle = {
        color: "red",
        background: "black",
        padding: "20px"
    }
    const 로그인여부 = true;

    return 로그인여부 ? 
        (<nav style={myStyle}>Hello, {name}</nav> ):
        (<h1>로그인을 진행해주세요.</h1>
    );
}