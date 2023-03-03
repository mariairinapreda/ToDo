import "./taskPage.css"
import Title from "../../components/card/title";
import AddTaskButton from "../../components/addTaskButton/addTaskButton";
import {useEffect, useState} from "react";
import {getEmptyTasks, Tasks} from "../../types/Tasks";
import {API_URL, ASC, DESC} from "../../constants";
import {apiAction} from "../../axiosInterceptors";
import {Card} from "../../components/card/card";

const TaskPage = () => {
    const [data, setData] = useState<Tasks>(getEmptyTasks);

    const fetchData = async () => {
        setData(await apiAction(API_URL));

    };
    useEffect(() => {
        fetchData();
    }, [])


    return (<div id={"tasks"}>
        <Title/>
        <button onClick={async () => {
            const info = await apiAction(ASC);
            setData(info.data);
           document.location.reload();
        }}>Order Ascending
        </button>


        <button id={"inline"} onClick={async () => {
            const info = await apiAction(DESC);
            setData(info.data);
            document.location.reload();
        }}>Order Descending
        </button>
        <Card tasks={data}/>
        <AddTaskButton/>
    </div>)
}

export default TaskPage;