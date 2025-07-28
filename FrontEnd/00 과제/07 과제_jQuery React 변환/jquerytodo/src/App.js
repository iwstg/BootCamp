import logo from './logo.svg';
import './App.css';
import React, { useState, useRef } from 'react';

function App() {
  const [inputValue, setInputValue] = useState('');
  const [todos, setTodos] = useState([]);
  const inputRef = useRef(null);

  // 항목 추가
  const handleAdd = () => {
    const trimmed = inputValue.trim();
    if (trimmed === '') {
      alert('값이 없습니다');
      return;
    }
    setTodos([...todos, trimmed]);
    setInputValue('');
    inputRef.current.focus();
  };

  // 항목 삭제
  const handleDelete = (indexToDelete) => {
    setTodos(todos.filter((_, index) => index !== indexToDelete));
  };

  return (
    <div className="container mt-5">
      <h2>jQuery TodoList를 React로</h2>
      <div className="d-flex gap-2 mb-3">
        <input
          ref={inputRef}
          type="text"
          className="form-control"
          value={inputValue}
          placeholder="할 일을 입력하세요"
          onChange={(e) => setInputValue(e.target.value)}
          onKeyDown={(e) => { if (e.key === 'Enter') handleAdd(); }}
        />
        <button className="btn btn-primary" onClick={handleAdd}>추가</button>
      </div>

      <div className="border p-3" style={{ minHeight: '8rem', maxHeight: '25rem', overflowY: 'auto' }}>
        <ul className="list-unstyled mb-0">
          {todos.map((item, index) => (
            <li
              key={index}
              className="list-group-item d-flex justify-content-between align-items-center"
            >
              {item}
              <button className="btn btn-sm btn-primary" onClick={() => handleDelete(index)}>삭제</button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default App;