import {getEmptyTask, Task} from "./Task";

export type Tasks = [Task];

export function getEmptyTasks(): Tasks {
    return [getEmptyTask()]

}