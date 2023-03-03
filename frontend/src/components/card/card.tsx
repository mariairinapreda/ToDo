import "./card.css"
import {FC} from "react";
import {Task} from "../../types/Task";
import SortButton from "../sortButton/sortButton";
import authFetch from "../../axiosInterceptors";
import {API_URL} from "../../constants";


export const Card: FC<{ tasks: [Task] }> = (tasks) => {
    const handleClick = async (id: bigint) => {
        await authFetch.delete(API_URL + `/${id}`, {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': "/*",
                'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE',
                "Accept": "application/json, text/plain, /"
            }
        });
    }
    return (<div id={"cards"}><SortButton/> {tasks.tasks.map(task =>
        <div key={task.name}><p className={"tasks"}>Task name : {task.name}</p>
            <p>Task type : {task.type.type}</p>
            <p>Task expiration date : {task.limit_date}</p>
            <p>Task estimated duration : {task.estimated_duration} h</p>
            <p>Days left : {Math.floor((Date.parse(task.limit_date) - Date.now()) / (1000 * 3600 * 24))}
                <button id={"deleteButton"} onClick={() => handleClick(task.id!)}>X</button>

            </p>
            <br/>
        </div>
    )}</div>)

}




