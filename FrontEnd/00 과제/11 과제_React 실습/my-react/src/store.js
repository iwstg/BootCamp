// import counterReducer from "./reducers/counterReducer";
import counterReducer from "./reducers/counterSlice";
// import { createStore } from "redux";
import { configureStore } from "@reduxjs/toolkit";

// const store = createStore(counterReducer);

const store = configureStore({
    reducer: {
        stores: counterReducer, 
    },
});

export default store;