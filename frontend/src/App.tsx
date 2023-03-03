import React from 'react';
import './App.css';
import Header from "./components/header/header";
import TaskPage from "./pages/taskPage/taskPage";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Form from "./components/form/form";

function App() {
    return (
        <BrowserRouter>
            <div className="App">
                <Header/>
            </div>
            <Routes>
                <Route path={"/"} element={<TaskPage/>}/>
                <Route path={"/add-task"} element={<Form/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
