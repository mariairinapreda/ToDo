import "./addTaskButton.css"
import {useNavigate} from "react-router-dom";


const AddTaskButton = () => {
    const navigate = useNavigate();
    return (<button id={"addButton"} type={"submit"} onClick={() => navigate("/add-task")}>Add Task</button>);
}
export default AddTaskButton;