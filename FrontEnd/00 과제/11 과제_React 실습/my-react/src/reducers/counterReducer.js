const initialState = {
  counter: 0, // 카운터 값
  showCounter: true, // 카운터 표시 여부
};

const counterReducer = (state = initialState, action) => {
  switch (action.type) {
    case "INCREMENT":
      return { ...state, counter: state.counter + action.payload };
    case "DECREMENT":
      return { ...state, counter: state.counter - action.payload };
    case "TOGGLE_COUNTER":
      return { ...state, showCounter: !state.showCounter };
    default:
      return state;
  }
};

export default counterReducer;