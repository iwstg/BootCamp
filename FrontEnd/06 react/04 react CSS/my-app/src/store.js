// import { createStore } from "redux";
// import counterReducer from "./counterSlice";
import counterReducer from "./reducers/counterReducer";
import { configureStore } from "@reduxjs/toolkit";

const store = configureStore({
    reducer: {
        stores: counterReducer, 
    },
});

export default store;