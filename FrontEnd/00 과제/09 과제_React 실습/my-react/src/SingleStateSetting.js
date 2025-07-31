import React, { useState } from "react";

function SingleStateSetting() {
  // 개별 상태들
  const [score, setScore] = useState(0);
  const [name, setName] = useState("Alice");

  const incrementScore = () => {
    setScore((prevScore) => prevScore + 1);
  };

  const changeName = () => {
    setName(name === "Alice" ? "Bob" : "Alice");
  };

  return (
    <div>
      <h1>점수: {score}</h1>
      <button onClick={incrementScore}>Increase Score</button>
      <h2>이름: {name}</h2>
      <button onClick={changeName}>Change Name</button>
    </div>
  );
}

export default SingleStateSetting;