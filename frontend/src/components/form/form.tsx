import "./form.css"
import SubmitButton from "../submitButton/submitButton";
import React, {useState} from "react";
import {getEmptyTaskDto, TaskDto} from "../../types/TaskDto";
import {API_URL} from "../../constants";
import authFetch from "../../axiosInterceptors";
import {useNavigate} from "react-router-dom";

const Form = () => {
    const navigate = useNavigate();
    const [task, setTask] = useState<TaskDto>(getEmptyTaskDto);

    const onSubmit = () => {
        if (task.estimated_duration < 0) {
            alert("Duration has to be bigger than 0");
        } else if (task.limit_date < Date.now()) {
            alert("Date starts tomorrow");
        } else if (task.type === "") {
            alert("choose a type please")
        } else {
            try {
                const request = authFetch.post(API_URL, task);
            } catch (error) {

            }
            setTimeout(() => navigate("/"), 1000);
        }

    }

    function updateTask(event: React.ChangeEvent<HTMLInputElement>) {
        return (prev: any) => ({...prev, [event.target.name]: event.target.value});
    }

    return (<div id={"form"}>
     <span className={"title"}>
       Pick task type :
         <div>
    <input type="radio" className={"radio"} onChange={(event) => {
        setTask(updateTask(event))
    }} id="home" name="type" value={"HOME"}/>
    <label className={"small"} htmlFor="home">HOME</label></div>
         <div>
       <input type="radio" id="work" className={"radio"} name="type" onChange={(event) => {
           setTask(updateTask(event))
       }} value={"WORK"}/>
      <label className={"small"} htmlFor="work">WORK</label></div>
         <div>
       <input type="radio" id="hobby" className={"radio"} onChange={(event) => {
           setTask(updateTask(event))
       }} name="type" value={"HOBBY"}/>
    <label className={"small"} htmlFor="hobby">HOBBY</label></div>
  </span>
        <label className={"title"} htmlFor="name">Task name : </label>
        <p>Any name will do</p>
        <input type="text" id="name" name="name" onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
            setTask(updateTask(event));
        }}/>
        <label className={"title"} htmlFor="estimated_duration">Estimated duration : </label>
        <p>The duration has to be above 0</p>
        <input type="number" id="estimated_duration" name="estimated_duration" min={0} max={24}
               onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                   setTask(updateTask(event));
               }}/>
        <label htmlFor="date" className={"title"}>Expiration date : </label>
        <p>The date has to be after today</p>
        <input type="date" id="date" name="limit_date" min={Date.now()}
               onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                   setTask(updateTask(event));
               }}/>
        <SubmitButton submitForm={() => onSubmit()}/>
    </div>)
}
export default Form;